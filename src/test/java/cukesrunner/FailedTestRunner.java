package cukesrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "@target/rerun.txt",
        glue = { "stepdefs", "testbase" },
        monochrome = true,
        plugin = { "pretty", "html:target", "json:target/rerun_cucumber.json"},
        strict = true
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
