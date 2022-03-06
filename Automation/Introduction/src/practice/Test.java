package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("checkBoxOption2")).click();
		
		String a= driver.findElement(By.xpath("//div[@class='right-align']/fieldset/label[2]")).getText();
		System.out.println(a);
		
		String b= a.toLowerCase();
		System.out.println(b);
		
		WebElement dt = driver.findElement(By.name("dropdown-class-example"));
		
		Select dd = new Select(dt);
		dd.selectByValue(b);
		driver.findElement(By.name("enter-name")).sendKeys(a);
		driver.findElement(By.id("alertbtn")).click();
		String test = driver.switchTo().alert().getText();
		System.out.println(test);
		if (test.contains("Option2")) {
			Assert.assertTrue(true);
			System.out.println("test case pass");
		}

		else {
			Assert.assertFalse(false);
			System.out.println("Test case fail");
		}
		
		driver.switchTo().alert().accept();
		

	}

}
