package XYZ_Bank.stepDefinitions.customerOperations;

import XYZ_Bank.stepDefinitions.BaseTest;
import XYZ_Bank.utils.ScreenshotToWordUtility;
import io.cucumber.java.en.*;

public class TC_Customer_04 extends BaseTest{
	ScreenshotToWordUtility screenshot;

	public TC_Customer_04() {
		screenshot = ScreenshotToWordUtility.getInstance(driver, testReportDirPath(this.getClass()),
				this.getClass().getSimpleName());
	}
	
	@Given("a customer {string} account exists with at least one account in XYZ Bank.")
	public void a_customer_account_exists_with_at_least_one_account_in_xyz_bank(String username) {
		homepage.clickCustomerLogin();
		customerLoginPage.selectCustomer(username);
		screenshot.captureScreenshotAndAddToDoc();
	    
	}
	@Then("withdraw {int} exceed with the current available balance was unsuccessfull")
	public void withdraw_exceed_with_the_current_available_balance_was_unsuccessfull(int withdraw) {
	    accountPage.withdrawl(withdraw);
	    screenshot.captureScreenshotAndAddToDoc();
	}
}
