package core.controller;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxController implements Controller {

    private ThreadLocal<WebDriver> driver;

    @Override
    public WebDriver getDriver() {
        if (null == driver) {
            setupController();
        }
        return driver.get();
    }

    @Override
    public void setDriver(ThreadLocal<WebDriver> driver) {
        this.driver = driver;
    }

    @Override
    public void setupController() {
        WebDriverManager.firefoxdriver().setup();
        this.driver = new ThreadLocal<>();
        driver.set(new FirefoxDriver());

    }
}
