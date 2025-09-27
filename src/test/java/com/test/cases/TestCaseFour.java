package com.test.cases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.pages.HomePage;
import com.test.base.TestBase;

public class TestCaseFour extends TestBase{

	@BeforeTest
	public void testSetup() {
		setup();
		driver.get("http://automationexercise.com");
	}
	
	@AfterTest
	public void testTeardown() {
		teardown();
	}
	
	@Test(priority = 1, description = "logout test")
	public void Test_004_LogoutTest() {
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Signup / Login' button
//		5. Verify 'Login to your account' is visible
//		6. Enter correct email address and password
//		7. Click 'login' button
//		8. Verify that 'Logged in as username' is visible
//		9. Click 'Logout' button
//		10. Verify that user is navigated to login page
		TestCaseTwo.Test_002_Login_Positive_02();	
		logout();
		TestCaseTwo.verifyLoginIsVisible();
	}
	
	public void logout() {
		new HomePage(driver).userLogout();
	}
}
