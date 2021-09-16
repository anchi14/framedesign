#SingleTest: automation


Narrative: As a user i want to click on repositories link
and see all the repositories are shown to user.


Scenario: User clicks on repositories tab on homepage
Given user navigate to django github page
When User clicks on repositories Link
Then all repositories must be shown to user
And verify all respotories are shown to user.