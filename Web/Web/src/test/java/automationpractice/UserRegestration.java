package automationpractice;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.RegPage;
import resources.BaseTest;

public class UserRegestration extends BaseTest {
	
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
	
	@Test(enabled=false)
	public void verifyElemntsOnRegPageTest() {
		
		lp = new LandingPage(driver);
		lp.signin().click();
		log.info("Web Element verifiaction started");
		
		rp = new RegPage(driver);
		rp.emailId().isDisplayed();
		rp.acc_cre_btn().isDisplayed();
		rp.email_signin().isDisplayed();
		rp.pass_signin().isDisplayed();
		rp.pass_reg().isDisplayed();
		rp.btn_sing().isDisplayed();
		
		log.info("Web Element Verification completed");
		
	}
	
	@Parameters({"Email", "First","Last","Password","Fname","Lname","Company","address1","address2","city","Mobile","alias"})
	@Test(enabled=false)
	public void createAccountTest(String Email,String First, String Last, String Passowrd, String Fname,
			String Lname,String Company,String address1, String address2,String city,String Mobile,String alias	) {
		
		log.info("User regesatrion started");
		lp = new LandingPage(driver);
		lp.signin().click();
		rp = new RegPage(driver);
		rp.emailId().sendKeys(Email);
		rp.acc_cre_btn().click();
		rp.id_gender().click();
		rp.name_first().sendKeys(First);
		rp.name_last().sendKeys(Last);
		rp.pwd().sendKeys(Passowrd);
		
		 ss = rp.daydropdown();
		Select drop = new Select(ss);
		
		drop.selectByIndex(5);
		ss = rp.monthdropdown();
		Select drop1 = new Select(ss);
		drop1.selectByIndex(5);
		ss = rp.yeardropdown();
		Select drop3 = new Select(ss);
		drop3.selectByIndex(32);
		rp.namefirst().sendKeys(Fname);
		rp.lastname().sendKeys(Lname);
		rp.company().sendKeys(Company);
		rp.address1().sendKeys(address1);
		rp.address1().sendKeys(address2);
		rp.address1().sendKeys(city);
		ss =rp.state();
		Select drop4 = new Select(ss);
		drop4.selectByVisibleText("New York");
		rp.phone_mobile().sendKeys(Mobile);
		rp.address_alias().sendKeys(alias);
		
		log.info("Account created succrssfully");
		
		
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
