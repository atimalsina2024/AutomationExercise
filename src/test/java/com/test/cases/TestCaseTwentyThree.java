package com.test.cases;

import org.testng.annotations.Test;

import com.page.pages.CartPage;
import com.test.base.TestBase;
import com.test.models.CustomerInfo;

import utils.JsonUtil;
import utils.PropertyUtil;

public class TestCaseTwentyThree extends TestBase{
	
//	✅ Test Case 23: Verify address details in checkout page
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Verify that home page is visible successfully
//	4. Click 'Signup / Login' button
//	5. Fill all details in Signup and create account
//	6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//	7. Verify ' Logged in as username' at top
//	8. Add products to cart
//	9. Click 'Cart' button
//	10. Verify that cart page is displayed
//	11. Click Proceed To Checkout
//	12. Verify that the delivery address and the billing address is same address filled at the time registration of account
//	13. Click 'Delete Account' button
//	14. Verify 'ACCOUNT DELETED!' and click 'Continue' button
	CustomerInfo customer;
	@Test(description = "tc 23")
	public void TC_023_Verify_Billing_And_Shipping_Address() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseOne.clickSignUpButtonFromHomePage();
		getCustomerInformtion(PropertyUtil.get("accountRegistrationData"));
		TestCaseFourteen.registerNewAccount(customer);
		TestCaseFourteen.fillOutAccountInformationForNewAccount(customer);
		TestCaseFourteen.verifyAccountCreationAndVerifyUserName(customer);
		TestCaseTwentyTwo.addARecommendedProductToCartAndProceedToCart();
		TestCaseFourteen.proceedToCheckoutWhenLoggedIn();
		TestCaseFourteen.verifyShippingAndBillingAddress(customer);
		//TestCaseFourteen.addMessagePlaceOrderAndVerifySuccessMessage("test", customer.getCreditCard());
		navigateToHomePageFromCart();
		TestCaseFourteen.deleteAccount();
	}
	
	public void getCustomerInformtion(String path) {
		customer = JsonUtil.parseAcctInfoJson(path);
	}
	public void navigateToHomePageFromCart() {
		new CartPage(driver)
		.clickHomePageButton();
	}
}
