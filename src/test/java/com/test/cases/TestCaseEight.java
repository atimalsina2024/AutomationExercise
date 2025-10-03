package com.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.HomePage;
import com.page.pages.ProductDetail;
import com.page.pages.ProductPage;
import com.test.base.TestBase;

public class TestCaseEight extends TestBase{

	@Test(description = "product detail verification")
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
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		verifyLandingOnProductsPage();
		clickViewProductDetailAndVerifyProductDetails();		
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
