package tests;

import base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.DriverFactory;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        if (currentClass instanceof BaseTest) {
            BaseTest base = (BaseTest) currentClass;
            ScreenshotUtil.captureScreenshot(base.driver, result.getName());
        }
    }

    // You can override other methods too: onTestSuccess, onTestStart, etc.
}
