package practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windwos {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://the-internet.herokuapp.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String>	Windows=	driver.getWindowHandles();
		Iterator<String>it = Windows.iterator();
		String parentid= it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		driver.switchTo().window(parentid);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		

}
}
