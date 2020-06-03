package pages;

import core.controller.Controller;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

@Getter
public class GoogleResultPage extends BasePage {

    public GoogleResultPage (Controller controller) {
        super(controller);
    }

    @FindBy(xpath = ".//a/h3")
    private WebElement resultLink;

    @FindBy(xpath = "//div[@class='rc']//a/h3")
    private List<WebElement> searchResultTitles;

    @FindBy(how = How.XPATH, using =".//button[@type='submit']")
    private WebElement Submit;

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
    }
}
