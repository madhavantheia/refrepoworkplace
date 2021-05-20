package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DistinctiveLogin extends PageObject {

    /**
     * use this.continueButton in-case of ambiguity
     */

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/form[1]/div[2]/button")
    WebElement continueButton;

    public DistinctiveLogin(WebDriver driver) {
        super(driver);
    }

    /**
     * Illustration of static import
     * visibilityOf doesn't mention the class ExpectedConditions
     */

    public void verifyPageTitle(String pageTitle) {
        // Hooks.wait.until(visibilityOf(continueButton));
        String titlenow = driver.getTitle();
        System.out.println(titlenow);
        Assert.assertTrue(pageTitle.contains(titlenow));
        System.out.println("\nUsing POM; pages.DistinctiveLogin.verifyPageTitle\n");
    }

    public void submitUsername(String username) {
        Hooks.wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(username);
        continueButton.click();
        System.out.println("\nUsing POM; pages.DistinctiveLogin.submitUsername\n");
    }

}
