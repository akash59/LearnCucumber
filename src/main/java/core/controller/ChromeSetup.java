package core.controller;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeSetup {

    String host = "localhost";
    String complete_url;

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        return chromeOptions;
    }

    public void setupChrome(String remoteExecution, ThreadLocal<WebDriver> driver) {

        if(remoteExecution != null && remoteExecution.equalsIgnoreCase("Y")) {
            if(System.getenv("HUB_HOST") != null)
            {
                host = System.getProperty("HUB_HOST");
            }

            try
            {
                complete_url = "http://"+ host +":4444/wd/hub";
                driver.set(new RemoteWebDriver(new URL(complete_url), getChromeOptions()));
            }

            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }

        }

        else
        {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
    }
}
