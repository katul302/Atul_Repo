import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class newTabOpen {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://www.google.com";

		// String baseUrl = "https://www.amazon.in/";
		driver.get(baseUrl);

		// System.out.println("Page title is: " + driver.getTitle());

		String parent_window = driver.getWindowHandle();

		System.out.println("Parent window hanlde is: " + parent_window);
		System.out.println("Page title is: " + driver.getTitle());

		((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com/');");

		((JavascriptExecutor) driver).executeScript("window.open('https://www.amazon.in/')");

		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(3));

		Set<String> all_win_handles = driver.getWindowHandles();
		System.out.println("Total number of windows: " + all_win_handles.size());
		for (String hand1 : all_win_handles) {
			if (!parent_window.equalsIgnoreCase(hand1)) {

				driver.switchTo().window(hand1);
				// new
				// WebDriverWait(driver,10).until(ExpectedConditions.titleContains("Amazon"));
				String first_child_window = driver.getWindowHandle();
				System.out.println("First Child Window Handle is: " + first_child_window);
				System.out.println("First Child Window Page Title is: " + driver.getTitle());
				driver.close();

			}

		}

	}

}
