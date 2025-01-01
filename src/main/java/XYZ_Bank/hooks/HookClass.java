package XYZ_Bank.hooks;

import java.util.Optional;
import org.openqa.selenium.WebDriver;

import XYZ_Bank.stepDefinitions.BaseTest;
import XYZ_Bank.utils.ConfigReader;
import XYZ_Bank.utils.ScreenshotToWordUtility;
import XYZ_Bank.utils.WebDriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HookClass {
	private static Logger logger = Logger.getLogger(HookClass.class);
	static WebDriver driver;

	@Before
	public void beforeHook() {
		System.setProperty("logfile.location", BaseTest.testLogDirPath());
		PropertyConfigurator.configure(ConfigReader.getProperty("log4jprop"));
		if (driver == null)
			driver = WebDriverUtil.CreateDriver(ConfigReader.getProperty("browser"));
		driver.get(ConfigReader.getProperty("base.url"));
		logger.info("Starting the execution of the scenario...");
		logger.info("Navigating to base URL: " + ConfigReader.getProperty("base.url"));
	}

	@After
	public void afterHook() {
		// if optional is not null the document will be save
		Optional<ScreenshotToWordUtility> testResult = ScreenshotToWordUtility.getInstance();
		// x is the instanceof ScreenshotToWordUtility class
		testResult.ifPresent((x) -> {
			x.saveWordDocument();
		});
		// driver.quit();
		logger.info("Completed execution of the scenario\n");
	}

	@AfterAll
	public static void tearDown() {
		// Quit the WebDriver after all scenarios have been executed in a feature.
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
