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
    static int counter = 0;

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setCapability("enableVNC", true);
        chromeOptions.setCapability("screenResolution", "1920x1080x24");
        chromeOptions.setCapability("enableVideo", true);
        chromeOptions.setCapability("enableLog", true);
        int count = counter++;
        chromeOptions.setCapability("name", "test_"+ count);
        chromeOptions.setCapability("videoName", "test_"+ count+".mp4");
        chromeOptions.setCapability("logName", "selenoid-execution_"+ count +".log");
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
