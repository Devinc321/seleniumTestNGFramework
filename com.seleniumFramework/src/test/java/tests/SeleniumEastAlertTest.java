package tests;

import org.testng.annotations.Test;

import pages.seleniumEasyAlertPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class SeleniumEastAlertTest {

	seleniumEasyAlertPage alertPage = new seleniumEasyAlertPage();
	BrowserUtils utils = new BrowserUtils();

	@Test
	public void firstAlertTest() throws InterruptedException {
		Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertURL"));
		alertPage.clickMe();
		utils.switchToAlert();
		utils.waitUntilAlertIsPresent();

		String expectedMessage = "I am an alert box!";
		String actual = utils.alertGetText();

		Assert.assertEquals(actual, expectedMessage);
		Thread.sleep(3000);
		utils.alertAccept();

	}

	@Test
	public void secondAlertTest() throws InterruptedException {
		String expectedMessage = "Press a button!";

		Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertURL"));
		alertPage.secondAlertBtn.click();
		utils.switchToAlert();
		utils.waitUntilAlertIsPresent();
		String actualMessage = utils.alertGetText();

		Assert.assertEquals(actualMessage, expectedMessage);
		Thread.sleep(3000);
		utils.alertDismiss();
	}

	@BeforeTest
	public void beforeTest() {
		Driver.getDriver();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	

	@AfterTest
	public void afterTest() {
		Driver.quitDriver();
	}

}
