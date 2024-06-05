package com.rupeek.web.pages;

import com.rupeek.web.LocatorType;
import com.rupeek.web.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waits {

    WebDriver driver;

    public Waits(WebDriver driver){
        this.driver = driver;
    }

    public void implicitlyWait(Integer seconds, WebDriver driver){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void hardWait(Integer milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
    }

    public void explicitWaitUntilElementToBeVisible(Locator locator){
        WebDriverWait webWait = new WebDriverWait(driver, 5);
        if (locator.getLocatorType() == LocatorType.ID) {
            webWait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator.getLocatorValue())));
        }
        else if(locator.getLocatorType() == LocatorType.XPATH){
            webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator.getLocatorValue())));
        }
    }

    public void explicitWaitUntilElementToBeClickable(Locator locator){
        WebDriverWait webWait = new WebDriverWait(driver, 5);
        if (locator.getLocatorType() == LocatorType.ID) {
            webWait.until(ExpectedConditions.elementToBeClickable (By.id(locator.getLocatorValue())));
        }
        else if(locator.getLocatorType() == LocatorType.XPATH){
            webWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getLocatorValue())));
        }
    }

    public WebElement getElementAfterExplicitWaitUntilClickable(Locator locator){
        WebDriverWait webWait = new WebDriverWait(driver, 5);
        if (locator.getLocatorType() == LocatorType.ID) {
            return webWait.until(ExpectedConditions.elementToBeClickable (By.id(locator.getLocatorValue())));
        }
        else if(locator.getLocatorType() == LocatorType.XPATH){
            return webWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getLocatorValue())));
        }
        return null;
    }

    public void explicitWaitUntilTextToBePresent(Locator locator, String text){
        WebDriverWait webWait = new WebDriverWait(driver, 5);
        if (locator.getLocatorType() == LocatorType.ID) {
            webWait.until(ExpectedConditions.textToBePresentInElement (driver.findElement(By.id(locator.getLocatorValue())), text) );
        }
        else if(locator.getLocatorType() == LocatorType.XPATH){
            webWait.until(ExpectedConditions.textToBePresentInElement (driver.findElement(By.xpath(locator.getLocatorValue())), text) );
        }
    }

}
