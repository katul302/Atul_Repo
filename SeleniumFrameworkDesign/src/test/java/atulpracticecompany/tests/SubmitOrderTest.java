package atulpracticecompany.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atulpracticecompany.TestComponents.BaseTest;
import atulpracticecompany.pageobjects.CheckOut;
import atulpracticecompany.pageobjects.ConfirmationPage;
import atulpracticecompany.pageobjects.LandingPage;
import atulpracticecompany.pageobjects.MyCart;
import atulpracticecompany.pageobjects.OrderPage;
import atulpracticecompany.pageobjects.ProductCatalog;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	String expMessage = "THANKYOU FOR THE ORDER.";
	String email = "atulkumar.sharma38@gmail.com";
	String password = "1@34567bA";
	String cvv = "123";
	String Name = "Atul";
	String ccode = "rahulshettyacademy";

	@Test(dataProvider = "getData", groups = "purchase")

	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// LandingPage lp = launcApplication();

		ProductCatalog pc = lp.loginApplicationMethod(input.get("email"), input.get("password"));

		List<WebElement> productList = pc.getProductList();

		pc.addProductToCart(input.get("productName"));
		MyCart mc = pc.goToCartPage();

		Boolean match = mc.confrimProductInCart(input.get("productName"));

		Assert.assertTrue(match);
		CheckOut ck = mc.checkOut();

		ck.fill_personalInfo(cvv, Name);
		String couponMessage = ck.applyCode(ccode);

		System.out.println("Coupon applies successfully: " + couponMessage);

		ck.selectCountry("Ind");
		ConfirmationPage cp = ck.placeOrder();

		String confirmation = cp.getConfirmationMessage();

		Assert.assertTrue(confirmation.equalsIgnoreCase(expMessage));

	}

	@Test(dependsOnMethods = { "submitOrder" })

	public void orderHistory() {
		ProductCatalog pc = lp.loginApplicationMethod(email, password);
		OrderPage op = pc.goToMyOrderPage();
		Assert.assertTrue(op.verifyOrderDisplay(productName));
	}

	@DataProvider
	public Object[][] getData() throws IOException {


		
	List<HashMap<String,String>> data = 	getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\atulpracticecomapny\\data\\purchaseorder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

//	@DataProvider
//
//	public Object[][] getData() {
//		return new Object[][] { { "atulkumar.sharma38@gmail.com", "1@34567bA", "ZARA COAT 3" },
//				{ "katul302@gmail.com", "Welcome@123", "Adidai" } };
//	}
//	HashMap<String, String> map = new HashMap<String, String>();
//	map.put("email", "atulkumar.sharma38@gmail.com");
//	map.put("password", "1@34567bA");
//	map.put("productName", "ZARA COAT 3");
//
//	HashMap<String, String> map1 = new HashMap<String, String>();
//	map1.put("email", "katul302@gmail.com");
//	map1.put("password", "Welcome@123");
//	map1.put("productName", "ADIDAS ORIGINAL");
//	return new Object[][] { { map }, { map1 } };

}
