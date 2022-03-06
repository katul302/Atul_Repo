package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register {

	public WebDriver driver;

	private By name = By.name("name");
	private By email = By.id("user_email");
	private By password = By.xpath("//*[@type='password']");
	private By terms = By.xpath("//*[@type='checkbox']");
	private By sign = By.xpath("//input[@type='submit']");
	private By login = By.linkText("Login");
	private By link = By.tagName("a");
	// driver.findElements(By.tagName("a")).size()

	public Register(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement name() {

		return driver.findElement(name);
	}

	public WebElement email() {

		return driver.findElement(email);
	}

	public WebElement password() {

		return driver.findElement(password);
	}

	public WebElement terms() {
		return driver.findElement(terms);

	}

	public WebElement signUp() {
		return driver.findElement(sign);

	}

	public LoginPage login() {
		/// return driver.findElement(login);
		driver.findElement(login).click();
		LoginPage l = new LoginPage(driver);
		return l;

	}

	public List<WebElement> linkcount() {
		return driver.findElements(link);
	}

	public List<WebElement> getAllLinks() {
		List<WebElement> allLinks = driver.findElements(link);
		return allLinks;
	}

	public List<WebElement> brokenLink() {
		List<WebElement> brkLink = driver.findElements(link);
		return brkLink;
	}
}
