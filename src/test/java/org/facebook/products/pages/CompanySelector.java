package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompanySelector extends PageObject {

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(xpath = "//button[@value='1']")
    private WebElement continueButton;

    public CompanySelector(WebDriver driver) {
        super(driver);
    }

    public void submitUsername(String username) {
        Hooks.wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(username);
        continueButton.click();
        System.out.println("\nUsing POM; pages.CompanySelector.submitUsername\n");
    }
}
