package com.traxens.traxhub_tests_autos.steps;

import com.traxens.traxhub_tests_autos.steps.serenity.TraxhubAdminSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SubCategoriesSteps {

	@Steps
	TraxhubAdminSteps admin;

	@Given("^I login as a traxens Admin$")
	public void i_login_as_a_traxens_Admin()  {
		admin.login();

	}

	@When("^I click on manage$")
	public void i_click_on_manage(){
		admin.clickOnManage();
	}

	@Then("^I should see sub-categories item$")
	public void i_should_see_sub_categories_item() {
		admin.subCategoriesIsVisible();
		}
	
	
	@When("^I click on subcategory item$")
	public void i_click_on_subcategory_item() {
	    admin.clicksOnSubCategoryItem();
	}

	@When("^I click on create subcategory button$")
	public void i_click_on_create_subcategory_button() {
		admin.clicksOnCreateSubCategoryButton();
	}

	@When("^I choose a category (.*)$")
	public void i_choose_a_category(String category)  {
		admin.chooseACategory(category);
	}

	@When("^I enter code and name subcategory$")
	public void i_enter_code_and_name_category()  {
	    admin.enterCodeAndNameCategory();
	}


	@When("^I save$")
	public void i_save() {
	    admin.save();
	}

	@Then("^I should see a message alert$")
	public void i_should_see_amessage_alert() throws Exception {
	    
		admin.shouldSeeAMessageAlert();
	}

}
