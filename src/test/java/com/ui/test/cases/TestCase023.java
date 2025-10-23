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
import com.ui.test.models.CustomerInfo;

import utils.JsonUtil;

public class TestCase023 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase016.class);
	private HomePageFlow homePageFlow;
	private NewUserRegistrationFlow newUserRegistrationFlow;
	private DeleteUserFlow deleteUserFlow;
	private CustomerInfo customer;
	private DialogBoxFlow dialogBoxFlow;
	private CartPageFlow cartPageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase016");
		homePageFlow = new HomePageFlow(driver);
		deleteUserFlow = new DeleteUserFlow(driver);
		customer = JsonUtil.parseAcctInfoJson(config.getProperty("account.registration.data"));
		dialogBoxFlow = new DialogBoxFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
		newUserRegistrationFlow = new NewUserRegistrationFlow(driver);
	}		
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
	@Test(description = "Test Case 23: Verify address details in checkout page", groups = {"functional", "regression"})
	public void TC_023_Verify_Billing_And_Shipping_Address() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToSignupLoginPage();
		newUserRegistrationFlow.verifySignupInformationIsVisible();
		newUserRegistrationFlow.signupNewUserPositive(customer);
		newUserRegistrationFlow.verifyNavigationToAccountInformationPage();
		newUserRegistrationFlow.fillAccountDetailsAndCreateAccount(customer);
		newUserRegistrationFlow.verifyAccountCreated();
		newUserRegistrationFlow.continueToHomePageFromAccountRegistrationPage();
		homePageFlow.verifyUsernameVisibilityFromHomePage();
		homePageFlow.addARecommendedProductToCart();
		dialogBoxFlow.gotoCart();
		cartPageFlow.verifyNumberOfProductsInCart(1);
		cartPageFlow.proceedToCheckout();
		cartPageFlow.verifyShippingAndBillingAddress(customer);
		cartPageFlow.deleteAccount();
		deleteUserFlow.verifyDeletionConfirmation();
		deleteUserFlow.continueToHomePageAfterUserDeletionConfirmation();
	}
}
