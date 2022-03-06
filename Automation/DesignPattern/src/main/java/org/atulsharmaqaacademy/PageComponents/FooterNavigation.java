package org.atulsharmaqaacademy.PageComponents;

import org.atulsharmaqaacademy.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNavigation extends AbstractComponent {


    WebDriver driver;



       By flights=   By.cssSelector("[title='Flights']");
       By link= By.cssSelector("a");

    public FooterNavigation(WebDriver driver, By sectionElement) {
        super(driver,sectionElement); //When you inherit parent class you should invoke parent class constructor
        // in your child constructor


    }


    public String getFlightAttribute()
       {

          return findElement(flights).getAttribute("class");


       }


       public int getLinkCount(){
          return findElements(link).size();
       }



}
