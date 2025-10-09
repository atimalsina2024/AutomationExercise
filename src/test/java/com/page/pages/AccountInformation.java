package com.page.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.page.base.PageBase;
import com.test.models.Address;
import com.test.models.CustomerInfo;

import utils.JavascriptUtils;
import utils.WaitUtils;

public class AccountInformation extends PageBase {

	private static final Logger logger = LogManager.getLogger(AccountInformation.class);
	
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	private WebElement pageTitle;

	@FindBy(id = "id_gender1")
	private WebElement genderMale;

	@FindBy(id = "id_gender2")
	private WebElement genderFemale;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "days")
	WebElement day;
	private Select dobDays = new Select(day);

	@FindBy(id = "months")
	WebElement month;
	private Select dobMonth = new Select(month);

	@FindBy(id = "years")
	WebElement year;
	private Select dobYear = new Select(year);

	@FindBy(id = "newsletter")
	private WebElement newsLetter;

	@FindBy(id = "optin")
	private WebElement specialOfferOptIn;

	@FindBy(id = "first_name")
	private WebElement signUpFirstName;

	@FindBy(id = "last_name")
	private WebElement signUpLastName;

	@FindBy(id = "company")
	private WebElement signUpCompany;

	@FindBy(id = "address1")
	private WebElement streetAddressOne;

	@FindBy(id = "address2")
	private WebElement streetAddressTwo;

	@FindBy(id = "country")
	private WebElement ctry;
	Select country = new Select(ctry);

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "zipcode")
	private WebElement zipcode;

	@FindBy(id = "mobile_number")
	private WebElement signUpMobile;

	@FindBy(css = "button[data-qa='create-account']")
	private WebElement createAccountButton;
	
	public AccountInformation(WebDriver driver) {
		super(driver);
	}

	public WebElement getPageTitleElement() {
		WaitUtils.waitForElementToBeVisible(driver, this.pageTitle);
		return this.pageTitle;
	}

	public String getPageTitleText() {
		return pageTitle.getText();
	}

	public void setTitle(String title) {
		if (title.toLowerCase().equals("mr")) {
			this.genderMale.click();
		} else {
			this.genderFemale.click();
		}

	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void setDataOfBirth(String dataOfBirth) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob = LocalDate.parse(dataOfBirth, formatter);
		String monthString = dob.format(DateTimeFormatter.ofPattern("MMMM"));
		String dayString = Integer.toString(dob.getDayOfMonth());
		String yearString = Integer.toString(dob.getYear());
		try {
			this.dobDays.selectByValue(dayString);
			this.dobMonth.selectByVisibleText(monthString);
			this.dobYear.selectByValue(yearString);
		}catch(ElementClickInterceptedException e) {
			logger.error("ElementClickInterceptedExceptio error");
			e.printStackTrace();
			JavascriptUtils.javascriptScrollToView(driver, this.day);
			this.dobDays.selectByValue(dayString);
			this.dobMonth.selectByVisibleText(monthString);
			this.dobYear.selectByValue(yearString);
		}
		
	}

	public void signUpForNewsLetter() {
		try {
			this.newsLetter.click();
		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
			JavascriptUtils.javascriptScrollToView(driver, this.newsLetter);
			this.newsLetter.click();
		}
	}

	public void receiveSpecialOffers() {
		this.specialOfferOptIn.click();
	}

	public void setFirstName(String fname) {
		this.signUpFirstName.sendKeys(fname);
		;
	}

	public void setLastName(String lname) {
		this.signUpLastName.sendKeys(lname);
	}

	public void setCompany(String company) {
		this.signUpCompany.sendKeys(company);

	}

	public void setStreetAddressOne(String streetAddressOne) {
		this.streetAddressOne.sendKeys(streetAddressOne);

	}

	public void setStreetAddressTwo(String apt) {
		this.streetAddressTwo.sendKeys(apt);
	}

	public void setCountry(String country) {
		clickCountryDropdown();
		this.country.selectByVisibleText(country);
	}

	public void setState(String state) {
		this.state.sendKeys(state);
	}

	public void setCity(String city) {
		this.city.sendKeys(city);
	}

	public void setZipcode(String zipcode) {
		this.zipcode.sendKeys(zipcode);
	}
	
	public void setAddressUtility(Address address) {
		setStreetAddressOne(address.getStreet());
		setStreetAddressTwo(address.getApt());
		setCity(address.getCity());
		setState(address.getState());
		setZipcode(address.getZip());
	}

	public void setMobileNumber(String mobile) {
		this.signUpMobile.sendKeys(mobile);
	}

	public void clickCreateAccountButton() {
		try {
			this.createAccountButton.click();
		}catch(ElementClickInterceptedException e) {
			logger.error("ElementClickInterceptedException on createAccountButton");
			logger.info("scrolling it to view");
			JavascriptUtils.javascriptScrollToView(driver, createAccountButton);
			this.createAccountButton.click();
		}
		
	}

	public void clickCountryDropdown() {
		try {
			this.ctry.click();
		} catch (ElementClickInterceptedException e) {
			JavascriptUtils.javascriptScrollToView(driver, this.ctry);
			this.ctry.click();
		}
	}

	public AccountInformation fillInformation(CustomerInfo cust) {
		setTitle(cust.getTitle());
		setPassword(cust.getPassword());
		setDataOfBirth(cust.getDob());
		signUpForNewsLetter();
		receiveSpecialOffers();
		setFirstName(cust.getFirstName());
		setLastName(cust.getLastName());
		setCompany(cust.getCompany());
		setAddressUtility(cust.getAddress());
		setMobileNumber(cust.getMobile());
		return this;
	}

}
