package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	// By sign = By.cssSelector("a[href*='sign in']");
	private By sign = By.xpath("//nav[@class='pull-right']/ul/li[4]/a");

	private By title = By.xpath("//div[@class='text-center']/h2");

	// .navbar-collapse.collapse
	private By navigationBar = By.cssSelector("[class*='navbar-collapse collapse']");
	private By reg = By.xpath("//*[@class='fa fa-user fa-lg']");
	
	private By header = By.xpath("//div[@class='col-sm-6 col-md-8 hidden-xs video-banner']/h3");

	// By link =By.cssSelector("div[class='m-b-3-xs form-footer ash bodyMain'] a");
	// driver.findElements(By.tagName("a")).size()
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {

		driver.findElement(sign).click();
		LoginPage l = new LoginPage(driver);
		return l;

	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getnavigationBar() {
		return driver.findElement(navigationBar);
	}

	public Register regsitraton() {
		// return driver.findElement(reg)
		driver.findElement(reg).click();
		Register rg = new Register(driver);
		return rg;
	}

//	public int linkcount() {
//		driver.findElement(reg).click();
//		return	driver.findElements(link).size();
//		
//	}

}
