package com.page.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.JavascriptUtils;
import utils.WaitUtils;

public class CartPage extends PageBase{

	private static final Logger logger = LogManager.getLogger(CartPage.class);
	
	@FindBy(css = "div.single-widget h2")
	private WebElement subscription;
	
	@FindBy(id = "susbscribe_email")
	private WebElement subscriptionEmail;
	
	@FindBy(id = "subscribe")
	private WebElement subscriptionButton;
	
	private String subscriptionConfirmationMessageLocator = "alert-success";
	
	@FindBy(css = "td.cart_description a")
	private List<WebElement> productNamesofProductsInCart;
	
	@FindBy(css = "td.cart_price p")
	private List<WebElement> price;
	
	@FindBy(css = "td.cart_quantity button")
	private List<WebElement> quantity;
	
	@FindBy(css = "td.cart_total p")
	private List<WebElement> total;
	
	@FindBy(css = "td.cart_delete a")
	private List<WebElement> deleteButton;
	
	@FindBy(css = "a.check_out")
	private WebElement checkoutButton;
	
	@FindBy(id = "address_delivery")
	private WebElement deliverAddress;
	
	@FindBy(id = "address_invoice")
	private WebElement billingAddress;
	
	@FindBy(name = "message")
	private WebElement orderMessage;
	
	@FindBy(className = "check_out")
	private WebElement placeOrderButton;
	
	@FindBy(xpath = "//b[text()='Cart is empty!']")
	private WebElement cartEmptyMessage;

	@FindBy(linkText = "Home")
	private WebElement homePageButton;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement scrollToSubscribe() {
		JavascriptUtils.javascriptScrollToView(driver, this.subscription);
		return this.subscription;
	}
	
	public CartPage enterSubscrptionEmail(String email) {
		this.subscriptionEmail.sendKeys(email);
		return this;
	}
	
	public CartPage clickSubscrbeButton() {
		this.subscriptionButton.click();
		return this;
	}
	
	public WebElement getSubscriptionConfirmationMessage() {
		return WaitUtils.waitForToastElement(driver, By.className(subscriptionConfirmationMessageLocator));
	}
	
	public List<String> getProductNames(){
		return this.productNamesofProductsInCart.stream()
		.map(element -> element.getText())
		.collect(Collectors.toList());
	}
	
	public List<String> getProductPrice(){
		return this.price.stream()
		.map(element -> element.getText())
		.collect(Collectors.toList());
	}
	
	public List<String> getProductQuantity(){
		return this.quantity.stream()
		.map(element -> element.getText())
		.collect(Collectors.toList());
	}
	
	public List<String> getTotalPrice(){
		return this.total.stream()
		.map(WebElement::getText)
		.collect(Collectors.toList());
	}

	
	public DialogBoxPage clickCheckOutButtonNotLoggedIn() {
		this.checkoutButton.click();
		return new DialogBoxPage(driver);
	}
	
	public CartPage clickCheckOutButtonLoggedIn() {
		this.checkoutButton.click();
		return this;
	}
	
	public CartPage clickCheckOutWhenLoggedIn() {
		this.checkoutButton.click();
		return this;
	}
	//convert address WebElement to Map
	public Map<String, String> addressUtility(WebElement addressElement) {
		Map<String, String> addressMap= new HashMap<>();
		addressMap.put("name", addressElement.findElement(By.className("address_firstname")).getText());
		addressMap.put("streetAddress", addressElement
				.findElements(By.className("address_address1"))
				.stream()
				.map(WebElement::getText)
				.collect(Collectors.joining(" ")));
		addressMap.put("cityStateZipcode", addressElement.findElement(By.className("address_state_name")).getText());
		addressMap.put("country", addressElement.findElement(By.className("address_country_name")).getText());
		addressMap.put("phone", addressElement.findElement(By.className("address_phone")).getText());
		return addressMap;
	}
	
	public Map<String, String> getDeliveryAddress(){
		return addressUtility(this.deliverAddress);
	}
	
	public Map<String, String> getBillingAddress(){
		return addressUtility(this.billingAddress);
	}
	
	public CartPage setOrderMessage(String msg) {
		try {
			this.orderMessage.sendKeys(msg);
		}catch(ElementNotInteractableException e) {
			logger.error("ElementNotInteractableException on Cart Order message");
			e.printStackTrace();
			JavascriptUtils.javascriptScrollToView(driver, this.orderMessage);
			this.orderMessage.sendKeys(msg);
		}
		
		return this;
	}
	
	public PaymentPage clickCheckoutButton() {
		JavascriptUtils.javascriptScrollToView(driver, this.checkoutButton);
		this.checkoutButton.click();
		return new PaymentPage(driver);
	}
	
	public CartPage deleteItemsInCart() {
		for(WebElement button:this.deleteButton) {
			button.click();
		}
		return this;
	}
	
	public WebElement getEmptyCartMessage() {
		WaitUtils.waitForElementToBeVisible(driver, cartEmptyMessage);
		return this.cartEmptyMessage;
	}
	
	public HomePage clickHomePageButton() {
		this.homePageButton.click();
		return new HomePage(driver);
	}
	

}
