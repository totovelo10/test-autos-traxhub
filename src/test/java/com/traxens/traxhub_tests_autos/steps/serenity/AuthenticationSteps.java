package com.traxens.traxhub_tests_autos.steps.serenity;

import com.traxens.traxhub_tests_autos.pages.GmailLoginPage;
import com.traxens.traxhub_tests_autos.pages.HomePage;
import com.traxens.traxhub_tests_autos.pages.LoginPage;
import com.traxens.traxhub_tests_autos.pages.ResetPasswordPage;

import java.sql.Timestamp;
import java.util.Date;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.traxens.traxhub_tests_autos.pages.CassandraConnection;
import com.traxens.traxhub_tests_autos.pages.ForgottenPasswordPage;

import net.thucydides.core.annotations.Step;

public class AuthenticationSteps {

	LoginPage loginPage;
	ForgottenPasswordPage forgottenPasswordPage;
	GmailLoginPage gmailLoginPage;
	ResetPasswordPage resetPasswordPage;
	HomePage homePage;
	CassandraConnection connection;
	Session session;
	
	String reset_Key;
	@Step
	public void is_on_the_login_page()  {
		loginPage.open();
	}

	@Step
	public void clicks_on_reset_password_link() {
		
		loginPage.clickOnResertPasswordLink();

	}

	@Step
	public void should_be_on_reset_password_page() {
		forgottenPasswordPage.shouldBeDisplayed();
	}

	@Step
	public void is_on_the_reset_password_page()  {
		forgottenPasswordPage.open();
	}


	@Step
	public void enter_his_username(String username) {
		forgottenPasswordPage.enter_username(username);

	}

	@Step
	public void clicks_on_reset_password_button() {
		forgottenPasswordPage.clicksOnResetPasswordButton();
	}

	@Step
	public void check_mails_message_shoul_be_displayed() {
		forgottenPasswordPage.checkMailsMessageShouldBeDisplayed();

	}


	@Step
	public void navigate_to_the_Gmail_login_page()  {
		//loginPage.open();
		gmailLoginPage.open();
		gmailLoginPage.getDriver().navigate().to("http://mail.google.com/mail?hl=fr");
	}

	@Step
	public void log_in_Gmail(String email,String password)  {
		gmailLoginPage.enter_email(email);
		gmailLoginPage.clicksOnNextButton();
		gmailLoginPage.enter_pass(password);
		gmailLoginPage.clicksOnNextButton();
	}

	@Step
	public void clicks_on_traxens_email() {
		gmailLoginPage.clicksOnTraxensMail();

	}

	@Step
	public void clicks_on_reset_link() {
		gmailLoginPage.clicksOnResetLink();

	}

	@Step
	public void clicks_on_go_on_button() {
		gmailLoginPage.clicksOnGoOnButton();

	}

	@Step
	public void connexion_to_theDataBase() {
		connection= new CassandraConnection();
		connection.connect("srvintegration1", 9042,"traxhub","traxhub");
		session = connection.getSession();
		if (session !=null) {
			System.out.println("************Connexion OK**************");
		}
		else {
			System.out.println("------------Connexion KO--------------");
		}
	}

	@Step
	public void setResetKey(String resetKey) {
		reset_Key=resetKey;
		String query ="update user set reset_key='"+reset_Key+"'where login='sboina_sncf';";
		session.execute(query);    
		
	}

	@Step
	public void setResetDate() {
		String query = "update user set reset_date=toTimeStamp(now()) where login='sboina_sncf';";
		session.execute(query);    
				
	}

	@Step
	public void close_connexion() {
		connection.close();
		System.out.println("------------Connexion Closed--------------");
	}

	public void navigate_to_reset_password_page() {
		//loginPage.open();
		loginPage.getDriver().navigate().to("http://uat1wap01/traxui/#/reset/finish?key="+reset_Key);
		
	}

	public void enter_his_new_password(String newPassword) {
		resetPasswordPage.enter_newPassword(newPassword);
	}

	public void enter_his_confirm_password(String confirmPassword) {
		resetPasswordPage.enter_confirmPassword(confirmPassword);
		
	}

	public void should_see_success_message() {
		resetPasswordPage.successMessageShouldBeDisplayed();
		
	}

	public void getResetKey(String user_login) {
		
		connexion_to_theDataBase();
		String query ="select reset_key from user where login='"+user_login+"';";
		ResultSet rs =session.execute(query);
		Row row = rs.one();
		System.out.println("Reset key = "+row.getString("reset_key"));
		reset_Key = row.getString("reset_key");
	}
	
	public void clicks_on_login_page_link() {
		resetPasswordPage.clicks_on_login_page_link();
	}

	public void login_traxhub(String username, String newpassword) {
		loginPage.log_in(username,newpassword);
		
	}

	public void should_see_his_account_name(String account_name) {
		
		homePage.shouldDisplay(account_name);
	}

	public void deconnect() {
		homePage.clickOnDropDown();
		homePage.clickOnLogOut();
		homePage.clickOkDeconnectButton();
		
	}
	
	
}
