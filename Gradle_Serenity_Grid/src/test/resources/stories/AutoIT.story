Narrative:
As a Test Automation Engineer
I want to test upload using AutoIT

Meta:               
@web @iexplorer

Scenario: empty validate the pch registration page
Given I type and go to https://blueimp.github.io/jQuery-File-Upload/
When I click on file upload button
Then I wait for 5 seconds
And I apply AutoIT to it
And Verify the file is uploaded
Then I wait for 5 seconds