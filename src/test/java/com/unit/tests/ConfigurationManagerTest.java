package com.unit.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.core.config.ConfigurationManager;

// currently in .gitignore
public class ConfigurationManagerTest {
	
	private static final Logger logger = LogManager.getLogger(ConfigurationManagerTest.class);
	private ConfigurationManager config;
	
	@BeforeTest
	public void setup() {
		config = ConfigurationManager.getInstance();
	}
	
	@Test(priority = 1, description  = "get existing property one")
	public void TC_001_GetExistingProperty() {
		String name = config.getProperty("name");
		Assert.assertEquals(name, "John", "name is not John");
		logger.info("TC_001_GetExistingProperty pass {} is John", name);
	}
	
	@Test(priority = 2, description =  "get existing property two")
	public void TC_002_GetExistingProperty() {
		String password = config.getProperty("password");
		Assert.assertEquals(password, "StrongP@ss123", "password is not correct");
		logger.info("TC_002_GetExistingProperty pass {} is StrongP@ss123", password);
	}
	
	@Test(priority = 3, description =  "get non existing property")
	public void TC_003_GetNonExistingProperty() {
		String ownerName = config.getProperty("owner.name");
		Assert.assertNull(ownerName, "non existing key is sending not-null value");
		logger.info("TC_003_GetNonExistingProperty pass {} is null", ownerName);
	}
	
	
	@Test(priority = 4, description =  "validate singleton pattern")
	public void TC_004_CompareInstances() {
		ConfigurationManager configTwo = ConfigurationManager.getInstance();
		Assert.assertEquals(config,configTwo, "instances are not equal");
		logger.info("TC_004_CompareInstances pass Instances are equal");
	}
}
