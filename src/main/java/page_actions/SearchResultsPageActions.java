package page_actions;

import core.controller.Controller;
import pages.GoogleResultPage;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPageActions extends ActionsBase {

    private final GoogleResultPage resultPage;

    public SearchResultsPageActions(GoogleResultPage resultPage, Controller controller) {
        super(controller);
        this.resultPage = resultPage;
    }

    public List<String> getAllSearchResultsTitles() {
        this.resultPage.get();
        return resultPage.getSearchResultTitles()
                .stream()
                .filter(element -> !element.getText().isEmpty())
                .map(element -> element.getText().trim())
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public List<String> getFilteredSearchResultTitles(String filterText) {
        this.resultPage.get();
        return resultPage.getSearchResultTitles()
                .stream()
                .filter(element -> !element.getText().isEmpty())
                .map(element -> element.getText().trim())
                .filter(s -> s.toLowerCase().contains(filterText.toLowerCase()))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public boolean verifySearchResultTitles(String keyword) {
        int expected_count = getAllSearchResultsTitles().size();
        int actual_count = getFilteredSearchResultTitles(keyword).size();
        System.out.println("Expected Count :: "+expected_count);
        System.out.println("Actual Count :: "+actual_count);
        return expected_count == actual_count;
    }




}
