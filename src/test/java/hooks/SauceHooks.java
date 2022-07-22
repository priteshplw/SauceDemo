package hooks;

import com.util.ConfigReader;
import com.util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class SauceHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties properties;

    @Before(order=0)
    public void getProperty(){
        configReader=new ConfigReader();
        properties=configReader.initProperties();
    }
    @Before(order = 1, value = "@UITest")
    public void launchBrowser(){
        driverFactory=new DriverFactory();
        driver=driverFactory.init_driver(properties.getProperty("browser"));
    }
    @After(order = 0, value = "@UITest")
    public void closeBrowser(){
        driver.quit();
    }
    @After(order = 1, value = "@UITest")
    public void takeScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            //take screenshots
            String name=scenario.getName().replaceAll("","_");
            byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",name);
        }
    }
}
