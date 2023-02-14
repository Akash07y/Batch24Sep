package pomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUPPopup {
	private WebDriver driverG;
	private Actions act ;
	private WebDriverWait wait ;
	
	@FindBy (xpath = "//input[@name='firstname']") 
	private WebElement firstName ;
	
	@FindBy (xpath = "//input[@name='lastname']") 
	private WebElement lastName ;
	
	@FindBy (xpath = "//input[contains(@name,'email')]") 
	private WebElement emailId ;
	
	@FindBy (xpath = "(//input[contains(@type,'password')])[2]") 
	private WebElement newPassword ;
	
	@FindBy (xpath = "//select[@id='day']") 
	private WebElement dayOfBirth ;
	
	@FindBy (xpath = "//select[@id='month']") 
	private WebElement monthOfBirth ;
	
	@FindBy (xpath = "//select[@id='year']") 
	private WebElement yearOfBirth ;
	
	@FindBy (xpath = "(//input[@type='radio'])[1]") 
	private WebElement femaleRadioButton ;
	
	@FindBy (xpath = "(//input[@type='radio'])[2]") 
	private WebElement maleRadioButton ;
	
	@FindBy (xpath = "(//input[@type='radio'])[3]") 
	private WebElement customRadioButton ;
	
	@FindBy (xpath = "(//button[text()='Sign Up'])[1]") 
	private WebElement submitButton ;
	
	@FindBy (xpath = "(//a[text()='Terms'])[2]") 
	private WebElement termsLink ;
	
	@FindBy (xpath = "(//a[text()='Privacy Policy'])[2]") 
	private WebElement provacyPolicy ;
	
	@FindBy (xpath = "//a[text()='Cookies Policy']") 
	private WebElement cookiesPolicy ;

	@FindBy (xpath = "common xpath") 
	private List<WebElement> links ;
		
	public SignUPPopup(WebDriver driver)   // driver = driverTest =new ChromeDrive()
	{
		PageFactory.initElements(driver, this);
		this.driverG = driver ; // initilizate the global driver
		act = new Actions(driver);
		wait = new WebDriverWait(driverG, 20);
	}
	public void clickOnTermsLink() {
		termsLink.click();
	}
	public void clickOnprivacyPolicyLink() {
		provacyPolicy.click();
			}
	public void clickOncookiesPolicyLink() {
		cookiesPolicy.click();	}
	// Scenario 2 => Waiting for both element is SAME 
	public void sendFirstName(String name) {
		//WebDriverWait wait = new WebDriverWait(driverG, 20);
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(name);
	}
	
	public void sendLastName(String name) {
		//WebDriverWait wait = new WebDriverWait(driverG, 20);
		wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.sendKeys(name);
	}
	
	public void sendEmailOrMobileNumber(String emailOrPhone) {
		emailId.sendKeys(emailOrPhone);
	}
	
	public void sendNewPassword(String password) {
		emailId.sendKeys(password);
	}
	
	public void selectDayOfBirth(String name) {
		//dayOfBirth.sendKeys(name);
		Select s = new Select(dayOfBirth);
		s.selectByVisibleText("15");
	}
	
	public void selectMonthOfBirth(String name) {
		//monthOfBirth.sendKeys(name);
		Select s = new Select(monthOfBirth);
		s.selectByVisibleText("Apr");
	}
	
	public void selectYearOfBirth(String name) {
		//yearOfBirth.sendKeys(name);
		Select s = new Select(yearOfBirth);
		s.selectByVisibleText("2000");
	}
	
	public void selectFemaleRadioButton() {
		femaleRadioButton.click();
	}
	
	public void selectMaleRadioButton() {
		maleRadioButton.click();
	}
	
	public void selectCustomRadioButton() {
		//customRadioButton.click();
		//Actions act = new Actions(driverG);
		act.moveToElement(customRadioButton).click().build().perform();
	}
	
	public void clickOnSubmitButton() {
		//submitButton.click();
		//Actions act = new Actions(driverG);
		act.moveToElement(submitButton).click().build().perform();
	}
}

