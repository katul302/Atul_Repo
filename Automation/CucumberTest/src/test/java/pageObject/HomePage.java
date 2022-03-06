package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By result = By.cssSelector("h4.product-name");
	By checkout = By.cssSelector("p.product-name");
	By cart = By.cssSelector("a.increment");
	By action = By.xpath("//div[@class='product-action']/button");
	By proceed = By.xpath("//a[@class='cart-icon']");
	By button = By.xpath("//button[@type='button']");
	
	//driver.findElements(By.cssSelector("h4.product-name"));

	public WebElement getSearch() {
		return driver.findElement(search);
	}

	public WebElement result() {
		return driver.findElement(result);
	}

	public WebElement checkout_page() {
		return driver.findElement(checkout);
	}

	public WebElement cart() {
		return driver.findElement(cart);
	}

	public WebElement action() {
		return driver.findElement(action);

	}

	public WebElement proceed() {
		return driver.findElement(proceed);
	}

	public WebElement button() {
		return driver.findElement(button);
	}
}
