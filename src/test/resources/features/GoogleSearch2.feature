Feature: Verify Google Search feature with new test cases

  @Sanity @Chrome
  Scenario:  Verify search suggestions on Google Home page for keyword "docker"
    When the user search for the item in google "docker"
    And user click suggestion "1" from the list
    Then results stats should be displayed

  @Sanity @Firefox
  Scenario:  Verify search suggestions on Google Home page for keyword "jenkins"
    When the user search for the item in google "jenkins"
    And user click suggestion "2" from the list
    Then results stats should be displayed