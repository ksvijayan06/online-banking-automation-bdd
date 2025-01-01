package XYZ_Bank.pageObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;
import XYZ_Bank.utils.ScreenshotToWordUtility;

public class AccountPage extends BasePage {
	private static Logger logger = Logger.getLogger(AccountPage.class);

	public AccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// deposit element
	// deposit option in account page
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[3]/button[2]")
	private WebElement depositButton;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/div/input")
	private WebElement amountToDeposit;
	// deposit money into the account
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
	private WebElement deposit;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/span")
	private WebElement depositSuccessMessage;

	// withdrawl element
	// withdrawl option in account page
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[3]/button[3]")
	private WebElement withdrawlButton;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/div/input")
	private WebElement amountToWithdrawl;
	// withdrawl money into the account
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
	private WebElement withdrawl;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/span")
	private WebElement withdrawlSuccessMessage;

	// other webelement
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong[2]")
	private WebElement balance;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong[3]")
	private WebElement currency;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong[1]")
	private WebElement accountNumber;
	@FindBy(id = "accountSelect")
	private WebElement allAccounts;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/strong/span")
	private WebElement customerName;
	@FindBy(xpath = "/html/body/div/div/div[1]/button[2]")
	private WebElement logout;

	// transaction element
	// transaction option in account page
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[3]/button[1]")
	private WebElement transactionsButton;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/table")
	private WebElement transactionTable;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
	private WebElement backFromTransactions;
	@FindBy(id = "start")
	private WebElement startDate;
	@FindBy(id = "end")
	private WebElement endDate;

	public void logout() {
		logout.click();
		logger.info("logout successfully");

	}

	public void verifyCustomerName(String name) {
		Assert.assertEquals(customerName.getText(), name);
	}

	public void verifyAccountDashboard(String username) {
		verifyCustomerName(username);
		logger.info(String.format("Customer name '%s' is successfully validated against the dashboard username.",
				username));
		verifyURLContains("account");
		logger.info(String.format("User navigated to the account dashboard. URL contains 'account': %s",
				driver.getCurrentUrl()));
		logger.info("inital account number : " + accountNumber.getText() + ", balance: " + balance.getText()
				+ ", Currency: " + currency.getText());
	}

	public void deposit(Integer depositAmt) {
		logger.info("Current available balance is : " + balance.getText());
		depositButton.click();
		invisibilityOf(depositSuccessMessage);

		amountToDeposit.sendKeys(depositAmt.toString());
		ScreenshotToWordUtility.getInstance().ifPresent(x -> x.captureScreenshotAndAddToDoc());
		deposit.click();
		Assert.assertEquals(depositSuccessMessage.getText(), "Deposit Successful");
		logger.info(String.format("Deposit successfully '%d' current avaialble balance is '%s'", depositAmt,
				balance.getText()));
	}

	public void withdrawl(Integer withdrawlAmt) {

		logger.info("Current available balance is : " + balance.getText());
		withdrawlButton.click();
		invisibilityOf(withdrawlSuccessMessage);

		amountToWithdrawl.sendKeys(withdrawlAmt.toString());
		ScreenshotToWordUtility.getInstance().ifPresent(x -> x.captureScreenshotAndAddToDoc());
		withdrawl.click();

		if (withdrawlAmt > Integer.parseInt(balance.getText())) {
			Assert.assertEquals(withdrawlSuccessMessage.getText(), "Transaction Failed. You can not withdraw amount more than the balance.");
			logger.info(String.format("Withdrawl unsuccessfull '%d' current available balance is '%s'", withdrawlAmt,
					balance.getText()));
		}
		else {
			Assert.assertEquals(withdrawlSuccessMessage.getText(), "Transaction successful");
			logger.info(String.format("Withdrawl successfull '%d' current available balance is '%s'", withdrawlAmt,
					balance.getText()));
		}
	}

	public void viewTransactionHistory() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("The thread was interrupted while sleeping: " + e.getMessage());
			logger.error("Exception Type: " + e.getClass().getName());
			logger.error("Stack Trace: ", e);
		}

		transactionsButton.click();

		// set current date as start date in calendar
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
		String formattedDate = currentDate.format(formatter) + "1200AM";

		String firstTransactionDateTime = startDate.getAttribute("min");
		DateTimeFormatter domDateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String domDateTime = currentDate.format(domDateTimeFormat);
		if (firstTransactionDateTime.contains(domDateTime) == false) {
			startDate.sendKeys(formattedDate);
			logger.info("set the start date time as : " + formattedDate);
		}

		// read data from transaction table
		WebElement tableHeader = transactionTable.findElement(By.tagName("thead"));
		WebElement tableBody = transactionTable.findElement(By.tagName("tbody"));

//		startDate.sendKeys(formattedDate);
//		waitForElementToBeVisible(transactionTable);
//		waitForElementToBeVisible(tableBody);

		logger.info("--------------- Latest Transaction History ------------------");
		List<WebElement> header = tableHeader.findElements(By.tagName("td"));
		String row = "";
		for (WebElement e : header) {
			row += e.getText() + "\t";
		}
		logger.info(row);

		List<WebElement> body = tableBody.findElements(By.tagName("tr"));
//		waitForElementToBeVisible(tableBody.findElement(By.tagName("tr")));

		for (WebElement r : body) {
			row = "";
			for (WebElement e : r.findElements(By.tagName("td"))) {
				row += e.getText() + "\t";
			}
			logger.info(row);
		}

		logger.info("-------------------------------------------------------------");
		// capture the screenshot of the transaction history
		ScreenshotToWordUtility.getInstance().ifPresent(x -> x.captureScreenshotAndAddToDoc());
		backFromTransactions.click();
		logger.info("Back to the account dashboard");
	}

	public void switchAnotherAccount() {
		String currAccount = accountNumber.getText();
		Select switchAccount = new Select(allAccounts);
		switchAccount.selectByIndex(1);

		// Log the change in account with details
		String newAccount = accountNumber.getText();
		String accountBalance = balance.getText();
		String accountCurrency = currency.getText();

		logger.info(String.format("Successfully switched from Account: %s to Account: %s", currAccount, newAccount));
		logger.info(String.format("New Account Details - Account Number: %s, Balance: %s, Currency: %s", newAccount,
				accountBalance, accountCurrency));

	}

	public void isDepositFeatureAvailable() {
		// TODO Auto-generated method stub
		boolean isAvailable = depositButton.isDisplayed();
		Assert.assertFalse(isAvailable);
		logger.info("Deposit feature is correctly not available for the user without an account.");
	}

	public void isWithdrawlFeatureAvailable() {
		boolean isAvailable = withdrawlButton.isDisplayed();
		Assert.assertFalse(isAvailable);
		logger.info("Withdrawal feature is correctly not available for the user without an account.");

	}

	public void isTransactionFeatureAvailable() {
		boolean isAvailable = transactionsButton.isDisplayed();
		Assert.assertFalse(isAvailable);
		logger.info("Transaction feature is correctly not available for the user without an account.");

	}

}
