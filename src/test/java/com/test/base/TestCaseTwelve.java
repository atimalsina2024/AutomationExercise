package com.test.base;

import com.test.cases.TestCaseEight;
import com.test.cases.TestCaseOne;

public class TestCaseTwelve extends TestBase{
	
	public void TC_012_Add_Products_To_Cart() {
//		✅ Test Case 12: Add Products in Cart
//
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click 'Products' button
//		5. Hover over first product and click 'Add to cart'
//		6. Click 'Continue Shopping' button
//		7. Hover over second product and click 'Add to cart'
//		8. Click 'View Cart' button
//		9. Verify both products are added to Cart
//		10. Verify their prices, quantity and total price
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseEight.verifyLandidriveroductsPage();
	}

}
