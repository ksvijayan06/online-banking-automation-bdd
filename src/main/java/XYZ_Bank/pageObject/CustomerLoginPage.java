package XYZ_Bank.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage extends BasePage {
	private static Logger logger = Logger.getLogger(CustomerLoginPage.class);

	public CustomerLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userSelect")
	private WebElement listOfCustomer;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/form/button")
	private WebElement login;
	
	@FindBy(xpath="/html/body/div/div/div[1]/button[1]")
	private WebElement home;

	private static String customer;

	public void selectCustomer(String customer) {
		Select s = new Select(listOfCustomer);
		s.selectByVisibleText(customer);
		logger.info("Customer selected: " + customer);
		CustomerLoginPage.customer = customer;
	}

	public void customerLogin() {
		login.click();
		logger.info("Login successful for " + customer);
	}
	
	public void goHome() {
		home.click();
		logger.info("Redirected to the HomePage");
	}
	
	public void verifySuccessfullLogout() {
		verifyURLContains("customer");
		logger.info("Successfully Logout from the account and redirected to login page: "+driver.getCurrentUrl());
	}

}
