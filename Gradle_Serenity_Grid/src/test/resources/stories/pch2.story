Narrative:
As a Test Automation Engineer
I want to test the validation of the Registration page

Scenario: This is from Grid 2 empty validate the pch registration page
Given I go to PCH website
When I click on the registration button
Then I should present in registration page
And I click on the registration submit button
Then Verify the registration page validation error message

Scenario: This is from Grid 2 Validate the pch registration page error message for First and Last name
Given I go to PCH website
When I click on the registration button
Then I should present in registration page
Then I enter value for first and last name as My first name and My last name respectively
And I click on the registration submit button
Then Verify the registration page validation error message is withour first and last name

Scenario: This is from Grid 2 This scenario will fail
Given I go to PCH website
When I click on the registration button
Then Assert for fail

Scenario: This is from Grid 2 This test has to be skipped
Meta:
@skip
@ignored true
Given I go to PCH website
When I click on the registration button
Then I should present in registration page
Then I enter value for first and last name as My first name and My last name respectively
And I click on the registration submit button