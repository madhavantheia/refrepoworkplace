package org.facebook.products.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class Hooks {

    public static ChromeDriver driver; // these objects are used on Logon.java, hence marking it as static
    public static WebDriverWait wait;
    public static StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void instantiateBrowser() {
        // ChromeOptions cOptions = new ChromeOptions();
        // cOptions.addArguments("disable-infobars"); // Chrome has removed "disable info-bars", so doesn't work
        System.out.println("initialization of browser using @Before hook \n");
        verificationErrors.delete(0, verificationErrors.length());
        System.out.println("VerificationErrors from previous scenario are cleared" + verificationErrors.toString());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10); //for explicit waits
        driver.manage().timeouts().pageLoadTimeout(15000, TimeUnit.MILLISECONDS); //time out for the page in browser
        // driver = new ChromeDriver();
        // driver.get("https://www.google.com");
    }

    @After
    public void screenshot_tearDown(/* Scenario scenario */) {

        System.out.println("\nteardown method using @After hook\n");
        driver.quit();
        // if (scenario.isFailed()) {
        try {
            String verificationErrorString = verificationErrors.toString();
            System.out.println("contents of verificationErrorString" + "\n\n" + verificationErrorString + "\n\n" + "End of verificationErrorString");
            if (!"".equals(verificationErrorString))
                fail(verificationErrorString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}