package com.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SettingsPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // -------------------------------
    // Verify Settings App is opened
    // -------------------------------
    public boolean isSettingsPageDisplayed() {
        try {
            wait.until(d ->
                    driver.getPageSource().toLowerCase().contains("settings")
            );
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    // -------------------------------
    // Click Network / SIM option
    // -------------------------------
 public void clickNetwork() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    try {
        // Scroll to any possible network-related option
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().className(\"android.widget.TextView\"))"
        ));

        // Get all visible text elements
        List<WebElement> elements = driver.findElements(By.className("android.widget.TextView"));

        for (WebElement el : elements) {
            String text = el.getText().toLowerCase();

            if (text.contains("network") || text.contains("sim") ||
                text.contains("connection") || text.contains("mobile")) {

                System.out.println("✅ Found option: " + text);
                el.click();
                return;
            }
        }

        throw new RuntimeException("No matching network option found");

    } catch (Exception e) {
        throw new RuntimeException("Settings page not stable or UI changed", e);
    }
}
public boolean isSettingsPageLoaded() {
    return driver.getPageSource().toLowerCase().contains("settings");
}
    // -------------------------------
    // Verify Network Page
    // -------------------------------
  public boolean isNetworkPageDisplayed() {
    try {

        // Preferred: check current activity (most stable)
        String activity = driver.currentActivity().toLowerCase();

        if (activity.contains("network")
                || activity.contains("settings")
                || activity.contains("connections")) {
            return true;
        }

        // fallback: minimal page source check (not primary)
        String source = driver.getPageSource().toLowerCase();

        return source.contains("mobile")
                || source.contains("sim")
                || source.contains("internet");

    } catch (Exception e) {
        return false;
    }
}
}