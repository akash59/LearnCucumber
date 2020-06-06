package stepdefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import pages.common.SearchSuggestions;
import pages.main.GoogleMainPage;
import pages.result.GoogleResultPage;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class GoogleSearchSteps extends BaseTest
{

    private final GoogleMainPage googleSearchPage;
    private final GoogleResultPage googleResultPage;

    // No need to define the constructor now as we are using lombak -> @AllArgsConstructor during execution
    /*public GoogleSearchSteps(GoogleMainPage googleSearchPage, GoogleResultPage googleResultPage) {
        this.googleSearchPage = googleSearchPage;
        this.googleResultPage = googleResultPage;
    }*/

    @When("^the user search for the item in google \"([^\"]*)\"$")
    public void the_user_search_for_the_item_in_google(String searchTerm)  {
        googleSearchPage.getSearchWidget().enter(searchTerm);
        scenario.write("Search keyword entered - "+searchTerm);
    }

    @And("user click suggestion {string} from the list")
    public void userClickSuggestionFromTheList(String index) {
        int index1 = Integer.parseInt(index);
        SearchSuggestions searchSuggestions = googleSearchPage.getSearchSuggestions();
        assertThat(searchSuggestions.getSuggestedResults(5).isEmpty()).isFalse();
        searchSuggestions.clickSuggestions(index1);
        scenario.write(+index1+ " search suggestion clicked");
    }

    @Then("results stats should be displayed")
    public void resultsStatsShouldBeDisplayed() {
        scenario.write("Search Results stats for "+googleResultPage.getResultStat().getSearchStats());
        assertThat(googleResultPage.getResultStat().getSearchStats())
                .as("Verify Result Stats are displayed on Search")
                .isNotBlank();
    }

}