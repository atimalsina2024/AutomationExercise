package com.ui.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.core.base.TestBase;
import com.ui.test.helper.CartPageFlow;
import com.ui.test.helper.DeleteUserFlow;
import com.ui.test.helper.DialogBoxFlow;
import com.ui.test.helper.HomePageFlow;
import com.ui.test.helper.NewUserRegistrationFlow;
import com.ui.test.helper.PaymentPageFlow;
import com.ui.test.helper.ProductPageFlow;
import com.ui.test.models.CustomerInfo;

import utils.JsonUtil;

public class TestCase015 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase015.class);
	private HomePageFlow homePageFlow;
	private ProductPageFlow productPageFlow;
	private NewUserRegistrationFlow newUserRegistrationFlow;
	private DeleteUserFlow deleteUserFlow;
	private CustomerInfo customer;
	private String msg = "message";
	private DialogBoxFlow dialogBoxFlow;
	private CartPageFlow cartPageFlow;
	private PaymentPageFlow paymentPageFlow;
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
		newUserRegistrationFlow = new NewUserRegistrationFlow(driver);
		deleteUserFlow = new DeleteUserFlow(driver);
		customer = JsonUtil.parseAcctInfoJson(config.getProperty("account.registration.data"));
		dialogBoxFlow = new DialogBoxFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
		paymentPageFlow = new PaymentPageFlow(driver);
	}	
//✅ Test Case 15: Place Order: Register before Checkout
//
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click 'Signup / Login' button
//5. Fill all details in Signup and create account
//6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//7. Verify ' Logged in as username' at top
//8. Add products to cart
//9. Click 'Cart' button
//10. Verify that cart page is displayed
//11. Click Proceed To Checkout
//12. Verify Address Details and Review Your Order
//13. Enter description in comment text area and click 'Place Order'
//14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//15. Click 'Pay and Confirm Order' button
//16. Verify success message 'Congratulations! Your order has been confirmed!'
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' and click 'Continue' button
	@Test(description = "Test Case 15: Place Order: Register before Checkout", groups = {"regression"})
	public void TC_015_Register_Before_Checkout() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToSignupLoginPage();
		newUserRegistrationFlow.verifySignupInformationIsVisible();
		newUserRegistrationFlow.signupNewUserPositive(customer);
		newUserRegistrationFlow.verifyNavigationToAccountInformationPage();
		newUserRegistrationFlow.fillAccountDetailsAndCreateAccount(customer);
		newUserRegistrationFlow.verifyAccountCreated();
		newUserRegistrationFlow.continueToHomePageFromAccountRegistrationPage();
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
	}
}
	
