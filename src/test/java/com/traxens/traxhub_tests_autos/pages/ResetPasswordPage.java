package com.traxens.traxhub_tests_autos.pages;



import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ResetPasswordPage extends PageObject {

	@FindBy(id="password")
	private WebElementFacade passwordField;

	@FindBy(name="confirmPassword")
	private WebElementFacade confirmPasswordField;

	@FindBy(xpath="//button[@type='submit')]")
	private WebElementFacade resetPasswordButton;

	@FindBy(xpath="//div[@class='alert alert-success']//p[1]")
	private WebElementFacade resetPasswordSuccesMessage;
	
	@FindBy(xpath="//a[@href='#/login']")
	private WebElementFacade loginPageLink;
	
	public void enter_newPassword(String newPassword) {
		passwordField.type(newPassword.trim());
	}

	public void enter_confirmPassword(String confirmPassword) {
		confirmPasswordField.type(confirmPassword.trim());
		
	}
	public void successMessageShouldBeDisplayed() {
		resetPasswordSuccesMessage.shouldBeVisible();
	}
	
	public void clicks_on_login_page_link() {
		loginPageLink.click();
	}
	

	
}
