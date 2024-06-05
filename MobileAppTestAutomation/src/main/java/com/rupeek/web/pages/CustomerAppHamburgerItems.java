package com.rupeek.web.pages;

import com.rupeek.web.LocatorType;
import com.rupeek.web.locator.Locator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;


public class CustomerAppHamburgerItems extends BasePage{

    private static final Logger logger = LogManager.getLogger(CustomerAppHamburgerItems.class);
    Waits wait ;
    Swipes swipe;

    public CustomerAppHamburgerItems(AppiumDriver driver) {
        super(driver);
        this.wait = new Waits(driver);
        this.swipe = new Swipes(driver);

    }

    public void clickOnHamburgerThenClickPage(String page) throws Throwable{
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ACCESSIBILITY_ID, "hamburger")).click();
        WebElement icon =  driver.findElementById("com.rupeek.customer.debug:id/" +page);
        icon.click();
    }

    public boolean referAndEarnPageAppears() throws Throwable {
        Thread.sleep(5000);
        WebElement referAndEarnPage = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "referAndEarn"));
        return referAndEarnPage.isDisplayed();
    }

    public boolean userRefersHisFriend() throws Throwable {
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("Via Phone No.").click();
        List<WebElement> friendsNamePhone = findElements(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "editText"));
        friendsNamePhone.get(0).click();
        friendsNamePhone.get(0).sendKeys("test");
        friendsNamePhone.get(1).click();
        friendsNamePhone.get(1).sendKeys("9131935864");
        driver.findElementByAccessibilityId("Refer Now").click();
        return (/*driver.findElementByAccessibilityId("We have sent an invite to\n" +
                "test\n" +
                "Your friend will receive an SMS from Rupeek, please ask them to click on the link to claim the bonus.").isDisplayed() ||*/ driver.findElementByAccessibilityId("Share Rupeek App").isDisplayed());
    }
    public void clickOnHamburgerThenClickSectionOnNewHomeScreen(String page) throws Throwable {
        findElement((Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "hamburgerOnNewHomeScreen"))).click();
        driver.findElementByAccessibilityId(page).click();
    }
        public boolean articlesPageAppears() throws Throwable {
            WebElement articlesPage = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "articles"));
            return articlesPage.isDisplayed();
        }
}