package pomClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

	private WebDriver driver ;
	private Actions act ; 
	
	@FindBy (xpath = "//table//tr[1]//td[2]//div") 
	private WebElement forgotMessage ;
	
	@FindBy (xpath = "(//input[@name='email'])[2]") 
	private WebElement emailOrPhoneNumner ;
	
	@FindBy (xpath = "//a[text()='Cancel']") 
	private WebElement cancelButton ;

	@FindBy (xpath = "//button[text()='Search']") 
	private WebElement searchButton ;
	
	
	public ForgotPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		act = new Actions(driver);
	}
	
	public String getLink(int index) {
		String attributeValue =  links.get(index).getAttribute("href");
		return attributeValue ;
	}
	
	                                 // Selenium - 3.141.59
	public void getTextMessage() {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("window.scrollIntoView(true);",forgotMessage);
		String text = forgotMessage.getText();
	}
	
	public void sendEmailOrPhoneNumber() {
		WebDriverWait wait = new WebDriverWait(driver,30); // 20 Sec
		wait.until(ExpectedConditions.visibilityOf(emailOrPhoneNumner));
		emailOrPhoneNumner.click();
	}
	
	public void clickOnSearchButton() {
		//Actions act = new Actions(driver);
		act.moveToElement(searchButton).click().perform();
	}
	
	public void clickOnCancelButton() {
		//Actions act = new Actions(driver);
		act.moveToElement(cancelButton).click().perform();
	}
	
	
	public boolean getStatusOfCancelButton() {
		boolean result = cancelButton.isDisplayed();
		boolean result = cancelButton.isEnabled();
		return result ;
	}
	

	

	
}
