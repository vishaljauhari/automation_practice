package com.test.vishal.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage {
	
	@FindBy(css = "input#email")
	private WebElement email;
	
	@FindBy(css = "input#passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement submit;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginWithEmailIdAndPassword(String userEmail, String userPassword) {
		email.sendKeys(userEmail);
		password.sendKeys(userPassword);
		submit.click();
		Reporter.log("User Login with Valid Credentials", true);
	}

}