package stepdefs;

import core.controller.Controller;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

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
        driver = controller.getDriver();
        System.out.println(driver.toString());
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

        if (driver.toString().contains("chrome")) {
            scenario.write("launching chrome browser { version -> "+caps.getVersion()+" }");
        }

        else if (driver.toString().contains("firefox")) {
            scenario.write("launching firefox browser { version -> "+caps.getVersion()+" }");
        }
        else {
            scenario.write("currently unsupported browser...");
        }

        driver.manage().window().setSize(new Dimension(1920, 1080));
        String testName = scenario.getName();
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
        long id = Thread.currentThread().getId();
        scenario.write("After scenario. Thread id is: " + id);
        scenario.write("shutting down browser");
        controller.tearDownController();
    }

    private void openTestApplication() {
        driver.get(TestSetup.APP_URL);
    }

}
