package utils;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileHandlerUtils {
	private static final Logger logger = LogManager.getLogger(FileHandlerUtils.class);
	public static boolean validateFileInAFolder(String folderPath, String fileName) throws IOException {
		File folder = new File(folderPath);
		String[] fileNames = folder.list();
		for(String name: fileNames) {
			if(name.contains(fileName)) {
				logger.debug("file found", name);
				return true;
			}
		}
		logger.debug("file not found");
		return false;
		
	}
	

}
