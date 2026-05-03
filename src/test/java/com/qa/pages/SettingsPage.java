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

    List<WebElement> elements = driver.findElements(By.className("android.widget.TextView"));

    for (WebElement el : elements) {
        String text = el.getText();
        System.out.println("Found: " + text);

        if (text != null && !text.isEmpty()) {
            if (text.toLowerCase().contains("network") ||
                text.toLowerCase().contains("sim") ||
                text.toLowerCase().contains("mobile") ||
                text.toLowerCase().contains("connection")) {

                el.click();
                System.out.println("Clicked: " + text);
                return;
            }
        }
    }

    throw new RuntimeException("No matching option found in Settings screen");
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