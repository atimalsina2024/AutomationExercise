package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyUtil {
	private static Properties prop = new Properties();
	private static final Logger logger = LogManager.getLogger(PropertyUtil.class);
	static {
		try {
			InputStream is = new FileInputStream(new File("/Users/work/eclipse-workspace/AutomationExercise/src/test/resources/qa.properties"));
			prop.load(is);
		} catch (IOException e) {
			logger.error("error loading properties file");
			throw new RuntimeException("Error loading config.properties", e);
		}
		
	}
	
	public static String get(String key) {
		return prop.getProperty(key);
	}

}
