package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Home extends PageObject {

    @FindBy(xpath = "//span[.='News Feed']")
    WebElement newsFeedLabel;

    @SuppressWarnings("SpellCheckingInspection")
    @FindBy(name = "xhpc_message_text")
    WebElement createPostEditor;

    @FindBy(xpath = "//span[contains(@class, ' _50f9  _50f7 _2iem')][.='General']")
    WebElement generalGroup;

    @FindBy(xpath = "//div[(@class='_2cuy _3dgx')]")
    WebElement messageEditor;

    @FindBy(xpath = "//span[.='Post']")
    WebElement postButton;

    public Home(WebDriver driver) {
        super(driver);
    }

    public void validateNewsFeed() {
        Hooks.wait.until(ExpectedConditions.visibilityOf(newsFeedLabel));

        String labelName = newsFeedLabel.getText();
        System.out.println(labelName);
        try {
            Assert.assertTrue(labelName.contains("News Feed"), "\"News Feed\" not available");
        } catch (AssertionError ae) {

            Hooks.verificationErrors.append("\n\n").append(ae.toString());
        }
        System.out.println("\nUsing POM; pages.Home.validateNewsFeed\n");
    }

    /***
     * JavascriptExecutor js = (JavascriptExecutor) driver;
     * js.executeScript("window.scrollBy(0,1000)");
     * removed as scrolling to the bottom of page was
     * interrupting the createPostEditor field's click operation
     *
     * examine below throws exception handling in documentation comments
     *
     * @throws InterruptedException if the execution is interrupted
     */

    public void postStatus() throws InterruptedException {
        createPostEditor.click();
        System.out.println("Editor accessed");
        Hooks.wait.until(ExpectedConditions.visibilityOf(generalGroup));
        generalGroup.click();
        System.out.println("General group selected");
        Hooks.wait.until(ExpectedConditions.visibilityOf(messageEditor));
        messageEditor.click();
        System.out.println("message editor clicked");
        messageEditor.sendKeys("Posted using robotizing script Aug-8");
        System.out.println("Message typed");
        postButton.click();
        Thread.sleep(5000);
        System.out.println("posted the message");
    }
}
