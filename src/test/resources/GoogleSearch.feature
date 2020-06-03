Feature: Verify Google Search feature

  @Regression
  Scenario:  Verify search behavior on Google Home page for keyword "cucumber"
    When the user search for the item in google "cucumber"
    Then search results should contain "cucumber"

  @Sanity
  Scenario:  Verify search behavior on Google Home page for keyword "linkedin"
    When the user search for the item in google "linkedin"
    Then search results should contain "linkedin"

  @Sanity
  Scenario:  Verify search behavior on Google Home page for keyword "data science"
    When the user search for the item in google "data science"
    Then search results should contain "data science"

  @Regression
  Scenario:  Verify search behavior on Google Home page for keyword "machine learning"
    When the user search for the item in google "machine learning"
    Then search results should contain "machine"

  @Sanity
  Scenario:  Verify search suggestions on Google Home page for keyword "india"
    When the user enter and keyword and get suggestions for the item "india"
    Then search results should shall match with input list
    |india | india coronavirus | india map| india news| india population| india vs new zealand | india population 2020 |

  @Sanity
  Scenario:  Verify search suggestions on Google Home page for keyword  "india"
    When the user enter and keyword and get suggestions for the item "india"
    Then search results should shall match with input list
      |india | india coronavirus | india map| india news| india population| india population 2020 |