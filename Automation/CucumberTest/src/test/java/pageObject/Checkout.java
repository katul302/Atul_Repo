package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout {
	
	public WebDriver driver;
	
	public Checkout(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By promo = By.className("promoCode");
	By apply = By.cssSelector("button.promoBtn");
 	By order = By.xpath("//div[@style='text-align: right; width: 100%; margin-top: 20px; margin-right: 10px;']/button");
	
	public WebElement promo()
	{
		return driver.findElement(promo);
	}
	public WebElement apply()
	{
		return driver.findElement(apply);
	}
	
	public WebElement order()
	{
		return driver.findElement(order);
	}

}
