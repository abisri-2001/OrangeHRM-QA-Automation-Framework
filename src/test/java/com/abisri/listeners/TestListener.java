package com.abisri.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.abisri.base.BaseClass;
import com.abisri.utilities.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    ExtentReports extent =
            ExtentReportManager.getExtentReport();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        test.fail(result.getThrowable());

        System.out.println(
                "Test Failed: " + result.getName()
        );

        Object testInstance = result.getInstance();

        if (testInstance instanceof BaseClass) {

            BaseClass base =
                    (BaseClass) testInstance;

            try {

                base.captureScreenshot(result.getName());

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        extent.flush();
    }
}