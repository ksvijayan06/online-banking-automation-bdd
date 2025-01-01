package XYZ_Bank.utils;

import java.time.Duration;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil {

	private static WebDriver driver;
	private static boolean isDriverSetUp = false;
	private static Logger logger = Logger.getLogger(WebDriverUtil.class);

	public static WebDriver CreateDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			if (!isDriverSetUp) {
				WebDriverManager.chromedriver().setup();
				isDriverSetUp = true;
				logger.info("Setting up driver for browser: " + browser);
			}
			driver = new ChromeDriver();
			logger.info("WebDriver created successfully for " + browser);
		}
		else if(browser.equalsIgnoreCase("edge")){
			if (!isDriverSetUp) {
				WebDriverManager.chromedriver().setup();
				isDriverSetUp = true;
				logger.info("Setting up driver for browser: " + browser);
			}
			driver = new EdgeDriver();
			logger.info("WebDriver created successfully for " + browser);
		}
		else if(browser.equalsIgnoreCase("firefox")){
			if (!isDriverSetUp) {
				WebDriverManager.firefoxdriver().setup();
				isDriverSetUp = true;
				logger.info("Setting up driver for browser: " + browser);
			}
			driver = new FirefoxDriver();
			logger.info("WebDriver created successfully for " + browser);
		}
		else {
			logger.warn("Driver not available to setup for browser: "+browser);
			if (!isDriverSetUp) {
				WebDriverManager.chromedriver().setup();
				isDriverSetUp = true;
				logger.info("Setting up default chrome-driver for browser");
			}
			driver = new ChromeDriver();
			logger.info("WebDriver created successfully for chrome");
			
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
