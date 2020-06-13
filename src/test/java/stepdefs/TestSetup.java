package stepdefs;

import core.controller.Controller;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Console;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class TestSetup extends BaseTest {

    private WebDriver driver;
    private int counter = 1;
    private final Controller controller;
    private static final String APP_URL = "https://google.com";
    public TestSetup(Controller controller) {
        this.controller = controller;
    }


    @Before
    public void init(Scenario scenario) {
        BaseTest.scenario.set(scenario);
        long id = Thread.currentThread().getId();
        scenario.write("Before scenario. Thread id is: " + id);
        scenario.write("launching browser...");
        driver = controller.getDriver();
        String testName = scenario.getName();
        //driver.manage().window().maximize();

        openTestApplication();
    }


    @After(order = 1)
    public void embedScreenshot(Scenario scenario)
    {
        System.out.println("Reading browser console logs if any....");

        if (scenario.isFailed() && driver != null)
        {
            scenario.write("taking screenshot for failed scenario");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", "failure" + "_" + counter++ + ".png");
        }
    }

    @After(order = 0)
    public void tear_down(Scenario scenario) {

        if(scenario.isFailed()) {
            Cookie cookie = new Cookie("zaleniumTestPassed", "false");
            driver.manage().addCookie(cookie);
        }
        else {
            Cookie cookie = new Cookie("zaleniumTestPassed", "true");
            driver.manage().addCookie(cookie);
        }

        long id = Thread.currentThread().getId();
        scenario.write("After scenario. Thread id is: " + id);
        scenario.write("shutting down browser");
        controller.teardownController();
        //devTools.send(disable());
    }

    private void openTestApplication() {
        driver.get(TestSetup.APP_URL);
    }

}
