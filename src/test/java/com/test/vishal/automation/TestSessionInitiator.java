package com.test.vishal.automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.vishal.keywords.HomePage;
import com.test.vishal.keywords.LoginPage;
import com.test.vishal.keywords.MyAccountPage;
import com.test.vishal.keywords.ProductPage;
import com.test.vishal.utils.YamlReader;

public class TestSessionInitiator {
	
	private WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public MyAccountPage myAccountPage;
	public ProductPage productPage;
	
	public TestSessionInitiator() {
		testInitiator();
	}
    
	public void initPage() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		myAccountPage = new MyAccountPage(driver);
		productPage = new ProductPage(driver);
	}
	
	public void testInitiator() {
		initWebdriver();
		initPage();
	}
	
	public void initWebdriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage()
				.timeouts()
				.implicitlyWait(Integer.parseInt(YamlReader.getYamlValue("timeout")),
						TimeUnit.SECONDS);
	}
	
	public void launchApp() {
		driver.get(YamlReader.getYamlValue("app_url"));
	}
	
	public void closeBrowserSession() {
		driver.quit();
	}
}
