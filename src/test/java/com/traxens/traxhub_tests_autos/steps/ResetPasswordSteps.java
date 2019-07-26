package com.traxens.traxhub_tests_autos.steps;

import com.traxens.traxhub_tests_autos.steps.serenity.AuthenticationSteps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ResetPasswordSteps {

	
	@Steps
	AuthenticationSteps user;
	

	@Given("the user is on the Login page")
	public void givenTheUserIsOnTheLoginPage() {

		user.is_on_the_login_page();	
	}

	@When("the user clicks on reset password link")
	public void whenTheUserClicksOnResetPasswordLink(){

		user.clicks_on_reset_password_link();
	}

	@Then("he should be redirected to the reset password page")
	public void thenHeShouldBeRedirectedToResetPasswordPage() {

		user.should_be_on_reset_password_page();
	}

	@Given("the user is on the reset password page")
	public void givenTheUserIsOnTheResetPasswordPage() {

		user.is_on_the_reset_password_page();	
	}

	@Given("^the user navigate to reset password page$")
	public void the_user_navigate_to_reset_password_page() {
		user.is_on_the_login_page();	
		user.clicks_on_reset_password_link();
	}

	@When("the user enter his username (.*)$")
	public void whenTheUserEnterHisUsername(String username){

		user.enter_his_username(username);
	}

	@When("^the user clicks on reset password button$")
	public void the_user_clicks_on_reset_password_button() {
		user.clicks_on_reset_password_button();
	}

	@Then("^a check mails message should be displayed$")
	public void a_check_mails_message_should_be_displayed() {
		user.check_mails_message_shoul_be_displayed();

	}



	@Given("^the user navigate to the Gmail page$")
	public void theUserNavigateToTheGmailPage()  {
		user.navigate_to_the_Gmail_login_page();
	}


	@When("^the user log in Gmail$")
	public void theUserLogInGmail()  {
		user.log_in_Gmail("traxtesteur@gmail.com","jetesteuneappli");
	}

	@When("^the user clicks on traxens email$")
	public void theUserClicksOnTraxensEmail()  {
		user.clicks_on_traxens_email();
	}
	
	@When("^the user clicks on reset link$")
	public void theUserClicksOnResetLink()  {
		user.clicks_on_reset_link();
	}
	
	@When("^the user clicks on go on button$")
	public void theUserClicksOnGoOnButton()  {
		user.clicks_on_go_on_button();
	}
	
	@Then("^he should be redirected to connexion page$")
	public void he_should_be_redirected_to_connexion_page()  {
		
	}
	
	
	@Given("^the user have a reset_key (.*)$")
	public void theUserHaveAResetKey(String key)  {
		user.connexion_to_theDataBase();
		user.setResetKey(key);
		user.setResetDate();  
		user.close_connexion();
	}
	
	@When("^the user navigate to the resetpasswordPage (.*)$")
	public void theUserNavigateToTheResetPasswordPage(String user_login)  {
		user.getResetKey(user_login);
		user.navigate_to_reset_password_page();
	}
	
	@When("^the user enters his new password(.*)$")
	public void the_user_enters_his_new_password(String newPassword) {
	   user.enter_his_new_password(newPassword);
	}

	@When("^the user enters the confirm password(.*)$")
	public void the_user_enters_the_confirm_password(String confirmPassword){
		user.enter_his_confirm_password(confirmPassword);
	   
	}

	@Then("^he should see the success message$")
	public void he_should_see_the_success_message() {
		user.should_see_success_message();
	}

	@When("^the user clicks on login page link$")
	public void the_user_clikcs_on_login_page_link() throws Exception {
	   user.clicks_on_login_page_link();
	}

	@When("^the user  log in traxhub with his username (.*) and newpassword (.*)$")
	public void the_user_log_in_traxhub(String username, String newpassword) throws Exception {
	    user.login_traxhub(username,newpassword);
	}
	
	@Then("^he should see his account name (.*)")
	public void he_should_see_his_account_name(String account_name) {
		user.should_see_his_account_name(account_name);
	}
	
	@After("@ResetPassword")
	public void testEnd(){
	    user.deconnect();
	} 
}
