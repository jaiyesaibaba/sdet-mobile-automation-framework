package com.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class WaitUtils {

    AndroidDriver driver;

    public WaitUtils(AndroidDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}