@Login
  Feature: Get into Workplace
    As a workplace user, I would like to access my News Feed
    * signs into the application
    * negative scenarios are yet to be written

    # '*' is for list of things, kind of bullet points

  Background: Availing the user specific Logon web-link

    """The Tool has new way of authentication using activation codes
    as a workaround, we use distinctive URL particular to the account
    it works only for qualitymanageribm@gmail.com, any other id will show up error"""

    Given I am on SignOn page using "https://spacex240.workplace.com/work/landing/input/"
    Then Title should be "Log in to Workplace"

  @Successfullogin
  Scenario: Successful login

    When I submit my username "toolsinceptor@gmail.com"
    And Submit password "toolsinceptor@1706"
    Then I should be able to view my News Feed