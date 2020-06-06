package pages.common;

import core.controller.Controller;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public void clickSuggestions(int index) {
        pageActions.click(this.suggestions.get(index-1));
        this.wait.until(d -> ExpectedConditions.invisibilityOfAllElements(suggestions));
    }

    public List<String> getSuggestedResults(int limit) {
        this.wait.until(d -> ExpectedConditions.visibilityOfAllElements(suggestions));
        return suggestions
                .stream()
                .map(element -> element.getText().trim())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public boolean isLoaded() {
        return this.wait.until(d -> this.suggestions.size() > 4);
    }

}
