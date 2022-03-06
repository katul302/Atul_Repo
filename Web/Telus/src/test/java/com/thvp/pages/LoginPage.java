package com.thvp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	
	public WebDriver driver;
	
	
	private By login_email = By.id("Email");
	private By password = By.name("Password");
	private By login_btn = By.cssSelector("#button-submit");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement login_email() {
		return driver.findElement(login_email);
		
		
	}
	public WebElement password() {
		return driver.findElement(password);
		
		
	}
	public WebElement login_btn() {
		return driver.findElement(login_btn);
		
		
	}
	

}
