package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/APITesting/REQRES",
        glue = {"stepDefinations/api/reqres"},plugin = "json:target/jsonReports/APIReport.json",
         tags = "@check",
        publish=true
)
public class APITestNGRunner extends AbstractTestNGCucumberTests {
}
