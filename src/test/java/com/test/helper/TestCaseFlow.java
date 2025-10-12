package com.test.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.pages.TestCasesPage;

public class TestCaseFlow {

	private static final Logger logger = LogManager.getLogger(TestCaseFlow.class);
	private WebDriver driver;
	
	public TestCaseFlow (WebDriver driver) {
		this.driver = driver;
		logger.debug("TestCaseFlow constructed");
	}

	public void verifyCurrentlyOnTestCasePage() {
		boolean landingOnTestCasePage = new TestCasesPage(driver)
		.getTestCasesLandingElement()
		.getText()
		.toUpperCase()
		.equals("TEST CASES");
		
		Assert.assertTrue(landingOnTestCasePage, "Landing on Test Case Page failed");
		logger.debug("verifyCurrentlyOnTestCasePage");
	}
	
	
}
