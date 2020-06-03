package pages;

import core.controller.Controller;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

@Getter
public class GoogleSearchPage extends BasePage {

    public GoogleSearchPage (Controller controller) {
        super(controller);
    }

    @FindBy(how = How.NAME, using="q")
    private WebElement searchBox;

    @FindBy(how = How.NAME, using ="btnK")
    private WebElement submitButton;

    @FindBy(how = How.LINK_TEXT, using ="Gmail")
    private WebElement Gmail;

    @FindBy(how = How.LINK_TEXT, using ="Images")
    private WebElement Images;

    @FindBy(how = How.XPATH, using=".//ul[@role='listbox']/li//span")
    private List<WebElement> suggestionsList;

    @FindBy(how = How.XPATH, using=".//ul[@role='listbox']")
    private WebElement suggestionsBox;

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
    }
}
