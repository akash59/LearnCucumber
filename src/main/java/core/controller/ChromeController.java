package core.controller;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeController implements Controller {

    private ThreadLocal<WebDriver> driver;

    @Override
    public WebDriver getDriver() {
        if(null == driver) {
            setupController();
        }
        return driver.get();
    }

    @Override
    public void setupController() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ThreadLocal<>();
        driver.set(new ChromeDriver());
    }

    @Override
    public void setDriver(ThreadLocal<WebDriver> driver) {
        this.driver = driver;
    }
}
