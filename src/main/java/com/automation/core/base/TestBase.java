package com.automation.core.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.automation.core.config.ConfigurationManager;


public class TestBase {
	
	private static final Logger logger = LogManager.getLogger(TestBase.class);
	protected WebDriver driver;
	protected ConfigurationManager config;
	
	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
		logger.info("Test Suite Execution Starting");
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
		logger.info("Environment {}", ConfigurationManager.getInstance().getProperty("environment"));
	}

	@BeforeClass(alwaysRun = true)
	public void setupClass() {
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
		logger.info("Test Base Before Class");
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
		config = ConfigurationManager.getInstance();
		logger.info("configured config");
		driver = WebDriverFactory.createDriver();
		logger.info("driver created");
		//refactor later and create driver in before method
				
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setup(ITestResult result) {
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
		logger.info("Test Base Before Method");
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
		logger.info("Method {}", result.getMethod().getMethodName());
		logger.info("Description {}", result.getMethod().getDescription());
		
		String baseUrl = ConfigurationManager.getInstance().getProperty("base.url");
		logger.info("Navigating to {}", baseUrl);
		driver.manage().window().maximize();
		logger.info("Window Maximized");
		driver.get(baseUrl);
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) {
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
		logger.info("Test Base After Method");
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
		String methodName = result.getMethod().getMethodName();
		logger.info("++++++++++++++++++++++++++Test Method {} complete", methodName);
		WebDriverFactory.quitWebDriver();
		logger.info("driver closed");
	}

	@AfterSuite(alwaysRun = true)
	public void suitTeardown() {
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
		logger.info("Test Suite Execution finished");
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
	}
}
