package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.List;

public class Home extends PageObject {

    @FindBy(xpath = "//span[.='News Feed']")
    WebElement newsFeedLabel;

    @SuppressWarnings("SpellCheckingInspection")
    @FindBy(xpath = "//span[.='Write something...']")
    WebElement createPostEditor;

    @SuppressWarnings("SpellCheckingInspection")
    @FindBy(xpath = "//span[.='Scriptures'] [@class='oecdyzpx qbbcxcfp ib0kwflm']")
    WebElement listofscriptures;

    @FindBy(id="489622505488337")
    WebElement scripturesGroup;

    @FindBy(xpath = "//div[@class='notranslate _5rpu'] [@role='textbox'] [@aria-label='What are you working on?']")
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

            Hooks.verificationErrors.append("\n\n").append(ae);
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
        System.out.println("Clicked on write something...");
        Hooks.wait.until(ExpectedConditions.visibilityOf(scripturesGroup));
        // Thread.sleep(5000);
        List<WebElement> sameClassnamelist =listofscriptures.findElements(By.xpath("//span[(.='Scriptures')][(@class='oecdyzpx qbbcxcfp ib0kwflm')]"));
        System.out.println("Number of elements:" +sameClassnamelist.size());

        for (int i=0; i<sameClassnamelist.size();i++) {
            System.out.println("Element: " + sameClassnamelist.get(i).getAttribute("src"));
            System.out.println("Element: " + sameClassnamelist.get(i).getAttribute("class"));
            System.out.println("Element: " + sameClassnamelist.get(i).getLocation());
            System.out.println("Element: " + sameClassnamelist.get(i).getText());
            System.out.println("Element: " + sameClassnamelist.get(i).getSize());
            System.out.println("\n----------------------\n");
        }

        System.out.println(scripturesGroup.isDisplayed());
        //Thread.sleep(5000);
        System.out.println(scripturesGroup.getCssValue("font-size"));
        System.out.println(scripturesGroup.getLocation());
        System.out.println("After breakpoint hit");
        System.out.println("Second line of breakpoint");
        Hooks.wait.until(ExpectedConditions.elementToBeClickable(scripturesGroup));
        System.out.println("Scriptures ready to be clicked");
        scripturesGroup.click();

        /*
        scripturesGroup.sendKeys(Keys.ENTER);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", scripturesGroup);
        Thread.sleep(5000);
        System.out.println("Scriptures group click action triggered");
        Actions actions = new Actions(driver);
        actions.moveToElement(scripturesGroup).click().perform();
         */

        System.out.println("Scriptures group selected");
        //Thread.sleep(5000);
        Hooks.wait.until(ExpectedConditions.visibilityOf(messageEditor));
        messageEditor.click();
        System.out.println("message editor clicked");
        LocalDateTime datetimeobj = LocalDateTime.now();
        messageEditor.sendKeys("Posted using robotizing script on - " + datetimeobj);
        System.out.println(messageEditor.getText());
        System.out.println(messageEditor.isDisplayed());
        System.out.println(messageEditor.getAttribute("class"));
        System.out.println(messageEditor.getAttribute("data-offset-key"));
        System.out.println("Message typed");
        // Thread.sleep(5000);
        System.out.println(postButton.isDisplayed());
        System.out.println(postButton.getAttribute("class"));
        System.out.println(postButton.getText());
        postButton.click();
        //jse.executeScript("arguments[0].click()", postButton);
        Thread.sleep(5000);
        System.out.println("Posted the message");
        System.out.println("The Feed doesn't auto-retrieve the freshly posted content even when done Directly");
    }
}
