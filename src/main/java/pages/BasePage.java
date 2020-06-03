package pages;

import core.controller.Controller;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;


public class BasePage extends LoadableComponent<BasePage> {

    protected final WebDriver driver;
    protected final Controller controller;

    public BasePage(Controller controller) {
        this.controller = controller;
        this.driver = controller.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Getter
    @FindBy(how = How.LINK_TEXT, using ="About")
    private WebElement About;

    @Getter
    @FindBy(how = How.LINK_TEXT, using ="Store")
    private WebElement Store;

    @Getter
    @FindBy(how = How.NAME, using ="q")
    private WebElement SearchBar;

    @FindBy(how = How.XPATH, using ="//div[@aria-label='Search by voice']")
    private WebElement VoiceSearch;

    @Override
    protected void load() {
      //not required, can be implemented later
    }

    @Override
    protected void isLoaded() throws Error {
        boolean ready = false;
        try {
            boolean hasTitleLoaded = driver.getTitle().contains("Google");
            boolean hasSearchBarLoaded = SearchBar.isEnabled();
            boolean hasVoiceSearchLoaded = VoiceSearch.isEnabled();
            ready = hasTitleLoaded && hasSearchBarLoaded && hasVoiceSearchLoaded;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!ready) {
            throw new Error("Page has not loaded");
        }

    }
}
