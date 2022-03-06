package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//https://www.itgeared.com/demo/1506-ajax-loading.html
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait W = new WebDriverWait(driver, 15);
		String baseUrl = "https://www.itgeared.com/demo/1506-ajax-loading.html";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
		W.until(ExpectedConditions.elementToBeClickable(By.id("results")));
		
		System.out.println(driver.findElement(By.id("results")).getText());
	}

}
