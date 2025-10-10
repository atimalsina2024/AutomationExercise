package com.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.CartPage;
import com.page.pages.SearchProductPage;
import com.test.base.TestBase;

import utils.PropertyUtil;

public class TestCaseTwenty extends TestBase{
	
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
	@Test(description = "tc_20")
	public void TC_020_Search_Products_And_Add_Them_To_Cart() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseEight.verifyLandingOnProductsPage();
		TestCaseNine.searchProductAndVerifySearchedProductsIsVisible();
		TestCaseNine.verifyProductRelatedToSearch();
		addSearchedProductToCart();
		proceedToCartFromSearchedProductsPage();
		verifyNumberOfProductsInCart();
		TestCaseFourteen.proceedToCheckOutFromCart();
		TestCaseTwo.loginFromLoginPage(PropertyUtil.get("email"), PropertyUtil.get("password"));
		TestCaseFourteen.proceedTocartFromHomePage();
		verifyNumberOfProductsInCart();
		TestCaseSeventeen.deleteProductsInAndVerifyProductsAreDeleted();
	}
	public void addSearchedProductToCart() {
		SearchProductPage sp = new SearchProductPage(driver);
		sp.getSearchedProductElements()
		.stream()
		.forEach(element ->{
			sp.hoverOnProduct(element)
			.addProductToCart(element)
			.clickContinueShopping();
		});
	}
	public void proceedToCartFromSearchedProductsPage() {
		new SearchProductPage(driver)
		.clickCartButton();
	}
	public void verifyNumberOfProductsInCart() {
		boolean productSize = new CartPage(driver)
		.getProductNames()
		.size() == 2;		
		Assert.assertTrue(productSize, "number of products assertion fail");
	}

}
