@Login
  Feature: Get into Workplace
    As a workplace user, I would like to access my News Feed
    * signs into the application
    * negative scenarios are yet to be written
    # '*' is for list of things, kind of bullet points

  Background: Availing the user specific Logon web-link
    # The Tool has new way of authentication using activation codes
    # as a workaround, we use distinctive URL particular to the account
    Given I am on SignOn page using "https://ypgdtsmjgh.workplace.com/work/landing/input/"
    Then Title should be "Log in to Workplace"

  @Successfullogin
  Scenario: Successful login
    """
    Signing in with a valid username
    and password
    """
    When I submit my username "qualitymanageribm@gmail.com"
    And Submit password "QAmanager@05"
    Then I should be able to view my News Feed
    But not the error page
    # last "But" step yet to be implemented - pending exception