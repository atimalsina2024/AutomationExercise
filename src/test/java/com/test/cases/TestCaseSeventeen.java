package com.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.CartPage;
import com.test.base.TestBase;

public class TestCaseSeventeen extends TestBase{
	
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
	@Test(description = "tc 17")
	public void TC_017_Remove_Products_From_Cart() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseTwelve.hoverAndAddSecondProductToCartAndGoToCart();
		deleteProductsInAndVerifyProductsAreDeleted();
	}
	public static void deleteProductsInAndVerifyProductsAreDeleted() {
		boolean cartMsg = new CartPage(driver)
		.deleteItemsInCart()
		.getEmptyCartMessage()
		.getText()
		.equals("Cart is empty!");		
		Assert.assertTrue(cartMsg);
	}

}
