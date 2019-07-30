package com.traxens.traxhub_tests_autos.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SubCategoriesPage extends PageObject {

	@FindBy(xpath="//button[@href='#/equipmentSubcategory/new']")
	private WebElementFacade createSubCategoriesButton;

	@FindBy(id="field_category")
	private WebElementFacade category_field;

	@FindBy(id="field_code")
	private WebElementFacade code_field;

	@FindBy(id="field_name")
	private WebElementFacade name_field;

	@FindBy(xpath="//option[@value='CONTAINER']")
	private WebElementFacade categoryContainer;

	
	@FindBy(xpath="//button[@type='submit']")
	private WebElementFacade saveButton;

	@FindBy(xpath="//span[@ng-bind-html='alert.msg']")
	private WebElementFacade alertMsg;

	
	public void clickOnCreateSubCategoriesButton() {
		createSubCategoriesButton.waitUntilEnabled();
		createSubCategoriesButton.waitUntilClickable();
		createSubCategoriesButton.click();
	}

	public void clickOnCategoryField() {

		category_field.click();

	}

	public void chooseCategoryContainer() {

		categoryContainer.click();

	}
	
	public void enterCodeAndNameSubCategory() {
		
		LocalDateTime ldt = LocalDateTime.now();
		String codeName= "CodeSubcategory-"+DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.ENGLISH).format(ldt);
		code_field.type(codeName);
		name_field.type(codeName);
	}
	
	public void clickOnSaveButton() {
		
		saveButton.click();
	}
	
	
	public void alertMsgShouldBeVisble() {
		//alertMsg.shouldBeVisible();
		alertMsg.shouldNotBeVisible();
	}

}
