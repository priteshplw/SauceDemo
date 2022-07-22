package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {
        String dir=System.getProperty("user.dir")+"/src/test/resources/drivers/";
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",dir+"chromedriver.exe");
            driver = new ChromeDriver();
            tlDriver.set(driver);
        } else if (browser.contains("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.contains("egde")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("No browser configuration matched");
        }

        tlDriver.get().manage().window().maximize();
        tlDriver.get().manage().deleteAllCookies();
        return tlDriver.get();
    }

    public WebDriver getDriver() {
        return tlDriver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
