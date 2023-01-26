package atulpracticecompany.tests;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import atulpracticecompany.TestComponents.BaseTest;
import atulpracticecompany.TestComponents.Retry;
import atulpracticecompany.pageobjects.CheckOut;
import atulpracticecompany.pageobjects.ConfirmationPage;
import atulpracticecompany.pageobjects.LandingPage;
import atulpracticecompany.pageobjects.MyCart;
import atulpracticecompany.pageobjects.ProductCatalog;

public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer =Retry.class)

	public void loginErrorValidation() throws IOException, InterruptedException {

		String email = "katul3032@gmail.com";
		String password = "Welcome@123545";

		// LandingPage lp = launcApplication();

		lp.loginApplicationMethod(email, password);
		Assert.assertEquals("Incorrect  or password.", lp.getLoginErrorMessage());

	}
	@Test

	public void productErrorValidation() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		String email = "katul302@gmail.com";
		String password = "Welcome@123";
		

		// LandingPage lp = launcApplication();

		ProductCatalog pc = lp.loginApplicationMethod(email, password);

		List<WebElement> productList = pc.getProductList();

		pc.addProductToCart(productName);
		MyCart mc = pc.goToCartPage();

		Boolean match = mc.confrimProductInCart("ZARA");

		Assert.assertFalse(match);
		

	}

}
