package com.test.vishal.keywords;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ProductPage {
	WebDriver driver;
	String orederId = "";
	
	@FindBy(css = "div.product-container div.product-image-container")
	private WebElement productImage;
	
	@FindBy(css = "a[title='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(css = "a[title='Proceed to checkout']")
	private WebElement proceedCheckout;
	
	@FindBy(css = "p.cart_navigation a[title='Proceed to checkout']")
	private WebElement summaryCheckout;
	
	@FindBy(css = "input[name='cgv']")
	private WebElement termsOfService;
	
	@FindBy(css = "button.button-medium")
	private WebElement confirmMyOrder;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addProductToCart() {
		WebElement productImage =driver.findElement
				(By.cssSelector("div.product-container div.product-image-container"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", productImage);
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(productImage).build().perform();
		addToCart.click();
		proceedCheckout.click();
		Reporter.log("User Add the Product to the Cart", true);
	}
	
	public void slectSummaryCheckout() {
		WebElement summaryCheckout =driver.findElement
				(By.cssSelector("p.cart_navigation a[title='Proceed to checkout']"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", summaryCheckout);
		summaryCheckout.click();
		Reporter.log("User select checkout on Summary screen", true);
	}
	
	public void slectAddressCheckout() {
		WebElement addressCheckout =driver.findElement
				(By.cssSelector("button[name='processAddress']"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", addressCheckout);
		addressCheckout.click();
		Reporter.log("User select checkout on Address screen", true);
	}
	
	public void slectShippingCheckout() {
		WebElement shippingCheckout =driver.findElement
				(By.cssSelector("button[name='processCarrier']"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", shippingCheckout);
		termsOfService.click();
		shippingCheckout.click();
		Reporter.log("User select checkout on Shipping screen", true);
	}
	
	public void slectPaymentCheckout() {
		WebElement paymentMethod =driver.findElement
				(By.cssSelector("a.bankwire"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", paymentMethod);		
		paymentMethod.click();
		confirmMyOrder.click();
		Reporter.log("User select checkout on Payment screen", true);
	}
	
	public void getOrderReference() {
		WebElement orderSummary = driver.findElement
				(By.cssSelector("div.box"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", orderSummary);	
		String orderText = orderSummary.getText();
		String regex = "\\b[A-Z]+\\b";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(orderText);
	    while (matcher.find())
	      {
	    	orederId = matcher.group(matcher.groupCount());
	      }
	}
	
	public void selectBackToOrders() {
		WebElement backToOrders =driver.findElement
				(By.cssSelector("p.cart_navigation a"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", backToOrders);		
		backToOrders.click();
		Reporter.log("User select moves to Order History screen", true);
	}
	
	public void verifyOrderHistory() {
		boolean orderPresnt = false;
		List<WebElement> orderIds =driver.findElements
				(By.cssSelector("table#order-list td.history_link a"));
		for (WebElement order : orderIds) {
			if (order.getText().trim().equalsIgnoreCase(orederId)) {
				orderPresnt = true;
			}
		}
		Assert.assertEquals(orderPresnt, true);
		Reporter.log("User verified the placed Order", true);
	}

}
