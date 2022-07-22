package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class ElementUtil {
    private WebDriver driver;

    public ElementUtil(WebDriver driver1) {
        this.driver = driver1;
    }

    public void click(By obj) {
        driver.findElement(obj).click();
    }

    public void sendKeys(By obj, String str) {
        driver.findElement(obj).sendKeys(str);
    }

    public boolean isDisplayed(By obj) {
        return driver.findElement(obj).isDisplayed();
    }

    public String getText(By obj) {
        return driver.findElement(obj).getText();
    }

    public Dimension getSize(By obj) {
        return driver.findElement(obj).getSize();
    }

    public String getAttribute(By obj, String attr) {
        return driver.findElement(obj).getAttribute(attr);
    }

    public Boolean isSelected(By obj, String attr) {
        return driver.findElement(obj).isSelected();
    }

    public void submit(By obj) {
        driver.findElement(obj).submit();
    }
}
