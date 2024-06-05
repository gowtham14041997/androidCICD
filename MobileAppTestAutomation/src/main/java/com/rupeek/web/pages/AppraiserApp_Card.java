package com.rupeek.web.pages;

import com.rupeek.web.APIService.AAARedis;
import com.rupeek.web.LocatorType;
import com.rupeek.web.locator.Locator;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class AppraiserApp_Card extends BasePage{
    private static final Logger LOGGER = LogManager.getLogger(AppraiserApp_TO.class);
    Waits wait;
    Swipes swipe = new Swipes(driver);
    WebDriverWait explicit = new WebDriverWait(driver, 30);
    HomePage_AppraiserApp homePage_appraiserApp= new HomePage_AppraiserApp(driver);

    public AppraiserApp_Card(AppiumDriver driver) {
        super(driver);
        this.wait = new Waits(driver);
    }


    public void CreditCardForm() throws MalformedURLException, DocumentException, InterruptedException {
        wait.implicitlyWait(90, driver);
        wait.hardWait(8000);
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"CreditCardForm")).click();
        wait.implicitlyWait(90, driver);
        homePage_appraiserApp.captureImage();
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeigh")).click();

    }

    public void creditCardDetails(String user) throws MalformedURLException, DocumentException, InterruptedException {
        wait.implicitlyWait(90, driver);
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"CreditCardDetails")).click();
        wait.implicitlyWait(90, driver);
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"EmailField")).sendKeys("rojalin.das@rupeek.com");
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"SendOtp")).click();
        wait.hardWait(1000);
        String otp= AAARedis.getInstance().getOtp("rojalin.das@rupeek.com",user);
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"OtpField")).sendKeys(otp);
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"VerifyOtp")).click();
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"Name")).sendKeys("Automation");
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"HouseNo")).sendKeys("223");
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"StreetName")).sendKeys("4th Cross");
        swipe.swipeMobileScreenSmall("DOWN");
        swipe.swipeMobileScreenSmall("DOWN");
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"Locality")).sendKeys("JPNagar");
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"City")).sendKeys("Bangalore");
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"State")).sendKeys("Karnataka");
        findElement(Locator.getLocatorFromXML("AppraiserAppGold", LocatorType.ID,"Pincode")).sendKeys("560078");

        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeigh")).click();

    }

}
