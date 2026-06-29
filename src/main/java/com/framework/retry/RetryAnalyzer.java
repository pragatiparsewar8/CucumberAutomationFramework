package com.framework.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int attempt = 1;
    private static final int MAX_ATTEMPTS = 2; // retry once

    @Override
    public boolean retry(ITestResult result) {
        if (attempt <= MAX_ATTEMPTS) {
            attempt++;
            return true;
        }
        return false;
    }
}
