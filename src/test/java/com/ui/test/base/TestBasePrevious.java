package com.ui.test.base;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automation.core.base.TestBase;
import com.automation.core.config.ConfigurationManager;


public class TestBasePrevious {
	protected static WebDriver driver;
	
	private static final Logger logger = LogManager.getLogger(TestBase.class);
	protected ConfigurationManager config;
	
	
	@BeforeTest
	public void setup() {
		config = ConfigurationManager.getInstance();
		logger.debug("@BeforeTest");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + config.getProperty("download.path"));
		//profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + config.getProperty("download.path"));
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
        FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
        options.addArguments("--private");
		//options.addArguments("--headless");
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(config.getProperty("baseUrl"));
		logger.debug("WebDriver initialized");
	}
	
	@AfterTest
	public void teardown() {
		if(driver != null) {
			//driver.close();
			driver.quit();
		}
	}

}
