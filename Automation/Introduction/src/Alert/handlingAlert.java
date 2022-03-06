package Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class handlingAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		String text = "Atul";
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		String test = driver.switchTo().alert().getText();
		if (test.contains("Atul")) {
			Assert.assertTrue(true);
		}

		else {
			Assert.assertFalse(false);
		}
		driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().accept();

	}

}
