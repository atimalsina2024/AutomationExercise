package com.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.ProductDetail;
import com.test.base.TestBase;

public class TestCaseTwentyOne extends TestBase{

//	✅ Test Case 21: Add review on product
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Click on 'Products' button
//	4. Verify user is navigated to ALL PRODUCTS page successfully
//	5. Click on 'View Product' button
//	6. Verify 'Write Your Review' is visible
//	7. Enter name, email and review
//	8. Click 'Submit' button
//	9. Verify success message 'Thank you for your review.'
	@Test(description = "adding review to a product")
	public void TC_021_Adding_Review_On_A_Product() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseEight.verifyLandingOnProductsPage();
		TestCaseEight.clickViewProductDetailAndVerifyProductDetails();
		addProductReviewAndVerifySuccessMessage("name", "a@b.com", "test message");
	}
	
	public void addProductReviewAndVerifySuccessMessage(String name, String email, String message) {
		boolean submissionSuccess = new ProductDetail(driver)
		.enterName(name)
		.enterEmail(email)
		.enterMessage(message)
		.clickSubmitButton()
		.getReviewSubmissionMessage()
		.getText()
		.equals("Thank you for your review.");
		
		Assert.assertTrue(submissionSuccess);
	}
}
