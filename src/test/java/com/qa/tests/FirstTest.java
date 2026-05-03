package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.SettingsPage;
import com.qa.base.BaseTest;
public class FirstTest extends BaseTest {

   @Test
public void openSettingsTest() {

    SettingsPage settingsPage = new SettingsPage(driver);

    Assert.assertTrue(
            settingsPage.isSettingsPageDisplayed(),
            "Settings app not launched"
    );
}
}