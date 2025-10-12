package com.test.cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.helper.CartPageFlow;
import com.test.helper.DialogBoxFlow;
import com.test.helper.HomePageFlow;

public class TestCase022 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase022.class);
	private HomePageFlow homePageFlow;
	private DialogBoxFlow dialogBoxFlow;
	private CartPageFlow cartPageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase022");
		homePageFlow = new HomePageFlow(driver);
		dialogBoxFlow = new DialogBoxFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
	}	
//	✅ Test Case 22: Add to cart from Recommended items
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Scroll to bottom of page
//	4. Verify 'RECOMMENDED ITEMS' are visible
//	5. Click on 'Add To Cart' on Recommended product
//	6. Click on 'View Cart' button
//	7. Verify that product is displayed in cart page
	
	@Test(description = "adding recommended product to cart")
	public void TC_022_Add_Recommended_Product_To_Cart() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.verifyRecommendedItemsIsVisible();
		homePageFlow.addARecommendedProductToCart();
		dialogBoxFlow.gotoCart();
		cartPageFlow.verifyNumberOfProductsInCart(1);
		cartPageFlow.deleteAllProductsInCart();
	}
	
}
