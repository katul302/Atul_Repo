package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import resources.BaseTest;
import io.cucumber.java.en.Then;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation_practice.ca.LandingPage;
import automation_practice.ca.RegPage;

import io.cucumber.java.en.And;

@RunWith(Cucumber.class)
public class stepDefinations extends BaseTest {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public WebDriver driver;
	public LandingPage lp;
	public RegPage rp;
	public String logo;

	@Given("^User launch the URL$")
	public void user_launch_the_url() throws Throwable {
		log.info("Launching url in browser");
		driver = getDriver();

	}

	@When("^User is on landing page$")
	public void user_is_on_landing_oage() throws Throwable {
		log.info("User land on landing page");
		lp = new LandingPage(driver);
		if (lp.lpVerification().isDisplayed()) {
			log.info("Test Step pass");
		} else {
			log.info("Test Step fail");
		}

	}

	@Then("^Get the logo$")
	public void get_the_logo() throws Throwable {
		log.info("steps to capture logo of landing page");
		lp = new LandingPage(driver);
		logo = lp.lpVerification().getAttribute("alt");
		log.info("Logo captured successfully:" + logo);
	}

	@And("^Verify logo title$")
	public void verify_logo_title() throws Throwable {
		log.info("Verifying logo");
		Assert.assertEquals(logo, "My Store");
		log.info("Logo verified");

	}

	@When("^User click on sign link$")
	public void user_click_on_sign_link() throws Throwable {
		log.info("clicking on sign in page");
		lp = new LandingPage(driver);
		lp.signin().click();
		log.info("sign in link verification completed");
	}

	@Then("^User should land on AUTHENTICATION screen$")
	public void user_should_land_on_authentication_screen() throws Throwable {

		log.info("Verification of auth page");
		rp = new RegPage(driver);
		String title = rp.RegPageVerification().getText();
		log.info("Heading of signup page is :" + title);
		Assert.assertEquals(title, "AUTHENTICATION");
		log.info("Sign in Link is working fine");
	}

	@Then("^Get link count on the landing page$")
	public void get_link_count_on_the_landing_page() throws Throwable {
		log.info("Get link count test case started");
		lp = new LandingPage(driver);
		int a = lp.linkcount().size();
		log.info("total count of link on landing page:" + a);
		Assert.assertEquals(a, 149);
		log.info("Get Link count test case executed");
	}

}