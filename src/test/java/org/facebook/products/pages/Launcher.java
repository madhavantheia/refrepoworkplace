package org.facebook.products.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Launcher extends PageObject {

    @FindBy(linkText = "Log In")
    private WebElement loginbutton;

    public Launcher(WebDriver driver) {
        super(driver);
    }

    public void poplogin() {
        System.out.println("Using POM; pages.Launcher.java.poplogin.loginbutton.click");
        loginbutton.click();
    }
}
