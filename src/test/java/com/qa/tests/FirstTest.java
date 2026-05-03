package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.SettingsPage;
import com.qa.base.BaseTest;
public class FirstTest extends BaseTest {

@Test
public void openSettingsTest() {
    System.out.println("Settings launched successfully");
}
}