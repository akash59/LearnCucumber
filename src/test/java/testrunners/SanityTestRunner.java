package testrunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources",
        glue = { "stepdefs", "testbase" },
        monochrome = true,
        plugin = { "pretty",
                "html:target",
                "json:target/cucumber.json",
                "logging.CustomTagsFormatter:target/tags.txt"
        },
        tags = { "(@Sanity or @Regression)"},
        strict = true
)

public class SanityTestRunner extends AbstractTestNGCucumberTests {


    @BeforeSuite
    public void beforeSuite(ITestContext context)
    {
        System.out.println(context.getCurrentXmlTest().getSuite().getName() +" : suite execution started");
    }

    @AfterSuite
    public void afterSuite(ITestContext context)
    {
        System.out.println(context.getCurrentXmlTest().getSuite().getName() +" : suite execution finished");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

