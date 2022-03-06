package dropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(baseUrl);
		
		Assert.assertFalse(driver.findElement(By.xpath("//*[contains(@id,'SeniorCitizenDiscount')]")).isSelected());

		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.xpath("//*[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());
		
		

}
}

