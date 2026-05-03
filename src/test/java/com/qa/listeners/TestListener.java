package com.qa.listeners;

import com.qa.utils.ExtentManager;
import com.qa.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver; // ✅ IMPORTANT IMPORT
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        Object testClass = result.getInstance();

        try {
            // ✅ Fetch driver from BaseTest using reflection
            WebDriver driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getField("driver")
                    .get(testClass);

            // ✅ FIX: method name should match your util
            String path = ScreenshotUtils.capture(driver, result.getMethod().getMethodName());

            // ✅ Null safety (prevents your previous crash)
            if (path != null && !path.isEmpty()) {
                test.addScreenCaptureFromPath(path);
            } else {
                test.warning("Screenshot not captured");
            }

        } catch (Exception e) {
            e.printStackTrace();
            test.warning("Screenshot failed due to exception");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}