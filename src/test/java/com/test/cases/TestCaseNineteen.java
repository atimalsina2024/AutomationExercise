package com.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.ProductPage;
import com.test.base.TestBase;

public class TestCaseNineteen extends TestBase {
//	✅ Test Case 19: View & Cart Brand Products
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Click on 'Products' button
//	4. Verify that Brands are visible on left side bar
//	5. Click on any brand name
//	6. Verify that user is navigated to brand page and brand products are displayed
//	7. On left side bar, click on any other brand link
//	8. Verify that user is navigated to that brand page and can see products	

	@Test(description = "tc 19")
	public void TC_019_View_Cart_Brand_Products() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseEight.verifyLandingOnProductsPage();
		verifyBrandsOnProductPage();
		clickOnPoloAndVerifyLandingOnPoloPage();
	}
	public void verifyBrandsOnProductPage() {
		boolean brandHeader = new ProductPage(driver)
		.getBrandHeader()
		.getText()
		.equals("BRANDS");
		
		Assert.assertTrue(brandHeader);
	}
	
	public void clickOnPoloAndVerifyLandingOnPoloPage() {
		boolean poloLanding = new ProductPage(driver)
		.clickPolo()
		.getLandingHeader()
		.getText()
		.equals("BRAND - POLO PRODUCTS");
		
		Assert.assertTrue(poloLanding);
	}
}
