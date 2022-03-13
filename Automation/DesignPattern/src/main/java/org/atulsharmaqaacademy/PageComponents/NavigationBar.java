package org.atulsharmaqaacademy.PageComponents;

import org.atulsharmaqaacademy.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {

    By flights=   By.cssSelector("[title='Flights']");
    By link= By.cssSelector("a");
    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public String getFlightAttribute()
    {

      return  findElement(flights).getAttribute("class");

    }

    public int getLinkCount(){

        return findElements(link).size();
    }

}
