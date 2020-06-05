package pages.result;

import core.controller.Controller;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_utils.PageActions;
import pages.common.BasePage;

public class NavigationBar extends BasePage {

    private PageActions pageActions;

    public NavigationBar(Controller controller) {
        super(controller);
        pageActions = new PageActions(controller);
    }

    @FindBy(id = "hdtb-msb")
    private WebElement navigationBar;

    @FindBy(linkText = "Images")
    private WebElement images;

    @FindBy(linkText = "News")
    private WebElement news;

    @FindBy(linkText = "Videos")
    private WebElement videos;

    public void goToImages() {
        pageActions.click(images);
    }

    public void goToNews() {
        pageActions.click(news);
    }

    public boolean isLoaded() {
        return this.wait.until((d) -> this.navigationBar.isDisplayed() && this.images.isEnabled());
    }
}
