package com.qa.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static String capture(WebDriver driver, String testName) {

        try {
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String dir = System.getProperty("user.dir") + "/screenshots/";
            Files.createDirectories(Paths.get(dir));

            String path = dir + testName + ".png";

            Files.copy(src.toPath(), Paths.get(path));

            return path;

        } catch (Exception e) {
            e.printStackTrace();
            return null; // 🔥 IMPORTANT
        }
    }
}