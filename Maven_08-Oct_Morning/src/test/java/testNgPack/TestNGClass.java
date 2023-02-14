package testNgPack;

import org.testng.Assert;
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

public class  TestNGClass {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite - TestNGClass");
	}
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String b) {
		System.out.println(b);
		System.out.println("Before Test - TestNGClass");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class - TestNGClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method - TestNGClass");
	}
	
	@Test 
	public void testA() {
		System.out.println("Test - A - TestNGClass");
		
		String actualsTitle = "log in or sign up" ;
		String expectedTitle = "Facebook – log in or sign up" ;
		
		SoftAssert soft = new SoftAssert();
		

		// to failed the test method forcefully
		soft.fail(); 
		
		// to apply the result of (soft) assertion on test method 
		soft.assertAll();
		
		
		
		
	
	}
	
	@Test
	public void testB() {
		System.out.println("Test - B - TestNGClass");
		Assert.fail();
	}
	
	@Test 
	public void testC() {
		System.out.println("Test - C - TestNGClass");
	}
	
	@Test
	public void testD() {
		System.out.println("Test - D - TestNGClass");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method - TestNGClass");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class - TestNGClass");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test - TestNGClass");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite - TestNGClass");
	}
}
