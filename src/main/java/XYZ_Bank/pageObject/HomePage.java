package XYZ_Bank.pageObject;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	private static Logger logger = Logger.getLogger(HomePage.class);
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[1]/button")
	private WebElement customerLogin;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/div[2]/button")
	private WebElement managerLogin;
	
	public HomePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickCustomerLogin() {
		customerLogin.click();
		logger.info("clicked the customer login");
	}
	
	public void clickManagerLogin() {
		managerLogin.click();
		logger.info("clicked the manager login");
	}
	
	
	
	
}
