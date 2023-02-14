package pomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {
	
	// Variable - private - WebElements 
	
	@FindBy (xpath = "//input[@id='email']") 
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@id='pass']") 
	private WebElement password ;
	
	@FindBy (xpath = "//button[text()='Log in']") 
	private WebElement loginButton ;
	
	@FindBy (xpath = "//a[text()='Forgotten password?']") 
	private WebElement forgotPasswordLink ;
	
	@FindBy (xpath = "//a[text()='Create new account']") 
	private WebElement createNewAcc ;
	
	@FindBy (xpath = "//a[text()='Create a Page']") 
	private WebElement createPage ;
	
	// Constructor - public - WebElement Initialization (Find)
	public LoginOrSignUpPage(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);
	}
	
	// Methods - public - WebElement Action 
	
	public void sendUserName(String user) {
		userName.sendKeys(user);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void clickOnForgotPasswordLink() {
		forgotPasswordLink.click();
	}
	         // clickOnCreatNewAccount
	public void openSignUpForm() {
		createNewAcc.click();
	}
}
