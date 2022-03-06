package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	// By sign = By.cssSelector("a[href*='sign in']");
	private By email = By.cssSelector("input#user_email");
	private By pass = By.cssSelector("input[type='password']");
	private By login = By.xpath("//input[@type='submit']");

	private By forgot = By.cssSelector(".link-below-button");

	private By signin = By.xpath("//input[@type='email']");
	private By password = By.id("password");
	private By name = By.name("commit");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {

		return driver.findElement(email);
	}

	public WebElement getPass() {

		return driver.findElement(pass);
	}

	public WebElement login() {

		return driver.findElement(login);
	}

	public ForgotPassword forgotpass() {
		driver.findElement(forgot).click();

		return new ForgotPassword(driver);

	}

	public WebElement signin() {

		return driver.findElement(signin);
	}

	public WebElement password() {

		return driver.findElement(password);
	}

	public WebElement name() {

		return driver.findElement(name);
	}

}
