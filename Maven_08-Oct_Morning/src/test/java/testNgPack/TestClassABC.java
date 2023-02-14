package testNgPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browser.Browser;
import pomClasses.LoginOrSignUpPage;
import pomClasses.SignUPPopup;
import utils.Utility;

public class TestClassABC extends Browser{
	
	
	Integer
	int a = 89;
	
	private String testID ;
	
	private WebDriver driver ;
	private LoginOrSignUpPage loginOrSignUpPage ;
	private SignUPPopup signUPPopup  ;
	private SoftAssert softAssert ;
	
	
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
				
		if(browserName.equals("Chrome")) {
			driver = openChromeBrowser();
		}
		
		if(browserName.equals("Firefox")) {
			driver = openFirefoxBrowser();
		}
		
		if(browserName.equals("Opera")) {
			driver = openOperaBrowser();
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
		softAssert = new SoftAssert();
		System.out.println("Before Method");
		
		//String user = Utility.getDataFromExcel("TestData", 1, 0);
		loginOrSignUpPage.sendUserName( Utility.getDataFromExcel("TestData", 1, 0) );
		
		//String pass = Utility.getDataFromExcel("TestData", 1, 1);
		loginOrSignUpPage.sendPassword( Utility.getDataFromExcel("TestData", 1, 1) );
				
		driver.get("https://www.facebook.com/");
		
		null ;
		
		
		https://www.facebook.com/
			
			https://www.sit-facebook.com/
				https://www.dit-facebook.com/
					https://www.rt-facebook.com/
						https://www.uat-facebook.com/
		
		//LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.openSignUpForm();
		
		
	}
	
	@Test
	public void verifyTermsLink123() throws InterruptedException { 
		testID = "T10101" ;
		SoftAssert softAssert = new SoftAssert();
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
		
		String actualText = driver.findElement(By.xpath("//div[@class=\"_1rf2\"]//h2[2]")).getText();
		String expextedTest = "Terms of Service" ;
		
		Assert.assertEquals(actualURL, expectedURL);
	
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertEquals(actualText, expextedTest);
		
		softAssert.assertAll();
	}
	
	@Test
	public void verifyPrivacyPolicyLink123() throws InterruptedException {
		testID = "T12301" ;
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
		testID = "T8756" ;
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
	public void closedCurrentTab(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureSceenshot(t);
		}
		
		
		
		System.out.println("After method");
		driver.close();
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
