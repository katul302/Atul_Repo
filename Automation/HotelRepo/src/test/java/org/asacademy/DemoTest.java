package org.asacademy;


import org.atulsharmaqaacademy.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest {

    WebDriver driver;
    TravelHomePage obj;

    @BeforeTest

    public void setup()
    {
        driver=   initializeDriver();

         obj = new TravelHomePage(driver);
    }
@AfterTest

public void teardown(){
        driver.quit();
}

    @Test(dataProvider = "getData")
    public  void  flightTest(HashMap<String,String> reservationsdetails) throws InterruptedException {



        obj.launchURL();
        System.out.println(obj.getFooterNavigation().getFlightAttribute());
        System.out.println(obj.getNavigationBar().getFlightAttribute());
        System.out.println(obj.getFooterNavigation().getLinkCount());

        System.out.println(obj.getNavigationBar().getLinkCount());


      //  obj.setBookingStrategy(new MultiTrip(driver,sectionElement));
       // obj.setBookingStrategy(new RoundTrip(driver,sectionElement));

        //obj.setBookingStrategy("roundtrip");
        obj.setBookingStrategy("multitrip");




       

        obj.checkAvail(reservationsdetails);
    }

    @DataProvider
    public Object[] [] getData() throws IOException {

//        //D:\\TestData\\TestData.json
//        HashMap<String,String > reservationsdetails = new <String,String>HashMap();
//        reservationsdetails.put("origin","MAA");
//        reservationsdetails.put("origin2","HYD");
//        reservationsdetails.put("destination","HYD");
//        reservationsdetails.put("destination2","DEL");
//        HashMap<String,String > reservationsdetails1 = new <String,String>HashMap();
//        reservationsdetails1.put("origin","DEL");
//        reservationsdetails1.put("origin2","HYD");
//        reservationsdetails1.put("destination","MAA");
//        reservationsdetails1.put("destination2","ATQ");
//
//        List<HashMap<String,String>> l = new ArrayList<>();
//        l.add(reservationsdetails);
//        l.add(reservationsdetails1);

        System.out.println(("user.dir") + "src/test/java/DataLoad/TestData.json");
        List<HashMap<String, String>> l =  getJsonData(System.getProperty("user.dir")+"//src//test//java//DataLoad//TestData.json");
        return  new Object[][]
                {
                        {l.get(0)},
                        {l.get(1)}
                };
    }
}
