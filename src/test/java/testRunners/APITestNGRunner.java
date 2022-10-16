package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/APITesting/REQRES", glue = {"stepDefinations/api/reqres"},
        plugin = {"json:target/jsonReports/APITest.json",
        "testng:target/xmlReports/APITest.xml"},
        tags = "APITEST"
)
public class APITestNGRunner extends AbstractTestNGCucumberTests {
}
