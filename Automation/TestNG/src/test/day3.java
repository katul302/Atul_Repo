package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day3 {

	@BeforeTest
	public void cookies()
	{
		System.out.println("Cookied clear");
	}
	@Test
	
	public void weblogin()
	{
		System.out.println("Weblogincar");
	}
	@Test(groups= {"Smoke"})
	public void mobileLogin()
	{
		System.out.println("MobileLogincar");
	}
	@Test(enabled=false)
	public void mobilesignin()
	{
		System.out.println("Mobilesignin");
	}
	@Test(timeOut=4000)
	public void mobilesingout()
	{
		System.out.println("Mobilesignout");
	}
	@Test(dataProvider="getData")
	public void apiLogin(String username, String password)
	{
		System.out.println("Api logincar");
		System.out.println(username);
		System.out.println(password);
	}
	
	@AfterTest
	public void browserclose()
	{
		System.out.println("Browser close");
	}
	@BeforeSuite
	
	public void bsuite()
	{
		System.out.println("I will run before suite");
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		// 1st Combination -- user pwd -- good credit history
		// 2nd Combination -- user pwd -- no credit history
		// 3rd combination -- user pwd -- fraudelent credit history
		Object [][] data = new Object[3][2];
		
		// 1st set
		data[0][0] = "Firstsetusername";
		data[0][1] = "password";
		
		//	column in the row are nothing but values  for that particular combination
		
		// 2nd set
		
		data[1][0] = "secondusername";
		data[1][1] = "pwd";
		
		// 3rd set
		
		data[2][0] = "thirdusername";
		data[2][1] ="pwd";
		return data;
		
		
		
	}
	
	
}
