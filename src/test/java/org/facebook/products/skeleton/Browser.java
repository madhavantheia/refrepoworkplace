package org.facebook.products.skeleton;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Browser {
    private WebDriver driver;
    @Test
    public void testEasy() {
        driver.get("https://www.workplace.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("Workplace from Facebook: A Work Collaboration Tool"));
    }
    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
