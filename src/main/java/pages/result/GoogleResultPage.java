package pages.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pages.common.SearchSuggestions;
import pages.common.SearchWidget;

@Getter @RequiredArgsConstructor
public class GoogleResultPage {

    private final SearchWidget searchWidget;
    private final SearchSuggestions searchSuggestions;
    private final NavigationBar navigationBar;
    private final ResultStat resultStat;

   /* public GoogleResultPage (Controller controller) {
        this.searchWidget = new SearchWidget(controller);
        this.searchSuggestions = new SearchSuggestions(controller);
        this.navigationBar = new NavigationBar(controller);
        this.resultStat = new ResultStat(controller);
    }*/

}
