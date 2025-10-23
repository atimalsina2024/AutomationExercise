package com.ui.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.core.base.TestBase;
import com.ui.test.helper.CartPageFlow;
import com.ui.test.helper.HomePageFlow;

public class TestCase011 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase011.class);
	private HomePageFlow homePageFlow;
	private CartPageFlow cartPageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase011");
		homePageFlow = new HomePageFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
	}
	
	@Test(description = "cart subscription verificaiton", groups = {"regression", "cart"})
	public void TC_011_Verify_Subscription_In_CartPage() {		
//		✅ Test Case 11: Verify Subscription in Cart page
//
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click 'Cart' button and scroll down to footer
//		5. Verify text 'SUBSCRIPTION'
//		6. Enter email address in input and click arrow button
//		7. Verify success message 'You have been successfully subscribed!' is visible
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToCartPage();
		cartPageFlow.verifySubscriptionVisibleOnFooterOfThePage();

	}
}
