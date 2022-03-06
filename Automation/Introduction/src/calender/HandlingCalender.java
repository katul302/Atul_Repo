package calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(baseUrl);
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		//ui-state-default.ui-state-highlight.ui-state-hover
		
		driver.findElement(By.xpath("//*[contains(@class,'highlight')]")).click();
		
		
		
	}

}
