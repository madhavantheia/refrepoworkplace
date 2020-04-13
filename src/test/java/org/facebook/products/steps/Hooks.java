package org.facebook.products.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {

    public static ChromeDriver driver; // these objects are used on Logon.java, hence marking it as static
    public static WebDriverWait wait;

    @Before
    public void instantiateBrowser() {
        ChromeOptions cOptions = new ChromeOptions();
        cOptions.addArguments("disable-infobars");
        driver = new ChromeDriver(cOptions);
        wait = new WebDriverWait(driver,15); //for explicit waits
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS); //time out for the page in browser
        //driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("initialization of browser using @Before hook \n");
    }

    @After
    public void screenshot_tearDown(Scenario scenario) {

        System.out.println("\n teardown method using @After hook");
        if(scenario.isFailed()) {
            try {
                // code to capture and embed images in test reports
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }

}