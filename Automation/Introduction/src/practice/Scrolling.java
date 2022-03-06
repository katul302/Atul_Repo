package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(5000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500", args);
		
		List<WebElement> values= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum =0;
		for(int i=0;i<values.size();i++)
		{
			sum = sum+Integer.parseInt(values.get(i).getText());
			
		}
		System.out.println(sum);
		
	int total =Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
	
	Assert.assertEquals(sum, total);
	
	
	
	
		
		
		
		
		
			


	}

}
