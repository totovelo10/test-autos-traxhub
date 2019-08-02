package com.traxens.traxhub_tests_autos.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	@FindBy(xpath="//div[@role='row']")
	private List<WebElementFacade> rowsList;
	
	@FindBy(xpath="//span[@translate='entity.action.delete']")
	private WebElementFacade deletePopupButton;



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

	public void enterCodeAndNameSubCategory(String code, String name) {
		code_field.type(code);
		name_field.type(name);
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


	}
	public void chooseCategoryPallet() {
		categoryPallet.click();

	}
	public void chooseCategoryTrailer() {
		categoryTrailer.click();

	}
	public void chooseCategoryUnknown() {
		categoryUnknown.click();

	}
	public void chooseCategoryWagon() {
		categoryWagon.click();

	}

	public void chooseAllSubCategoriesFilter() {
		this.getDriver().navigate().refresh();
		allSubcategoriesFilter.waitUntilPresent();
		allSubcategoriesFilter.waitUntilVisible();
		allSubcategoriesFilter.waitUntilEnabled();
		allSubcategoriesFilter.waitUntilClickable();
		allSubcategoriesFilter.click();
	}

	public void subcategoryShouldbeVisible(String subcategoryCode) {




		for(int i=0;i<subcategoriesList.size();i++) {
			if (subcategoriesList.get(i).getText()== subcategoryCode) {
				subcategoriesList.get(i).shouldBeVisible();
			}
		}


	}

	public void deleteSubcategory(String subcategoryCode) {
		WebElement deleteSubcategoryButton = getDriver().findElement(By.xpath("//button[@href='#/equipmentSubcategory/"+subcategoryCode+"/delete']"));
		deleteSubcategoryButton.click();                                        //button[@href='#/equipmentSubcategory/Container-TestsAutos/delete']
		deletePopupButton.click();
	}


}
