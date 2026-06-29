package com.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestListeners implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListeners.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("Test failed: " + result.getName(), result.getThrowable());
        // e.g., take screenshot here if Selenium
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.warn("Test skipped: " + result.getName());
    }
}
