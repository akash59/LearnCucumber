package pages.result;

import core.controller.Controller;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_utils.PageActions;
import pages.common.BasePage;

public class ResultStat extends BasePage {

    private final PageActions pageActions;

    public ResultStat(Controller controller) {
        super(controller);
        pageActions = new PageActions(controller);
    }

    @FindBy(id = "result-stats")
    private WebElement stat;

    public String getSearchStats() {
        return stat.getText().trim();
    }

    public boolean isLoaded() {
        return this.wait.until(d -> this.stat.isDisplayed());
    }
}
