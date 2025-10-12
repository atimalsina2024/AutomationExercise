package com.test.cases;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.page.pages.ProductPage;
import com.page.pages.SearchProductPage;
import com.test.base.TestBase;
import com.test.helper.HomePageFlow;
import com.test.helper.ProductPageFlow;

import utils.PropertyUtil;

public class TestCase009 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase009.class);
	private HomePageFlow homePageFlow;
	private ProductPageFlow productPageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase009");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
	}
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
	@Test(description = "search products", groups = {"regression", "products"})
	public void Test_009_Search_Products() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToProductPage();
		productPageFlow.verifyLandingOnProductsPage();
		productPageFlow.searchAProduct(PropertyUtil.get("search.keyword"));
		productPageFlow.verifySearchedProductTitleIsVisible();
		productPageFlow.verifySearchedProductsAreDisplayedInSearchResult(PropertyUtil.get("search.keyword"));
	}
	
	public static void searchProductAndVerifySearchedProductsIsVisible() {
		boolean searchResultLanding = new ProductPage(driver)
		.enterSearchTextToSearchTextBox(PropertyUtil.get("search.keyword"))
		.clickSearchButton()
		.getLandingPageHeader()
		.getText()
		.toUpperCase()
		.equals("SEARCHED PRODUCTS");		
		Assert.assertTrue(searchResultLanding);
	}
	public static void verifyProductRelatedToSearch() {
		List<String> names = new SearchProductPage(driver)
		.getAllSearchResultProductName();
		for(String name: names) {
			Assert.assertTrue(name.toLowerCase().contains(PropertyUtil.get("search.keyword").toLowerCase()));
		}
	}

}
