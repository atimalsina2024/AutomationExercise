package com.test.cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.helper.HomePageFlow;

public class TestCase025 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase025.class);
	private HomePageFlow homePageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase025");
		homePageFlow = new HomePageFlow(driver);
	}		
//	✅ Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Verify that home page is visible successfully
//	4. Scroll down page to bottom
//	5. Verify 'SUBSCRIPTION' is visible
//	6. Click on arrow at bottom right side to move upward
//	7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
	@Test
	public void TC_025_Scroll_Up_And_Down() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.scrollToFooter();
		homePageFlow.verifySubscriptionIsVisible();
		homePageFlow.scrollToTopUsingArrow();
		homePageFlow.verifyPageBodyMessageIsSeen();
	}
}
