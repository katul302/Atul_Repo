package com.thvp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut {

	public WebDriver driver;

	private By alt_add_radio = By.xpath("//input[@id='alternateAddress']/following-sibling::span[1]");
	private By add_l1 = By.xpath("//*[@placeholder='Street name']");
	private By add_l2 = By.name("DeliverToAddress2");
	private By city = By.cssSelector("#DeliverToCity");
	private By province = By.id("DeliverToProv");
	private By postal = By.xpath("//*[@id='DeliverToPostalCode']");
	private By phone = By.name("DeliverToPhoneNumber");
	private By ext = By.id("DeliverToPhoneExtension");
	private By continue_btn = By.xpath("//*[text()[contains(.,'Continue')]]");

	public CheckOut(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement alt_add_radio() {
		return driver.findElement(alt_add_radio);
	}

	public WebElement add_l1() {
		return driver.findElement(add_l1);
	}

	public WebElement add_l2() {
		return driver.findElement(add_l2);
	}

	public WebElement city() {
		return driver.findElement(city);
	}

	public WebElement province() {
		return driver.findElement(province);
	}

	public WebElement postal() {
		return driver.findElement(postal);
	}

	public WebElement phone() {
		return driver.findElement(phone);
	}

	public WebElement ext() {
		return driver.findElement(ext);
	}

	public WebElement continue_btn() {
		return driver.findElement(continue_btn);
	}

}
