package com.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtil {
    final ExtentReports extent;
    final ExtentSparkReporter reporter;
    ThreadLocal<ExtentTest> extentTest;

    public ExtentUtil() {
        reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\target\\reports\\index.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        reporter.config().setReportName("Config Web Automation Results");
        reporter.config().setDocumentTitle("Configured Results");
        extent.setSystemInfo("Tester", "Pritesh");
        extentTest=new ThreadLocal<>();
    }

    public ExtentReports getExtent() {
        return extent;
    }

    public ExtentTest getExtentTest() {
        return extentTest.get();

    }

    public void setExtentTest(ExtentTest exTest) {
       extentTest.set(exTest);
    }
    public void extentFlush(){
        extent.flush();
    }
}
