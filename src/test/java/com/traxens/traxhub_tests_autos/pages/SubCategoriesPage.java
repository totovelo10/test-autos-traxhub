package com.traxens.traxhub_tests_autos.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/equipmentSubcategory")
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

	@FindBy(xpath="//option[@value='GENSET']")
	private WebElementFacade categoryGenset;

	@FindBy(xpath="//option[@value='PALLET']")
	private WebElementFacade categoryPallet;

	@FindBy(xpath="//option[@value='TRAILER']")
	private WebElementFacade categoryTrailer;

	@FindBy(xpath="//option[@value='UNKNOWN']")
	private WebElementFacade categoryUnknown;

	@FindBy(xpath="//option[@value='WAGON']")
	private WebElementFacade categoryWagon;

	@FindBy(xpath="//li[@class='filter filter-predefined']//a[1]")
	private WebElementFacade allSubcategoriesFilter;

	@FindBy(xpath="//button[@type='submit']")
	private WebElementFacade saveButton;

	@FindBy(xpath="//span[@ng-bind-html='alert.msg']")
	private WebElementFacade alertMsg;

	@FindBy(partialLinkText="CodeSubcategory")
	private List<WebElementFacade> subcategoriesList;
	private String codeName;
	private String categoryChoosen;

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
		categoryChoosen = "Container-";

	}

	public void enterCodeAndNameSubCategory() {

		LocalDateTime ldt = LocalDateTime.now();
		codeName= categoryChoosen+DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.ENGLISH).format(ldt);
		code_field.type(codeName);
		name_field.type(codeName);
	}

	public void clickOnSaveButton() {

		saveButton.click();
	}


	public void alertMsgShouldBeVisble() {
		alertMsg.shouldBeVisible();
		//alertMsg.shouldNotBeVisible();
	}

	public void chooseCategoryGenset() {
		categoryGenset.click();
		categoryChoosen = "Genset-";

	}
	public void chooseCategoryPallet() {
		categoryPallet.click();
		categoryChoosen = "Pallet-";
	}
	public void chooseCategoryTrailer() {
		categoryTrailer.click();
		categoryChoosen = "Trailer-";
	}
	public void chooseCategoryUnknown() {
		categoryUnknown.click();
		categoryChoosen = "Unknown-";
	}
	public void chooseCategoryWagon() {
		categoryWagon.click();
		categoryChoosen = "Wagon-";
	}

	public void chooseAllSubCategoriesFilter() {
		allSubcategoriesFilter.waitUntilPresent();
		allSubcategoriesFilter.waitUntilVisible();
		allSubcategoriesFilter.waitUntilEnabled();
		allSubcategoriesFilter.waitUntilClickable();
		allSubcategoriesFilter.click();


		this.getDriver().navigate().refresh();
		for(int i=0;i<subcategoriesList.size();i++) {
			if (subcategoriesList.get(i).getText()==codeName) {
				subcategoriesList.get(i).shouldBeVisible();
			}
		}

		allSubcategoriesFilter.click();

	}


}
