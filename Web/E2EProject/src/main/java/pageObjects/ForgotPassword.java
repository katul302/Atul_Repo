package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;

	// By sign = By.cssSelector("a[href*='sign in']");
	 private By email = By.id("user_email");
	 private By button = By.cssSelector("input.btn.btn-primary.btn-md.login-button");

	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}

	
	public WebElement email() {
		return driver.findElement(email);
		
		
		
	}
	public WebElement sendIns() {
		return driver.findElement(button);
		
		
		
	}

}
