@tag
Feature: Google Search project
  I want to use this template for my feature file

  @tag1
  Scenario: Search a title in Google search
    Given I go to "https://www.google.com"
    And observer the search bar is present
    When I type "testing methodologies" in the search bar
    And I hit enter
    And I wait for 5 seconds
    Then I validate that the page has "testing methodologies - Google Search"
    And I check for the number of counts of the link in that page

  @tag1
  Scenario: Search a title in Google search for serentiy result
    Given I go to "https://www.google.com"
    And observer the search bar is present
    When I type "serenity bdd" in the search bar
    And I hit enter
    And I wait for 5 seconds
    Then I validate that the page has "serenity bdd - Google Search"
    And I check for the number of counts of the link in that page

  @tag2
  Scenario Outline: Search a title in Google search using table
    Given I want to write a step with "<name>"
    When I check for the "<value>" in step
    Then I verify the "<status>" in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |

  @tag1
  Scenario: Search a title in Google search
    Given I go to "https://www.github.com"
    And I wait for 5 seconds
