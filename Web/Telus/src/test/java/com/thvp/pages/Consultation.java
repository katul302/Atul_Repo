package com.thvp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Consultation {

	public WebDriver driver;
	
	private By ph = By.id("patientConsultations_0__PhoneNumber");
	
	private By btn = By.cssSelector("#submitCounselingForm");
	
	private By place_btn = By.xpath("//*[text()[contains(.,'Place order')]]");
	
	public Consultation(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement ph() {
		return driver.findElement(ph);
	}
	
	public WebElement btn() {
		return driver.findElement(btn);
	}
	public WebElement place_btn() {
		return driver.findElement(place_btn);
	}
	
}
