package com.traxens.traxhub_tests_autos;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/equipment/Sub-categories.feature")
public class EquipmentTestSuite {

}
