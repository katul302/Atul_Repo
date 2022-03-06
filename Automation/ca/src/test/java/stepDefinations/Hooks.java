package stepDefinations;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import resources.BaseTest;

public class Hooks extends BaseTest{
	
	@Before("@FunctionalTest")
	
	public void before()
	{
		System.out.println("Landing Page verifiaction started");
	}
		
	
	@After("@FunctionalTest")
	
	public void AfterSeleniumTest()
	{
		driver.close();
	}
		
	
	}

