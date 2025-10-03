package com.page.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.JavascriptUtils;
import utils.WaitUtils;

public class CartPage extends PageBase{

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
	
	public DialogBoxPage clickCheckOutButton() {
		this.checkoutButton.click();
		return new DialogBoxPage(driver);
	}
	
	public CartPage proceedToCheckOutWhenLoggedIn() {
		this.checkoutButton.click();
		return this;
	}
	
	
	
	

}
