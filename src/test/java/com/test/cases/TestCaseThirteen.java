package com.test.cases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.CartPage;
import com.page.pages.ProductDetail;
import com.test.base.TestBase;

public class TestCaseThirteen extends TestBase{
	private int quantity = 4;
	@Test
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
		
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseEight.verifyLandingOnProductsPage();
		TestCaseEight.clickViewProductDetailAndVerifyProductDetails();
		increaseProductQuantityInProductDetailPageAndClickAddToCartAndViewCart(quantity);
		verifyProductQuantityInCart();
	}
	public void increaseProductQuantityInProductDetailPageAndClickAddToCartAndViewCart(int quantity) {
		new ProductDetail(driver)
		.increaseQuantity(quantity)
		.clickAddToCartButton()
		.clickViewCart();	
	}
	public void verifyProductQuantityInCart() {
		List<String> quantity = new CartPage(driver)
		.getProductQuantity();
		Assert.assertEquals(quantity.get(0), "4");
	}


}
