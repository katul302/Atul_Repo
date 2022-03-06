package com.thvp.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thvp.base.TestBase;
import com.thvp.pages.LandingPage;
import com.thvp.pages.LoginPage;



public class Login extends TestBase{
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	public LandingPage lp;
	public LoginPage lp1;
	
	
	
	@Parameters({"Email","Password"})
	
	@Test(enabled=false)
	public void loginTest(String Email,String Password)  throws Exception {
		lp = new  LandingPage(driver);
		lp.login().click();

		log.info("Get title of the page to verify user land on login page");
		
		String login_title =	driver.getTitle();
	
		String expected_title = "Login | TELUS PharmaConnect™ for Patients";
		
		Assert.assertEquals(expected_title, login_title);

		log.info("Code to verify title of login page completed");
		
		log.info("Steps to login started");
		lp1 = new  LoginPage(driver);
		lp1.login_email().sendKeys(Email);
		lp1.password().sendKeys(Password);
		lp1.login_btn().click();
		log.info("Login successfully");
	}

}
