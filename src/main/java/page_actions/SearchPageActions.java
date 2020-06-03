package page_actions;

import core.controller.Controller;
import pages.GoogleSearchPage;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPageActions extends ActionsBase {

    private final GoogleSearchPage searchPage;

    public SearchPageActions(GoogleSearchPage searchPage, Controller controller) {
        super(controller);
        this.searchPage = searchPage;
        this.searchPage.get();
    }

    public void performSearchOperation(CharSequence charSequence) {
        type(searchPage.getSearchBox(), charSequence);
        pressEnterKey(searchPage.getSearchBox());
        //click(searchPage.getSubmitButton());
    }

    public List<String> getSuggestedResults(CharSequence charSequence) {
        type(searchPage.getSearchBox(), charSequence);
        waitForVisibilityOfElement(searchPage.getSuggestionsBox(), 30);
        return searchPage.getSuggestionsList()
                .stream()
                .map(element -> element.getText().trim())
                .limit(6)
                .collect(Collectors.toList());
    }


}
