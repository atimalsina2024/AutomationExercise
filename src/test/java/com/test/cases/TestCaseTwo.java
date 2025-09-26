package com.test.cases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.pages.HomePage;
import com.page.pages.SignupLogin;
import com.test.base.TestBase;

public class TestCaseTwo extends TestBase{

	@BeforeTest
	public void testSetup() {
		setup();
		driver.get("http://automationexercise.com");
		
	}
	
	@AfterTest
	public void testTeardown() {
		teardown();
	}
	
	@Test
	public void Test_002_Login_Positive(){
//		Test Case 2: Login User with correct email and password
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
		HomePage hp = new HomePage(driver);
//		3. Verify that home page is visible successfully
		WebElement homePageHeader = hp.getHomeElement();
		hp.waitForElementToBeVisible(homePageHeader);
		assertTrue(hp.isElementSelected(homePageHeader),"Home Page visibility assert fail");
//		4. Click on 'Signup / Login' button
		hp.clickSignupLoginButton();
//		5. Verify 'Login to your account' is visible
		SignupLogin sl = new SignupLogin(driver);
		WebElement loginElement = sl.getLoginElement();
		sl.waitForVisiblityOfElement(loginElement);
		assertTrue(sl.getLoginElementText().equals("Login to your account"),"Login Page visibility assert fail");
//		6. Enter correct email address and password
		sl.setLoginEmail("login@test.com");
		sl.setLoginPassword("test1");
//		7. Click 'login' button
		sl.clickLoginButton();
//		8. Verify that 'Logged in as username' is visible
		assertTrue(hp.getLoggedUserNameText().equals("usr"));
	}
}
