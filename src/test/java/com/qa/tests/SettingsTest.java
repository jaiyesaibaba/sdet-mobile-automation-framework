package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.qa.pages.SettingsPage;
import com.qa.base.BaseTest;

public class SettingsTest extends BaseTest {

 @Test
public void verifyNetworkClick() {

    SettingsPage settingsPage = new SettingsPage(driver);

    settingsPage.clickNetwork();

    Assert.assertTrue(
            settingsPage.isNetworkPageDisplayed(),
            "Network screen not opened"
    );
}
}