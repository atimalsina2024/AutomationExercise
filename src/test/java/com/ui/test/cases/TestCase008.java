package com.ui.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.core.base.TestBase;
import com.ui.test.helper.HomePageFlow;
import com.ui.test.helper.ProductDetailFlow;
import com.ui.test.helper.ProductPageFlow;

public class TestCase008 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase008.class);
	private HomePageFlow homePageFlow;
	private ProductPageFlow productPageFlow;
	private ProductDetailFlow productDetailFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase008");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
		productDetailFlow = new ProductDetailFlow(driver);
	}
	@Test(description = "product detail verification", groups = {"regression", "product"})
	public void Test_008_Product_Detail_Page_Verification() {
//		✅ Test Case 8: Verify All Products and product detail page
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Products' button
//		5. Verify user is navigated to ALL PRODUCTS page successfully
//		6. The products list is visible
//		7. Click on 'View Product' of first product
//		8. User is landed to product detail page
//		9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToProductPage();
		productPageFlow.verifyLandingOnProductsPage();
		productPageFlow.clickOnBlueTopDetail();
		productDetailFlow.VerifyBlueTopProductDetails();
		//TestCase001.verifyHomePageIsVisibleSuccessfully();
		//verifyLandingOnProductsPage();
		//clickViewProductDetailAndVerifyProductDetails();		
	}
}
