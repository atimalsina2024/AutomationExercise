package com.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.CartPage;
import com.page.pages.HomePage;
import com.test.base.TestBase;

public class TestCaseEleven extends TestBase{
	private String subsEmail = "cart@test.com";
	
	@Test(description = "cart subscription verificaiton")
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
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		clickCartAndVerifySubscription();
		verifySubscriptionConfirmationAfterEntereingEmail();
	}
	
	public void clickCartAndVerifySubscription() {
		boolean cartSubscription = new HomePage(driver)
		.clickCartButton()
		.scrollToSubscribe()
		.getText()
		.toUpperCase()
		.equals("SUBSCRIPTION");
		
		Assert.assertTrue(cartSubscription);
	}
	
	public void verifySubscriptionConfirmationAfterEntereingEmail() {
		new CartPage(driver)
		.enterSubscrptionEmail(subsEmail)
		.clickSubscrbeButton()
		.getSubscriptionConfirmationMessage()
		.getText()
		.toUpperCase()
		.equals("You have been successfully subscribed!");
	}
	

}
