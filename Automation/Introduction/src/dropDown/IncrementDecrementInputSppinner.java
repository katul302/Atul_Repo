package dropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncrementDecrementInputSppinner {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(baseUrl);
		driver.findElement(By.cssSelector(".paxinfo")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.cssSelector(".paxinfo")).getText());
		
		/*int i =0;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}*/
		
		for(int i=1;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.xpath("//input[@value='Done']")).click();
		System.out.println(driver.findElement(By.cssSelector(".paxinfo")).getText());
		driver.close();
	}
}
