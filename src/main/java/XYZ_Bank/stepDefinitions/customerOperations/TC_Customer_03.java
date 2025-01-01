package XYZ_Bank.stepDefinitions.customerOperations;

import XYZ_Bank.stepDefinitions.BaseTest;
import XYZ_Bank.utils.ScreenshotToWordUtility;
import io.cucumber.java.en.*;

public class TC_Customer_03 extends BaseTest{
	ScreenshotToWordUtility screenshot;

	public TC_Customer_03() {
		screenshot = ScreenshotToWordUtility.getInstance(driver, testReportDirPath(this.getClass()),
				this.getClass().getSimpleName());
	}
	
	@Given("setup test data {string} {string} {string} with 0 account in XYZ Bank")
	public void setup_test_data_with_account_in_xyz_bank(String firstName, String lastName, String postCode) {
		homepage.clickManagerLogin();
	    managerPage.addCustomer(firstName, lastName, postCode);
	    managerPage.goHome();
	}
	@Given("a customer {string} account exists with 0 account in XYZ Bank")
	public void a_customer_account_exists_with_zero_account_in_xyz_bank(String username) {
		homepage.clickCustomerLogin();
		customerLoginPage.selectCustomer(username);
		screenshot.captureScreenshotAndAddToDoc();
	}
	@Then("no deposit, withdrawl, transaction feature are available for customer having 0 account")
	public void no_deposit_withdrawl_transaction_feature_are_available_for_customer_having_account() {
	    accountPage.isDepositFeatureAvailable();
	    accountPage.isWithdrawlFeatureAvailable();
	    accountPage.isTransactionFeatureAvailable();
	}

}
