package core.controller;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

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
        String remote_execution = System.getProperty("REMOTE_EXEC", "N");
        new FirefoxSetup().setupFirefox(remote_execution, driver);
    }


}
