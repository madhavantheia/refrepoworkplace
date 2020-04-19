package org.facebook.products.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Instant;

public class GetIn {
    @Given("I am on Workplace portal using url {string}")
    public void i_am_on_Workplace_portal_using_url(String url) {
        System.out.println(Instant.now());
        Hooks.driver.get(url);
        System.out.println(Instant.now());
        System.out.println("Page Title: " + Hooks.driver.getTitle());
    }

    @Then("{string} button should be available")
    public void login_button_should_be_available(String login) {
        // Hooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(login)));
        Assert.assertTrue((Hooks.driver.findElement(By.linkText("Log In")).isDisplayed()), "\"Log In\" button is not available");
        System.out.println(login + " link is available \n");
    }

    @When("I click on {string} button")
    public void i_click_on_login_button(String login) {
        Hooks.driver.findElement(By.linkText(login)).click();
        System.out.println("triggered Log In");
    }

    @When("Submit my username {string}")
    public void submit_my_username(String username) {
        /* try {
            Assert.assertTrue((Hooks.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/section[1]/div[1]/h1")).isEnabled()),
                    "Heading element is not present");
        } catch (NoSuchElementException nee) {
            Hooks.verificationErrors.append(nee.toString());
        }
        */
        // This try-catch ensures execution proceeds to further steps regardless of Element discovery status
        // Also exception info is appended to String Buffer object
        Hooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        Hooks.driver.findElement(By.name("email")).clear();
        Hooks.driver.findElement(By.name("email")).sendKeys(username);
        Hooks.driver.findElement(By.xpath("//button[@value='1']")).click();
        // or By.className("ibm-btn-pri) or By.className("ibm-btn-blue-50") cause it has 2 classes for this button
    }

    @When("Submit my password {string}")
    public void submit_my_password(String pwd) {
        Hooks.driver.findElement(By.name("pass")).sendKeys(pwd);
        Hooks.driver.findElement(By.id("u_0_9")).click();
    }

    @Then("I should be able to view my News Feed")
    public void i_should_be_able_to_view_my_News_Feed() {
        String newsFeedLabel = Hooks.driver.findElement(By.xpath("//*[@id=\"u_0_1\"]/div/div/div/div/div/div[2]/div[2]/div[2]/header/div/div/div[1]/div[2]/div/h1/span")).getText();
        System.out.println(newsFeedLabel);
        try {
            Assert.assertTrue(newsFeedLabel.contains("News Feed"), "\"News Feed\" not available");
        } catch (AssertionError ae) {
            Hooks.verificationErrors.append("\n\n").append(ae.toString());
        }
        System.out.println("Last statement in final step; After \"News Feed\" Label Validation");
        /* In-case of try-catch last statement always executes irrespective of "News Feed" availability/status
        Without exception handling, last statement execution depends on "News Feed" availability
         */
    }
}
