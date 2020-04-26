package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends PageObject {

    @FindBy(name = "pass")
    WebElement passwordField;

    @FindBy(id = "u_0_9")
    WebElement submitButton;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void submitPassword(String pwd) {
        Hooks.wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(pwd);
        submitButton.click();
        System.out.println("\nUsing POM; pages.Login.submitPassword\n");
    }
}
