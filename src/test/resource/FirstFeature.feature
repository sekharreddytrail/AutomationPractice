Feature: Automation test Practice website

  Scenario: Wiki search for String

    Given Navigate to website
    When Search for fish in wikipedia
    Then Verify the search page heading is fish
    Then Verify search page for other Languages
    When I navigate to different language Italiano
    Then I verify search page of new language has English
