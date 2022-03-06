package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dragable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://jqueryui.com/droppable/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		Actions a = new Actions(driver);
		WebElement dg = driver.findElement(By.cssSelector("div#draggable"));
		WebElement dp = driver.findElement(By.id("droppable"));
		a.dragAndDrop(dg, dp).build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Accept")).click();
		
	}

}
