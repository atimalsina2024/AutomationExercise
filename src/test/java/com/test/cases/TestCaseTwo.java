package com.test.cases;

import static org.testng.Assert.assertTrue;

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
	
	@Test(priority = 1, description = "positive login scenario")
	public void Test_002_Login_Positive_02() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseOne.clickSignUpButton();
		verifyLoginIsVisible();
		login("login@test.com", "test1");
		verifyLoggedInUsernameIsVisible("usr");
	}
	
	//--------------------
	//steps
	//--------------------
	
	public static void verifyLoginIsVisible() {
		boolean rslt = new SignupLogin(driver).getLoginElement().isDisplayed();
		assertTrue(rslt);
	}
	
	public static void login(String email, String password) {
		SignupLogin sl = new SignupLogin(driver);
		sl.setLoginEmail(email);
		sl.setLoginPassword(password);
		sl.clickLoginButton();
	}
	
	public void verifyLoggedInUsernameIsVisible(String username) {
		boolean rslt = new HomePage(driver).getLoggedUserNameText().equals(username);
		assertTrue(rslt);
	}
}
