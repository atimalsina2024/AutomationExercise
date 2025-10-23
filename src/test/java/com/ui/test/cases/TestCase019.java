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

public class TestCase019 extends TestBase {
	private static final Logger logger = LogManager.getLogger(TestCase019.class);
	private HomePageFlow homePageFlow;
	private ProductPageFlow productPageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCaseNineteen");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
	}
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

	@Test(description = "Test Case 19: View & Cart Brand Products", groups = {"regression", "functional"})
	public void TC_019_View_Cart_Brand_Products() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToProductPage();
		productPageFlow.verifyBrandsOnProductPage();
		productPageFlow.clickOnPoloAndVerifyLandingOnPoloPage();
	}
}
