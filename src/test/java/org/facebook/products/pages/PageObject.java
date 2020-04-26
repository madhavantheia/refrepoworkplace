package org.facebook.products.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        //@FindBy is assigning or defining the webElement, initElements instantiates the element
        PageFactory.initElements(driver, this);
        System.out.println("\nusing POM; pages.PageObject.constructor\n");
    }
}