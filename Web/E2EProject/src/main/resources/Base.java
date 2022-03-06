package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver inintializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Web\\E2EProject\\src\\main\\resources\\data.properties");
		
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();

			capabilities.setCapability("marionette", true);

			driver = new FirefoxDriver(capabilities);
		} else if (browsername.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_Win32_2.41.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

	}

}
