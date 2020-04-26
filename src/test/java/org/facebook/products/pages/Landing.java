package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Landing extends PageObject {

    @FindBy(xpath = "//*[@id=\"u_0_1\"]/div/div/div/div/div/div[2]/div[2]/div[2]/header/div/div/div[1]/div[2]/div/h1/span")
    private WebElement newsFeedLabel;

    public Landing(WebDriver driver) {
        super(driver);
    }

    public void validateNewsFeed() {
        String labelname = newsFeedLabel.getText();
        System.out.println(labelname);
        try {
            Assert.assertTrue(labelname.contains("News Feed"), "\"News Feed\" not available");
        } catch (AssertionError ae) {
            Hooks.verificationErrors.append("\n\n").append(ae.toString());
        }
        System.out.println("\nUsing POM; pages.Landing.validateNewsFeed\n");
    }
}
