package com.test.cases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.base.TestBase;

public class TestCaseThree extends TestBase{

	@BeforeTest
	public void testSetup() {
		setup();
		driver.get("http://automationexercise.com");
	}
	
	@AfterTest
	public void testTeardown() {
		teardown();
	}
	
	@Test(description = "Login User with incorrect email and password")
	public void Test_003() {
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Signup / Login' button
//		5. Verify 'Login to your account' is visible
//		6. Enter incorrect email address and password
//		7. Click 'login' button
//		8. Verify error 'Your email or password is incorrect!' is visible
		
	}
}
