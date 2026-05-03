package com.qa.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
protected AndroidDriver driver;  // 🔥 IMPORTANT

    @BeforeMethod   // 🔥 use BeforeMethod (better for stability)
    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName("Android Device");
        options.setUdid("10BE1T1B93000Y0");
        options.setAutomationName("UiAutomator2");

       options.setAppPackage("com.android.settings");
options.setAppActivity("com.android.settings.Settings");

        options.setNoReset(true);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}