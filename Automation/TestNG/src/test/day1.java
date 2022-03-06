package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {
	
	@Parameters({"URL","KEY"})
	
	@Test()
	public void demo(String url, String key)
	{
		System.out.println("hello");
		System.out.println(url);
		System.out.println(key);
	}
	

	@Test(groups= {"Smoke"})
	public void Secondtest()
	{
		System.out.println("Bye");
	}
	
	@BeforeMethod
	
	public void bemethod()
	{
		System.out.println("i will execute before every method");
	}
	
	@AfterMethod
	
	public void afmethod()
	{
		System.out.println("I will execute after every method");
	}
	
	@AfterTest
	public void lastexe()
	{
		System.out.println("I will execute last");
	}
	
	@AfterSuite
	
	public void asuite()
	{
		System.out.println("I will after suite");
	}
	
	@BeforeClass
	public void befclass()
	{
		System.out.println("Before class day1");
	}
	@AfterClass
	
	public void afclass()
	{
		System.out.println("After class day1");
	}
	
	
}
