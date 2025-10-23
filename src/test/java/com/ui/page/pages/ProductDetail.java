package com.ui.page.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.page.base.PageBase;

import utils.WaitUtils;

public class ProductDetail extends PageBase{
	
	@FindBy(css = "div.product-information h2")
	WebElement productName;
	
	@FindBy(xpath = "//p[contains(text(),'Category')]")
	WebElement category;
	
	@FindBy(css = "div.product-information span span")
	WebElement price;
	
	@FindBy(xpath = "//p[b[text()='Availability:']]")
	WebElement availability;
	
	@FindBy(xpath = "//p[b[text()='Condition:']]")
	WebElement condition;
	
	@FindBy(xpath = "//p[b[text()='Brand:']]")
	WebElement brand;
	
	@FindBy(id = "quantity")
	WebElement quantity;
	
	@FindBy(css = "button.cart")
	WebElement addToCartButton;
	
	@FindBy(id = "name")
	WebElement reviewerName;
	
	@FindBy(id = "email")
	WebElement reviewerEmail;
	
	@FindBy(id = "review")
	WebElement productReview;
	
	@FindBy(id = "button-review")
	WebElement submitReview;
	
	private String reviewSuccessMessage = "div.alert-success span";
	
	public ProductDetail(WebDriver driver) {
		super(driver);
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getPrice() {
		return price;
	}

	public String getAvailability() {
		return availability.getText();
	}

	public WebElement getCondition() {
		return condition;
	}

	public WebElement getBrand() {
		return brand;
	}
	// min quantity is 1, thus looping qty-1 times
	public ProductDetail increaseQuantity(int qty) {
		for(int i=0; i<qty-1; i++) {
			this.quantity.sendKeys(Keys.ARROW_UP);
		}
		return this;
	}
	
	public DialogBoxPage clickAddToCartButton() {
		this.addToCartButton.click();
		return new DialogBoxPage(driver);
	}
	
	public ProductDetail enterName(String name) {
		this.reviewerName.sendKeys(name);
		return this;
	}
	
	public ProductDetail enterEmail(String email) {
		this.reviewerEmail.sendKeys(email);
		return this;
	}
	
	public ProductDetail enterMessage(String review) {
		this.productReview.sendKeys(review);
		return this;
	}
	
	public ProductDetail clickSubmitButton() {
		this.submitReview.click();
		return this;
	}
	
	public WebElement getReviewSubmissionMessage() {
		return WaitUtils.waitForToastElement(driver, By.cssSelector(reviewSuccessMessage));
	}


}
