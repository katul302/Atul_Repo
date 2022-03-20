package org.atulsharmaqaacademy.PageComponents;

import net.bytebuddy.asm.Advice;
import org.atulsharmaqaacademy.AbstractComponents.AbstractComponent;
import org.atulsharmaqaacademy.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {

    private By rad = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private  By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By to2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
    private By chk = By.id("ctl00_mainContent_chk_IndArm");

    private  By search = By.id("ctl00_mainContent_btn_FindFlights");


    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    @Override
    public void checkAvail(HashMap<String, String> reservationsdetails) {


        makeStateReady(s->selectOriginCity(reservationsdetails.get("origin")));
        destinationCity(reservationsdetails.get("destination"));
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

    public void makeStateReady(Consumer<RoundTrip> consumer){
        System.out.println("I am inside round Trip");

        findElement(rad).click();
        consumer.accept(this);
        System.out.println("i am done");
    }
}
