package com.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

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


}
