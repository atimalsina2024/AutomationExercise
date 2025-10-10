package com.test.cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.HomePage;
import com.test.base.TestBase;

public class TestCaseTwentyFive extends TestBase{
	
//	✅ Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Verify that home page is visible successfully
//	4. Scroll down page to bottom
//	5. Verify 'SUBSCRIPTION' is visible
//	6. Click on arrow at bottom right side to move upward
//	7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
	private static final Logger logger = LogManager.getLogger(TestCaseTwentyFive.class);
	@Test
	public void TC_025_Scroll_Up_And_Down() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseTen.ScrollToFooterAndVerifySubscription();
		scrollToTopAndValidateLandingMessage();	
	}
	
	public void scrollToTopAndValidateLandingMessage() {
		logger.info("scrolling up");
		boolean msg = new HomePage(driver)
		.clickScrollUpArrow()
		.getLandingCarousel()
		.isDisplayed();
		
		Assert.assertTrue(msg);
	}
}
