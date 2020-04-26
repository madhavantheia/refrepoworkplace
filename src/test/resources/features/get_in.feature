@Login
Feature: Get into Workplace
  As a workplace user, I would like to access my News Feed

  Background: Jump to workplace portal and confirm Log In button presence
    Given I am on Workplace portal using url "https://www.workplace.com"
    Then Log In button should be available

  @Successfullogin
  Scenario: Successful login
    When I click on Log In button
    And Submit my username "madhavan.profession@gmail.com"
    And Submit my password "context@13"
    Then I should be able to view my News Feed