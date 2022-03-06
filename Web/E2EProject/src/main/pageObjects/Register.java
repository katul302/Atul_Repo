package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register {

	public WebDriver driver;

	
	By name = By.name("name");
	By email = By.id("user_email");
	By password = By.xpath("//*[@type='password']");
	By terms = By.xpath("//*[@type='checkbox']");

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

}
