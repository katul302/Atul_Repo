package Academy;

import static org.testng.Assert.assertTrue;

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

public class navigationBarValidation extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest

	public void intialize() throws IOException {
		driver = inintializeDriver();
		// driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws IOException {

		LandingPage lp = new LandingPage(driver);

		boolean flag = lp.getnavigationBar().isDisplayed();
		assertTrue(flag);
		log.info("Navigation bar is displayed");
	}

	@AfterTest

	public void tearDown() {
		driver.close();
	}

}
