package com.traxens.traxhub_tests_autos.pages;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://uat1wap01/traxui/#/reset/request")
public class ForgottenPasswordPage extends PageObject {
	
	@FindBy(id="username")
    private WebElementFacade usernameField;
	
	@FindBy(xpath="//button[@type='submit']")
    private WebElementFacade resetPasswordButton;
	
	@FindBy(xpath="//p[contains(text(),'Check your e-mails for details on how to reset you')]")
    private WebElementFacade checkMailsMessage;
	
	public void enter_username(String username) {
		usernameField.type(username);
    }

	public void clicksOnResetPasswordButton() {
		resetPasswordButton.click();
    }
	
	public void checkMailsMessageShouldBeDisplayed() {
		checkMailsMessage.shouldBeVisible();
	}
}
