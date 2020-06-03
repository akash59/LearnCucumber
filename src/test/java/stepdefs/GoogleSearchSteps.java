package stepdefs;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import page_actions.SearchPageActions;
import page_actions.SearchResultsPageActions;
import testutils.TestUtilities;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class GoogleSearchSteps extends TestUtilities
{

    private final SearchPageActions searchPageActions;
    private final SearchResultsPageActions resultsPageActions;
    private List<String> actualSuggestions;

    // No need to define the constructor now as we are using lombak -> @AllArgsConstructor during execution
    /*public GoogleSearchSteps(SearchPageActions searchPageActions, SearchResultsPageActions resultsPageActions) {
        this.searchPageActions = searchPageActions;
        this.resultsPageActions = resultsPageActions;
    }*/

    @When("^the user search for the item in google \"([^\"]*)\"$")
    public void the_user_search_for_the_item_in_google(String searchTerm)  {
        searchPageActions.performSearchOperation(searchTerm);
        sleep(1000);
    }

    @Then("search results should contain {string}")
    public void relevant_search_results_should_be_displayed(String expected) {
        assertThat(resultsPageActions.verifySearchResultTitles(expected))
                .as("Matching Relevant search results are displayed or not")
                .isEqualTo(true);
    }


    @When("the user enter and keyword and get suggestions for the item {string}")
    public void theUserEnterAndKeywordAndGetSuggestionsForTheItem(String keyword) {
        actualSuggestions = searchPageActions.getSuggestedResults(keyword);
    }


    @Then("search results should shall match with input list")
    public void searchResultsShouldShallMatchWithInputList(DataTable dt) {

        List<String> expected_suggestions = dt.asList();
        System.out.println(expected_suggestions);
        System.out.println(actualSuggestions);

        //matching all condition to pass based on the criterion
        assertThat(verifySuggestions(actualSuggestions, expected_suggestions)).isTrue();
    }

    public static boolean verifySuggestions(List<String> actual, List<String> expected) {

        if(actual.equals(expected)) {
            return true;
        }

        else if (actual.size() < expected.size()) {

            int count = 0;
            for (String s : actual) {
                if (expected.contains(s)) {
                    count++;
                }
            }
            System.out.println("matched count "+count);
            System.out.println("expected "+ (expected.size() - 1));
            return count == expected.size()-1;
        }

        else {

            //third check can be added here
            return false;
        }
    }

    public static boolean areAllTrue(boolean[] array)
    {
        for(boolean b : array) if(!b) return false;
        return true;
    }
}
