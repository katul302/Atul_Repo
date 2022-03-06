package Miscellaneous;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class widowspopusimgautoit {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


		// Run the exe file that compiled from AutoIT to simulate enter
		// username&password into authentication pop up window
		Runtime.getRuntime().exec("D:\\driver\\pop.exe");

		// Go to OneSpace website (Dev environment)
		driver.get("https://the-internet.herokuapp.com/");

	}

}
