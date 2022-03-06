package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest

	public void intialize() throws IOException {
		driver = inintializeDriver();
		// driver.get("http://qaclickacademy.com");

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {

		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		//lp.getLogin().click();
		LoginPage l=lp.getLogin();

		//LoginPage l = new LoginPage(driver);
		
		
		l.getEmail().sendKeys(username);
		l.getPass().sendKeys(password);

		l.login().click();
		log.info(text);
	ForgotPassword fp	= l.forgotpass();
	fp.email().sendKeys("katul302@gmail.com");
	fp.sendIns().click();
	
	
	}
	
	

	@DataProvider

	public Object[][] getData() {
		// Row stand for how many different data types test should run
		// Column stands for how many value for each test
		Object[][] data = new Object[2][3];

		// 0th row
		data[0][0] = "nonrestricted@gmail.com";
		data[0][1] = "1234567";
		data[0][2] = "Restricted user";

		// 1st row
		data[1][0] = "restricted@gmail.com";
		data[1][1] = "67855";
		data[1][2] = "non resticted user";

		return data;

	}

	@AfterTest

	public void tearDown() {
		driver.close();
	}

}
