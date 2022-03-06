package Academy;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.Register;
import resources.Base;

public class Registration extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	public LandingPage lp;

//	@BeforeTest
//
//	public void intialize() throws IOException {
//		driver = inintializeDriver();
//		// driver.get("http://qaclickacademy.com");
//		driver.get(prop.getProperty("url"));
//	}
	@BeforeMethod
	public void intialize() throws IOException {
		driver = inintializeDriver();
		// driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void regPageNavigation() throws IOException {

		lp = new LandingPage(driver);

		 lp.regsitraton();
		 log.info("Success");

	}

	@Test

	public void linkVerification() throws MalformedURLException, IOException {

		lp = new LandingPage(driver);

		Register r = lp.regsitraton();
		int a = r.linkcount().size();
		List<WebElement> links = r.getAllLinks();

		for (WebElement link : links) {
			log.info(link.getText() + " - " + link.getAttribute("href"));
		}

		log.info("Count of Link on Regestration page is: " + a);

		List<WebElement> brkLinks = r.brokenLink();
		for (WebElement link : brkLinks) {
			SoftAssert a1 = new SoftAssert();
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int res = conn.getResponseCode();
			log.info("Url response from regestration page: " + res);
			a1.assertTrue(res < 400, "The link with text" + link.getText() + "is broken with code" + res);
		}

	}

	@Test(dataProvider = "getData")

	public void reg(String name, String email, String pass) throws InterruptedException {
		lp = new LandingPage(driver);

		// lp.regsitraton().click();
		log.info("Regsitration page  is displayed");
		// Register rg = new Register(driver);
		Register rg = lp.regsitraton();
		rg.name().sendKeys(name);
		rg.email().sendKeys(email);
		rg.password().sendKeys(pass);
		rg.terms().click();
		rg.signUp();
		log.info("Regsitration is done");

		log.info("Login step started");
		//rg.login().click();

		//LoginPage l = new LoginPage(driver);
		
		LoginPage l = rg.login();
		l.signin().sendKeys(email);
		l.password().sendKeys(pass);
		l.name().click();

		
		log.info("Login step ended");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@DataProvider

	public Object[][] getData() {
		// Row stand for how many different data types test should run
		// Column stands for how many value for each test
		Object[][] data = new Object[1][3];

		// 0th row
		data[0][0] = "Atul";
		data[0][1] = "katul302@gmail.com";
		data[0][2] = "Password@123";

		return data;

	}

//	@AfterTest
//
//	public void tearDown() {
//		driver.close();
//	}
}
