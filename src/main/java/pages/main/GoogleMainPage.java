package pages.main;

import core.controller.Controller;
import lombok.Getter;
import page_utils.PageActions;
import pages.common.SearchSuggestions;
import pages.common.SearchWidget;

@Getter
public class GoogleMainPage {

    private final SearchWidget searchWidget;
    private final SearchSuggestions searchSuggestions;
    //private final WebDriver driver;
    private final PageActions pageActions;

    public GoogleMainPage(Controller controller) {
        this.searchWidget = new SearchWidget(controller);
        this.searchSuggestions = new SearchSuggestions(controller);
        this.pageActions = new PageActions(controller);
    }

    public void goToSearchPage() {
        pageActions.navigateTo("https://google.com");
    }
}
