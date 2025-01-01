package XYZ_Bank.OnlineBankingApplication;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
		WebElement select = driver.findElement(By.id("userSelect"));
		Select s = new Select(select);
		s.selectByIndex(2);

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("300");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
		Thread.sleep(900);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]")).click();
		WebElement table = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/table"));
		WebElement tableHeader = table.findElement(By.tagName("thead"));
		WebElement tableBody = table.findElement(By.tagName("tbody"));
		List<WebElement> header = tableHeader.findElements(By.tagName("td"));
		WebElement datapicker = driver.findElement(By.xpath("//*[@id=\"end\"]"));
		datapicker.sendKeys("12292024");

		driver.findElement(By.xpath("//*[@id=\"start\"]")).sendKeys("122920241200AM");

		System.out.println(header.size());
		for (WebElement e : header) {
			System.out.print(e.getText() + " \t");
		}
		System.out.println();
		List<WebElement> body = tableBody.findElements(By.tagName("tr"));

		for (WebElement ele : body) {
			for (WebElement e : ele.findElements(By.tagName("td"))) {
				System.out.print(e.getText() + "\t");
			}
			System.out.println();
		}

		driver.quit();

	}

}
