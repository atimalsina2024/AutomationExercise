package com.automation.core.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigurationManager {
	/*
	 *Enforce singleton pattern and Load configuration
	 *
	 * SingletonPattern=> private static instance variable
	 * SingletonPattern=> private constructor
	 * SingletonPattern=> thread locked public static getter to access the instance
	 * 
	 * LoadConfiguration==> environment based properties
	 * LoadConfiguration==> hard code default properties for when loading of configuration file fails
	 * LoadConfiguration==> override configuration with System.properties if present
	 * LoadConfiguration==> getters for most used property keys
	 */
	
	private static final Logger logger = LogManager.getLogger();
	private static ConfigurationManager instance ;
	private Properties properties;
	private String environment;
	
	// Private constructor to enforce singleton;
	private ConfigurationManager() {
		loadConfiguration();
	}

	//Thread locked static method to access instance of this class
	public static synchronized ConfigurationManager getInstance() {
		if(instance == null) {
			instance = new ConfigurationManager();
		}
		return instance;
	}
	
	
	private void loadConfiguration() {
		properties = new Properties();
		
		//Getting environment from system configuration. If environment not set in system configuration, defaulting it to qa.
		environment = System.getProperty("env", "qa");
		
		//selecting configuration file based on environment
		//qa.config, dev.config and prod.config
		String fileName = String.format("config/%s.properties", environment);
		
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
			if(inputStream == null) {
				logger.warn("file not found {}, loading defaults", fileName);
				//implement default configuration feature later
				return;
			}
			properties.load(inputStream);
			logger.info("config loaded");
		}
		catch (IOException e) {
			logger.error("Error loading configuration {}", e.getMessage());
			throw new RuntimeException("Configuraiton loading failed ", e);
		}
		//implement system property override later
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
