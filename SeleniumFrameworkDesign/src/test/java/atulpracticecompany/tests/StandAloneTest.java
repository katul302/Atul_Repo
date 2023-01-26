package atulpracticecompany.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atulpracticecompany.pageobjects.LandingPage;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		String productName = "ZARA COAT 3";
		String expMessage = "THANKYOU FOR THE ORDER.";
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/client");
		
		LandingPage lp = new LandingPage(driver);

		// System.out.println(driver.findElement(By.id("userEmail")).getAttribute("class"));
		driver.findElement(By.id("userEmail")).sendKeys("katul302@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Welcome@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// List<WebElement> productList =
		// driver.findElements(By.xpath("//div[@class='container']/div[2]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = productList.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);

		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		WebElement cvv = driver.findElement(By.xpath("//div[text()  = 'CVV Code ']"));

//		driver.findElement(with(By.xpath("//*[@class  = 'input txt']")).below(cvv)).sendKeys("143");

		driver.findElement(By.xpath("//*[text() = 'CVV Code '] / following-sibling::input")).sendKeys("123");
		driver.findElement(with(By.xpath("//*[@class  = 'input txt']")).below(cvv)).sendKeys("Atul");
		driver.findElement(By.name("coupon")).sendKeys("rahulshettyacademy");
Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text() = 'Apply Coupon']")).click();
		// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		Thread.sleep(2000);
		String couponMessage = driver.findElement(By.cssSelector(".mt-1.ng-star-inserted")).getText();
		System.out.println("Coupon applies successfully: " + couponMessage);

		 driver.findElement(By.cssSelector(".user__address div input")).sendKeys("Ind");

//		Actions act = new Actions(driver);
//
//		act.sendKeys(driver.findElement(By.cssSelector(".user__address div input")), "India");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));

		// (//button[contains(@class,'ta-item')])[2] --xpath
		// //*[@class='ta-results list-group ng-star-inserted']/button[2] --xpath

		// .ta-item:first-child,.ta-item:last-child,.ta-item:nth-child,
		// .ta-item:nth-last-child, :first-of-type, :last-of-type, :nth-of-type
		// .ta-item:nth-of-type(2)

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

		driver.findElement(By.cssSelector(".action__submit")).click();

		String AppMessage = driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).getText();

		Assert.assertTrue(AppMessage.equalsIgnoreCase(expMessage));

		// Assert.assertEquals(AppMessage, expMessage);
		driver.quit();

	}

}
