package com.test.vishal.stepDefs;

import com.test.vishal.automation.TestSessionInitiator;
import static com.test.vishal.stepDefs.Base_Step_Def.test;
import java.io.IOException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductPurchaseAndProfileUpdateStepDef {

	@Given("^User is on Application Home page$")
	public void lauchApplicationHomePage() {
		test = new TestSessionInitiator();
		test.launchApp();
	}

	@When("^User Login with valid (.*) and (.*)$")
	public void loginWithValidCredential(String email, String password) {
		test.homePage.selectLogin();
		test.loginPage.loginWithEmailIdAndPassword(email, password);
	}

	@Then("^User is navigate to My Account page$")
	public void verifyUserIsOnMyAccountPage() {
	    test.myAccountPage.verifyPageHeader();
	}
	
	@When("^User selects T-shirts$")
	public void selectTshirtsFromTopMenu() {
		test.homePage.selectTshirtsFromTopMenu();
	}
	
	@When("^User add the T-shirt to the cart$")
	public void addTshirtsToCart() {
		test.productPage.addProductToCart();
	}
	
	@When("^User place order for the T-shirt$")
	public void placeTshirtsOrder() {
		test.productPage.slectSummaryCheckout();
		test.productPage.slectAddressCheckout();
		test.productPage.slectShippingCheckout();
		test.productPage.slectPaymentCheckout();
		test.productPage.getOrderReference();
		test.productPage.selectBackToOrders();
	}
	
	@Then("^User verifies the order is placed successfully$")
	public void verifyOrderIsPlaced() {
		test.productPage.verifyOrderHistory();		
	}
	
	@When("^User select user info form header$")
	public void selectUserInfoFromHeader() {
		test.homePage.selectUserInfo();
	}
	
	@When("^User select My Personal Information$")
	public void selectMyPersonalInformationOption() {
		test.myAccountPage.selectMyPersonalInformation();
	}
	
	@When("^User update first name Information$")
	public void updateMyPersonalInformation() {
		test.myAccountPage.editFirstName();
	}
	
	@Then("^User verifies the updated Information$")
	public void verifyUpdatedPersonalInformation() {
		test.myAccountPage.verifyInformationUpdateMessage();
		test.myAccountPage.verifyFirstName();		
	}
	
	@Then("^User closes the browser session$")
	public void closeBrowserSession() throws IOException {
		test.closeBrowserSession();
	}

}
