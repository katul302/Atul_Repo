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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver inintializeDriver() throws IOException {

		prop = new Properties();
		
		//System.getProperty("user.dir")
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		// mvn test -Dbrowser=chrome
		String browsername = System.getProperty("browser");
		//String browsername = prop.getProperty("browser");
		if (browsername.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\chromedriver.exe");
			
			ChromeOptions option = new ChromeOptions();
			
			if(browsername.contains("headless")) {
				option.addArguments("headless");	
			}
			
			driver = new ChromeDriver(option);

		} else if (browsername.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		} else if (browsername.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\msedgedriver.exe");
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
