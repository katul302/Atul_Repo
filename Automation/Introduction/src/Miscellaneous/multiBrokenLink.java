package Miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class multiBrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		SoftAssert a = new SoftAssert();

		List<WebElement> Lists = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for (WebElement link : Lists) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int res = conn.getResponseCode();
			System.out.println(res);

			a.assertTrue(res < 400, "The link with text" + link.getText() + "is broken with code" + res);

//					if(res>400)
//					{
//						System.out.println("The link with text" +link.getText()+ "is broken with code" +res);
//						Assert.assertTrue(false);
//					}

		}
		a.assertAll();

	}

}
