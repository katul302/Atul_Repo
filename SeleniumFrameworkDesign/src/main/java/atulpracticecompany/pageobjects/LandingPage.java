package atulpracticecompany.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atulpracticecompany.Abstractcomponent.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// WebElement userPassword = driver.findElement(By.id("userPassword"));
	//WebElement login = driver.findElement(By.id("login"));
	
	// PageFactory: In backend line 22 and 23 will
	// get convert like line 18

	// How this find by know about driver: PageFactory.initElements(driver, this);
	// will give the knowledge of driver and start initializing webelement

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css = "[class*=flyInOut]")
	WebElement errorMessage;
	
	public ProductCatalog loginApplicationMethod(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		ProductCatalog pc = new ProductCatalog(driver);
		return pc;
	}
	
	public String getLoginErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return	errorMessage.getText();
		 
		 
	}
	public void goTo()
	{
		driver.get("https://www.rahulshettyacademy.com/client");
	}

}
