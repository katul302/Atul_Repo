package ecommerce;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait W = new WebDriverWait(driver, 5);
		String[] items = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		String baseUrl = "https://rahulshettyacademy.com/seleniumPractise/#/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		additems(driver, items);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
		W.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		W.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		driver.findElement(By
				.xpath("//div[@style='text-align: right; width: 100%; margin-top: 20px; margin-right: 10px;']/button"))
				.click();
		Select dd = new Select(driver.findElement(By.xpath("//div[@style='width: 360px; margin: 10px auto;']/select")));
		dd.selectByVisibleText("Afghanistan");
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//div[@class='wrapperTwo']/button")).click();
	}

	public static void additems(WebDriver driver, String[] items) throws InterruptedException {
		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] veg = products.get(i).getText().split("-");
			String formattedname = veg[0].trim();
			// check whether name you extracted is present in array or not
			// convert array into arraylist for east search

			List itemsneededlist = Arrays.asList(items);
			if (itemsneededlist.contains(formattedname))

			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == items.length) {
					break;
				}

			}

		}

	}

}
