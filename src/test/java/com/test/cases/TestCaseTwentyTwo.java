package com.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.HomePage;
import com.test.base.TestBase;

public class TestCaseTwentyTwo extends TestBase{
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
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		verifyRecommendedItemsIsVisible();
		addARecommendedProductToCartAndProceedToCart();
	}
	public void verifyRecommendedItemsIsVisible() {
		boolean recoHeader = new HomePage(driver)
		.getRemmendedItemHeader()
		.getText()
		.toUpperCase()
		.equals("RECOMMENDED ITEMS");

		Assert.assertTrue(recoHeader, "Recommendation header");
	}
	
	public static void addARecommendedProductToCartAndProceedToCart() {
		boolean recoProductInCart = new HomePage(driver)
		.addRecommendedProductToCart()
		.clickViewCart()
		.getProductNames()
		.size() == 1;
		
		Assert.assertTrue(recoProductInCart);
	}
}
