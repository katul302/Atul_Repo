package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		WebElement TogetRows = driver.findElement(By.xpath("//table[@name='courses']/tbody"));

		List<WebElement> TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of rows in the table are: " + TotalRowsList.size());

		WebElement Togetcolumn = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[1]"));

		List<WebElement> TotalcolumnList = Togetcolumn.findElements(By.tagName("th"));
		System.out.println("Total number of column in the table are: " + TotalcolumnList.size());

		WebElement print = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]"));

		List<WebElement> test = print.findElements(By.tagName("td"));
		String col;
		for (int i = 0; i < test.size(); i++) {
			col = test.get(i).getText();
			System.out.println(col);
		}

	}

}
