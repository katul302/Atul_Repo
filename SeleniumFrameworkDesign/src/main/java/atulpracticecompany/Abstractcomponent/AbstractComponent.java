package atulpracticecompany.Abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atulpracticecompany.pageobjects.MyCart;
import atulpracticecompany.pageobjects.OrderPage;

public class AbstractComponent {

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;

	@FindBy(css = "[routerlink*='/dashboard/myorders']")
	WebElement myOrder;

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException

	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
		Thread.sleep(1000);
	}

	public MyCart goToCartPage() {
		cartHeader.click();
		MyCart mc = new MyCart(driver);
		return mc;
	}

	
	public OrderPage goToMyOrderPage() {
		myOrder.click();
		OrderPage op = new OrderPage(driver);
		return op;
	}

}
