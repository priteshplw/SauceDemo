package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = {"stepDefinations","hooks"},
        plugin = {"json:target/jsonReports/UITest.json",
                "testng:target/xmlReports/UITest.xml"},
        tags = "@UITest"
)
public class SauceTestNGRunner extends AbstractTestNGCucumberTests {
}
