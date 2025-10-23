package com.ui.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automation.core.base.TestBase;
import com.ui.test.helper.CartPageFlow;
import com.ui.test.helper.DeleteUserFlow;
import com.ui.test.helper.DialogBoxFlow;
import com.ui.test.helper.HomePageFlow;
import com.ui.test.helper.PaymentPageFlow;
import com.ui.test.helper.ProductPageFlow;
import com.ui.test.helper.UserLoginFlow;
import com.ui.test.models.CustomerInfo;

import utils.JsonUtil;

public class TestCase016 extends TestBase {
	private static final Logger logger = LogManager.getLogger(TestCase016.class);
	private HomePageFlow homePageFlow;
	private UserLoginFlow userLoginFlow;
	private ProductPageFlow productPageFlow;
	private DeleteUserFlow deleteUserFlow;
	private CustomerInfo customer;
	private String msg = "message";
	private DialogBoxFlow dialogBoxFlow;
	private CartPageFlow cartPageFlow;
	private PaymentPageFlow paymentPageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase016");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
		deleteUserFlow = new DeleteUserFlow(driver);
		customer = JsonUtil.parseAcctInfoJson(config.getProperty("account.registration.data"));
		dialogBoxFlow = new DialogBoxFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
		paymentPageFlow = new PaymentPageFlow(driver);
		userLoginFlow = new UserLoginFlow(driver);
	}	
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
	@Test(description = "Test Case 16: Place Order: Login before Checkout", groups = {"regression"})
	public void TC_16_Login_Before_Checkout() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToSignupLoginPage();
		userLoginFlow.verifyLoginIsVisible();
		userLoginFlow.login(config.getProperty("email"), config.getProperty("password"));
		homePageFlow.verifyUsernameVisibilityFromHomePage();
		homePageFlow.navigateToProductPage();
		productPageFlow.hoverAndAddFirstProduct();
		dialogBoxFlow.continueShopping();
		productPageFlow.hoverAndAddSecondProduct();
		dialogBoxFlow.gotoCart();
		cartPageFlow.proceedToCheckout();
		cartPageFlow.verifyShippingAndBillingAddress(customer);
		cartPageFlow.addMessageAndPlaceOrder(msg);
		paymentPageFlow.makePaymentAndVerifyOrderSuccess(customer.getCreditCard());
		paymentPageFlow.proceedToHomePageFromSuccessfulOrderPlacement();
		homePageFlow.deleteUser();
		deleteUserFlow.verifyDeletionConfirmation();
		deleteUserFlow.continueToHomePageAfterUserDeletionConfirmation();
	}

}
