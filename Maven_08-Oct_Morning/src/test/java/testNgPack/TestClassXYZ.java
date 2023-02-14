package testNgPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pomClasses.LoginOrSignUpPage;
import pomClasses.SignUPPopup;

public class TestClassXYZ {

	private WebDriver driver ;
	private LoginOrSignUpPage loginOrSignUpPage ;
	private SignUPPopup signUPPopup  ;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
				
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver_win32 (6)\\chromedriver.exe");	
			driver = new ChromeDriver();
		}
		
		if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");	
			driver = new FirefoxDriver();
		}
		
		if(browserName.equals("Opera")) {
			System.setProperty("webdriver.opera.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver_win32 (6)\\chromedriver.exe");	
			driver = new OperaDriver();
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void creatPomObjects() {
		loginOrSignUpPage =  new LoginOrSignUpPage(driver);
		signUPPopup = new SignUPPopup(driver);
	}
	
	@BeforeMethod
	public void openSignUpPage() {
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		
		//LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.openSignUpForm();
	}
	
	@Test
	public void verifyTermsLink123() throws InterruptedException {
		System.out.println("Test - 1");
		//SignUPPopup signUPPopup = new SignUPPopup(driver);
		signUPPopup.clickOnTermsLink();
		Thread.sleep(2000);
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		
		String expectedURL = "https://www.facebook.com/legal/terms/update";
		String expectedTitle = "Facebook";
		
		if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
		}
	}
	
	@Test
	public void verifyPrivacyPolicyLink123() throws InterruptedException {
		System.out.println("Test - 2");
		//SignUPPopup signUPPopup = new SignUPPopup(driver);
		signUPPopup.clickOnprivacyPolicyLink();
		Thread.sleep(2000);
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		
		String expectedURL = "https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0";
		String expectedTitle = "Meta Privacy Policy – How Meta collects and uses user data | Privacy Centre";
		
		if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
		}
	}
	
	@Test
	public void VerifyCookiesPolicyLink123() throws InterruptedException {
		System.out.println("Test - 2");
		//SignUPPopup signUPPopup = new SignUPPopup(driver);
		signUPPopup.clickOncookiesPolicyLink();
		Thread.sleep(2000);
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		
		String expectedURL = "https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0";
		String expectedTitle = "Meta Cookies Policy";
		
		if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
		}
	}
	
	@AfterMethod
	public void closedCurrentTab() throws InterruptedException {
		System.out.println("After method");
		driver.close();
		Thread.sleep(2000);
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
	}
	
	@AfterClass
	public void clearPomObjects() {
		loginOrSignUpPage =  null ;
		signUPPopup = null ;
	}
	
	@AfterTest
	public void afterClass() {
		System.out.println("After Class");
		driver.quit();
		driver = null ;
		System.gc(); // garbage collector 	
	}
	
	
}
