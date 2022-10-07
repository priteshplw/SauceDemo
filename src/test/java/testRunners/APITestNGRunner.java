package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/APITesting/REQRES",
        glue = {"stepDefinations/api/reqres"},plugin = {"json:target/jsonReports/APIReport.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@check",
        publish=true
)
public class APITestNGRunner extends AbstractTestNGCucumberTests {
}
