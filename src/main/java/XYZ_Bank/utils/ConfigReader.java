package XYZ_Bank.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigReader {
	private static Logger logger = Logger.getLogger(ConfigReader.class);
	private static Properties properties = new Properties();

	// Load properties file once when the class is loaded
	static {
		try (InputStream input = new FileInputStream("./src/main/resource/config.properties")) {
			properties.load(input);
		} catch (IOException e) {
			logger.fatal("Can't locate Property file: " + e.getMessage());
			logger.fatal("Exception Type: " + e.getClass().getName());
			logger.fatal("Stack Trace: ", e);
			System.exit(1); // Exit the program with a non-zero status code (indicating failure)
		}
	}

	// Method to get a property by key (returns a string)
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	// Method to get an integer property (e.g., for wait times)
	public static int getIntProperty(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}

	// Method to get boolean property (for features like headless mode, etc.)
	public static boolean getBooleanProperty(String key) {
		return Boolean.parseBoolean(properties.getProperty(key));
	}
}
