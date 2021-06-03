package com.test.vishal.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/features/Product_Purchase_And_Profile_Update.feature", glue="com.test.vishal.stepDefs", plugin= {"html:target/cucumber-html-report", "json:target/cucmber.json"})
public class ProductPurchaseAndProfileUpdateTestRunner extends AbstractTestNGCucumberTests{

}
