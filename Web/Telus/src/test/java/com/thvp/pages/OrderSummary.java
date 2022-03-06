package com.thvp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSummary {

	public WebDriver driver;
	
////*[text()[contains(.,'complete')]]
	
	private By proceed = By.xpath("//*[text()[contains(.,'checkout')]]");

	public OrderSummary(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement proceed() {
		return driver.findElement(proceed);
		
		
	}
}
