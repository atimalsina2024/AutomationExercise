package com.test.cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.helper.HomePageFlow;

public class TestCaseTwentySix extends TestBase{

	private static final Logger logger = LogManager.getLogger(TestCase025.class);
	private HomePageFlow homePageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase025");
		homePageFlow = new HomePageFlow(driver);
	}		
//	✅ Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Verify that home page is visible successfully
//	4. Scroll down page to bottom
//	5. Verify 'SUBSCRIPTION' is visible
//	6. Scroll up page to top
//	7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
	
	@Test(description = "tc 26")
	public void TC_026_Scroll_Up_And_Down() {
		homePageFlow.verifyPageBodyMessageIsSeen();
		homePageFlow.scrollToFooter();
		homePageFlow.verifySubscriptionIsVisible();
		homePageFlow.scrollToTop();
		homePageFlow.verifyPageBodyMessageIsSeen();
	}
}
