package org.facebook.products.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GetIn {
    @Given("I am on Workplace portal using url {string}")
    public void i_am_on_Workplace_portal_using_url(String url) {
        Hooks.driver.get(url);
    }

    @Then("{string} button should be available")
    public void button_should_be_available(String login) {
        Assert.assertTrue((Hooks.driver.findElements( By.linkText(login) ).size() != 0),"Sign-in link is not available");
        System.out.println(login+" link is available \n");
    }

    @When("I click on {string} button")
    public void i_click_on_button(String login) {
        Hooks.driver.findElement(By.linkText(login)).click();
        System.out.println("triggered Log In");
    }

    @When("Submit my username {string}")
    public void submit_my_username(String username) {
        System.out.println(Hooks.driver.getTitle());
        System.out.println(Hooks.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/section[1]/div[1]/h1")).getText());
        Hooks.driver.findElement(By.name("email")).sendKeys(username);
        Hooks.driver.findElement(By.xpath("//*[@id=\"work_company_creation_form\"]/div[3]/button")).click(); // or By.className("ibm-btn-pri) or By.className("ibm-btn-blue-50") cause it has 2 classes for this button
    }

    @When("Submit my password {string}")
    public void submit_my_password(String pwd) {
        Hooks.driver.findElement(By.name("pass")).sendKeys(pwd);
        Hooks.driver.findElement(By.id("u_0_9")).click(); // or By.className("ibm-btn-pri) or By.className("ibm-btn-blue-50") cause it has 2 classes for this button
    }

    @Then("I should be able to view my News Feed")
    public void i_should_be_able_to_view_my_News_Feed() {
        String newsFeedLabel = Hooks.driver.findElement(By.xpath("//*[@id=\"u_0_1\"]/div/div/div/div/div/div[2]/div[2]/div[2]/header/div/div/div[1]/div[2]/div/h1/span")).getText();
        System.out.println(newsFeedLabel);
        Assert.assertTrue(newsFeedLabel.contains("News Feed"),"\"News Feed\" not available");
        //add a statement to write display name onto the report
        System.out.println("Label \"News Feed\" available");

    }
}
