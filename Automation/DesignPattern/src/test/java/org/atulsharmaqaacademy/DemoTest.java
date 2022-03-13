package org.atulsharmaqaacademy;


import org.atulsharmaqaacademy.PageComponents.MultiTrip;
import org.atulsharmaqaacademy.PageComponents.RoundTrip;
import org.atulsharmaqaacademy.PageObjects.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {



    @Test
    public  void  flightTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        TravelHomePage obj = new TravelHomePage(driver);

        obj.launchURL();
        System.out.println(obj.getFooterNavigation().getFlightAttribute());
        System.out.println(obj.getNavigationBar().getFlightAttribute());
        System.out.println(obj.getFooterNavigation().getLinkCount());

        System.out.println(obj.getNavigationBar().getLinkCount());


      //  obj.setBookingStrategy(new MultiTrip(driver,sectionElement));
       // obj.setBookingStrategy(new RoundTrip(driver,sectionElement));

        obj.setBookingStrategy("multitrip");

        obj.checkAvail("MAA","HYD");
    }
}
