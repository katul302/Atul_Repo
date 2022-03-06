import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleChildWinows {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://demoqa.com/browser-windows";
		driver.get(baseUrl);

		// Open new child window within the main window
		driver.findElement(By.cssSelector("#windowButton")).click();
		// Open another child windows
		driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();

		String mainWindow = driver.getWindowHandle();
		System.out.println("Tha main windows is " + mainWindow);

		// To handle all the new opened windows

		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Child windows handle is " + s1);
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {

			String childWindows = i1.next();
			if (!mainWindow.equalsIgnoreCase(childWindows)) {
				driver.switchTo().window(childWindows);
				
				WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
				driver.close();
				System.out.println("Child window closed");

			}

		}
		
	//  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainWindow);
        driver.quit();
		
		 

	}

}
