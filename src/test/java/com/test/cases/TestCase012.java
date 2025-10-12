package com.test.cases;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.helper.CartPageFlow;
import com.test.helper.DialogBoxFlow;
import com.test.helper.HomePageFlow;
import com.test.helper.ProductPageFlow;

import utils.PropertyUtil;

public class TestCase012 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase012.class);
	private HomePageFlow homePageFlow;
	private ProductPageFlow productPageFlow;
	private DialogBoxFlow dialogBoxFlow;
	private CartPageFlow cartPageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase012");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
		dialogBoxFlow = new DialogBoxFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
	}
	
	int quantity = 1;
	@Test(description = "items in cart", groups = {"regression", "cart", "functional"})
	public void TC_012_Add_Products_To_Cart() {
//		✅ Test Case 12: Add Products in Cart
//
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click 'Products' button
//		5. Hover over first product and click 'Add to cart'
//		6. Click 'Continue Shopping' button
//		7. Hover over second product and click 'Add to cart'
//		8. Click 'View Cart' button
//		9. Verify both products are added to Cart
//		10. Verify their prices, quantity and total price
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToProductPage();
		productPageFlow.hoverAndAddFirstProduct();
		dialogBoxFlow.continueShopping();
		productPageFlow.hoverAndAddSecondProduct();
		dialogBoxFlow.gotoCart();
		cartPageFlow.verifyAddedProductsPresentInCart(new ArrayList<String>(Arrays.asList(PropertyUtil.get("first.product"), PropertyUtil.get("second.product"))));
		cartPageFlow.verifyPriceQuantityAndTotalPriceOfAddedProducts(1);
	}
}
