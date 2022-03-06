package com.cucumberpoint.CucumberTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;
	public static Properties prop;

	public static  WebDriver getDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Automation\\CucumberTest\\src\\test\\java\\Global.properties");

		prop.load(fis);

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
