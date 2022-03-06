package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPageFactory {
	
	
	WebDriver driver;
	
	public  RediffLoginPageFactory(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	/*By Sign = By.xpath("//*[text()='Sign in']");
	By username = By.id("login1");
	By password = By.name("passwd");
	By login_btn =  By.cssSelector("input.signinbtn");*/
	
	
	@FindBy(xpath="//*[text()='Sign in']")
	WebElement Sign	;
	
	@FindBy(id="login1")
	WebElement username;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(css="input.signinbtn")
	WebElement login_btn;
	
	public WebElement sing_in_link()
	{
		return Sign;
	}
	
	public WebElement user_name() {
		return username;	
	}
	public WebElement btn_login()
	{
		return login_btn;
	}
	
	public WebElement pass()
	{
		return password;
	}
}
