package com.rupeek.web.pages;

import com.rupeek.web.LocatorType;
import com.rupeek.web.locator.Locator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.BaseTest.getEnvironmentProperty;

public class CmbTemplateHomePage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(CmbTemplateHomePage.class);

    Waits wait ;
    Swipes swipe = new Swipes(driver);

    public CmbTemplateHomePage(AppiumDriver driver) {
        super(driver);
        this.wait = new Waits(driver);

    }

    public void enterMobNumber(String phoneNumber) throws Throwable {
        wait.implicitlyWait(5, driver);
        findElement(Locator.getLocatorFromXML("CmbHomePage", LocatorType.ID, "firstLeadBox")).click();
        wait.hardWait(5000);
        driver.findElement(By.xpath("//section[contains(@class, 'popupWrapper')]//input[@id='mobile']")).sendKeys(phoneNumber);
        if (getEnvironmentProperty("platform").equals("ANDROID_WEB") && ((AndroidDriver)driver).isKeyboardShown()){
            driver.hideKeyboard();
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'popupInnerwrapper')]//button")));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

}
