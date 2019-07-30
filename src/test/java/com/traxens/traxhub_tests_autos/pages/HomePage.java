package com.traxens.traxhub_tests_autos.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObject {

	
	@FindBy(xpath="//span[@class='hidden-sm hidden-md ng-binding']")
	private WebElementFacade account_displayname;
	
	@FindBy(xpath="//a[@class='dropdown-toggle ng-scope']")
	private WebElementFacade dropdown;
	
	@FindBy(xpath="//li[@class='dropdown pointer open']//li[5]//a[1]")
	private WebElementFacade logOut;
	
	@FindBy(xpath="//li[@title='Gérer']")
	private WebElementFacade manageMenu;
	
	@FindBy(id="okBtn")
	private WebElementFacade OkDeconnectButton;
	
	@FindBy(xpath="//a[@href='#/equipmentSubcategory']")
	private WebElementFacade subcategoriesItem;
	
	public void shouldDisplay(String account_name) {
		account_displayname.waitUntilEnabled();
		account_displayname.waitUntilVisible();
		account_displayname.waitUntilPresent();
		account_displayname.shouldContainOnlyText(account_name.trim());
		
    }
	
	public void clickOnDropDown() {
		dropdown.click();
		
	}
	
	public void clickOnLogOut() {
		logOut.waitUntilVisible();
		logOut.waitUntilEnabled();
		logOut.waitUntilClickable();
		logOut.click();
	}
	
	public void clickOkDeconnectButton() {
		OkDeconnectButton.waitUntilClickable();
		OkDeconnectButton.click();
	}
	
	public void clickOnManage() {
		manageMenu.waitUntilClickable();
		manageMenu.click();
	}
	
	public void subcategoriesItemShouldBeVisible() {
		subcategoriesItem.shouldBeVisible();
	}

	public void clicksOnSubCategoriesItem() {
		
		subcategoriesItem.click();
	}
}
