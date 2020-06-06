package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Home extends PageObject {

    @FindBy(xpath = "//*[@id=\"u_0_1\"]/div/div/div/div/div/div[2]/div[2]/div[2]/header/div/div/div[1]/div[2]/div/h1/span")
    WebElement newsFeedLabel;

    @SuppressWarnings("SpellCheckingInspection")
    @FindBy(name = "xhpc_message_text")
    WebElement createPostEditor;

    @FindBy(xpath = "//span[contains(@class, ' _50f9  _50f7 _2iem')][.='General']")
    WebElement generalGroup;

    @FindBy(xpath = "//input[contains(@class, '_2cuy _3dgx']")
    WebElement messageEditor;

    @FindBy(xpath = "//span[.='Post']")
    WebElement postButton;

    public Home(WebDriver driver) {
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

    public void postStatus() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        createPostEditor.click();
        System.out.println("Editor accessed");
        Hooks.wait.until(ExpectedConditions.visibilityOf(generalGroup));
        generalGroup.click();
        System.out.println("General group selected");
        Thread.sleep(5000);

        messageEditor.click();
        System.out.println("message editor clicked");
        messageEditor.sendKeys("Posted using robotizing script");
        Thread.sleep(5000);
        postButton.click();
    }
}
