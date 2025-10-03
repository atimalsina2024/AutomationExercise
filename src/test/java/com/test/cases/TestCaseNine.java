package com.test.cases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.ProductPage;
import com.page.pages.SearchProductPage;
import com.test.base.TestBase;

public class TestCaseNine extends TestBase{	
	static String search = "women";
	//	✅ Test Case 9: Search Product
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Verify that home page is visible successfully
//	4. Click on 'Products' button
//	5. Verify user is navigated to ALL PRODUCTS page successfully
//	6. Enter product name in search input and click search button
//	7. Verify 'SEARCHED PRODUCTS' is visible
//	8. Verify all the products related to search are visible
	@Test(description = "search products")
	public void Test_009_Search_Products() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseEight.verifyLandingOnProductsPage();
		searchProductAndVerifySearchedProductsIsVisible();
		verifyProductRelatedToSearch();
	}
	
	public void searchProductAndVerifySearchedProductsIsVisible() {
		boolean searchResultLanding = new ProductPage(driver)
		.enterSearchTextToSearchTextBox(search)
		.clickSearchButton()
		.getLandingPageHeader()
		.getText()
		.toUpperCase()
		.equals("SEARCHED PRODUCTS");		
		Assert.assertTrue(searchResultLanding);
	}
	public void verifyProductRelatedToSearch() {
		List<String> names = new SearchProductPage(driver)
		.getAllSearchResultProductName();
		for(String name: names) {
			Assert.assertTrue(name.toLowerCase().contains(search.toLowerCase()));
		}
	}

}
