package pages.common;

import core.controller.Controller;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_utils.PageActions;

import java.util.List;
import java.util.stream.Collectors;

public class SearchSuggestions extends BasePage {

    private final PageActions pageActions;

    public SearchSuggestions(Controller controller) {
        super(controller);
        pageActions = new PageActions(controller);
    }

    @FindBy(how = How.XPATH, using=".//ul[@role='listbox']/li//span")
    private List<WebElement> suggestions;

    @FindBy(how = How.XPATH, using=".//ul[@role='listbox']")
    private WebElement suggestionsBox;

    public void clickSuggestions(int index) {
        pageActions.click(this.suggestions.get(index-1));
    }

    public List<String> getSuggestedResults() {
        return suggestions
                .stream()
                .map(element -> element.getText().trim())
                .limit(6)
                .collect(Collectors.toList());
    }

    public boolean isLoaded() {
        return this.wait.until(d -> this.suggestions.size() > 4);
    }

}
