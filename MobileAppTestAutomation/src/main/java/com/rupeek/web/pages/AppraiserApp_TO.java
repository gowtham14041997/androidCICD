package com.rupeek.web.pages;

import com.rupeek.web.LocatorType;
import com.rupeek.web.locator.Locator;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AppraiserApp_TO extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(AppraiserApp_TO.class);
    Waits wait;
    Swipes swipe = new Swipes(driver);
    WebDriverWait explicit = new WebDriverWait(driver, 30);

    public AppraiserApp_TO(AppiumDriver driver) {
        super(driver);
        this.wait = new Waits(driver);
    }

    public void addPic() throws MalformedURLException, DocumentException, InterruptedException {
        wait.hardWait(7000);
        try {
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeight")).click();

        }
        catch (Exception e){
            System.out.println("Plus icon is not present");
        }
        Thread.sleep(200);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImage")).click();
        wait.implicitlyWait(60, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
        //wait.hardWait(3000);
        System.out.println("confirm wait");
        //wait.hardWait(10000);
        wait.implicitlyWait(180, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
        //wait.implicitlyWait(180, driver);
        System.out.println("confirm button is clicked");
        wait.hardWait(8000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeight")).click();
        wait.implicitlyWait(20, driver);

    }




    public void takeOverDocuments() throws Throwable {
        wait.implicitlyWait(10, driver);
        String documentPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals("Takeover Documents",documentPage);
        findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "Agreement")).click();
        wait.hardWait(10000);
        String agreementPicPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals("Agreement Pics",agreementPicPage);
         addPic();
         wait.hardWait(9000);
        String agreementPicPage1 = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals("Agreement Pics",agreementPicPage1);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeight")).click();
        findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "Cheque")).click();
        addPic();
        wait.hardWait(9000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeight")).click();
        wait.hardWait(5000);


    }

    public void startTheJourney() throws MalformedURLException, DocumentException, InterruptedException {
       String swipeMessage= findElement(Locator.getLocatorFromXML("AppraiserTO",LocatorType.ID,"SwipeMessage")).getText();
       Assert.assertEquals("Please swipe to start the trip to takeover branch",swipeMessage);
        String startTripPage= findElement(Locator.getLocatorFromXML("AppraiserTO",LocatorType.XPATH,"StartToBranch")).getText();
        Assert.assertEquals("Start to Competitor Branch",startTripPage);
    }

    public void endTheJourney() throws MalformedURLException, DocumentException, InterruptedException {
        String swipeMessage= findElement(Locator.getLocatorFromXML("AppraiserTO",LocatorType.ID,"SwipeMessage")).getText();
        Assert.assertEquals("Please swipe to end the trip at takeover branch",swipeMessage);
        String endTripPage= findElement(Locator.getLocatorFromXML("AppraiserTO",LocatorType.XPATH,"StartToBranch")).getText();
        Assert.assertEquals("Arrived at Competitor Branch",endTripPage);
    }


    public void takeOverCollection() throws MalformedURLException, DocumentException, InterruptedException {
        Thread.sleep(2000);
        String toCollectionPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals("Takeover Gold Collection",toCollectionPage);
        String collectMessage= findElement(Locator.getLocatorFromXML("AppraiserTO",LocatorType.ID,"ToCollectQuestion")).getText();
        Assert.assertEquals("Did you collect the gold?",collectMessage);
        findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "YesButton")).click();
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();

    }
    public void registerPacket() throws MalformedURLException, DocumentException, InterruptedException {
        Thread.sleep(2000);
        String registerPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals("Register Packet",registerPage);
        String registerMessage = findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "RegisterMessage")).getText();
        Assert.assertEquals("Please put all the jewels in a big packet. Please register the packet after applying SmartDNA and barcode on the packet ",registerMessage);
        String packets = findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "PacketCount")).getText();
        String[] count =packets.split(": ");
        int parcelCount= Integer.valueOf(count[1]);
        String customerPlace = findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "CustomerPlaceMessage")).getText();
        Assert.assertEquals("Are you doing appraisal in customer’s place (skip temp pledge card) ?",customerPlace);
        if(parcelCount==0) {
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "RegisterPacket")).click();
            wait.implicitlyWait(20, driver);
            String question = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SmartDNAMessage")).getText();
            Assert.assertEquals("Do you want to mock smartdna response?", question);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "okButton")).click();
            //wait.implicitlyWait(20, driver);
            wait.hardWait(1000);
           // findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "QRCodeScan")).click();
            wait.hardWait(500);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "AssetCode")).sendKeys("5673");
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "send")).click();
            wait.implicitlyWait(30, driver);
            //driver.switchTo().alert();
           // findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "okButton")).click();
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
            wait.implicitlyWait(120, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
            wait.implicitlyWait(100, driver);
           // driver.switchTo().alert();
        }
        String registerPacketPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals(registerPacketPage,"Register Packets");
        List<WebElement> packet = findElements(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "PacketCounts"));
        Assert.assertEquals(packet.size(),1);
        String packetNumber = findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "PacketNumber")).getText();
        findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "JewelAddButton")).isDisplayed();
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeight")).click();

    }

    public void TOReceipt() throws MalformedURLException, DocumentException, InterruptedException {
        wait.hardWait(5000);
        String toReceiptPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals(toReceiptPage,"Register Packet");
        try {
            findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "TickImage")).isDisplayed();
        }
        catch (Exception e){
            LOGGER.info("TO Receipt is not added");
            findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "TOReceipt")).click();
            new HomePage_AppraiserApp(driver).captureImage();
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeight")).click();

        }

        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CleanTouchStoneYes")).click();
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitPacket")).click();

    }
    public void submitPacket() throws MalformedURLException, DocumentException {
        String customerPlace = findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "CustomerPlaceMessage")).getText();
        Assert.assertEquals(customerPlace,"Are you doing appraisal in customer’s\n"+" place (skip temp pledge card) ?");
        findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "YesButton")).click();
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitPacket")).click();


    }


}
