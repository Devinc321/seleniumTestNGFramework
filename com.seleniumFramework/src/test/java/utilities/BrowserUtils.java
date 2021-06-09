package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrowserUtils {

	static Alert alert;
	static WebDriverWait letsWait; 
	static Select letsSelect;

	public void switchToAlert() {
		 alert = Driver.getDriver().switchTo().alert();
	}
	
	public void alertAccept() {
		 alert.accept();
	}
	
	public void alertDismiss() {
		 alert.dismiss();;
	}
	
	
	public String alertGetText() {
		return alert.getText();
	}
	
	
	public static void waitUntilAlertIsPresent() {
		letsWait = new WebDriverWait(Driver.getDriver(), 10);
		letsWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void waitUntilElementIsVisible(WebElement ELEMENT) {
		 letsWait= new WebDriverWait(Driver.getDriver(), 10);
		 letsWait.until(ExpectedConditions.visibilityOf(ELEMENT));
		}
	
	public static void selectByVisibleText(WebElement element, String optionToSelect) {
		letsSelect = new Select(element);
		letsSelect.selectByVisibleText(optionToSelect);
	}
	
	
	
	
}
