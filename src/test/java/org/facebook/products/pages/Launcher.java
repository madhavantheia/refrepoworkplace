package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Launcher extends PageObject {

    /**
     * Attribute value for linkText should be constant
     * so we can't pass a element property from feature file
     * or from step definition class for validation or other purposes
     *
     * private WebElement LoginButton
     * shows up warning "private variable isn't assigned"
     * so removed the modified private
     * and error cleared
     *
     * use this.loginButton in-case of ambiguity
     */

    @FindBy(linkText = "Log In")
    WebElement loginButton;

    public Launcher(WebDriver driver) {
        super(driver);
    }

    /**
     * Illustration of static import
     * visibilityOf doesn't mention the class ExpectedConditions
     */

    public void checkForLoginButton() {
        Hooks.wait.until(visibilityOf(loginButton));
        Assert.assertTrue((loginButton.isDisplayed()), "\"Log In\" button is not available");
        System.out.println("\nLog In link is available\n");
        System.out.println("\nUsing POM; pages.Launcher.checkLoginButton\n");
    }

    public void popLogin() {
        loginButton.click();
        System.out.println("\nUsing POM; pages.Launcher.popLogin\n");
    }
}
