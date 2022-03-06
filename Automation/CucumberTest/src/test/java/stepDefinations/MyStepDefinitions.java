package stepDefinations;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cucumberpoint.CucumberTest.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObject.Checkout;
import pageObject.HomePage;
import pageObject.OrderConfirmation;

@RunWith(Cucumber.class)
public class MyStepDefinitions {
	public WebDriver driver;
	HomePage h;
	Checkout c;
	
	OrderConfirmation oc;

	@Given("^User is on GreenCart landing page$")
	public void user_is_on_greencart_landing_page() throws Throwable {
		driver = Base.getDriver();
		
		
		

	}

	@When("User search for {string} Vegetable")
	public void user_search_for_vegetable(String string) throws InterruptedException {

		h = new HomePage(driver);
		h.getSearch().sendKeys(string);
		Thread.sleep(3000);
	}

	@When("^User click on add to cart$")
	public void user_click_on_add_to_cart() throws Throwable {
		int j = 0;
		String[] items = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] veg = products.get(i).getText().split("-");
			String formattedname = veg[0].trim();
			// check whether name you extracted is present in array or not
			// convert array into arraylist for east search

			List itemsneededlist = Arrays.asList(items);
			if (itemsneededlist.contains(formattedname))

			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == items.length) {
					break;
				}

			}

		}

	}

	@Then("^\"([^\"]*)\" result are displayed$")
	public void something_result_are_displayed(String strArg1) throws Throwable {

		h = new HomePage(driver);
		Assert.assertTrue(h.result().getText().contains(strArg1));

	}

	@Then("^Verify selected \"([^\"]*)\" items are displayed in checkout page$")
	public void verify_selected_something_items_are_displayed_in_checkout_page(String strArg1) throws Throwable {

		h = new HomePage(driver);
		Assert.assertTrue(h.checkout_page().getText().contains(strArg1));
	}

	@And("^Added item to Cart$")
	public void added_item_to_cart() throws Throwable {

		h = new HomePage(driver);
		h.cart().click();
		h.action().click();

	}

	@And("^User proceed to Checkout page$")
	public void user_proceed_to_checkout_page() throws Throwable {

		h = new HomePage(driver);
		h.proceed().click();
		h.button().click();

	}

	@Then("^User should apply the promo code$")
	public void user_should_apply_the_promo_code() throws Throwable {
		c = new Checkout(driver);

		Thread.sleep(5000);
		c.promo().sendKeys("test");
		c.apply().click();
	}

	@And("^Place the order$")
	public void place_the_order() throws Throwable {

		c = new Checkout(driver);
		c.order().click();

	}

	@And("^User should choose the county$")
	public void user_should_choose_the_county() throws Throwable {
		Select dd = new Select(driver.findElement(By.xpath("//div[@style='width: 360px; margin: 10px auto;']/select")));
		dd.selectByVisibleText("Afghanistan");

	}

	@And("^Select the radio button$")
	public void select_the_radio_button() throws Throwable {
		oc = new OrderConfirmation(driver);
		oc.confirm().click();
	}

	@And("^User should be able Proceed$")
	public void user_should_be_able_proceed() throws Throwable {

		oc = new OrderConfirmation(driver);
		oc.btk().click();
	}

	@When("^User search for (.+) Vegetables$")
	public void user_search_for_vegetables(String veggie) throws Throwable {

		h = new HomePage(driver);
		h.getSearch().sendKeys(veggie);
		Thread.sleep(3000);
	}

}