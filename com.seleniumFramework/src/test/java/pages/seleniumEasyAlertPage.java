package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class seleniumEasyAlertPage {

	public seleniumEasyAlertPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//button[@onclick='myAlertFunction()']")
	public WebElement firstAlertBtn;
	
	public void clickMe() {
		firstAlertBtn.click();
	}
	
	@FindBy(xpath="//button[@onclick='myConfirmFunction()']")
	public WebElement secondAlertBtn;
}
