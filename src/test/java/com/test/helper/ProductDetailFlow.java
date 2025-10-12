package com.test.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.pages.ProductDetail;

public class ProductDetailFlow {
	private static final Logger logger = LogManager.getLogger(ProductDetailFlow.class);
	private WebDriver driver;

	public ProductDetailFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("ProductDetailFlow constructed");
	}
	
	public void VerifyBlueTopProductDetails() {
		ProductDetail productDetail = new ProductDetail(driver);
		boolean productName = productDetail.getProductName().getText().equals("Blue Top");
		boolean productCategory = productDetail.getCategory().getText().replace("Category: ", "").trim().equals("Women > Tops");
		boolean productPrice = productDetail.getPrice().getText().replace("Rs.", "").strip().equals("500");
		boolean productAvailability = productDetail.getAvailability().replace("Availability:","").strip().equals("In Stock");
		boolean productCondition = productDetail.getCondition().getText().replace("Condition:", "").strip().equals("New");
		boolean productBrand = productDetail.getBrand().getText().replace("Brand:", "").strip().equals("Polo");
		Assert.assertTrue(productName);
		Assert.assertTrue(productCategory);
		Assert.assertTrue(productPrice);
		Assert.assertTrue(productAvailability);
		Assert.assertTrue(productCondition);
		Assert.assertTrue(productBrand);
		logger.debug("VerifyBlueTopProductDetails");
	}

	public void increaseQuantity(int i) {
		new ProductDetail(driver)
		.increaseQuantity(i);
		logger.debug("increaseQuantity");
	}
	
	public void addProductToCart() {
		new ProductDetail(driver)
		.clickAddToCartButton();
		logger.debug("addProductToCart");
	}
	
	
	public void addProductReview(String name, String email, String message) {
		new ProductDetail(driver)
		.enterName(name)
		.enterEmail(email)
		.enterMessage(message)
		.clickSubmitButton();
		logger.debug("addProductReview");
	}
	
	public void VerifyProductReviewSubmissionSuccessMessage() {
		boolean submissionSuccess = new ProductDetail(driver)
		.getReviewSubmissionMessage()
		.getText()
		.equals("Thank you for your review.");
		
		Assert.assertTrue(submissionSuccess);
		logger.debug("VerifyProductReviewSubmissionSuccessMessage");
	}

}
