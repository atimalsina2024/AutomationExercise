package com.page.pages;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.page.base.PageBase;

public class AccountInformation extends PageBase{

	public AccountInformation(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	WebElement pageTitle;
	
	@FindBy(id = "id_gender1")
	WebElement genderMale;
	
	@FindBy(id = "id_gender2")
	WebElement genderFemale;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "days")
	WebElement day;	
	Select dobDays = new Select(day);
	
	@FindBy(id = "months")
	WebElement month;	
	Select dobMonth = new Select(month);
	
	@FindBy(id = "years")
	WebElement year;	
	Select dobYear = new Select(year);
	
	@FindBy(id = "newsletter")
	WebElement newsLetter;

	@FindBy(id = "optin")
	WebElement specialOfferOptIn;

	@FindBy(id = "first_name")
	WebElement signUpFirstName;
	
	@FindBy(id = "last_name")
	WebElement signUpLastName;
	
	@FindBy(id = "company")
	WebElement signUpCompany;
	
	@FindBy(id = "address1")
	WebElement streetAddressOne;
	
	@FindBy(id = "address2")
	WebElement streetAddressTwo;
	
	@FindBy(id = "country")
	WebElement ctry;
	Select country = new Select(ctry);
	
	@FindBy(id = "state")
	WebElement state;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "zipcode")
	WebElement zipcode;
	
	@FindBy(id = "mobile_number")
	WebElement signUpMobile;
	
	@FindBy(css = "button[data-qa='create-account']")
	WebElement createAccountButton;
	
	public static void waitForElementToBeVisible(WebElement element) {
		waitUtil.waitForElementToBeVisible(element);
	}
	
	public WebElement getPageTitleElement() {
		 waitForElementToBeVisible(this.pageTitle);
		 return this.pageTitle;
	}
	
	public String getPageTitleText() {
		return pageTitle.getText();
	}

	public void setTitle(String title) {
		if(title.toLowerCase().equals("male")) {
			this.genderMale.click();
		}
		else {
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
		
		this.dobDays.selectByValue(dayString);
		this.dobMonth.selectByVisibleText(monthString);
		this.dobYear.selectByValue(yearString);
	}

	public void signUpForNewsLetter() {
		try {
			this.newsLetter.click();
		}catch(ElementClickInterceptedException e) {
			e.printStackTrace();
			js.javascriptScrollToView(this.newsLetter);
			this.newsLetter.click();
		}		
	}

	public void receiveSpecialOffers() {
		this.specialOfferOptIn.click();		
	}

	public void setFirstName(String fname) {
		this.signUpFirstName.sendKeys(fname);;
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

	public void setMobileNumber(String mobile) {
		this.signUpMobile.sendKeys(mobile);	
	}

	public void clickCreateAccountButton() {
		this.createAccountButton.click();	
	}

	public void clickCountryDropdown() {
		try {
			this.ctry.click();
		}catch(ElementClickInterceptedException e) {
			js.javascriptScrollToView(this.ctry);
			this.ctry.click();
		}
		
	}
	
	
	
	

}
