package Miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String url= driver.findElement(By.linkText("SoapUI")).getAttribute("href");
		HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int res=conn.getResponseCode();
		System.out.println(res);
		
				String url1= driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		HttpURLConnection conn2=(HttpURLConnection)new URL(url).openConnection();
		conn2.setRequestMethod("HEAD");
		conn2.connect();
		int res2=conn.getResponseCode();
		System.out.println(res2);
	}

}
