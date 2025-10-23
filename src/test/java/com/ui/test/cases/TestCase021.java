package com.ui.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.core.base.TestBase;
import com.ui.test.helper.HomePageFlow;
import com.ui.test.helper.ProductDetailFlow;
import com.ui.test.helper.ProductPageFlow;

public class TestCase021 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase021.class);
	private HomePageFlow homePageFlow;
	private ProductPageFlow productPageFlow;
	private ProductDetailFlow productDetailFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase021");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
		productDetailFlow = new ProductDetailFlow(driver);
	}	
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
	@Test(description = "adding review to a product", groups = {"regression", "functional"})
	public void TC_021_Adding_Review_On_A_Product() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToProductPage();
		productPageFlow.verifyLandingOnProductsPage();
		productPageFlow.clickOnBlueTopDetail();
		productDetailFlow.addProductReview(config.getProperty("name"), config.getProperty("email"), config.getProperty("product.review"));
		productDetailFlow.VerifyProductReviewSubmissionSuccessMessage();
	}
	
	
}
