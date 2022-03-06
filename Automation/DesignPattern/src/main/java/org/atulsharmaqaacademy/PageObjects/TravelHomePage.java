package org.atulsharmaqaacademy.PageObjects;

import org.atulsharmaqaacademy.PageComponents.FooterNavigation;
import org.atulsharmaqaacademy.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {
    WebDriver driver;
    By sectionElement = By.id("traveller-home");
    By headerNavSectionElement = By.id("buttons");

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
}
