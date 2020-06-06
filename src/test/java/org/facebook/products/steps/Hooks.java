package org.facebook.products.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class Hooks {

    public static ChromeDriver driver; // these objects are used on Logon.java, hence marking it as static
    public static WebDriverWait wait;
    public static StringBuffer verificationErrors = new StringBuffer();

    /**
     * Chrome has deprecated "disable info-bars", so doesn't work
     * ChromeOptions cOptions = new ChromeOptions();
     * cOptions.addArguments("disable-infobars");
     * driver = new ChromeDriver();
     * driver.get("https://www.google.com");
     */

    @Before
    public void instantiateBrowser() {
        System.out.println("initialization of browser using @Before hook \n");
        verificationErrors.delete(0, verificationErrors.length());
        System.out.println("VerificationErrors from previous scenario are cleared" + verificationErrors.toString());
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs. put("credentials_enable_service", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5); //for explicit waits
        driver.manage().timeouts().pageLoadTimeout(15000, TimeUnit.MILLISECONDS); //time out for the page in browser
    }

    /**
     * if (scenario.isFailed()) {}
     * removed as we chosen a versatile approach
     */

    @After
    public void screenshot_tearDown(/* Scenario scenario */) {

        System.out.println("\nteardown method using @After hook\n");
        driver.quit();
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