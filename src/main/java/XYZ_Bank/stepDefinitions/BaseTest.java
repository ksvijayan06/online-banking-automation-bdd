package XYZ_Bank.stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import XYZ_Bank.pageObject.AccountPage;
import XYZ_Bank.pageObject.CustomerLoginPage;
import XYZ_Bank.pageObject.HomePage;
import XYZ_Bank.pageObject.ManagerPage;
import XYZ_Bank.utils.WebDriverUtil;

public class BaseTest {

	protected WebDriver driver = WebDriverUtil.getDriver();
	protected HomePage homepage = new HomePage(driver);
	protected CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
	protected AccountPage accountPage = new AccountPage(driver);
	protected ManagerPage managerPage = new ManagerPage(driver);
	private static String dynamicDateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	private final static String testResultDir = "./test-report/" + "test-result" + dynamicDateTime + "/";

	protected String testReportDirPath(Class<?> clazz) {
		String packageName = "default-package";
		if (clazz.getPackage() != null) {
			String fullPackageName = clazz.getPackage().getName();
			packageName = fullPackageName.substring(fullPackageName.lastIndexOf('.') + 1);
		}

		String dirPath = testResultDir + packageName;
		return dirPath;
	}
	
	public static String testLogDirPath() {
		return testResultDir+"test-log/";
	}

}
