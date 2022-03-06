import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(baseUrl);

		WebElement dt = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dd = new Select(dt);
		dd.selectByVisibleText("AED");
		System.out.println(dt.getText());
		System.out.println(dd.getFirstSelectedOption().getText());
		dd.selectByIndex(1);
		System.out.println(dd.getFirstSelectedOption().getText());
		dd.selectByValue("USD");
		System.out.println(dd.getFirstSelectedOption().getText());
		driver.close();
	}

}
