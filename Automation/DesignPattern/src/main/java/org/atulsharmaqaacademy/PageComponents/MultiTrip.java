package org.atulsharmaqaacademy.PageComponents;

import org.atulsharmaqaacademy.AbstractComponents.AbstractComponent;
import org.atulsharmaqaacademy.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {
    private By rou_ad = By.id("ctl00_mainContent_rbtnl_Trip_2");
    //private model_pop = By.id("//div[@id='MultiCityModelPopup']");
    private By model = By.id("MultiCityModelAlert");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By chk = By.id("ctl00_mainContent_chk_IndArm");
    private By to2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
    private  By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");

    private  By search = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationsdetails) throws InterruptedException {




        makeStateReady(s->selectOriginCity(reservationsdetails.get("origin")));

        destinationCity(reservationsdetails.get("destination"));

        selectOriginCity2(reservationsdetails.get("origin2"));
        destinationCity2(reservationsdetails.get("destination2"));


        findElement(chk).click();
        findElement(search).click();
    }

    public void selectOriginCity(String origin )
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void destinationCity(String destination )
    {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
    public void selectOriginCity2(String origin2 )
    {

        System.out.println("Select origin city as:" + origin2);

        findElement(from2).click();
        findElement(By.xpath("(//a[@value='"+origin2+"'])[3]")).click();
    }
    public void destinationCity2(String destination2 ) throws InterruptedException {
        System.out.println("select destination2 as :" + destination2);
        findElement(to2).click();

        findElement(By.xpath("(//a[@value='"+destination2+"'])[4]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer) throws InterruptedException {
        // common prerequistes code
        //execute actual function
        // tear down method

        System.out.println("I am inside Multi Trip");

        findElement(rou_ad).click();
        findElement(model).click();
       // Thread.sleep(3000);

        waitForElementToDisappear(model);
        consumer.accept(this);

    }


}
