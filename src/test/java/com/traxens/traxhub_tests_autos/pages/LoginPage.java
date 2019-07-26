package com.traxens.traxhub_tests_autos.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/login")
public class LoginPage extends PageObject {

	
	@FindBy(id="username")
    private WebElementFacade username;
	
	@FindBy(id="password")
    private WebElementFacade password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElementFacade logInButton;
	
	@FindBy(xpath="//a[@href='#/reset/request']")
    private WebElementFacade forgetPasswordLink;

	public void clickOnResertPasswordLink() {
	
		forgetPasswordLink.waitUntilVisible();
		forgetPasswordLink.waitUntilEnabled();
		forgetPasswordLink.waitUntilClickable();
		forgetPasswordLink.click();
		
    }

	public void log_in(String login, String pass) {
		username.type(login.trim());
		password.type(pass.trim());
		clickOnConnexionButton();
		
	}
	
	public void clickOnConnexionButton() {
		logInButton.click();
		
    }

}
