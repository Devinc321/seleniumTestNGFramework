package tests;

import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AmazonSearchTest {
	
	BrowserUtils utils = new BrowserUtils();
	AmazonHomePage amazonHP = new AmazonHomePage();

	@Test
	public void amazonSearchTest() throws InterruptedException {
		AmazonHomePage amazonHP = new AmazonHomePage();
		Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
		amazonHP.twotabsearchtextbox.sendKeys("coffee mug");
		amazonHP.searchButton.click();
		Thread.sleep(4000);
	}

	@Test
	public void dropDownTest() {
		Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
		amazonHP = new AmazonHomePage();
		BrowserUtils.selectByVisibleText(amazonHP.departmentsDropdown, "Amazon Fresh");
	}

	@BeforeMethod
	public void beforeMethod() {
		Driver.getDriver();
	}

	@AfterMethod
	public void afterMethod() {
		Driver.quitDriver();
	}
}
