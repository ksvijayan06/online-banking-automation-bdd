package XYZ_Bank.stepDefinitions.customerOperations;

import XYZ_Bank.stepDefinitions.BaseTest;
import XYZ_Bank.utils.ScreenshotToWordUtility;
import io.cucumber.java.en.*;

public class TC_Customer_05 extends BaseTest{
	ScreenshotToWordUtility screenshot;

	public TC_Customer_05() {
		screenshot = ScreenshotToWordUtility.getInstance(driver, testReportDirPath(this.getClass()),
				this.getClass().getSimpleName());
	}
	
	@Given("a customer {string} account exist with at least one account in XYZ Bank")
	public void a_customer_account_exist_with_at_least_one_account_in_xyz_bank(String username) {
		homepage.clickCustomerLogin();
		customerLoginPage.selectCustomer(username);
		screenshot.captureScreenshotAndAddToDoc();
	}
	@When("the customer {string} re-login")
	public void the_customer_re_login(String username) {
		customerLoginPage.selectCustomer(username);
		customerLoginPage.customerLogin();
		screenshot.captureScreenshotAndAddToDoc();
	}
	@When("the customer should be able to view the updated transaction history")
	public void the_customer_should_be_able_to_view_the_updated_transaction_history() {
		accountPage.viewTransactionHistory();
	}
}
