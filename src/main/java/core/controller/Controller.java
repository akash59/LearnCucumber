package core.controller;

import org.openqa.selenium.WebDriver;

public interface Controller {

    WebDriver getDriver();

    void setupController();

    void setDriver(ThreadLocal<WebDriver> driver);

    default void tearDownController() {
        if (getDriver() != null) {
            getDriver().quit();
            setDriver(null);
        }
    }
}
