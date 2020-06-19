package core.controller;

import org.openqa.selenium.WebDriver;

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
        this.driver = new ThreadLocal<>();
        String remote_execution = System.getProperty("REMOTE_EXEC", "Y");
        new FirefoxSetup().setupFirefox(remote_execution, driver);
    }


}
