package com.traxens.traxhub_tests_autos.steps.serenity;

import com.traxens.traxhub_tests_autos.pages.HomePage;
import com.traxens.traxhub_tests_autos.pages.LoginPage;
import com.traxens.traxhub_tests_autos.pages.SubCategoriesPage;

import net.thucydides.core.annotations.Step;

public class TraxhubAdminSteps {

	LoginPage loginPage;
	HomePage homePage;
	SubCategoriesPage subCategoriesPage;
	@Step
	public void login() {

		loginPage.open();
		loginPage.log_in("sadati_traxens", "sadati_traxens");
	}

	@Step
	public void clickOnManage() {

		homePage.clickOnManage();
	}
	
	@Step
	public void subCategoriesIsVisible() {
		homePage.subcategoriesItemShouldBeVisible();
	}

	public void clicksOnSubCategoryItem() {
		homePage.clicksOnSubCategoriesItem();
		
	}

	public void clicksOnCreateSubCategoryButton() {
		
		subCategoriesPage.clickOnCreateSubCategoriesButton();
	}

	public void chooseACategory(String category) {
		if(category == "container")
		subCategoriesPage.chooseCategoryContainer();
		
	}

	public void enterCodeAndNameCategory() {
		subCategoriesPage.enterCodeAndNameSubCategory();
		
	}

	public void save() {
		subCategoriesPage.clickOnSaveButton();
		
	}

	public void shouldSeeAMessageAlert() {
		subCategoriesPage.alertMsgShouldBeVisble();
		
	}

}
