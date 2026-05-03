package com.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
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

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    String[] options = {"Network", "SIM", "Connection"};

    for (String option : options) {
        try {
            // Scroll dynamically based on option
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().textContains(\"" + option + "\"))"));

            By locator = By.xpath("//*[contains(@text,'" + option + "')]");

            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            );

            element.click();

            System.out.println(" Clicked option: " + option);
            return;

        } catch (Exception e) {
            System.out.println(" Not found: " + option);
        }
    }

    throw new RuntimeException("No Network/SIM/Connection option found in Settings");
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