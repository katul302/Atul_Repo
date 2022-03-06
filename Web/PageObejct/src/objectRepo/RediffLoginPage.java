package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
	
	
	WebDriver driver;
	
	public  RediffLoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		
	}
	
	By Sign = By.xpath("//*[text()='Sign in']");
	By username = By.id("login1");
	By password = By.name("passwd");
	By login_btn =  By.cssSelector("input.signinbtn");
	
	public WebElement sing_in_link()
	{
		return driver.findElement(Sign);
	}
	
	public WebElement user_name() {
		return driver.findElement(username);
	}
	public WebElement btn_login()
	{
		return driver.findElement(login_btn);
	}
	
	public WebElement pass()
	{
		return driver.findElement(password);
		}
}
