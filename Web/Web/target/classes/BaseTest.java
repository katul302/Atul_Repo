package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver inintializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Web\\Web\\src\\main\\java\\resources\\data.properties");
		
		
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {
			
			System.setProperty("webdriver.firefox.bin",
					"D:\\driver\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		} else if (browsername.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;

	}

	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

	}

}
