package com.ui.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.core.base.TestBase;
import com.ui.test.helper.HomePageFlow;


public class TestCase010 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase010.class);
	private HomePageFlow homePageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase010");
		homePageFlow = new HomePageFlow(driver);
	}
	@Test(description = "subscription validation",  groups = {"regression", "homePage"})
	public void TC_010_Verify_Subscription() {
//		✅ Test Case 10: Verify Subscription in home page
//
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Scroll down to footer
//		5. Verify text 'SUBSCRIPTION'
//		6. Enter email address in input and click arrow button
//		7. Verify success message 'You have been successfully subscribed!' is visible
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.scrollToFooter();
		homePageFlow.verifySubscriptionIsVisible();
		homePageFlow.enterSubscriptionEmailAndVerifySubscriptionMessage(config.getProperty("email"));
	}
}
