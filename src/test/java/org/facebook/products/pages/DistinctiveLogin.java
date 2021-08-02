package org.facebook.products.pages;

import org.facebook.products.steps.Hooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DistinctiveLogin extends PageObject {

    /**
     * // @FindBy(linkText = "English (US)")
     * WebElement englishLanguage;
     */

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(xpath = "//button[@value='1']")
    WebElement continueButton;

    public DistinctiveLogin(WebDriver driver) {
        super(driver);
    }

    /**
     * Illustration of static import
     * visibilityOf doesn't mention the class ExpectedConditions
     */

    /*
     * public void setEnglishLanguage() {
     * englishLanguage.click();
     * }
     */
    public void verifyPageTitle(String pageTitle) throws Exception {
        LocalDateTime datetimeobj = LocalDateTime.now();
        String dtf = datetimeobj.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_DATE_TIME);
        String LandingPageShot = "LandingPageShot"+dtf;
        LandingPageShot = LandingPageShot.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println("Working Directory = " + System.getProperty("user.dir") + "\n");
        takeSnapShot(Hooks.driver, ".\\Screenshots\\"+LandingPageShot+".png") ;
        String dirName = "Screenshots";
        Files.list(new File(dirName).toPath())
                .limit(10)
                .forEach(System.out::println);
        System.out.println("\n");
        // distinctiveLogin.setEnglishLanguage();
        String titlenow = driver.getTitle();
        System.out.println(titlenow);
        Assert.assertTrue(pageTitle.contains(titlenow));
        System.out.println("\nUsing POM; pages.DistinctiveLogin.verifyPageTitle\n");
    }
    public static void takeSnapShot(WebDriver driver, String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileHandler.copy(SrcFile, DestFile);
    }

    /**
     * use this.continueButton in-case of ambiguity
     */

    public void submitUsername(String username) {
        Hooks.wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(username);
        continueButton.click();
        System.out.println("\nUsing POM; pages.DistinctiveLogin.submitUsername\n");
    }

}
