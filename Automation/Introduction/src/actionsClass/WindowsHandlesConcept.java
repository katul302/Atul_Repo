package actionsClass;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandlesConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://rahulshettyacademy.com/loginpagePractise/#";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> Windows = driver.getWindowHandles(); //[parentid,childid]
		Iterator<String>it = Windows.iterator();
		String parentid= it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
		String email = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(email);
		
		

	}

}
