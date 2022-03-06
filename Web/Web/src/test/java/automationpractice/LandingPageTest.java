package automationpractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import pageObjects.RegPage;
import resources.BaseTest;

public class LandingPageTest extends BaseTest {

	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public WebDriver driver;
	public LandingPage lp;
	public RegPage rp;

	@BeforeMethod
	public void intialize() throws IOException {
		driver = inintializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is intialize from landingpage test case");
	}

	@Test(enabled = false)
	public void lp_Verify() throws IOException {

		lp = new LandingPage(driver);
		String logo = lp.lpVerification().getAttribute("alt");

		Assert.assertEquals(logo, "My Store");

		log.info("Landing page verrified");
	}

	@Test(enabled = false)
	public void signup() {

		lp = new LandingPage(driver);
		lp.signin().click();
		rp = new RegPage(driver);
		String title = rp.RegPageVerification().getText();
		log.info("Heading of signup page is :" + title);
		Assert.assertEquals(title, "AUTHENTICATION");
		log.info("Sign in Link is working fine");

	}

	@Test(enabled = false)

	public void linkCountVerificationTest() {

		log.info("Link Verfication test case started");
		lp = new LandingPage(driver);
		int a = lp.linkcount().size();

		log.info("total count of link on landing page:" + a);
		Assert.assertEquals(a, 149);

	}

	@Test(enabled = false)
	public void getTextOfLinks() {
		log.info("Text of all the links on landing page");

		lp = new LandingPage(driver);
		List<WebElement> links = lp.getAllLinks();

		for (WebElement link : links) {
			log.info("Text of all the link on landing page: " + link.getText() + " - " + link.getAttribute("href"));
			// System.out.println("Text of all the link on landing page: " + link.getText()
			// + " - " + link.getAttribute("href"));

		}

		log.info("Text of all the links printed successfully");
	}

	@Test

	public void footer_link() {
		log.info("footer link verification started");

		lp = new LandingPage(driver);
		log.info("test1");

		int s = lp.link_footer().size();
		log.info(s);
		log.info("test2");

		for (int i = 1; i < s; i++) {
			log.info("test3");
			String clickontab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			log.info("test4");
			lp.link_footer().get(i).sendKeys(clickontab);
			log.info("test5");
		}
		log.info("test6");
		Set<String> Windows = driver.getWindowHandles();
		log.info("test7");
		Iterator<String> it = Windows.iterator();
		log.info("test8");
		while (it.hasNext()) {
			log.info("test9");

			driver.switchTo().window(it.next());
			log.info("test10");
			log.info("Title of the link on footer: " + driver.getTitle());
			

		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
