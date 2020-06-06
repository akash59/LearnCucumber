package pages.common;

import com.google.common.util.concurrent.Uninterruptibles;
import core.controller.Controller;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_utils.PageActions;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends BasePage {

    private final PageActions pageActions;

    public SearchWidget(Controller controller) {
        super(controller);
        pageActions = new PageActions(controller);
    }

    @FindBy(how = How.NAME, using="q")
    private WebElement searchBox;

    @FindBy(how = How.NAME, using ="btnK")
    private WebElement submitButton;


    public void enter(String keyword) {
        pageActions.clearText(searchBox);
        for(char ch : keyword.toCharArray()) {
            pageActions.type(searchBox, ch+"");
            Uninterruptibles.sleepUninterruptibly(120, TimeUnit.MILLISECONDS);
        }
        Uninterruptibles.sleepUninterruptibly(120, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until(d -> this.searchBox.isEnabled());
    }

}
