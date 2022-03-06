package stepDefinations;

import com.cucumberpoint.CucumberTest.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base{
	
	@Before("@MobileTest")
	
	public void before()
	{
		System.out.println("the beofre hooks");
	}
		
		
	@After("@MobileTest")
	
	public void after()
	{
		System.out.println("After hooks");
	}
	
	@After("@ParameterTest")
	
	public void AfterSeleniumTest()
	{
		driver.close();
	}
		
	
	}

