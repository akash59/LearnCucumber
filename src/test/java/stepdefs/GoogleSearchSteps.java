package stepdefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.result.GoogleResultPage;
import pages.main.GoogleMainPage;
import testutils.TestUtilities;

import java.util.List;

public class GoogleSearchSteps extends TestUtilities
{

    private final GoogleMainPage googleSearchPage;
    private final GoogleResultPage googleResultPage;
    private List<String> actualSuggestions;

    // No need to define the constructor now as we are using lombak -> @AllArgsConstructor during execution
    public GoogleSearchSteps(GoogleMainPage googleSearchPage, GoogleResultPage googleResultPage) {
        this.googleSearchPage = googleSearchPage;
        this.googleResultPage = googleResultPage;
    }

    @When("^the user search for the item in google \"([^\"]*)\"$")
    public void the_user_search_for_the_item_in_google(String searchTerm)  {
        googleSearchPage.getSearchWidget().enter(searchTerm);
        sleep(1000);
    }

    @And("user click suggestion {string} from the list")
    public void userClickSuggestionFromTheList(String index) {
        int index1 = Integer.parseInt(index);
        googleSearchPage.getSearchSuggestions().clickSuggestions(index1);
    }

    @Then("results stats should be displayed")
    public void resultsStatsShouldBeDisplayed() {
        System.out.println(googleResultPage.getResultStat().getSearchStats());
    }

    /*@Then("search results should contain {string}")
    public void relevant_search_results_should_be_displayed(String expected) {
        assertThat(resultsPageActions.verifySearchResultTitles(expected))
                .as("Matching Relevant search results are displayed or not")
                .isEqualTo(true);
    }


    @When("the user enter and keyword and get suggestions for the item {string}")
    public void theUserEnterAndKeywordAndGetSuggestionsForTheItem(String keyword) {
        actualSuggestions = searchPageActions.getSuggestedResults(keyword);
    }*/


}
