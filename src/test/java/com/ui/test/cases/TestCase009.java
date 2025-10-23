package com.ui.test.cases;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.core.base.TestBase;
import com.ui.test.helper.HomePageFlow;
import com.ui.test.helper.ProductPageFlow;

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
		productPageFlow.searchAProduct(config.getProperty("search.keyword"));
		productPageFlow.verifySearchedProductTitleIsVisible();
		productPageFlow.verifySearchedProductsAreDisplayedInSearchResult(config.getProperty("search.keyword"));
	}

}
