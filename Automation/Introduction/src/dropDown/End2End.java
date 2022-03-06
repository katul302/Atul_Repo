package dropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class End2End {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(baseUrl);
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(3000);

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

		driver.findElement(By.xpath("//a[@value='DEL']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@value='BHO'])[2]")).click();
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();

		// ui-state-default.ui-state-highlight.ui-state-hover

		driver.findElement(By.xpath("//*[contains(@class,'highlight')]")).click();
		driver.findElement(By.cssSelector(".paxinfo")).click();
		Thread.sleep(3000);

		System.out.println(driver.findElement(By.cssSelector(".paxinfo")).getText());

		/*
		 * int i =0; while(i<5) { driver.findElement(By.id("hrefIncAdt")).click(); i++;
		 * }
		 */

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.xpath("//input[@value='Done']")).click();
		System.out.println(driver.findElement(By.cssSelector(".paxinfo")).getText());
		WebElement dt = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dd = new Select(dt);
		dd.selectByVisibleText("AED");
		System.out.println(dt.getText());
		System.out.println(dd.getFirstSelectedOption().getText());
		dd.selectByIndex(1);
		System.out.println(dd.getFirstSelectedOption().getText());
		dd.selectByValue("USD");
		System.out.println(dd.getFirstSelectedOption().getText());
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).getSize());

		System.out.println(driver.findElement(By.xpath("//*[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.xpath("//*[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());

		// count the number of checkbox
		System.out.println(driver.findElements(By.id("input[type='checkbox']")).size());
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_btn_FindFlights']")).click();
	}

}
