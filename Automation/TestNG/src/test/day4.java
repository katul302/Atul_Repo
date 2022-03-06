package test;

import org.testng.annotations.Test;

public class day4 {

	@Test(groups= {"Smoke"})
	
	public void webloginHomeLoan()
	{
		System.out.println("WebloginHome");
	}
	@Test(dependsOnMethods= {"webloginHomeLoan"})
	public void mobileLoginHomeLoan()
	{
		System.out.println("MobileLoginHome");
	}
	@Test(dependsOnMethods= {"webloginHomeLoan","mobileLoginHomeLoan"})
	public void apiLoginHomeLoan()
	{
		System.out.println("Api loginhomeloan");
	}
}
