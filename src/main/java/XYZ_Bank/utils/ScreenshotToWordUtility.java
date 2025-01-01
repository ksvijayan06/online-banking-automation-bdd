package XYZ_Bank.utils;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;


public class ScreenshotToWordUtility {
	private static ScreenshotToWordUtility instance;
	private WebDriver driver;
	private XWPFDocument docx;
	private XWPFRun run;
	private FileOutputStream out;
	private String dirPath;
	private static Logger logger = Logger.getLogger(ScreenshotToWordUtility.class);

	// Constructor to initialize WebDriver, Word document, and file paths
	private ScreenshotToWordUtility(WebDriver driver, String dirPath, String fileName) {
		this.driver = driver;
		this.dirPath = dirPath;
		this.docx = new XWPFDocument();
		this.run = docx.createParagraph().createRun();
		try {
			// Create directory if it doesn't exist
			File dir = new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			// Prepare Word file for saving
			this.out = new FileOutputStream(dirPath + "/" + fileName + ".docx");
		} catch (IOException e) {
			logger.fatal("Can't create a test-report: " + e.getMessage());
			logger.fatal("Exception Type: " + e.getClass().getName());
			logger.fatal("Stack Trace: ", e);
			System.exit(1);
		}
	}

	// Method to capture a screenshot and add it to Word document
	public void captureScreenshotAndAddToDoc() {
		// Capture the screenshot using Selenium
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot as PNG file
		String screenshotName = System.currentTimeMillis() + ".png";
		File screenshotDestination = new File(dirPath + screenshotName);
		try {
			FileUtils.copyFile(screenshotFile, screenshotDestination);
			// Add the screenshot to the Word document
			InputStream pic = new FileInputStream(screenshotDestination);
			run.addBreak(); // Add a break between images
			run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshotName, Units.toEMU(500), Units.toEMU(350));
			pic.close();
			// Delete the screenshot file after adding it to Word document
			Files.delete(Paths.get(screenshotDestination.toURI()));
		} catch (IOException | InvalidFormatException e) {
			logger.error("Error occurred while inserting screenshot into the Word document.");
			logger.error("Exception Type: " + e.getClass().getName());
			logger.error("Exception Message: " + e.getMessage());
			logger.error("Stack Trace: ", e);
		}

	}

	// Method to save the Word document after test completion
	public void saveWordDocument() {
		// Write the Word document
		try {
			docx.write(out);
			out.flush();
			out.close();
			docx.close();
		} catch (IOException e) {
			logger.error("Error occurred while saving the Word document.");
			logger.error("Exception Type: " + e.getClass().getName());
			logger.error("Exception Message: " + e.getMessage());
			logger.error("Stack Trace: ", e);
		}

		instance = null;
	}

	// Singleton method to get the instance of ScreenshotToWordUtility
	public static ScreenshotToWordUtility getInstance(WebDriver driver, String dirPath, String fileName) {
		if (instance == null) {
			instance = new ScreenshotToWordUtility(driver, dirPath, fileName);
		}
		return instance;
	}

	public static Optional<ScreenshotToWordUtility> getInstance() {
		if (instance == null) {
			// Return an empty Optional if the instance is not created yet
			return Optional.empty();
		} else {
			// Return an Optional containing the instance if it's not null
			return Optional.of(instance);
		}
	}
}