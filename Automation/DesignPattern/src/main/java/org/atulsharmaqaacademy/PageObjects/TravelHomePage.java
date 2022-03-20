package org.atulsharmaqaacademy.PageObjects;

import org.atulsharmaqaacademy.AbstractComponents.SearchFlightAvail;
import org.atulsharmaqaacademy.AbstractComponents.StrategyFactor;
import org.atulsharmaqaacademy.PageComponents.FooterNavigation;
import org.atulsharmaqaacademy.PageComponents.MultiTrip;
import org.atulsharmaqaacademy.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    WebDriver driver;
    By sectionElement = By.id("traveller-home");
    By headerNavSectionElement = By.id("buttons");

    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void launchURL(){

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }
    public NavigationBar getNavigationBar(){

        return new NavigationBar(driver,headerNavSectionElement);
    }

    public FooterNavigation getFooterNavigation()
    {

        return new FooterNavigation(driver,sectionElement);
    }

    public void setBookingStrategy(String strategyType){

        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail = strategyFactor.createStrategy(strategyType);
        this.searchFlightAvail = searchFlightAvail;

    }

    public void checkAvail(HashMap<String,String> reservationsdetails) throws InterruptedException {



        searchFlightAvail.checkAvail(reservationsdetails);
    }
}
