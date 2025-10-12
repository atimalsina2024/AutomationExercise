package com.test.cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.page.pages.HomePage;
import com.page.pages.ProductDetail;
import com.page.pages.ProductPage;
import com.test.base.TestBase;
import com.test.helper.HomePageFlow;
import com.test.helper.ProductDetailFlow;
import com.test.helper.ProductPageFlow;

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
	public static void verifyLandingOnProductsPage() {
		String header = new HomePage(driver)
				.clickProductButton()
				.getProductPageHeader()
				.getText();
		Assert.assertEquals(header, "ALL PRODUCTS", "landing on Product page failed");
	}
	public static void clickViewProductDetailAndVerifyProductDetails() {
		ProductDetail productDetail = new ProductPage(driver).clickViewProduct();
		boolean productName = productDetail.getProductName().getText().equals("Blue Top");
		boolean productCategory = productDetail.getCategory().getText().replace("Category: ", "").trim().equals("Women > Tops");
		boolean productPrice = productDetail.getPrice().getText().replace("Rs.", "").strip().equals("500");
		boolean productAvailability = productDetail.getAvailability().replace("Availability:","").strip().equals("In Stock");
		boolean productCondition = productDetail.getCondition().getText().replace("Condition:", "").strip().equals("New");
		boolean productBrand = productDetail.getBrand().getText().replace("Brand:", "").strip().equals("Polo");
		Assert.assertTrue(productName);
		Assert.assertTrue(productCategory);
		Assert.assertTrue(productPrice);
		Assert.assertTrue(productAvailability);
		Assert.assertTrue(productCondition);
		Assert.assertTrue(productBrand);
	}
	
	
	
}
