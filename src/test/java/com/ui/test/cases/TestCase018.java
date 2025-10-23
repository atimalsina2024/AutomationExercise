package com.ui.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automation.core.base.TestBase;
import com.ui.test.helper.HomePageFlow;

public class TestCase018 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase018.class);
	private HomePageFlow homePageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase018");
		homePageFlow = new HomePageFlow(driver);
	}	
//	✅ Test Case 18: View Category Products
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Verify that categories are visible on left side bar
//	4. Click on 'Women' category
//	5. Click on any category link under 'Women' category, for example: Dress
//	6. Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'
//	7. On left side bar, click on any sub-category link of 'Men' category
//	8. Verify that user is navigated to that category page
	@Test(description = "Test Case 18: View Category Products", groups = {"regression"})
	public void TC_018_View_Category_Products() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.verifyCategoriesAreVisible();
		homePageFlow.clickAndVerifyWomensDress();
		homePageFlow.clickAndVerifyMensDress();
	}

}
