package atulpracticecompany.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atulpracticecompany.Abstractcomponent.AbstractComponent;

public class CheckOut extends AbstractComponent {

	WebDriver driver;

	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()  = 'CVV Code ']")
	WebElement cvv;

	@FindBy(xpath = "//*[text() = 'CVV Code '] / following-sibling::input")
	WebElement code;

	@FindBy(xpath = "//*[text() = 'Name on Card '] / following-sibling::input")
	WebElement name;

	@FindBy(name = "coupon")
	WebElement coupon;

	@FindBy(xpath = "//*[text() = 'Apply Coupon']")
	WebElement btn_click;

	@FindBy(css = ".mt-1.ng-star-inserted")
	WebElement text;

	@FindBy(css = ".user__address div input")
	WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;

	@FindBy(css = ".action__submit")
	WebElement placeOrder;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By countryList = By.cssSelector(".ta-results.list-group.ng-star-inserted");

	public void fill_personalInfo(String cvv, String Name) {
		code.sendKeys(cvv);
		name.sendKeys(Name);

		System.out.println("Personal info filled successfully");

	}

	public String applyCode(String couponcode) throws InterruptedException {
		coupon.sendKeys(couponcode);
		
		
		Thread.sleep(2000);
		btn_click.click();
		waitForElementToDisappear(spinner);

		return text.getText();

	

	}
	
	public void selectCountry(String countryName) throws InterruptedException
	{
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(countryList);
		selectCountry.click();
		System.out.println("Country selected");
		
	}
	
	public ConfirmationPage placeOrder()
	{
		placeOrder.click();
		return new ConfirmationPage(driver);
	}

}
