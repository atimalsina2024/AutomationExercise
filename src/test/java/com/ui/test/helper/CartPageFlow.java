package com.ui.test.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ui.page.pages.CartPage;
import com.ui.test.models.CustomerInfo;

public class CartPageFlow {

	private static final Logger logger = LogManager.getLogger(CartPageFlow.class);
	
	private CartPage cartPage;
	
	public CartPageFlow(WebDriver driver) {
		cartPage = new CartPage(driver);
		logger.debug("CartPage Flow Constructor");
	}
	
	public void verifySubscriptionVisibleOnFooterOfThePage() {
		boolean isSubscriptionVisible = cartPage
		.scrollToSubscribe()
		.getText()
		.toUpperCase()
		.equals("SUBSCRIPTION");
		
		Assert.assertTrue(isSubscriptionVisible);
		logger.debug("verifySubscriptionVisibleOnFooterOfThePage");
	}

	public void verifyAddedProductsPresentInCart(ArrayList<String> expectedProducts) {
		List<String> actual = cartPage
		.getProductNames();
		Assert.assertEquals(actual, expectedProducts, "Added product not in cart");
		logger.debug("verifyAddedProductsPresentInCart");
		
	}
	
	public  void verifyPriceQuantityAndTotalPriceOfAddedProducts(int qty) {
		List<String> price = cartPage.getProductPrice();
		List<String> quantity = cartPage.getProductQuantity();
		List<String>  total = cartPage.getTotalPrice();
		
		for(int i=0; i<price.size(); i++) {
			Assert.assertEquals(total.get(i), price.get(i));
			Assert.assertEquals(quantity.get(i), Integer.toString(qty));
		}
		logger.debug("verifyPriceQuantityAndTotalPriceOfAddedProducts");
	}

	public void verifyProductQuantityInCart(int i) {
		List<String> quantity = cartPage
				.getProductQuantity();
				Assert.assertEquals(quantity.get(0), String.valueOf(i));
		logger.debug("verifyProductQuantityInCart");
	}

	public void proceedToCheckout() {
		cartPage
		.clickCheckOutButton();
		logger.info("proceedToCheckout");
	}

	public void verifyShippingAndBillingAddress(CustomerInfo customer) {
		String billingAdd = customer.getCompany().concat(" ")
				.concat(customer.getAddress().getStreet().concat(" ")
				.concat(customer.getAddress().getApt()));
		String shippingAdd = customer.getCompany().concat(" ")
				.concat(customer.getAddress().getStreet().concat(" ")
				.concat(customer.getAddress().getApt()));
		Map<String, String> billingAddress = cartPage.getBillingAddress();
		Map<String, String> shippingAddress = cartPage.getDeliveryAddress();
		Assert.assertEquals(billingAddress.get("streetAddress"), billingAdd);
		Assert.assertEquals(shippingAddress.get("streetAddress"), shippingAdd);
		logger.info("verifyShippingAndBillingAddress");	
	}


	public void addMessageAndPlaceOrder(String msg) {		
		cartPage.
		setOrderMessage(msg)
		.clickPlaceOrder();
		logger.info("addMessageAndPlaceOrder");	
	}

	public void deleteAllProductsInCart() {
		cartPage
		.deleteItemsInCart();
		logger.info("deleteAllProductsInCart");	
	}

	public void verifyCartIsEmpty() {
		boolean isCartEmpty = cartPage.getEmptyCartMessage()
		.getText()
		.equals("Cart is empty!");		
		Assert.assertTrue(isCartEmpty);
		logger.info("verifyCartIsEmpty");
	}

	public void verifyNumberOfProductsInCart(int num) {
		boolean productSize = cartPage
				.getProductNames()
				.size() == num;		
				Assert.assertTrue(productSize, "number of products assertion fail");
				logger.info("verifyNumberOfProductsInCart");
			}

	public void deleteAccount() {
		cartPage
		.clickDeleteAccountButton();
		
	}
		
}
