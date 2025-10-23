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
import com.ui.test.helper.UserLoginFlow;


public class TestCase020 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase020.class);
	private HomePageFlow homePageFlow;
	private UserLoginFlow userLoginFlow;
	private ProductPageFlow productPageFlow;
	private CartPageFlow cartPageFlow;
	private DialogBoxFlow dialogBoxFlow;
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase020");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
		userLoginFlow = new UserLoginFlow(driver);
		dialogBoxFlow = new DialogBoxFlow(driver);
	}		
//	✅ Test Case 20: Search Products and Verify Cart After Login
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Click on 'Products' button
//	4. Verify user is navigated to ALL PRODUCTS page successfully
//	5. Enter product name in search input and click search button
//	6. Verify 'SEARCHED PRODUCTS' is visible
//	7. Verify all the products related to search are visible
//	8. Add those products to cart
//	9. Click 'Cart' button and verify that products are visible in cart
//	10. Click 'Signup / Login' button and submit login details
//	11. Again, go to Cart page
//	12. Verify that those products are visible in cart after login as well
//	13. Remove all products that have been added
//	14. Verify 'Cart is empty! Click here to buy products.' is visible
	@Test(description = "tc_20", groups = {"functional", "cart", "regression"})
	public void TC_020_Search_Products_And_Add_Them_To_Cart() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToProductPage();
		productPageFlow.verifyLandingOnProductsPage();
		productPageFlow.searchAProduct(config.getProperty("search.keyword"));
		productPageFlow.verifySearchedProductsAreDisplayedInSearchResult(config.getProperty("search.keyword"));
		productPageFlow.addAllSearchedProductsToCart();
		productPageFlow.navigateToCartPage();
		cartPageFlow.verifyNumberOfProductsInCart(2);
		cartPageFlow.proceedToCheckout();
		dialogBoxFlow.proceedToLoginRegister();
		userLoginFlow.login(config.getProperty("email"), config.getProperty("password"));
		homePageFlow.navigateToCartPage();
		cartPageFlow.verifyNumberOfProductsInCart(2);
		cartPageFlow.deleteAllProductsInCart();
		cartPageFlow.verifyCartIsEmpty();
	}
}
