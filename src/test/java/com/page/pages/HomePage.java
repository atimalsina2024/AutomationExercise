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

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "ul.nav a[href='/']")
	private WebElement homeButton;
	
	@FindBy(css = "a[href='/login']")
	private WebElement logonSignupButton;
	
	@FindBy(css = "ul.navbar-nav b")
	private WebElement loggedUserName;
	
	@FindBy(css = "a[href='/delete_account']")
	private WebElement deleteUser;
	
	@FindBy(css = "a[href='/logout']")
	private WebElement logoutButton;
	
	@FindBy(css = "a[href='/contact_us']")
	private WebElement contactUsButton;
	
	@FindBy(css = "a[href='/test_cases']")
	private WebElement testCaseButton;
	
	@FindBy(css = "a[href='/products']")
	private WebElement productButton;
	
	@FindBy(css = "div.single-widget h2")
	private WebElement subscription;
	
	@FindBy(id = "susbscribe_email")
	private WebElement subscriptionEmail;
	
	@FindBy(id = "subscribe")
	private WebElement subscriptionButton;
	
	//@FindBy(className = "alert-success")
	private String subscriptionConfirmationMessageElementLocator = "alert-success";
	
	@FindBy(css = "a[href='/view_cart']")
	private WebElement cartButton;
	
	@FindBy(css = "h4.panel-title a")
	private List<WebElement> categories;

	@FindBy(linkText = "WOMEN")
	private WebElement womenCategory;
	
	@FindBy(linkText = "DRESS")
	private WebElement womensDress;
	
	@FindBy(css = "div.recommended_items h2.title")
	private WebElement recommendedItemHeader;
	
	private String activeRecommendation ="div#recommended-item-carousel div.active";
	
	@FindBy(id = "scrollUp")
	private WebElement upArrow;
	
	@FindBy(css = "div.carousel div.active h2")
	private WebElement homePageLandingCarousel;
	
	public WebElement getHomeElement() {
		return this.homeButton;
	}
	public boolean isElementSelected(WebElement homeBtn) {
		if(homeBtn.getAttribute("style").equals("color: orange;")) {
			return true;
		}
		return false;
	}
	
	public WebElement getLoggedUserNameElement() {
		WaitUtils.waitForElementToBeVisible(driver, this.loggedUserName);
		return this.loggedUserName;
	}
	
	public void clickSignupLoginButton() {
		this.logonSignupButton.click();
	}

	public String getLoggedUserNameText() {
		WaitUtils.waitForElementToBeVisible(driver, this.loggedUserName);
		return this.loggedUserName.getText();
	}
	public DeleteUser deleteUser() {
		this.deleteUser.click();
		return new DeleteUser(driver);
	}
	public void userLogout() {
		this.logoutButton.click();
	}
	
	public ContactUsPage clickContactUsButton() {
		this.contactUsButton.click();
		return new ContactUsPage(driver);
	}
	
	public TestCasesPage clickTestCaseButton() {
		this.testCaseButton.click();
		return new TestCasesPage(driver);
	}
	
	public ProductPage clickProductButton() {
		this.productButton.click();
		return new ProductPage(driver);
	}
	
	public WebElement scrollToSubscription() {
		JavascriptUtils.javascriptScrollToView(driver, this.subscription);
		return this.subscription;
	}
	
	public HomePage enterSubscriptionEmailAddress(String email) {
		this.subscriptionEmail.sendKeys(email);
		return this;
	}
	
	public HomePage clickSubscribeButton() {
		this.subscriptionButton.click();;
		return this;
	}
	
	public WebElement getSubscriptionConfirmationMessage() {
		return WaitUtils.waitForToastElement(driver, By.className(subscriptionConfirmationMessageElementLocator));
	}
	
	public CartPage clickCartButton() {
		this.cartButton.click();
		return new CartPage(driver);
	}
	public List<String> getCategories() {
		return this.categories
		.stream()
		.map(WebElement::getText)
		.collect(Collectors.toList());		
	}
	
	public HomePage expandWomenCategory() {
		this.womenCategory.click();
		return this;
	}
	
	public ProductPage clickWomensDress() {
		this.womensDress.click();
		return new ProductPage(driver);
	}
	
	public WebElement getRemmendedItemHeader() {
		JavascriptUtils.javascriptScrollToView(driver, this.recommendedItemHeader);
		return this.recommendedItemHeader;
	}
	
	public WebElement getActiveRecommendations() {
		return WaitUtils.waitForToastElement(driver, By.cssSelector(activeRecommendation));
	}
	
	public DialogBoxPage addRecommendedProductToCart() {
		WebElement elmnt = getActiveRecommendations();
		JavascriptUtils.javascriptScrollToView(driver, elmnt);
		WebElement cart = elmnt.findElement(By.cssSelector(" a.add-to-cart"));
		JavascriptUtils.javascriptScrollToView(driver, cart);
		cart.click();
		return new DialogBoxPage(driver);
	}
	
	public HomePage clickScrollUpArrow() {
		this.upArrow.click();
		return this;
	}
	
	public WebElement getLandingCarousel() {
		return this.homePageLandingCarousel;
	}
	public HomePage scrollToHomePageWithoutClickingArrow() {
		JavascriptUtils.javascriptScrollToView(driver, homePageLandingCarousel);
		return this;
	}
	
	
		

}
