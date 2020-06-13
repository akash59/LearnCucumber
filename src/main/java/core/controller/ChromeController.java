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
    private String complete_url;
    private String host = "localhost";

    @Override
    public WebDriver getDriver() {
        if(null == driver) {
            setupController();
        }
        return driver.get();
    }

    @Override
    public void setupController() {

        if(System.getenv("HUB_HOST") != null) {
            host = System.getenv("HUB_HOST");
        }

        WebDriverManager.chromedriver().setup();
        this.driver = new ThreadLocal<>();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        try {
            complete_url = "http://"+ host +":4444/wd/hub";
            driver.set(new RemoteWebDriver(new URL(complete_url), chromeOptions));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //driver.set(new ChromeDriver());
    }

    @Override
    public void setDriver(ThreadLocal<WebDriver> driver) {
        this.driver = driver;
    }
}
