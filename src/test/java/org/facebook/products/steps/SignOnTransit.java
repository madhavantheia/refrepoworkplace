package org.facebook.products.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SignOnTransit {

    GetIn getIn = new GetIn();

    @Given("I submit my credentials on workplace.com with {string} and {string}")
    public void i_submit_my_credentials_on_workplace_com(String username, String password) {
        getIn.i_submit_my_username("https://ypgdtsmjgh.workplace.com/work/landing/input/");
        /**
         * The above method is need not to be called,
         * thou when removed, we have received null-pointer exception
         * as launcher object is instantiated in the above method
         * consecutive methods couldn't reach for the object
         */
        getIn.submit_my_password(password);
    }

    @Then("I should be able to view my portal")
    public void i_should_be_able_to_view_my_portal() {
        getIn.i_should_be_able_to_view_my_news_feed();
    }
}
