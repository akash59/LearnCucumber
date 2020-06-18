Feature: Verify Google Search feature

  @Sanity @Chrome
  Scenario:  Verify search suggestions on Google Home page for keyword "india"
    When the user search for the item in google "india"
    And user click suggestion "5" from the list
    Then results stats should be displayed

  @Sanity @Chrome
  Scenario:  Verify search suggestions on Google Home page for keyword "japan"
    When the user search for the item in google "japan"
    And user click suggestion "2" from the list
    Then results stats should be displayed

  @Sanity @Chrome
  Scenario:  Verify search suggestions on Google Home page for keyword "usa"
    When the user search for the item in google "usa"
    And user click suggestion "3" from the list
    Then results stats should be displayed

  @Sanity @Chrome
  Scenario:  Verify search suggestions on Google Home page for keyword "australia"
    When the user search for the item in google "australia"
    And user click suggestion "1" from the list
    Then results stats should be displayed

  @Sanity @Chrome
  Scenario:  Verify search suggestions on Google Home page for keyword "new zealand"
    When the user search for the item in google "new zealand"
    And user click suggestion "3" from the list
    Then results stats should be displayed

  @Sanity @Firefox
  Scenario:  Verify search suggestions on Google Home page for keyword "himachal pradesh"
    When the user search for the item in google "himachal pradesh"
    And user click suggestion "6" from the list
    Then results stats should be displayed

  @Sanity @Firefox
  Scenario:  Verify search suggestions on Google Home page for keyword "delhi"
    When the user search for the item in google "delhi"
    And user click suggestion "4" from the list
    Then results stats should be displayed

  @Sanity @Firefox
  Scenario:  Verify search suggestions on Google Home page for keyword "china"
    When the user search for the item in google "china"
    And user click suggestion "1" from the list
    Then results stats should be displayed

  @Sanity @Firefox
  Scenario:  Verify search suggestions on Google Home page for keyword "russia"
    When the user search for the item in google "russia"
    And user click suggestion "4" from the list
    Then results stats should be displayed

  @Sanity @Firefox
  Scenario:  Verify search suggestions on Google Home page for keyword "lanka"
    When the user search for the item in google "lanka"
    And user click suggestion "5" from the list
    Then results stats should be displayed