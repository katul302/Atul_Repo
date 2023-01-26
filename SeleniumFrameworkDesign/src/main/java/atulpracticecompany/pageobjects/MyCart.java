package atulpracticecompany.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atulpracticecompany.Abstractcomponent.AbstractComponent;

public class MyCart extends AbstractComponent {

	WebDriver driver;

	public MyCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;
	
	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));


	
	public List<WebElement> cartProducts()
	{
		return cartProducts;
	}
	public Boolean confrimProductInCart(String productName) {
		Boolean match = cartProducts().stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;

	}
	
	public CheckOut checkOut()
	{
		checkout.click();
		
		CheckOut co = new CheckOut(driver);
		return co;
	}

}
