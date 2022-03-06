import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class childWindowsSameTab {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://demoqa.com/browser-windows";
		driver.get(baseUrl);

		// Open new child window within the main window
		driver.findElement(By.xpath("//div[@id='tabButtonWrapper']/button")).click();

		String mainWindow = driver.getWindowHandle();
		System.out.println("Tha main windows is " + mainWindow);

		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Child windows handle is " + s1);
		Iterator<String> it = s1.iterator();

		while (it.hasNext()) {
			String childWindows = it.next();
			if (!mainWindow.equalsIgnoreCase(childWindows)) {
				driver.switchTo().window(childWindows);

				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println("Heading of child window is " + text.getText());
				driver.close();
				System.out.println("Child window closed");
			}

		//  Switch back to the main window which is the parent window.
	        driver.switchTo().window(mainWindow);
	        
	      String header =  driver.findElement(By.xpath("//div[@class='main-header']")).getText();
	    		  
	    		  System.out.println("Header of the page " + header);
			

		}
	}

}
