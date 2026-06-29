package com.framework.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 10;
    private JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, 10);
    }

    // ✅ Overloaded wait if you want custom timeout
    protected WebDriverWait getWait(int timeoutSeconds) {
        return new WebDriverWait(driver,timeoutSeconds);
    }
    // ✅ Waits
    public void click(WebElement element) {
    	getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitForVisibility(WebElement element) {
    	getWait().until(ExpectedConditions.visibilityOf(element));
    }

    // ✅ JavaScriptExecutor helpers
    public void jsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollBy(int x, int y) {
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    // ✅ Screenshot utility
    public String takeScreenshot(String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path; // return screenshot path for reporting
    }
}
