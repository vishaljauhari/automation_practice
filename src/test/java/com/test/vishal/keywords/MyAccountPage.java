package com.test.vishal.keywords;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.test.vishal.utils.YamlReader;

public class MyAccountPage {
	
	String newName = "";
	
	@FindBy(css = "div#center_column .page-heading")
	private WebElement pageHeader;
	
	@FindBy(css = "a[title='Information']")
	private WebElement myInformation;
	
	@FindBy(id = "firstname")
	private WebElement firstName;
	
	@FindBy(id = "old_passwd")
	private WebElement oldPassword;
	
	@FindBy(css = "button[name='submitIdentity']")
	private WebElement saveButton;
	
	@FindBy(css = "div.header_user_info span")
	private WebElement userInfo;
	
	@FindBy(css = "p.alert-success")
	private WebElement infoUpdateSuccess;
	
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPageHeader() {
		Assert.assertEquals(pageHeader.getText().trim(), "MY ACCOUNT");
		Reporter.log("User is on MY ACCOUNT page", true);
	}
	
	public void selectMyPersonalInformation() {
		myInformation.click();
		Reporter.log("User selects My Personal Information", true);
	}
	
	public void editFirstName() {
		newName = RandomStringUtils.randomAlphabetic(10);
		firstName.clear();
		firstName.sendKeys(newName);
		oldPassword.sendKeys(YamlReader.getYamlValue("password"));
		saveButton.click();
		Reporter.log("User enters new Personal Information", true);
	}
	
	public void verifyInformationUpdateMessage() {
		Assert.assertEquals(infoUpdateSuccess.getText().trim(), "Your personal information has been successfully updated.");
		Reporter.log("User verifies Personal Information update message", true);
	}
	
	public void verifyFirstName() {
		String firstName = userInfo.getText().substring(0, userInfo.getText().indexOf(' '));
		System.out.println("user info firstname"+firstName);
		System.out.println("new name second time"+newName);
		Assert.assertEquals(firstName.toLowerCase(), newName.toLowerCase());
		Reporter.log("User verifies First name value from user info section", true);
	}
}
