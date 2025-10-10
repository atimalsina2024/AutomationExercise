package com.test.base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.PropertyUtil;

public class TestBase {
	protected static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + PropertyUtil.get("download.path"));
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
        FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
        options.addArguments("--private");
		//options.addArguments("--headless");
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(PropertyUtil.get("baseUrl"));
	}
	
	@AfterTest
	public void teardown() {
		if(driver != null) {
			//driver.close();
			driver.quit();
		}
	}

}
