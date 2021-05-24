package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordSubmission extends PageObject{

    @FindBy(name = "pass")
    WebElement passwordField;

    @FindBy(xpath = "//button[@value='1']")
    WebElement pwdContinueButton;

    public PasswordSubmission(WebDriver driver) {
        super(driver);
    }

    public void submitPassword(String pwd) {
        Hooks.wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(pwd);
        pwdContinueButton.click();
        System.out.println("\nUsing POM; pages.PasswordSubmission.submitPassword\n");
    }

}
