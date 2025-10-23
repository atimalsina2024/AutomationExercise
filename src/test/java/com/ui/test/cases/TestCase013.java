package com.ui.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.automation.core.base.TestBase;
import com.ui.test.helper.CartPageFlow;
import com.ui.test.helper.DialogBoxFlow;
import com.ui.test.helper.HomePageFlow;
import com.ui.test.helper.ProductDetailFlow;
import com.ui.test.helper.ProductPageFlow;

public class TestCase013 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase012.class);
	private HomePageFlow homePageFlow;
	private ProductPageFlow productPageFlow;
	private DialogBoxFlow dialogBoxFlow;
	private CartPageFlow cartPageFlow;
	private ProductDetailFlow productDetailFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase012");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
		dialogBoxFlow = new DialogBoxFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
		productDetailFlow = new ProductDetailFlow(driver);
	}
	
	@Test(description = "increase qty in product detail", groups = {"regression", "functional", "cart"})
	public void Test_013_Verify_Product_Quantity_In_Cart() {
//		✅ Test Case 13: Verify Product quantity in Cart
//
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click 'View Product' for any product on home page
//		5. Verify product detail is opened
//		6. Increase quantity to 4
//		7. Click 'Add to cart' button
//		8. Click 'View Cart' button
//		9. Verify that product is displayed in cart page with exact quantity
		homePageFlow.verifyCurrentlyOnHomePage();
		productPageFlow.verifyLandingOnProductsPage();
		productPageFlow.clickOnBlueTopDetail();
		productDetailFlow.VerifyBlueTopProductDetails();
		productDetailFlow.increaseQuantity(4);
		productDetailFlow.addProductToCart();
		dialogBoxFlow.gotoCart();
		cartPageFlow.verifyProductQuantityInCart(4);
	}
}
