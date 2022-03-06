package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class TitleVerification extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	public LandingPage lp;

	@BeforeTest

	public void intialize() throws IOException {
		driver = inintializeDriver();
		log.info("Driver is intialized");
		// driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}

	@Test
	public void basePageNavigation() throws IOException {

		lp = new LandingPage(driver);

		// compare the text from the browser with actual text error
		//System.out.println(lp.getTitle().getText());

		String actual = lp.getTitle().getText();
		Assert.assertEquals(actual, "FEATURED COURSES");
		log.info("Sucessfully validated Text Message");

	}
	
	@Test
	
	public void headerVerification()
	{
		log.info("Header Verifiaction Test started");
		
		String actual = lp.getHeader().getText();
		Assert.assertEquals(actual, "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated header");
		
	}

	@AfterTest

	public void tearDown() {
		driver.close();
	}

}
