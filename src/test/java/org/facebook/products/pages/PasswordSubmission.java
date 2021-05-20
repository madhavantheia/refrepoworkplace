package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordSubmission extends PageObject{

    @FindBy(name = "pass")
    WebElement passwordField;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div[3]/form/div[5]/button")
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
