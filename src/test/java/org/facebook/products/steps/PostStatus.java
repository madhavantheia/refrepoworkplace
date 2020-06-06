package org.facebook.products.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.facebook.products.pages.Home;

public class PostStatus {

    Home home;

    @When("I post message to a group")
    public void i_post_message_to_a_group() throws InterruptedException {
        home = new Home(Hooks.driver);
        home.postStatus();
    }

    @Then("It should appear in the News Feed")
    public void it_should_appear_in_the_News_Feed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
