package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://the-internet.herokuapp.com/nested_frames";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("frame")).size());
		//driver.switchTo().frame(By.xpath("/frameset[@name='frameset-middle']/frame[2]"));
		
		//driver.switchTo().frame(driver.findElement(By.xpath("/frameset[@name='frameset-middle']/frame[2]")));
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.close();
		

	}

}
