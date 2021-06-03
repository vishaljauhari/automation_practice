package com.test.vishal.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {
	
	@FindBy(css = "a.login")
	private WebElement loginButton;
	
	@FindBy(css = "div.header_user_info span")
	private WebElement userInfo;
	
	@FindBy(css = "ul.sf-menu>li>a[title='T-shirts']")
	private WebElement tshirtsOption;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectLogin() {
		loginButton.isDisplayed();
		loginButton.click();
		Reporter.log("User select Login Button", true);
	}
	
	public void selectTshirtsFromTopMenu() {
		tshirtsOption.isDisplayed();
		tshirtsOption.click();
		Reporter.log("User select Tshirts Option", true);
	}
	
	public void selectUserInfo() {
		userInfo.isDisplayed();
		userInfo.click();
		Reporter.log("User select User Info", true);
	}
}
