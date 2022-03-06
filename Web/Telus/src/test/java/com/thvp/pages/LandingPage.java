package com.thvp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	
	private By login_btn = By.cssSelector(".b-welcome__login.btn.btn-primary");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement login() {
		return driver.findElement(login_btn);
		
		
	}

}
