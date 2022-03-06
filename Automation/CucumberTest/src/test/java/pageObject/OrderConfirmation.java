package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmation {

	public WebDriver driver;

	public OrderConfirmation(WebDriver driver) {
		this.driver = driver;
	}

	By radio = By.cssSelector(".chkAgree");
	By btk = By.xpath("//div[@class='wrapperTwo']/button");

	public WebElement confirm() {

		return driver.findElement(radio);

	}

	public WebElement btk() {

		return driver.findElement(btk);

	}
}
