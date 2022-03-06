package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	// By sign = By.cssSelector("a[href*='sign in']");
	By sign = By.xpath("//nav[@class='pull-right']/ul/li[4]/a");

	By title = By.xpath("//div[@class='text-center']/h2");

	//.navbar-collapse.collapse
	By navigationBar = By.cssSelector("[class*='navbar-collapse collapse']");
	By reg = By.xpath("//*[@class='fa fa-user fa-lg']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {

		 driver.findElement(sign).click();
		 LoginPage l = new LoginPage(driver);
		return l;
		
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getnavigationBar() {
		return driver.findElement(navigationBar);
	}
	public WebElement regsitraton() {
		return driver.findElement(reg);
	}

}
