import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\chromedriver.exe");
		//driver = new ChromeDriver();
		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://www.google.com/";
		driver.get(baseUrl);

		WebElement P = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		P.sendKeys("javatpoint tutorials");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement id = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='wM6W7d']/span")));

		// driver.findElement(By.id("gLFyf")).sendKeys("javatpoint tutorials");

		// Click on the search button
		P.submit();

	}

}