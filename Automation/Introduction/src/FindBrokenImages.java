import java.util.List;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenImages {
	
	public static int invalidImageCount;

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://the-internet.herokuapp.com/broken_images";
		
		invalidImageCount = 0;
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		System.out.println("Total no. of images are " + imagesList.size());
		for (WebElement imgElement : imagesList) {
			if (imgElement != null) {
				verifyimageActive(imgElement);
			}
		}
		System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		
		
		
	}

	private static void verifyimageActive(WebElement imgElement) {
		// TODO Auto-generated method stub
		
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
