package com.test.cases;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.HomePage;
import com.page.pages.ProductPage;
import com.test.base.TestBase;

public class TestCaseEighteen extends TestBase{

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
	@Test(description = "tc 18")
	public void TC_018_View_Category_Products() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		verifyCategoriesAreVisible();
		clickAndVerifyWomensDress();
		clickAndVerifyMensDress();
	}
	public void verifyCategoriesAreVisible() {
		boolean catgs = new HomePage(driver)
		.getCategories()
		.equals(new ArrayList<String>(Arrays.asList("WOMEN", "MEN", "KIDS")));
		
		Assert.assertTrue(catgs);
	}
	
	public void clickAndVerifyWomensDress() {
		boolean womensCat = new HomePage(driver)
		.expandWomenCategory()
		.clickWomensDress()
		.getProductPageHeader()
		.getText()
		.equals("WOMEN - DRESS PRODUCTS");
		
		Assert.assertTrue(womensCat);
	}
	public void clickAndVerifyMensDress() {
		boolean mensCat = new ProductPage(driver)
		.expandMensCategory()
		.clickMensJeans()
		.getProductPageHeader()
		.getText()
		.equals("MEN - JEANS PRODUCTS");
		
		Assert.assertTrue(mensCat);
	}
}
