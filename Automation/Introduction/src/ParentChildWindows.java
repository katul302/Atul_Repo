import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChildWindows {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");

		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://demoqa.com/browser-windows";
		driver.get(baseUrl);

		// Open new child window within the main window
		driver.findElement(By.cssSelector("#windowButton")).click();
		// Get handles of the windows
//It stores parent window value in a unique identifier of string type.
		String mainWindowHandle = driver.getWindowHandle();
		
		//All child windows are stored in a set of strings.
		Set<String> allWindowsHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowsHandles.iterator();
		// Here we will check if parent window has other child windows and will fetch the heading of the child window

		
		while(iterator.hasNext()) {
			String ChildWindow = iterator.next();
			
			//Now check them by comparing the main window with the child windows.
			if(!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				
				//Switch to the child window and read the heading.
				driver.switchTo().window(ChildWindow);
				
				//Find the element and store in a web element through which we will
				//get the text of heading using gettext() method.
				WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }
			}
			
		}

	}

