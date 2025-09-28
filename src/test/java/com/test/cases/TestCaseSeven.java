package com.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.HomePage;
import com.test.base.TestBase;

public class TestCaseSeven extends TestBase{
	
	@Test(description = "verify landing on test cases page")
	public void TC_007_Verify_Test_Case_Page() {
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Test Cases' button
//		5. Verify user is navigated to test cases page successfully
		
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		clickTestCaseButtonAndVerifyLandingOnTestCasePage();
	}
	public void clickTestCaseButtonAndVerifyLandingOnTestCasePage() {
		String msg = new HomePage(driver)
		.clickTestCaseButton()
		.getTestCasesLandingElement()
		.getText();		
		Assert.assertEquals(msg, "TEST CASES");
	}

}
