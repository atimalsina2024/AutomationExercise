package com.test.cases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.page.pages.SignupLogin;
import com.test.base.TestBase;

public class TestCaseFive extends TestBase{

	@Test(description = "register acct with email that is already used")
	public void TC_005_Register_Negative() {
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Signup / Login' button
//		5. Verify 'New User Signup!' is visible
//		6. Enter name and already registered email address
//		7. Click 'Signup' button
//		8. Verify error 'Email Address already exist!' is visible
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseOne.clickSignUpButton();
		TestCaseOne.verifySignupInformationIsVisible();
		TestCaseOne.signUp("usr", "login@test.com");
		verifyIncorrectEmailError();
	}
	
	public void verifyIncorrectEmailError() {
		boolean result = new SignupLogin(driver).getSignupEmailErrorMsgElement().isDisplayed();
		assertTrue(result, "sign up email negative test fail");
	}
}
