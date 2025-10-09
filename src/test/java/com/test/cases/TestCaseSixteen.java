package com.test.cases;

import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.models.CustomerInfo;

import utils.JsonUtil;
import utils.PropertyUtil;

public class TestCaseSixteen extends TestBase {
//✅ Test Case 16: Place Order: Login before Checkout
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Verify that home page is visible successfully
//	4. Click 'Signup / Login' button
//	5. Fill email, password and click 'Login' button
//	6. Verify 'Logged in as username' at top
//	7. Add products to cart
//	8. Click 'Cart' button
//	9. Verify that cart page is displayed
//	10. Click Proceed To Checkout
//	11. Verify Address Details and Review Your Order
//	12. Enter description in comment text area and click 'Place Order'
//	13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//	14. Click 'Pay and Confirm Order' button
//	15. Verify success message 'Congratulations! Your order has been confirmed!'
	private CustomerInfo custo;
	@Test(description = "tc 16")
	public void TC_16_Login_Before_Checkout() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseOne.clickSignUpButton();
		TestCaseOne.verifySignupInformationIsVisible();
		TestCaseTwo.login(PropertyUtil.get("email"), PropertyUtil.get("password"));
		TestCaseTwo.verifyLoggedInUsernameIsVisible(PropertyUtil.get("name"));
		TestCaseTwelve.hoverAndAddFirstProductToCartAndContinueShopping();
		TestCaseTwelve.hoverAndAddSecondProductToCartAndGoToCart();
		TestCaseFifteen.proceedToCheckInWhenLoggedIn();
		getCustomerInformation();
		TestCaseFourteen.verifyShippingAndBillingAddress(custo);
		TestCaseFourteen.addMessagePlaceOrderAndVerifySuccessMessage("message", custo.getCreditCard());
	}
	public void getCustomerInformation() {
		custo = JsonUtil.parseAcctInfoJson("/Users/work/eclipse-workspace/AutomationExercise/src/test/resources/newAccount.json");

	}

}
