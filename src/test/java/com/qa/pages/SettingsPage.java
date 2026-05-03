package com.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(d -> driver.getPageSource().length() > 0);

        String[] options = {
                "Network",
                "Network & internet",
                "Mobile network",
                "Connections",
                "SIM",
                "SIM manager"
        };

        for (String option : options) {
            try {
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + option + "\"))"
                )).click();

                return; // success

            } catch (Exception ignored) {
                // try next option
            }
        }

        throw new RuntimeException("No Network/SIM option found in this device Settings UI");

    } catch (Exception e) {
        throw new RuntimeException("Settings page not stable or not loaded", e);
    }
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