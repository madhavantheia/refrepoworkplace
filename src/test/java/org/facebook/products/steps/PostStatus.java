package org.facebook.products.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.facebook.products.pages.DistinctiveLogin;
import org.facebook.products.pages.Home;
import org.facebook.products.pages.PasswordSubmission;

public class PostStatus {

    DistinctiveLogin distinctiveLogin;
    PasswordSubmission passwordSubmission;
    Home home;
    GetIn getin;

    @Given("I submit my credentials on workplace.com with {string} and {string} using url {string}")
    public void i_submit_my_credentials_on_workplace_com_with_and(String username, String pwd, String url) {
        String pageTitle = "Log in to Workplace";
        getin = new GetIn();
        getin.i_am_on_signon_page_using(url);
        distinctiveLogin = new DistinctiveLogin(Hooks.driver);
        distinctiveLogin.verifyPageTitle(pageTitle);
        distinctiveLogin.submitUsername(username);
        passwordSubmission = new PasswordSubmission(Hooks.driver);
        passwordSubmission.submitPassword(pwd);
    }

    @Then("I should be able to view my portal")
    public void i_should_be_able_to_view_my_portal() {
        home = new Home(Hooks.driver);
        home.validateNewsFeed();
    }

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
