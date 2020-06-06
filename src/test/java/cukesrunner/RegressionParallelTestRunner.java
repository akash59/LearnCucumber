package cukesrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources",
        glue = { "stepdefs", "testbase" },
        monochrome = true,
        plugin = { "pretty",
                "html:target",
                "json:target/cucumber.json",
                },
        tags = { "@Regression"},
        strict = true
)

public class RegressionParallelTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}