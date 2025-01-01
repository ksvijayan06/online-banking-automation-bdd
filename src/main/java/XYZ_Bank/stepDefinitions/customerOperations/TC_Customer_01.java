package XYZ_Bank.stepDefinitions.customerOperations;

import XYZ_Bank.stepDefinitions.BaseTest;
import XYZ_Bank.utils.ScreenshotToWordUtility;
import io.cucumber.java.en.*;

public class TC_Customer_01 extends BaseTest {
	ScreenshotToWordUtility screenshot;

	public TC_Customer_01() {
		screenshot = ScreenshotToWordUtility.getInstance(driver, testReportDirPath(this.getClass()),
				this.getClass().getSimpleName());
	}

	@Given("a customer {string} account exists with at least one account in XYZ Bank")
	public void a_customer_account_exists_with_at_least_one_account_in_xyz_bank(String username) {
		homepage.clickCustomerLogin();
		customerLoginPage.selectCustomer(username);
		screenshot.captureScreenshotAndAddToDoc();
	}

	@When("the customer logs in with the username")
	public void the_customer_logs_in_with_the_username() {
		customerLoginPage.customerLogin();
		screenshot.captureScreenshotAndAddToDoc();
	}

	@Then("the customer {string} should be redirected to the account dashboard")
	public void the_customer_should_be_redirected_to_the_account_dashboard(String username) {
		accountPage.verifyAccountDashboard(username);
		screenshot.captureScreenshotAndAddToDoc();
	}

	@Then("the customer should be able to deposit {int}")
	public void the_customer_should_be_able_to_deposit(int deposit) {
		accountPage.deposit(deposit);
		screenshot.captureScreenshotAndAddToDoc();
	}

	@Then("withdraw {int} successfully")
	public void withdraw_successfully(int withdraw) {
		accountPage.withdrawl(withdraw);
		screenshot.captureScreenshotAndAddToDoc();
	}

	@Then("the customer should be able to view the transaction history")
	public void the_customer_should_be_able_to_view_the_transaction_history() {
		accountPage.viewTransactionHistory();
	}

	@When("the customer logs out of the system")
	public void the_customer_logs_out_of_the_system() {
		screenshot.captureScreenshotAndAddToDoc();
		accountPage.logout();
	}

	@Then("the customer should be successfully logged out and redirected to the login page")
	public void the_customer_should_be_successfully_logged_out_and_redirected_to_the_login_page() {
		customerLoginPage.verifySuccessfullLogout();
		screenshot.captureScreenshotAndAddToDoc();
	}
}
