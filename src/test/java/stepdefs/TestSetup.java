package stepdefs;

import core.controller.Controller;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
    private final Map<String, String> ERROR_LOGS = new HashMap<>();
    private DevTools devTools;

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

        devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();
        devTools.send(Console.enable());

        devTools.addListener(Console.messageAdded(), entry -> ERROR_LOGS.put(entry.getLevel(), entry.getText()));
        driver.manage().window().maximize();

        openTestApplication();

        //remove this code - this is temp , just for demo purpose
        JavascriptExecutor exec = (JavascriptExecutor) driver;
        exec.executeScript("console.error('Abandon Hope All Ye Who Enter');");
        exec.executeScript("console.warn('Warning message');");
        exec.executeScript("console.info('Information message');");

    }


    @After(order = 1)
    public void embedScreenshot(Scenario scenario)
    {
        System.out.println("Reading browser console logs if any....");
        ERROR_LOGS.forEach((k,v) -> System.out.println(k.toUpperCase() + " -> " +v));

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
        controller.teardownController();
        //devTools.send(disable());
    }

    private void openTestApplication() {
        driver.get(TestSetup.APP_URL);
    }

}
