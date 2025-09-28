package com.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

public class TestCasesPage extends PageBase{

	public TestCasesPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = ".text-center")
	WebElement testCasePageSuccessLanding;
	
	public WebElement getTestCasesLandingElement() {
		return this.testCasePageSuccessLanding;
	}

}
