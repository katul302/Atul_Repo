package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveOverExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://www.amazon.in/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("span#nav-link-accountList-nav-line-1"));
		WebElement text = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		act.moveToElement(text).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		act.moveToElement(move).contextClick().build().perform();	
		
	}

}
