package stepDefinations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
public class stepDefination {
	
	

	
	@Given("^Validate the Browser$")
    public void validate_the_browser() throws Throwable {
        System.out.println("Validate the Browser");
    }

    @When("^Browser is triggred$")
    public void browser_is_triggred() throws Throwable {
        System.out.println("Browser is triggred");
    }

    @Then("^Check if Browser is started$")
    public void check_if_browser_is_started() throws Throwable {
        System.out.println("Browser is started");
    }

	
	@Given("^User is on NetBanking landing page$")
	public void landing()
	{
		System.out.println("Landing Page");
	}
	
	@When("^User login with username and password$")
	public void login()
	{
		System.out.println("Login");
	}
	@Then("^Home page is populated$")
	public void home()
	{
		System.out.println("Home Page");
	}
	@And("^Cards are displayed$")
	public void cards()
	{
		System.out.println("Cards are displayed");
	}
	@When("^User login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_login_with_something_and_something(String strArg1, String strArg2) throws Throwable {
		System.out.println(strArg1);
		System.out.println(strArg2);
        
    }
	
	@And("^Cards displayed are \"([^\"]*)\"$")
    public void cards_displayed_are_something(String strArg1) throws Throwable {
        System.out.println(strArg1);
    }
	
	@When("^User sign up with following details$")
    public void user_sign_up_with_following_details(DataTable data) throws Throwable {
		
		List<List<String>> obj = data.asLists();
		// Below line will fetch the value of first row and first column i;e jenny
		System.out.println(obj.get(0).get(0));
		
		// Below line will fetch the value of first row and 2 column from fetaure file
		System.out.println(obj.get(0).get(1));
		
		System.out.println(obj.get(1).get(0));
        
    }
	
	@When("^User log with (.+) and (.+)$")
    public void user_login_with_and(String username, String password) throws Throwable {
        System.out.println(username);
        System.out.println(password);
    }


}

