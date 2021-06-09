package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class AmazonHomePage {

	public AmazonHomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	//if there is an element ID, just create element abstract object
	@FindBy(id = "twotabsearchtextbox")
	public WebElement twotabsearchtextbox;
	
	@FindBy(id= "nav-search-submit-button")
	public WebElement searchButton;
	
	//@FindBy (xpath=" a[@href='signInButton']")
	@FindBy(xpath = "//a[text()='Sign in securely']")
	public WebElement signInButton;
	
	@FindBy(id = "searchDropDown")
	public WebElement departmentsDropdown;
	
	@FindBy(xpath="//div[@data-component-type='s-search-result']//span[@class='a-price-whole']")
	public List <WebElement> searchItemPrices;
	
	@FindBy(xpath = "//title[contains(text(),'Amazon.com')]")
	public WebElement titlePage;
	
	@FindBy(xpath="")
	public WebElement searchResultText;
	
}
	

