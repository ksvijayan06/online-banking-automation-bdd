package XYZ_Bank.stepDefinitions.customerOperations;



import XYZ_Bank.stepDefinitions.BaseTest;
import XYZ_Bank.utils.ScreenshotToWordUtility;
import io.cucumber.java.en.*;

public class TC_Customer_02 extends BaseTest {
	
	ScreenshotToWordUtility screenshot;

	public TC_Customer_02() {
		screenshot = ScreenshotToWordUtility.getInstance(driver, testReportDirPath(this.getClass()),
				this.getClass().getSimpleName());
	}
	
	@Given("a customer {string} account exists with multiple account in XYZ Bank")
	public void a_customer_account_exists_with_multiple_account_in_xyz_bank(String username) {
		homepage.clickCustomerLogin();
		customerLoginPage.selectCustomer(username);
		screenshot.captureScreenshotAndAddToDoc();
	}
	@Then("the customer switch to another account")
	public void the_customer_switch_to_another_account() {
	    accountPage.switchAnotherAccount();
	    screenshot.captureScreenshotAndAddToDoc();
	}

}
