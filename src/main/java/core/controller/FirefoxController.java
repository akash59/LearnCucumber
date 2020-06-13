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
    String host = "localhost";
    String complete_url;

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

        if(System.getenv("HUB_HOST") != null) {
            host = System.getenv("HUB_HOST");
        }

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        try {
            complete_url = "http://"+ host +":4444/wd/hub";
            driver.set(new RemoteWebDriver(new URL(complete_url), firefoxOptions));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //driver.set(new FirefoxDriver());
}
