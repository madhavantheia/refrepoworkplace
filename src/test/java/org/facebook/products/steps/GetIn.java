package org.facebook.products.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.facebook.products.pages.CompanySelector;
import org.facebook.products.pages.Landing;
import org.facebook.products.pages.Launcher;
import org.facebook.products.pages.Login;

import java.time.Instant;

public class GetIn {

    Launcher launcher;
    CompanySelector companySelector;
    Login login;
    Landing landing;

    @Given("I am on Workplace portal using url {string}")
    public void i_am_on_Workplace_portal_using_url(String url) {
        System.out.println(Instant.now());
        Hooks.driver.get(url);
        System.out.println(Instant.now());
        System.out.println("Page Title: " + Hooks.driver.getTitle());
    }

    /**
     * Hooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(login)));
     * Assert.assertTrue((Hooks.driver.findElement(By.linkText("Log In")).isDisplayed()), "\"Log In\" button is not available");
     * System.out.println(login + " link is available \n");
     *
     * Instantiating Launcher declares loginButton
     * calls super, thereby initElements
     * then Launcher constructor
     * Object for PageObject will not be created thou
     */

    @Then("{string} button should be available")
    public void login_button_should_be_available(String login) {
        launcher = new Launcher(Hooks.driver);
        launcher.checkLoginButton();
    }

    /**
     * Hooks.driver.findElement(By.linkText(login)).click();
     *
     * launcher = new Launcher(Hooks.driver);
     * has been removed since its been instantiated already in prior step
     * as a result, in execution logs
     * "pages.PageObject.constructor will not be present this time around
     *
     * Illustration of javadoc comment Tags "param"
     * click on login below
     * you will be taken to respective variable
     * and these tags are auto-generated by IntelliJ
     *
     * @param login
     */

    @When("I click on {string} button")
    public void i_click_on_login_button(String login) {
        launcher.popLogin();
        System.out.println("triggered Log In");
    }

    /**
     * try {
     * Assert.assertTrue((Hooks.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/section[1]/div[1]/h1")).isEnabled()),
     * "Heading element is not present");
     * } catch (NoSuchElementException nee) {
     * Hooks.verificationErrors.append(nee.toString());
     * }
     *
     * This try-catch ensures execution proceeds to further steps regardless of Element discovery status
     * Also exception info is appended to String Buffer object
     *
     * Hooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
     * Hooks.driver.findElement(By.name("email")).clear();
     * Hooks.driver.findElement(By.name("email")).sendKeys(username);
     * Hooks.driver.findElement(By.xpath("//button[@value='1']")).click();
     * or By.className("ibm-btn-pri) or By.className("ibm-btn-blue-50") cause it has 2 classes for this button
     *
     * @param username
     */

    @When("Submit my username {string}")
    public void submit_my_username(String username) {
        companySelector = new CompanySelector(Hooks.driver);
        companySelector.submitUsername(username);
    }

    /**
     * Hooks.driver.findElement(By.name("pass")).sendKeys(pwd);
     * Hooks.driver.findElement(By.id("u_0_9")).click();
     */

    @When("Submit my password {string}")
    public void submit_my_password(String pwd) {
        login = new Login(Hooks.driver);
        login.submitPassword(pwd);
    }

    /**
     * String newsFeedLabel = Hooks.driver.findElement(By.xpath("//*[@id=\"u_0_1\"]/div/div/div/div/div/div[2]/div[2]/div[2]/header/div/div/div[1]/div[2]/div/h1/span")).getText();
     * System.out.println(newsFeedLabel);
     * try {
     * Assert.assertTrue(newsFeedLabel.contains("News Feed"), "\"News Feed\" not available");
     * } catch (AssertionError ae) {
     * Hooks.verificationErrors.append("\n\n").append(ae.toString());
     * }
     * System.out.println("Last statement in final step; After \"News Feed\" Label Validation");
     *
     * In-case of try-catch last statement always executes irrespective of "News Feed" availability/status
     * Without exception handling, last statement execution depends on "News Feed" availability
     */

    @Then("I should be able to view my News Feed")
    public void i_should_be_able_to_view_my_News_Feed() {
        landing = new Landing(Hooks.driver);
        landing.validateNewsFeed();
    }
}
