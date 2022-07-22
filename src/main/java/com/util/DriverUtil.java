package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DriverUtil {
    private WebDriver driver;
    public DriverUtil(WebDriver driver1){
        this.driver=driver1;
    }
    public void get(String str){
        driver.get(str);
    }

    public WebElement findElement(By obj){
        return driver.findElement(obj);
    }
    public List<WebElement> findElements(By obj){
        return driver.findElements(obj);
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
