package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;

	public static  WebDriver getDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Automation\\ca\\src\\main\\java\\resources\\Global.properties");

		prop.load(fis);

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;

	}

}
