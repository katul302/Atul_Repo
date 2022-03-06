package automationpractice;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.RegPage;
import resources.BaseTest;

public class LoginTest extends BaseTest {
	
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public WebDriver driver;
	public RegPage rp;
	public LandingPage lp;
	public WebElement ss;
	@BeforeMethod
	public void intialize() throws IOException {
		driver = inintializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is intialize from user registration test");
	}
	
	@Parameters({"Email","Password"})
	
	@Test(enabled=false)
	public void login_test(String Email,String Password)
	{
		log.info("Login test case started");
		
		lp = new LandingPage(driver);
		lp.signin().click();
		rp = new RegPage(driver);
		rp.email_signin().sendKeys(Email);
		rp.pass_signin().sendKeys(Password);
		rp.btn_sing().click();
		String user = rp.act_usr().getText();
		
		Assert.assertEquals(user, "Atul Sharma");
		
		log.info("Login successfully");
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
