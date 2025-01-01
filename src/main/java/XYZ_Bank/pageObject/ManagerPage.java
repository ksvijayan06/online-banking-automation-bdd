package XYZ_Bank.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage extends BasePage {
	private static Logger logger = Logger.getLogger(ManagerPage.class);

	public ManagerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
	private WebElement addCustomer;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")
	private WebElement firstName;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")
	private WebElement lastName;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")
	private WebElement postCode;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/button")
	private WebElement addCustomerButton;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
	private WebElement openAccount;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[3]")
	private WebElement customers;

	@FindBy(xpath = "/html/body/div/div/div[1]/button[1]")
	private WebElement home;

	public void addCustomer(String cusFirstName, String cusLastName, String cusPostCode) {
		logger.info("Initiating customer addition process for " + cusFirstName + " " + cusLastName);
		addCustomer.click();
		logger.info("Clicked on 'Add Customer' button");
		firstName.sendKeys(cusFirstName);
		logger.info("Entered first name: " + cusFirstName);
		lastName.sendKeys(cusLastName);
		logger.info("Entered last name: " + cusLastName);
		postCode.sendKeys(cusPostCode);
		logger.info("Entered postcode: " + cusPostCode);
		addCustomerButton.click();
		logger.info("Clicked on 'Add Customer Button' to submit the form");
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		logger.info("Alert received: " + alertMsg);
		alert.accept();
		logger.info("Alert accepted and customer addition process completed successfully");

	}

	public void goHome() {
		home.click();
		logger.info("Navigating to home page");
	}

}
