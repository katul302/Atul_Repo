package Miscellaneous;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class fileUpload {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String downloadPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		//Code to set preferance for chrome browser start
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs", chromePrefs);

		//Code to set preferance for chrome browser end
		
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://altoconvertpdftojpg.com/");

		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();

		Thread.sleep(3000);

		Runtime.getRuntime().exec("C:\\Users\\atulkumar.sharma\\Documents\\AutoIT\\fileupdown.exe");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));

		driver.findElement(By.cssSelector("button[class*='medium']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));

		driver.findElement(By.linkText("Download Now")).click();

		Thread.sleep(5000);
		
		//Code to put check if file is downloaded to the given directory start

		File f = new File(downloadPath + "/converted.zip");

		if (f.exists())

		{

			Assert.assertTrue(f.exists());

			if (f.delete())

				System.out.println("file deleted");

		}
		
//Code to put the check if the file is downloaded ends
	}

}