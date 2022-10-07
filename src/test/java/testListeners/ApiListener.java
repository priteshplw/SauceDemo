package testListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.util.ExtentUtil;
import hooks.SauceHooks;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ApiListener implements ITestListener {
//    ExtentUtil extentUtil;

    @Override
    public void onStart(ITestContext context) {
//        ITestListener.super.onStart(context);
//        this.extentUtil= SauceHooks.extentUtil;
    }

    @Override
    public void onTestStart(ITestResult result) throws NullPointerException{
//        ITestListener.super.onTestStart(result);
//        System.out.println(extentUtil.getExtentTest());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
//        ITestListener.super.onTestSkipped(result);
//        extentUtil.getExtentTest().skip(result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result)throws NullPointerException {
     //   ITestListener.super.onTestFailure(result);
//        System.out.println(result.getThrowable());
//        extentUtil.getExtentTest().fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
//        extentUtil.extentFlush();
    }
}
