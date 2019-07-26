package com.traxens.traxhub_tests_autos.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


public class GmailLoginPage extends PageObject {
	
	@FindBy(linkText="Connexion")
    private WebElementFacade connexionButton;
	
	@FindBy(name="identifier")
    private WebElementFacade emailField;
	
	@FindBy(name="password")
    private WebElementFacade passwordField;
	
	@FindBy(xpath="//span[contains(text(),'Suivant')]")
    private WebElementFacade nextButton;
	
	@FindBy(xpath="//table/tbody/tr[3]")
    private  WebElementFacade traxensMail;
	
	@FindBy(partialLinkText="http://uat1wap01/traxui/#/reset/finish?key=")
    private WebElementFacade resetLink;
	
	@FindBy(xpath="//button[@name='sl']")
    private  WebElementFacade goOnButton;
	
	
	public void clickOnConnexionButton() {
		connexionButton.click();
		
    }
	
	public void enter_email(String email) {
		emailField.type(email);
    }

	public void enter_pass(String pass) {
		passwordField.type(pass);
    }
	
	public void clicksOnNextButton() {
		nextButton.click();
    }

	public void clicksOnTraxensMail() {
		traxensMail.click();
		//System.out.println("********"+traxensMail.size()+"*****");
		
    }
	
	public void clicksOnResetLink() {
		resetLink.click();
	
    }
	
	public void clicksOnGoOnButton() {
		goOnButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
