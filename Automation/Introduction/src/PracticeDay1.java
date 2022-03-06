import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeDay1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\resources\\chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win321\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.naukri.com/";
		driver.get(baseUrl);

		//driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/i")).click();
		
		driver.findElement(By.id("cta")).click();

		/*
		 * String mainWinHandle = driver.getWindowHandle(); // Get your main window
		 * String subWinHandle = null;
		 * 
		 * Set<String> allHandle = driver.getWindowHandles(); // Fetch all handles
		 * Iterator<String> iterator = allHandle.iterator(); while (iterator.hasNext()){
		 * subWindowHandler = iterator.next(); }
		 * driver.switchTo().window(subWindowHandler); // switch to popup
		 * 
		 * //Write code to close Ad or skip
		 * 
		 * driver.switchTo().window(parentWindowHandler);
		 */

		String currentwindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> i = allWindows.iterator();
		while (i.hasNext()) {
			String childwindow = i.next();
			if (!childwindow.equalsIgnoreCase(currentwindow)) {
				driver.switchTo().window(childwindow);
				System.out.println("The child window is " + childwindow);
			} else {
				System.out.println("There are no children");
			}
		}
		// driver.quit();

	}

}
