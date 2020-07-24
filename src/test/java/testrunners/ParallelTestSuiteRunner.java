package testrunners;

import courgette.api.CucumberOptions;
import org.testng.annotations.Test;
import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.testng.TestNGCourgette;

@Test
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = false,
        rerunAttempts = 1,
        showTestOutput = true,
        reportTitle = "Google Search Tests",
        reportTargetDir = "target",
        plugin = { "extentreports" },
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = {"stepdefs", "testbase"},
                tags = {"@Sanity"},
                plugin = {
                        "pretty",
                        "json:target/cucumber-report/cucumber.json",
                        "html:target/cucumber-report/cucumber.html"},
                strict = true
        ))
public class ParallelTestSuiteRunner extends TestNGCourgette {
}