package com.rupeek.web.pages;

import com.rupeek.web.locator.Locator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Swipes extends BasePage{
    private static final Logger logger = LogManager.getLogger(Swipes.class);
    Waits wait ;

    public Swipes(AppiumDriver driver) {
        super(driver);
        this.wait = new Waits(driver);
    }
    public Swipes(WebDriver webDriver) {
        super(webDriver);
        this.wait = new Waits(webDriver);
    }

    public void swipeDownByPixels(String pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,"+pixels+")", "");
    }

    public void swipeDownByPageHeight(String swipeHeight) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.hardWait(2000);
        if (swipeHeight.equals("half")){
            js.executeScript("window.scrollBy(0,document.body.scrollHeight/2)");
        }
        else if (swipeHeight.equals("full")){
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        }
    }


    public void swipeTillGivenElementIsFound(Locator locator) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i=0; i<=10; i++) {
            List<WebElement> element = findElements(locator);
            if (element.size()>0){
                break;
            }
            js.executeScript("window.scrollBy(0,600)");
            wait.hardWait(250);
        }
    }


    public void swipeMobileScreenSmall(String dir) {

        PointOption pointOptionStart, pointOptionEnd;

        Dimension dims = driver.manage().window().getSize();

        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        int mult = 2; // multiplier

        if(dir.equalsIgnoreCase("DOWN")){
            pointOptionEnd = PointOption.point(dims.width / 2, (dims.height / 2) - (dims.height / 2) / mult);
        }
        else if(dir.equalsIgnoreCase("UP")){
            pointOptionEnd = PointOption.point(dims.width / 2, (dims.height / 2) + (dims.height / 2) / mult);
        }
        else{
            pointOptionEnd = PointOption.point(dims.width / 2, (dims.height / 2) - (dims.height / 2) / mult);

        }
        try {
            new TouchAction(driver).press(pointOptionStart).waitAction().moveTo(pointOptionEnd).release().perform();
        }
        catch (Exception e){
            logger.info(e);
        }

    }
    public void swipeDownByPageHeightUI(String swipeHeight) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        wait.hardWait(2000);
        if (swipeHeight.equals("half")){
            js.executeScript("window.scrollBy(0,document.body.scrollHeight/2)");
        }
        else if (swipeHeight.equals("full")){
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        }
    }

}

