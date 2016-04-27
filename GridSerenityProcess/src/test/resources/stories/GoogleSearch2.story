Narrative:
As a Test Automation Engineer
I want to test the validation of the Registration page

Scenario: This was from Grid2
Given I go to PCH website
When I click on the registration button
Then I should present in registration page
And I click on the registration submit button
Then Verify the registration page validation error message

Scenario: This was from grid2 on with googlesearch part 2
Given I go to PCH website
When I click on the registration button
Then I should present in registration page
Then I enter value for first and last name as My first name and My last name respectively
And I click on the registration submit button
Then Verify the registration page validation error message is withour first and last name

