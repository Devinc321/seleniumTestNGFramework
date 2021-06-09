package tests;

import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmazonSeachDataDrivenTest1 {
	
	String expectedTitle = "Amazon.com. Spend less. Smile more.";
	AmazonHomePage amazon;
	WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	BrowserUtils utils = new BrowserUtils();
	
  @Test(dataProvider = "myDataBucket")
  public void test(String input) {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  AmazonHomePage amazon = new AmazonHomePage();
	  Assert.assertTrue(amazon.searchButton.isDisplayed()); // verify the search button is displayed
	  amazon.twotabsearchtextbox.sendKeys(input);
	  amazon.searchButton.click();
	  utils.waitUntilElementIsVisible(amazon.searchResultText);
	  
	  String searchResultText = amazon.searchResultText.getText();
	  String actualSubstringText = searchResultText.substring(1, searchResultText.length() - 1);
	  Assert.assertEquals(actualSubstringText, input);
	 
	  
  }
  
  @DataProvider
  public String[] myDataBucket() {
	  String[] mydata = new String[5];
	  mydata[0] = "coffee mug";
	  mydata[1] = "pretty coffee mug";
	  mydata[2] = "cool coffee mug";
	  mydata[3] = "cute coffee mug";
	  mydata[4] = "ugly coffee mug";
	  
	  return mydata;
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
