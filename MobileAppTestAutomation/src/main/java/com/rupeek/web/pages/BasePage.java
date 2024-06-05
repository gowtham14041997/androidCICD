package com.rupeek.web.pages;

import com.rupeek.web.LocatorType;
import com.rupeek.web.locator.Locator;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BasePage {
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    public AppiumDriver driver;
    public  WebDriver webDriver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public WebElement findElement(Locator locator) {
        WebElement webElement;
        LOGGER.info("Finding Element : {} by : {}", locator.getLocatorValue(), locator.getLocatorType());
        try {
            switch (locator.getLocatorType()) {
                case ID:
                    webElement = driver.findElement(By.id(locator.getLocatorValue()));
                    break;
                case CSS_SELECTOR:
                    webElement = driver.findElement(By.cssSelector(locator.getLocatorValue()));
                    break;
                case XPATH:
                    webElement = driver.findElement(By.xpath(locator.getLocatorValue()));
                    break;
                case NAME:
                    webElement = driver.findElement(By.name(locator.getLocatorValue()));
                    break;
                case CLASS_NAME:
                    webElement = driver.findElement(By.className(locator.getLocatorValue()));
                    break;
                case LINK_TEXT:
                    webElement = driver.findElement(By.linkText(locator.getLocatorValue()));
                    break;
                case PARTIAL_LINK_TEXT:
                    webElement = driver.findElement(By.partialLinkText(locator.getLocatorValue()));
                    break;
                case TAG_NAME:
                    webElement = driver.findElement(By.tagName(locator.getLocatorValue()));
                    break;
                case ACCESSIBILITY_ID:
                    webElement = driver.findElementByAccessibilityId(locator.getLocatorValue());
                    break;
                default:
                    LOGGER.error("Invalid Locator Type : {}", locator.getLocatorValue());
                    throw new RuntimeException("Invalid Locator Type");
            }
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.error("Element : {} is not found", locator.getLocatorValue());
            throw noSuchElementException;
        } catch (ElementNotVisibleException elementNotVisibleException) {
            LOGGER.error("Element : {} is not visible", locator.getLocatorValue());
            throw elementNotVisibleException;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            LOGGER.error("Element : {} is stale", locator.getLocatorValue());
            throw staleElementReferenceException;
        }
        return webElement;
    }

    public WebElement findElementInGivenWebElement(WebElement givenWebElement, Locator locator) {
        WebElement webElement;
        LOGGER.info("Finding Element : {} by : {}", locator.getLocatorValue(), locator.getLocatorType());
        try {
            switch (locator.getLocatorType()) {
                case ID:
                    webElement = givenWebElement.findElement(By.id(locator.getLocatorValue()));
                    break;
                case CSS_SELECTOR:
                    webElement = givenWebElement.findElement(By.cssSelector(locator.getLocatorValue()));
                    break;
                case XPATH:
                    webElement = givenWebElement.findElement(By.xpath(locator.getLocatorValue()));
                    break;
                case NAME:
                    webElement = givenWebElement.findElement(By.name(locator.getLocatorValue()));
                    break;
                case CLASS_NAME:
                    webElement = givenWebElement.findElement(By.className(locator.getLocatorValue()));
                    break;
                case LINK_TEXT:
                    webElement = givenWebElement.findElement(By.linkText(locator.getLocatorValue()));
                    break;
                case PARTIAL_LINK_TEXT:
                    webElement = givenWebElement.findElement(By.partialLinkText(locator.getLocatorValue()));
                    break;
                case TAG_NAME:
                    webElement = givenWebElement.findElement(By.tagName(locator.getLocatorValue()));
                    break;
                default:
                    LOGGER.error("Invalid Locator Type : {}", locator.getLocatorValue());
                    throw new RuntimeException("Invalid Locator Type");
            }
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.error("Element : {} is not found", locator.getLocatorValue());
            throw noSuchElementException;
        } catch (ElementNotVisibleException elementNotVisibleException) {
            LOGGER.error("Element : {} is not visible", locator.getLocatorValue());
            throw elementNotVisibleException;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            LOGGER.error("Element : {} is stale", locator.getLocatorValue());
            throw staleElementReferenceException;
        }
        return webElement;
    }

    public List<WebElement> findElements(Locator locator) {
        List<WebElement> webElementList;
        LOGGER.info("Finding Element : {} by : {}", locator.getLocatorValue(), locator.getLocatorType());
        try {
            switch (locator.getLocatorType()) {
                case ID:
                    webElementList = driver.findElements(By.id(locator.getLocatorValue()));
                    break;
                case CSS_SELECTOR:
                    webElementList = driver.findElements(By.cssSelector(locator.getLocatorValue()));
                    break;
                case XPATH:
                    webElementList = driver.findElements(By.xpath(locator.getLocatorValue()));
                    break;
                case NAME:
                    webElementList = driver.findElements(By.name(locator.getLocatorValue()));
                    break;
                case CLASS_NAME:
                    webElementList = driver.findElements(By.className(locator.getLocatorValue()));
                    break;
                case LINK_TEXT:
                    webElementList = driver.findElements(By.linkText(locator.getLocatorValue()));
                    break;
                case PARTIAL_LINK_TEXT:
                    webElementList = driver.findElements(By.partialLinkText(locator.getLocatorValue()));
                    break;
                case TAG_NAME:
                    webElementList = driver.findElements(By.tagName(locator.getLocatorValue()));
                    break;
                case ACCESSIBILITY_ID:
                    webElementList = driver.findElementsByAccessibilityId(locator.getLocatorValue());
                    break;
                default:
                    LOGGER.error("Invalid Locator Type : {}", locator.getLocatorValue());
                    throw new RuntimeException("Invalid Locator Type");
            }
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.error("Element : {} is not found", locator.getLocatorValue());
            throw noSuchElementException;
        } catch (ElementNotVisibleException elementNotVisibleException) {
            LOGGER.error("Element : {} is not visible", locator.getLocatorValue());
            throw elementNotVisibleException;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            LOGGER.error("Element : {} is stale", locator.getLocatorValue());
            throw staleElementReferenceException;
        }
        return webElementList;
    }

    public WebElement findWebElement(Locator locator) {
        WebElement webElement;
        LOGGER.info("Finding Element : {} by : {}", locator.getLocatorValue(), locator.getLocatorType());
        try {
            switch (locator.getLocatorType()) {
                case ID:
                    webElement = webDriver.findElement(By.id(locator.getLocatorValue()));
                    break;
                case CSS_SELECTOR:
                    webElement = webDriver.findElement(By.cssSelector(locator.getLocatorValue()));
                    break;
                case XPATH:
                    webElement = webDriver.findElement(By.xpath(locator.getLocatorValue()));
                    break;
                case NAME:
                    webElement = webDriver.findElement(By.name(locator.getLocatorValue()));
                    break;
                case CLASS_NAME:
                    webElement = webDriver.findElement(By.className(locator.getLocatorValue()));
                    break;
                case LINK_TEXT:
                    webElement = webDriver.findElement(By.linkText(locator.getLocatorValue()));
                    break;
                case PARTIAL_LINK_TEXT:
                    webElement = webDriver.findElement(By.partialLinkText(locator.getLocatorValue()));
                    break;
                case TAG_NAME:
                    webElement = webDriver.findElement(By.tagName(locator.getLocatorValue()));
                    break;
                default:
                    LOGGER.error("Invalid Locator Type : {}", locator.getLocatorValue());
                    throw new RuntimeException("Invalid Locator Type");
            }
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.error("Element : {} is not found", locator.getLocatorValue());
            throw noSuchElementException;
        } catch (ElementNotVisibleException elementNotVisibleException) {
            LOGGER.error("Element : {} is not visible", locator.getLocatorValue());
            throw elementNotVisibleException;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            LOGGER.error("Element : {} is stale", locator.getLocatorValue());
            throw staleElementReferenceException;
        }
        return webElement;
    }

    public List<WebElement> findWebElements(Locator locator) {
        List<WebElement> webElementList;
        LOGGER.info("Finding Element : {} by : {}", locator.getLocatorValue(), locator.getLocatorType());
        try {
            switch (locator.getLocatorType()) {
                case ID:
                    webElementList = webDriver.findElements(By.id(locator.getLocatorValue()));
                    break;
                case CSS_SELECTOR:
                    webElementList = webDriver.findElements(By.cssSelector(locator.getLocatorValue()));
                    break;
                case XPATH:
                    webElementList = webDriver.findElements(By.xpath(locator.getLocatorValue()));
                    break;
                case NAME:
                    webElementList = webDriver.findElements(By.name(locator.getLocatorValue()));
                    break;
                case CLASS_NAME:
                    webElementList = webDriver.findElements(By.className(locator.getLocatorValue()));
                    break;
                case LINK_TEXT:
                    webElementList = webDriver.findElements(By.linkText(locator.getLocatorValue()));
                    break;
                case PARTIAL_LINK_TEXT:
                    webElementList = webDriver.findElements(By.partialLinkText(locator.getLocatorValue()));
                    break;
                case TAG_NAME:
                    webElementList = webDriver.findElements(By.tagName(locator.getLocatorValue()));
                    break;
                default:
                    LOGGER.error("Invalid Locator Type : {}", locator.getLocatorValue());
                    throw new RuntimeException("Invalid Locator Type");
            }
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.error("Element : {} is not found", locator.getLocatorValue());
            throw noSuchElementException;
        } catch (ElementNotVisibleException elementNotVisibleException) {
            LOGGER.error("Element : {} is not visible", locator.getLocatorValue());
            throw elementNotVisibleException;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            LOGGER.error("Element : {} is stale", locator.getLocatorValue());
            throw staleElementReferenceException;
        }
        return webElementList;
    }


}