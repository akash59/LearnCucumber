package core.controller;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

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
        this.driver = new ThreadLocal<>();
        String remote_execution = System.getProperty("REMOTE_EXEC", "N");
        new ChromeSetup().setupChrome(remote_execution, driver);
    }

    @Override
    public void setDriver(ThreadLocal<WebDriver> driver) {
        this.driver = driver;
    }
}
