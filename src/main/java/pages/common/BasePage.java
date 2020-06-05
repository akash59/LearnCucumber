package pages.common;

import core.controller.Controller;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    protected final WebDriver driver;
    protected final Controller controller;
    protected final WebDriverWait wait;

    public BasePage(Controller controller) {
        this.controller = controller;
        this.driver = controller.getDriver();
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    protected abstract boolean isLoaded();
}
