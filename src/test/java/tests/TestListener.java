package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.*;
import base.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestListener implements ITestListener {
    private static final ExtentReports extent = ExtentReportManager.getReporter();
    private static final Map<String, ExtentTest> testMap = new HashMap<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testMap.put(result.getMethod().getMethodName(), test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testMap.get(result.getMethod().getMethodName()).log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = testMap.get(result.getMethod().getMethodName());
        test.log(Status.FAIL, "Test failed: " + result.getThrowable());

        Object currentClass = result.getInstance();
        if (currentClass instanceof BaseTest) {
            BaseTest base = (BaseTest) currentClass;
            String screenshotPath = ScreenshotUtil.captureAndReturnPath(base.driver, result.getMethod().getMethodName());
            if (screenshotPath != null) {
                try {
                    test.addScreenCaptureFromPath(screenshotPath);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
