package testNgPack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Automation {

	SoftAssert soft ;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite - Automation");
	}

	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String b) {
		System.out.println(b);
		System.out.println("Before Test - Automation");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class - Automation");
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method  - Automation");
		soft = new SoftAssert();
	}
	
	@Test 
	public void test1() {
		//SoftAssert soft = new SoftAssert();
		System.out.println("Test - 1  - Automation");
		
		String actualsTitle = "log in or sign up" ;
		String expectedTitle = "log in or sign up" ;
		
		//soft = new SoftAssert();
		soft.assertEquals(actualsTitle, expectedTitle, "Title is wrong");
		soft.assertAll();
	}
	
	@Test
	public void test2() throws InterruptedException {
		//SoftAssert soft = new SoftAssert();
		System.out.println("Test - 2  - Automation");
		
		String actualsUrl = "https://www.facebook.com/" ;
		String expectedUrl = "https://www.facebook.com/home" ;
		
		soft.assertEquals(actualsUrl, expectedUrl, "URL is wrong");
		soft.assertAll();
		
	}
	
	@Test 
	public void test3() {
		//SoftAssert soft = new SoftAssert();
		System.out.println("Test - 3  - Automation");
		
		String actualButtonText = "Cancel" ;
		String expectedButtonText = "Cancel" ;
		
		soft.assertEquals(actualButtonText, expectedButtonText, "Cancel Button text is wrong");
		soft.assertAll();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method  - Automation");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class  - Automation");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test - Automation");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite - Automation");
	}
	
}


// Suite-tagname    class-annotation
// parameter
// suite         -> @BeforeSuite @AfterSuite
// test          -> @BeforeTest @AfterTest
// class         -> @BefoteClass @AfterClass
// include       -> @BeforeMethod @Test @AfterMethod
//
//
//
//










