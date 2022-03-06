package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By logo = By.xpath("//img[@alt='My Store']");
	
	By sign = By.cssSelector("a.login");
	
	By link = By.tagName("a");
	
	By footer_link =By.cssSelector(".footer-container");
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement lpVerification() {
		return driver.findElement(logo);
		
		
	}
	
	public WebElement signin() {
		return driver.findElement(sign);
	}
	
	public List<WebElement> getAllLinks() {
		List<WebElement> allLinks = driver.findElements(link);
		return allLinks;
	}
	
	public List<WebElement> linkcount() {
		return driver.findElements(link);
	}
	
	public List<WebElement> link_footer()
	{
		WebElement foot =  driver.findElement(footer_link);
		return foot.findElements(link);
		
	}
	

}
