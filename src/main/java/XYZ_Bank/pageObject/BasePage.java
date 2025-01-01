package XYZ_Bank.pageObject;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	public WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void verifyTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}

	public void verifyURLContains(String url) {
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
	}

	// Explicit Wait for a WebElement to be clickable
	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Explicit Wait for a WebElement to be visible
	public WebElement waitForElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void invisibilityOf(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	BasePage(WebDriver driver) {
		this.driver = driver;
	}
}
