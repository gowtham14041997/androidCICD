package com.rupeek.web.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage extends BasePage{
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

   Waits wait ;
    Swipes swipe = new Swipes(driver);

    public HomePage(AppiumDriver driver) {
        super(driver);
        this.wait = new Waits(driver);

    }



}
