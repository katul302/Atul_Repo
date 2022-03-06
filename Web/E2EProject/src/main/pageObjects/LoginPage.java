package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	// By sign = By.cssSelector("a[href*='sign in']");
	By email = By.cssSelector("input#user_email");
	By pass = By.cssSelector("input[type='password']");
	By login = By.xpath("//input[@type='submit']");
	
	By forgot = By.cssSelector(".link-below-button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {

		return driver.findElement(email);
	}
	public WebElement getPass() {

		return driver.findElement(pass	);
	}
	
	public WebElement login() {
		
		return driver.findElement(login);
	}
	public ForgotPassword forgotpass() {
		driver.findElement(forgot).click();
		
		return  new ForgotPassword(driver);
		
		
	}

}
