package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepo.RediffLoginPage;
import objectRepo.RediffLoginPageFactory;

public class LoginApplication {

	
	@Test
	
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		//RediffLoginPage rp = new RediffLoginPage(driver);
		
		RediffLoginPageFactory rp = new RediffLoginPageFactory(driver);
		rp.sing_in_link().click();
		rp.user_name().sendKeys("Hello");
		rp.pass().sendKeys("12345678");
		rp.btn_login().click();
		
	}
}
