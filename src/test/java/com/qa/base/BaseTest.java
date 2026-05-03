package com.qa.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.List;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName("Android Emulator");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true);

        // 🚀 Start Appium session
        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        // 🔥 FORCE OPEN SETTINGS APP (works on all devices including Vivo)
        driver.executeScript("mobile: shell", Map.of(
                "command", "am",
                "args", List.of("start", "-a", "android.settings.SETTINGS")
        ));

        // ⏱ Wait setup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("✅ Settings app launched successfully");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}