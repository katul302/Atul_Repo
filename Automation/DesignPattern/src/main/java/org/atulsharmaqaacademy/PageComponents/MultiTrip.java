package org.atulsharmaqaacademy.PageComponents;

import org.atulsharmaqaacademy.AbstractComponents.AbstractComponent;
import org.atulsharmaqaacademy.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {
    private By rou_ad = By.id("ctl00_mainContent_rbtnl_Trip_2");
    //private model_pop = By.id("//div[@id='MultiCityModelPopup']");
    private By model = By.id("MultiCityModelAlert");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By chk = By.id("ctl00_mainContent_chk_IndArm");

    private  By search = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(String origin, String destination) throws InterruptedException {
        System.out.println("I am inside Multi Trip");

        findElement(rou_ad).click();
        findElement(model).click();
        Thread.sleep(3000);
        selectOriginCity(origin);
        destinationCity(destination);

        findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
        findElement(By.xpath("(//a[@value='BLR'])[2]")).click();

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
//    public void selectOriginCity2(String origin )
//    {
//        findElement(from).click();
//        findElement(By.xpath("//a[@value='BLR']")).click();
//    }
}
