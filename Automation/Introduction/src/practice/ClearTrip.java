package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClearTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.cleartrip.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".closeit")).click();
		driver.findElement(By.xpath("//*[contains(@style,'185px')]")).click();
		driver.findElement(By.xpath("//*[contains(@style,'35px')]")).click();

	}

}
