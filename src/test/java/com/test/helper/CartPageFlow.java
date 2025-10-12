package com.test.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.pages.CartPage;
import com.test.models.CustomerInfo;

public class CartPageFlow {

	private static final Logger logger = LogManager.getLogger(CartPageFlow.class);
	
	private WebDriver driver;
	public CartPageFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("CartPage Flow Constructor");
	}
	
	public void verifySubscriptionVisibleOnFooterOfThePage() {
		boolean isSubscriptionVisible = new CartPage(driver)
		.scrollToSubscribe()
		.getText()
		.toUpperCase()
		.equals("SUBSCRIPTION");
		
		Assert.assertTrue(isSubscriptionVisible);
		logger.debug("verifySubscriptionVisibleOnFooterOfThePage");
	}

	public void verifyAddedProductsPresentInCart(ArrayList<String> expectedProducts) {
		List<String> actual = new CartPage(driver)
		.getProductNames();
		Assert.assertEquals(actual, expectedProducts, "Added product not in cart");
		logger.debug("verifyAddedProductsPresentInCart");
		
	}
	
	public  void verifyPriceQuantityAndTotalPriceOfAddedProducts(int qty) {
		CartPage cart = new CartPage(driver);
		List<String> price = cart.getProductPrice();
		List<String> quantity = cart.getProductQuantity();
		List<String>  total = cart.getTotalPrice();
		
		for(int i=0; i<price.size(); i++) {
			Assert.assertEquals(total.get(i), price.get(i));
			Assert.assertEquals(quantity.get(i), Integer.toString(qty));
		}
		logger.debug("verifyPriceQuantityAndTotalPriceOfAddedProducts");
	}

	public void verifyProductQuantityInCart(int i) {
		List<String> quantity = new CartPage(driver)
				.getProductQuantity();
				Assert.assertEquals(quantity.get(0), String.valueOf(i));
		logger.debug("verifyProductQuantityInCart");
	}

	public void proceedToCheckout() {
		new CartPage(driver)
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
		CartPage cp = new CartPage(driver);
		Map<String, String> billingAddress = cp.getBillingAddress();
		Map<String, String> shippingAddress = cp.getDeliveryAddress();
		Assert.assertEquals(billingAddress.get("streetAddress"), billingAdd);
		Assert.assertEquals(shippingAddress.get("streetAddress"), shippingAdd);
		logger.info("verifyShippingAndBillingAddress");	
	}


	public void addMessageAndPlaceOrder(String msg) {		
		new CartPage(driver).
		setOrderMessage(msg)
		.clickPlaceOrder();
		logger.info("addMessageAndPlaceOrder");	
	}

	public void deleteAllProductsInCart() {
		new CartPage(driver)
		.deleteItemsInCart();
		logger.info("deleteAllProductsInCart");	
	}

	public void verifyCartIsEmpty() {
		boolean isCartEmpty = new CartPage(driver).getEmptyCartMessage()
		.getText()
		.equals("Cart is empty!");		
		Assert.assertTrue(isCartEmpty);
		logger.info("verifyCartIsEmpty");
	}
}
