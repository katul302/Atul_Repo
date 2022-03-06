package practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkcount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		driver.manage().window().maximize();

		// Using below command we will get the link on entire page

		System.out.println(driver.findElements(By.tagName("a")).size());

		// Using below command we will limit the scope of webdriver and any specfic
		// section of the screen

		// Let say we need to find the link on the footer section of the page we use
		// below script

		WebElement foot = driver.findElement(By.cssSelector("div#gf-BIG"));

		int c = foot.findElements(By.tagName("a")).size();
		System.out.println(c);

		// we can more limit the webdriver to specfic column

		WebElement colfoot = foot.findElement(By.xpath("//table/tbody/tr/td/ul[1]"));
		int d = colfoot.findElements(By.tagName("a")).size();
		System.out.println(d);

		// Click on each link in the column and see pages are opening

		for (int i = 1; i < d; i++) {
			String clickontab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			colfoot.findElements(By.tagName("a")).get(i).sendKeys(clickontab);
			//Thread.sleep(5000);

		}
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

		 driver.quit();

	}

}
