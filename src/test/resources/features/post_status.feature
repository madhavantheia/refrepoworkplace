@PostStatus
  Feature: Post a status message
    As workplace user, I post message to a group

  Background: Sign-in to the application
    Given I submit my credentials on workplace.com with "colleague.workplace@gmail.com" and "colleague@64"
    Then I should be able to view my portal

   @ToGeneralGroup
   Scenario: Status post to General group
     When I post message to a group
     Then It should appear in the News Feed
