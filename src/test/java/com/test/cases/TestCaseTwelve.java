package com.test.cases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.CartPage;
import com.page.pages.ProductPage;
import com.test.base.TestBase;

public class TestCaseTwelve extends TestBase{
	int quantity = 1;
	@Test(description = "items in cart")
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
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseEight.verifyLandingOnProductsPage();
		hoverAndAddFirstProductToCartAndContinueShopping();
		hoverAndAddSecondProductToCartAndGoToCart();
		verifyBothProductsAreAddedToCart();
		verifyPriceQuantityAndTotalPrice(quantity);
	}
	public static void hoverAndAddFirstProductToCartAndContinueShopping() {
		new ProductPage(driver)
		.hoverOnFirstProduct()
		.clickAddToCartFirstProduct()
		.clickContinueShopping();
	}
	public static void hoverAndAddSecondProductToCartAndGoToCart() {
		new ProductPage(driver)
		.hoverOnSecondProduct()
		.clickAddToCartSecondProduct()
		.clickViewCart();
	}
	public static void verifyBothProductsAreAddedToCart() {
		List<String> expected = new ArrayList<>(Arrays.asList("Blue Top", "Men Tshirt"));
		List<String> actual = new CartPage(driver)
		.getProductNames();
		Assert.assertEquals(actual, expected);
	}
	public static void verifyPriceQuantityAndTotalPrice(int qty) {
		CartPage cart = new CartPage(driver);
		List<String> price = cart.getProductPrice();
		List<String> quantity = cart.getProductQuantity();
		List<String>  total = cart.getTotalPrice();
		
		for(int i=0; i<price.size(); i++) {
			Assert.assertEquals(total.get(i), price.get(i));
			Assert.assertEquals(quantity.get(i), Integer.toString(qty));
		}
	}

}
