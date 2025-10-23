package com.ui.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.core.base.TestBase;
import com.ui.test.helper.CartPageFlow;
import com.ui.test.helper.DialogBoxFlow;
import com.ui.test.helper.HomePageFlow;
import com.ui.test.helper.ProductPageFlow;

public class TestCase017 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase017.class);
	private HomePageFlow homePageFlow;
	private ProductPageFlow productPageFlow;
	private DialogBoxFlow dialogBoxFlow;
	private CartPageFlow cartPageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase017");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
		dialogBoxFlow = new DialogBoxFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
	}		
//	✅ Test Case 17: Remove Products From Cart
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Verify that home page is visible successfully
//	4. Add products to cart
//	5. Click 'Cart' button
//	6. Verify that cart page is displayed
//	7. Click 'X' button corresponding to particular product
//	8. Verify that product is removed from the cart	
	@Test(description = "Test Case 17: Remove Products From Cart", groups = {"functional"})
	public void TC_017_Remove_Products_From_Cart() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToProductPage();
		productPageFlow.hoverAndAddFirstProduct();
		dialogBoxFlow.continueShopping();
		productPageFlow.hoverAndAddSecondProduct();
		dialogBoxFlow.gotoCart();
		cartPageFlow.deleteAllProductsInCart();
		cartPageFlow.verifyCartIsEmpty();
	}
}
