package dropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(baseUrl);
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).getSize());

		System.out.println(driver.findElement(By.xpath("//*[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.xpath("//*[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());

		// count the number of checkbox
		System.out.println(driver.findElements(By.id("input[type='checkbox']")).size());

	}

}
