package core.controller;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxSetup {

    String host = "localhost";
    String complete_url;

    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        return firefoxOptions;
    }

    public void setupFirefox(String remoteExecution, ThreadLocal<WebDriver> driver) {

        if(remoteExecution != null && remoteExecution.equalsIgnoreCase("Y")) {
            if(System.getProperty("HUB_HOST") != null)
            {
                host = System.getProperty("HUB_HOST");
            }

            try
            {
                complete_url = "http://"+ host +":4444/wd/hub";
                driver.set(new RemoteWebDriver(new URL(complete_url), getFirefoxOptions()));
            }

            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }

        }

        else
        {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
    }

}
