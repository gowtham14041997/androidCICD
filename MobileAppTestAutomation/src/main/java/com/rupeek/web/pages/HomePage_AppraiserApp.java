package com.rupeek.web.pages;



import com.aventstack.extentreports.GherkinKeyword;
import com.google.common.collect.ImmutableMap;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import com.rupeek.web.APIService.ApiVerify;
import com.rupeek.web.LocatorType;
import com.rupeek.web.db.CoreDB;
import com.rupeek.web.locator.Locator;
import com.rupeek.web.service.Andromeda;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.TouchAction;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.android.nativekey.PressesKey;

import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.eo.Se;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.DocumentException;
import org.bson.Document;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;

import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;


import static base.BaseTest.getEnvironmentProperty;
import static io.appium.java_client.AppiumDriver.*;



public class HomePage_AppraiserApp extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(HomePage_AppraiserApp.class);

    Waits wait;
    Swipes swipe = new Swipes(driver);
    WebDriverWait explicit = new WebDriverWait(driver, 30);

    public HomePage_AppraiserApp(AppiumDriver driver) {
        super(driver);
        this.wait = new Waits(driver);
    }

    public void continueButtonIsClicked() throws Throwable {
        wait.implicitlyWait(3, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "continueButton")).click();
        wait.hardWait(2000);

    }

    public void OkButtonIsClicked() throws Throwable {
        wait.implicitlyWait(3, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "okButton")).click();
        wait.hardWait(2000);

    }

    public void selectEnv(String env) throws Throwable {
        wait.implicitlyWait(3, driver);
        explicit.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        driver.findElement(By.xpath("//*[@text='"+ env+"'and @class='android.widget.CheckedTextView']")).click();
       // findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "QAEnv")).click();
        wait.hardWait(2000);

    }

    public void ChangeButtonIsClicked() throws Throwable {
        wait.implicitlyWait(10, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "changeButton")).click();
        wait.hardWait(2000);


    }

    public void loginButtonIsClicked() throws Throwable {
        wait.implicitlyWait(3, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "LoginButton")).click();
        wait.hardWait(2000);

    }

    public void phoneNumberIsEntered(String phone) throws Throwable {
        wait.implicitlyWait(3, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "PhoneNumber")).sendKeys(phone);
        wait.hardWait(2000);

    }

    public void clickOnLogin() throws Throwable {
        wait.implicitlyWait(3, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "AgentLogin")).click();
        wait.hardWait(2000);

    }

    public void enterOTP(String otp) throws Throwable {
        wait.implicitlyWait(3, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "AgentOtp")).sendKeys(otp);
        wait.hardWait(8000);

    }

    public void cancelWarning() throws Throwable {
        wait.implicitlyWait(3, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CancelWarning")).click();
        wait.hardWait(1000);

    }

    public void clickOnFreshLoan() throws Throwable {
        wait.implicitlyWait(240, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "FreshLoan")).click();

    }

    public void swipeToStart() throws Throwable {
        wait.implicitlyWait(5, driver);
        WebElement startElement = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "Swipe"));
        WebElement endElement = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SwipeStart"));
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth();
        TouchAction action = new TouchAction(driver);
        action.longPress(ElementOption.element(startElement)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(ElementOption.element(endElement, 1036, 0)).release().perform();
    }

    public void addGrossWeight() throws Throwable {
        wait.implicitlyWait(120, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeight")).click();
        Thread.sleep(200);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImage")).click();
        wait.implicitlyWait(60, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
        wait.implicitlyWait(120, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
        wait.hardWait(5000);
        WebElement editWeight = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "EditWeight"));
        editWeight.sendKeys(String.valueOf(25));
        wait.hardWait(3000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeight")).click();

    }

    public void verifyCustomerOtp(String agentPhone) throws Throwable {
        wait.implicitlyWait(6, driver);
        String agentUserId = CoreDB.getInstance().getUserIdByPhone(agentPhone);
        String otp = CoreDB.getInstance().getOtpFromLoanRequest(agentUserId);
        WebElement otpBox = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CustomerOtp"));
        otpBox.sendKeys(otp);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "Verify")).click();
        wait.implicitlyWait(18, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinueToBank")).click();

    }

    public void validateTotalWeight() throws Throwable {
        wait.implicitlyWait(80, driver);
        String visibleWeight = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "VisibleWeight")).getText();
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeight")).click();
        wait.implicitlyWait(30, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeights")).click();
        wait.implicitlyWait(5, driver);
    }

    public void cleanTouchStone() throws Throwable {
        wait.implicitlyWait(10, driver);
        try {
            String question = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "TouchStoneQuestion")).getText();
            Assert.assertEquals("Do you want to capture touchstone?", question);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CleanTouchStoneYes")).click();
            wait.implicitlyWait(10, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitTouchStone")).click();
            Thread.sleep(200);
        }
        catch (Exception e){
            LOGGER.info("Touch stone question is not available");
        }
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImage")).click();
        wait.hardWait(6000);
        wait.implicitlyWait(120, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
        wait.hardWait(2000);
        wait.implicitlyWait(120, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
        wait.hardWait(5000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeight")).click();

    }


    public void clearNotification() throws Throwable {
        explicit.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.rupeek.rupeek_agent_android.debug:id/notification_id")));
        WebElement notification = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "Notification"));
        WebElement endElement = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "NotificationBar"));
        Dimension size = driver.manage().window().getSize();
        int x = size.getHeight();
        TouchAction action = new TouchAction(driver);
        action.longPress(ElementOption.element(notification)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(ElementOption.element(endElement, 0, x)).release().perform();

    }

    public void addJewel(int jewelNumber) throws Throwable {
        String approxLoan = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ApproxLoanEligibility")).getText();
        Assert.assertEquals("Approx Loan Eligibility - ₹0.00", approxLoan);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "AddJewelIcon")).click();
        driver.findElement(By.id("com.rupeek.rupeek_agent_android.debug:id/count_" + jewelNumber + "_tv")).click();
        wait.implicitlyWait(120, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureWeighScale")).click();
        wait.hardWait(9000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeigh")).click();
        wait.hardWait(7000);
        try {
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureWeighScale")).click();
            wait.hardWait(9000);
            System.out.println("touch stone");
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeigh")).click();
        } catch (Exception e) {
            LOGGER.info("1 jewel is required" );
        }
    }

    public void appriseTheJewel(int jewelCount,String loanType) throws Throwable {
        List<WebElement> cardsView = findElements(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.CLASS_NAME, "CardView"));
        Assert.assertEquals(jewelCount, cardsView.size() - 1);
        for (int i = 1; i <= jewelCount; i++) {
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "EditButton")).click();
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SelectJewel")).click();
            wait.implicitlyWait(10, driver);
            List<WebElement> jewels = findElements(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.CLASS_NAME, "JewelsType"));
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Kadaga")).click();
            wait.implicitlyWait(35, driver);
            if (loanType.equals("Takeover")) {
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "Caret")).click();
                wait.hardWait(200);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "Quantity")).click();
            }
            swipe.swipeMobileScreenSmall("DOWN");
            wait.implicitlyWait(25, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Gross")).sendKeys("25");
            wait.implicitlyWait(5, driver);
            if(loanType.equals("Takeover")){
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "StoneAdjustment")).sendKeys("1");
            }
            else {
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "StoneAdjust")).sendKeys("1");
            }
            wait.implicitlyWait(5, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AdjustmentComment")).sendKeys("comment");
            wait.implicitlyWait(5, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "Hallmark")).click();
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeigh")).click();
        }
        explicit.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.rupeek.rupeek_agent_android.debug:id/edit_btn")));
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeigh")).click();
        //wait.implicitlyWait(10, driver);
        wait.hardWait(4000);
        try {
            driver.switchTo().alert();
            String apprisalCompleted = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ApprisalComplete")).getText();
            Assert.assertEquals("Appraisal is completed successfully", apprisalCompleted);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ApprisalOk")).click();
        }
        catch (Exception e){
            LOGGER.info("Appraisal is auto completed");
        }

    }

    public void bankDetails(String pictureType, DataTable dataTable) throws Throwable {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String accountNumber = map.get("accountnumber");
        String benificiaryNumber = map.get("beneficiaryname");
        String bankName = map.get("bank");
        String ifsc = map.get("ifsc");
        explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.TextView' and @text='Bank Account Details']")));
        String bankDetailsPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "BankDetailsText")).getText();
        Assert.assertEquals("Bank Details", bankDetailsPage);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImage")).click();
        wait.implicitlyWait(2, driver);
        List<WebElement> pictureOptions = findElements(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "CheckBookOptions"));
        if (pictureType.equals("TakePicture")) {
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "TakePicture")).click();
        }
        else {
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "UploadFromGallery")).click();
        }
        wait.implicitlyWait(10, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
        System.out.println("Capture image clicked");
        wait.hardWait(5000);
        //wait.implicitlyWait(30, driver);
        System.out.println("waited");
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
        System.out.println("Not clicked");
        wait.hardWait(5000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AccountNumber")).sendKeys(accountNumber);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "ReEnterAccountNumber")).sendKeys(accountNumber);
        swipe.swipeMobileScreenSmall("DOWN");
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "BankName")).sendKeys(bankName);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "IFSCCode")).sendKeys(ifsc);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "BenificiaryName")).sendKeys(benificiaryNumber);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitBankDetails")).click();
        wait.implicitlyWait(200, driver);
    }

    public void fillKyc(DataTable dataTable,String addressType) throws Throwable {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String address = map.get("AddressProof");
        String id = map.get("IDProof");
        //String occupation = map.get("Occupation");
        String occupationDetails = map.get("OccupationDetails");
        String fatherName = map.get("FatherName");
        String motherName = map.get("MotherName");
        String mail = map.get("Email");
        String domain = map.get("Domain");


        String pageTitle = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "selectKycDocumentText")).getText();
        Assert.assertEquals("Select KYC Document",pageTitle);
        wait.hardWait(6000);
//        try {
            if(findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AddressProof")).isEnabled()){
                    findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CurrentAddress")).click();
                    findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AddressProof")).click();
                    wait.implicitlyWait(30, driver);
                    TouchAction option = new TouchAction(driver);
                    wait.hardWait(4000);
                    option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(236, 912))).waitAction().perform();
                    wait.hardWait(2400);
                    findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "IDproof")).click();
                    wait.hardWait(2300);
                    option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(195, 1330))).perform();
                    wait.hardWait(2300);
//                findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "House")).sendKeys("223");
//                wait.hardWait(200);
//                findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "Street")).sendKeys("street");
//                wait.hardWait(300);
//                findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "Locality")).sendKeys("locality");
//                swipe.swipeMobileScreenSmall("DOWN");
//                findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "City")).sendKeys("Bangalore");
//                findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "State")).sendKeys("Karnataka");
//                wait.hardWait(3000);
//                WebElement localAddress = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Localaddressproof"));
//                swipe.swipeMobileScreenSmall("DOWN");
//                findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "State")).sendKeys("560001");
                    // WebElement localAddress= findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Localaddressproof"));
//                JavascriptExecutor js= (JavascriptExecutor)driver;
//                js.executeScript("arguments[0].scrollIntoView(true);",localAddress);
//                localAddress.click();
//                wait.hardWait(2400);
//                option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(186,1094))).perform();
//                wait.hardWait(2400);
                    //swipe.swipeMobileScreenSmall("DOWN");
                    // wait.hardWait(2400);
                    WebElement occupation = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Occupation"));
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    // js.executeScript("arguments[0].scrollIntoView(true);",occupation);
                    occupation.click();
                    wait.hardWait(2400);
                    option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(141, 1786))).perform();
                    wait.hardWait(2400);
                    findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "OccupationDetail")).sendKeys("Teacher");
                    wait.hardWait(2000);
                    findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Qualification")).click();
                    wait.hardWait(2400);
                    option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(170, 1256))).perform();
                    wait.hardWait(2000);
                    swipe.swipeMobileScreenSmall("DOWN");
                    swipe.swipeMobileScreenSmall("DOWN");
                    swipe.swipeMobileScreenSmall("DOWN");
                    swipe.swipeMobileScreenSmall("DOWN");
                    wait.hardWait(2000);
                    findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "MaritalStatus")).click();
                    wait.hardWait(2200);
                    option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(153, 883))).perform();
                    wait.hardWait(2000);
                    findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "MonthlyIncome")).sendKeys("55000");
                    //swipe.swipeDownByPageHeight("full");

                    findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "FatherName")).sendKeys(fatherName);
                    findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "MotherName")).sendKeys(motherName);
                    findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "EmailId")).sendKeys(mail);
                    findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Domain")).click();
                    wait.hardWait(2000);
                    option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(763, 953))).perform();
                    wait.hardWait(1000);
//                }
//                else if(addressType.equals("Voter")) {
//
//
//
//                }


//                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Localaddressproof")).click();
//                wait.hardWait(2300);
//                option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(178,1633))).perform();
//                wait.hardWait(2300);
//                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Occupation")).click();
//                wait.hardWait(2300);
//                option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(162,953))).perform();
//                wait.hardWait(2300);
//                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "OccupationDetails")).sendKeys(occupationDetails);
//                //swipe.swipeMobileScreenSmall("DOWN");
////                swipe.swipeMobileScreenSmall("DOWN");
//                WebElement qualification = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Qualification"));
//                PointOption pointOptionStart, pointOptionEnd;
//                Dimension dims = driver.manage().window().getSize();
//                pointOptionStart = PointOption.point(0, 1696);
//                pointOptionEnd = PointOption.point(0, 522);
//                new TouchAction(driver).press(pointOptionStart).waitAction().moveTo(pointOptionEnd).release().perform();
//                //swipe.swipeMobileScreenSmall("DOWN");
//                qualification.click();
//                wait.hardWait(1000);
//                option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(240,870))).perform();
//                wait.hardWait(1000);
//                swipe.swipeMobileScreenSmall("DOWN");
//                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "MaritalStatus")).click();
//                wait.hardWait(2000);
//                option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(157,1036))).perform();
//                wait.hardWait(1000);
//                swipe.swipeMobileScreenSmall("DOWN");
//                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "MonthlyIncome")).sendKeys("55000");
//                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "FatherName")).sendKeys(fatherName);
//                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "MotherName")).sendKeys(motherName);
//                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "EmailId")).sendKeys(mail);
//                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Domain")).click();
//                wait.hardWait(2000);
//                option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(763,953))).perform();
//                wait.hardWait(1000);

            }
//        }
//        catch (Exception e){
//            wait.implicitlyWait(30, driver);
//            TouchAction option= new TouchAction(driver);
//            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "EmailId")).sendKeys(mail);
//            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Domain")).click();
//            option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(771,903))).perform();
//            wait.implicitlyWait(10, driver);
//        }
    }

    public void addNominee(DataTable dataTable) throws MalformedURLException, DocumentException, InterruptedException {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("NomineeName");
        String relation = map.get("RelationShip");
        String contact = map.get("Contact");
        String pincode = map.get("pincode");
        String country = map.get("Country");
        String state = map.get("State");
        String city = map.get("City");
        String address = map.get("Address");
        String aadhar = map.get("Aadhar");
        String pan = map.get("Pan");
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "AddNominee")).click();
        Thread.sleep(1000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "NomineeName")).sendKeys(name);
        LocalDate currentDate = LocalDate.now();
        LocalDate previousDate = currentDate.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        String formattedPreviousDate = currentDate.format(formatter);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "DOB")).click();
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "DOB")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"" + formattedPreviousDate + "\"]")).click();
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "okButton")).click();
        Thread.sleep(2000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "Relation")).click();
        wait.hardWait(500);
        TouchAction option= new TouchAction(driver);
        option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(245,1471))).perform();
        Thread.sleep(2000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "ContactNumber")).sendKeys(contact);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "CommutingAddress")).sendKeys(address);
        String pageTitle = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "NomineeDetailsText")).getText();
        Assert.assertEquals("Nominee Details",pageTitle);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();
        wait.hardWait(2000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();
        wait.hardWait(6000);
        String photoPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "CustomerPhotoPage")).getText();
        Assert.assertEquals("Customer Photo",photoPage);
        wait.implicitlyWait(60, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
        wait.hardWait(2000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
        wait.hardWait(2000);


    }
    public void verifyFingerPrint() throws MalformedURLException, DocumentException {
        wait.implicitlyWait(40, driver);
        String fingerPrintPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals("Verify Customer Fingerprint",fingerPrintPage);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.ID,"ScanFingerPrint")).click();
        String proceedMessage=findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.ID,"ProceedMessage")).getText();
        Assert.assertEquals("Please proceed by clicking Submit",proceedMessage);
        String kycStatus=findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.ID,"FingerPrintConfirm")).getText();
        Assert.assertEquals("Fingerprint verification successful\n" +
                "Aadhar and fingerprint matched",kycStatus);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.ID,"SubmitKyc")).click();

    }
    public void selectScheme(String loanType) throws MalformedURLException, DocumentException, InterruptedException {
        wait.implicitlyWait(60, driver);
        String loanPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals("Confirm Loan Amount",loanPage);
        Thread.sleep(3000);
        String amount=findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.ID,"EligibleLoanAmount")).getText();
        Assert.assertTrue(Integer.valueOf(amount)>0);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.ID,"ConfirmButton")).click();
        wait.implicitlyWait(300, driver);
        if (loanType.equals("Card")){
            String insuranceCheck=findElement(Locator.getLocatorFromXML("AppraiserAppGold",LocatorType.ID,"InsuranceCheck")).getText();
            Assert.assertEquals(insuranceCheck,"Are you sure you want to unselect the insurance?");
            findElement(Locator.getLocatorFromXML("AppraiserAppGold",LocatorType.ID,"Yes")).click();

        }
        String loanParcels =findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.ID,"LoanParcels")).getText();
        String[] parcels= loanParcels.split(" - ");
        int parcelCount= Integer.valueOf(parcels[1]);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.XPATH,"SchemeClick")).click();
        wait.implicitlyWait(240, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.XPATH,"SelectScheme")).click();
        wait.implicitlyWait(30, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.ID,"OkButton")).click();
        wait.implicitlyWait(30, driver);
        if(parcelCount==0) {
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "AddLoanParcel")).click();
            wait.implicitlyWait(30, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "AddParcel")).click();
            wait.implicitlyWait(20, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "RegisterPacket")).click();
            wait.implicitlyWait(20, driver);
            String question = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SmartDNAMessage")).getText();
            Assert.assertEquals("Do you want to mock smartdna response?", question);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "okButton")).click();
            //wait.implicitlyWait(20, driver);
            wait.hardWait(1000);
            //findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "QRCodeScan")).click();
            wait.hardWait(500);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "AssetCode")).sendKeys("5673");
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "send")).click();
            //driver.switchTo().alert();
            wait.implicitlyWait(30, driver);
            //findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "okButton")).click();

            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImage")).click();
            wait.implicitlyWait(60, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
            wait.implicitlyWait(120, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
            wait.implicitlyWait(300, driver);
            wait.hardWait(9000);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitPacket")).click();
            wait.implicitlyWait(30, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeigh")).click();
            wait.implicitlyWait(30, driver);
        }
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ActionDone")).click();
        wait.implicitlyWait(10, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "AlertYes")).click();
        wait.implicitlyWait(20, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ActionDone")).click();
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "okButton")).click();
        wait.implicitlyWait(20, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ApprisalForm")).click();
        wait.implicitlyWait(30, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImage")).click();
        wait.implicitlyWait(60, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
        wait.implicitlyWait(60, driver);
        //wait.hardWait(6000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
        wait.hardWait(9000);
        wait.implicitlyWait(18, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitPacket")).click();
        try{
            Boolean selected =findElement(Locator.getLocatorFromXML("AppraiserAppTO", LocatorType.ID, "NoButton")).isSelected();
            Assert.assertTrue(selected);
        }
        catch (Exception e){
            LOGGER.info("Radio button is not there");
        }
        wait.implicitlyWait(20, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeigh")).click();
        wait.implicitlyWait(20, driver);

    }
    public void verifyCashBack(String phone) throws MalformedURLException, DocumentException, InterruptedException {
        wait.implicitlyWait(90, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage",LocatorType.XPATH,"CashBackForm")).click();
        wait.implicitlyWait(30, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImage")).click();
        wait.implicitlyWait(60, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
        wait.implicitlyWait(120, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
        wait.hardWait(9000);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeigh")).click();

    }
    public void adminApproval() throws MalformedURLException, DocumentException, InterruptedException {
        wait.hardWait(3000);
        wait.implicitlyWait(120, driver);
        String approvalPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals("Admin Approval",approvalPage);
        String jewellery = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "JewelleryApproval")).getText();
        Assert.assertEquals("Jewellery Appraisal Pending",jewellery);
        String KycApproval = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "KycApproval")).getText();
        Assert.assertEquals("KYC Approval Pending",KycApproval);
    }
    public void confirmCurrentAddress() throws Throwable {
        wait.implicitlyWait(20, driver);
        try {
            String confirmAddressPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CustomerAddress")).getText();
            Assert.assertEquals("Confirm Address", confirmAddressPage);
            String confirmAddressQuestion = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmAddressQuestion")).getText();
            Assert.assertEquals("Is this the customer's current address?", confirmAddressQuestion);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmYes")).click();
        }
        catch (Exception e){
            LOGGER.info("KYC details are not filled");
        }

    }
    public void addPhotos(Double statusCode,DataTable dataTable, String phone) throws Throwable {
        wait.implicitlyWait(240, driver);
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("NomineeName");
        String relation = map.get("RelationShip");
        String contact = map.get("Contact");
        String pincode = map.get("pincode");
        String country = map.get("Country");
        String state = map.get("State");
        String city = map.get("City");
        String address = map.get("Address");
        String aadhar = map.get("Aadhar");
        String pan = map.get("Pan");
        String passport = map.get("Passport");
        String voter= map.get("Voter");
        String agentId = CoreDB.getInstance().getUserIdByPhone(phone);
        String userId = CoreDB.getInstance().getUserIdFromLoanRequest(agentId);
        Document customerProfile =CoreDB.getInstance().getCustomerProfile(userId);
        if(statusCode<=2.2) {
            try {
                String aadhaar = customerProfile.getString("aadharpic").toString();
                String customerSign = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "CustomerSign")).getText();
                Assert.assertEquals("Customer Signature", customerSign);
                wait.implicitlyWait(60, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
                wait.implicitlyWait(120, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
                //wait.implicitlyWait(10, driver);
                wait.hardWait(7000);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();
                wait.hardWait(7000);

            } catch (Exception e) {
                String aadhaarFront = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AadhaarCardFront")).getText();
                Assert.assertEquals("Aadhaar Card (Front Side)", aadhaarFront);
                wait.implicitlyWait(60, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
                wait.implicitlyWait(120, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
                // wait.implicitlyWait(10, driver);
                wait.hardWait(5000);
                String aadhaarBack = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AadhaarCardBack")).getText();
                Assert.assertEquals("Aadhaar Card (Back Side)", aadhaarBack);
                wait.implicitlyWait(60, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
                wait.implicitlyWait(120, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
                // wait.implicitlyWait(10, driver);
                wait.hardWait(5000);

                String aadhaarNumber = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AadhaarNumber")).getText();
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AadhaarNumber")).sendKeys(aadhar);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();
                String panFront = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "PanCardFront")).getText();
                Assert.assertEquals("Pan Card (Front Side)", panFront);
                wait.implicitlyWait(60, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
                wait.implicitlyWait(120, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
                wait.hardWait(5000);

                String panNumber = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "PanNumberPage")).getText();
                Assert.assertEquals("Pan number", panNumber);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AadhaarNumber")).sendKeys(pan);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();
                String customerSign = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "CustomerSign")).getText();
                Assert.assertEquals("Customer Signature", customerSign);
                wait.implicitlyWait(60, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
                wait.implicitlyWait(120, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
                wait.hardWait(7000);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ADDDocument")).click();
                wait.hardWait(2000);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "Passport")).click();
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "DocumentContinue")).click();

                wait.implicitlyWait(60, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
                wait.implicitlyWait(120, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
                //wait.hardWait(7000);
                wait.implicitlyWait(60, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
                wait.implicitlyWait(120, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
                wait.hardWait(7000);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AadhaarNumber")).sendKeys("jgfvic87");
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();
                wait.hardWait(300);
                String error =findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "InputError")).getText();
                Assert.assertEquals(error,"Passport number is invalid");
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "DocumentTextBox")).clear();
                wait.hardWait(200);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "DocumentTextBox")).sendKeys(passport);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();
                wait.hardWait(300);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ADDDocument")).click();
                wait.hardWait(2000);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "VoterId")).click();
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "DocumentContinue")).click();

                wait.implicitlyWait(60, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
                wait.implicitlyWait(120, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
                //wait.hardWait(7000);
                wait.implicitlyWait(60, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
                wait.implicitlyWait(120, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
                wait.hardWait(7000);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AadhaarNumber")).sendKeys("jgfvic87");
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();
                wait.hardWait(300);
                String voterError =findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "InputError")).getText();
                Assert.assertEquals(voterError,"Voter Id is invalid");
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "DocumentTextBox")).clear();
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "DocumentTextBox")).sendKeys(voter);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();
                wait.hardWait(300);
                Boolean breCheck=Boolean.parseBoolean(getEnvironmentProperty("bre_consent"));
                if(breCheck) {
                    WebElement breCheckBox = findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "BRECheck"));
                    Assert.assertTrue(breCheckBox.isDisplayed());
                    Assert.assertFalse(breCheckBox.isSelected());
                    breCheckBox.click();
                    wait.hardWait(200);
                   // Assert.assertTrue(breCheckBox.isSelected());
                }
                wait.hardWait(300);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ContinuetoKyc")).click();
                wait.hardWait(5000);

            }
        }
    }

    public boolean apprisalFormCompleted() throws Throwable {
        wait.implicitlyWait(7, driver);
        try {
            String page= findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
            if(page.equals("Confirm Loan Amount")) {
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            return true;
        }

    }
    public void verifySchemeOtp(String phone,String url) throws Throwable {
       // wait.implicitlyWait(10, driver);
        wait.hardWait(8000);
        String otp = ApiVerify.getSchemeOtp(phone,url);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CustomerOtp")).sendKeys(otp);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "VerifySchemeOtp")).click();
        wait.hardWait(20000);

    }

    public void completeAppraisal(Boolean esignEnable) throws MalformedURLException, DocumentException, InterruptedException {
        wait.hardWait(30000);
        //esignEnable=true;
        if(!esignEnable) {
            explicit.until(ExpectedConditions.elementToBeClickable(findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitPacket"))));
            String pledgeCardPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
            Assert.assertEquals("Pledge Card", pledgeCardPage);
            explicit.until(ExpectedConditions.elementToBeClickable(findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitPacket"))));
            wait.hardWait(3000);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitPacket")).click();
            String printMessage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SmartDNAMessage")).getText();
            wait.hardWait(2000);
            Assert.assertEquals("Are you sure that you have printed all the copies of Rupeek Pledge Card", printMessage);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "okButton")).click();
            wait.hardWait(2000);
        }
        String summaryPage = findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "GrossWeightTitle")).getText();
        Assert.assertEquals("Topup / Summary PC",summaryPage);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitPacket")).click();
        //Assert.assertEquals("Are you sure that you have printed all the copies of Rupeek Pledge Card",printMessage);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "okButton")).click();

    }
    public void capturePledgeCard(String phone, String loanType, boolean eSignEnable) throws Throwable {


        if(!eSignEnable) {
            wait.hardWait(7000);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "PledgeCard")).click();
            wait.hardWait(2000);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
            wait.implicitlyWait(120, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
            wait.hardWait(5000);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "KFS")).click();
            wait.implicitlyWait(10, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
            wait.implicitlyWait(120, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
            wait.hardWait(4000);
        }
        if(loanType.equals("Fresh")||loanType.equals("Card")) {
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "UnsecuredKFS")).click();
            wait.implicitlyWait(10, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
            wait.implicitlyWait(120, driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
            wait.hardWait(5000);
            swipe.swipeMobileScreenSmall("DOWN");
        }
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "SummaryPledgeCard")).click();
        wait.implicitlyWait(10, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
        wait.implicitlyWait(120, driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
        wait.hardWait(5000);
        swipe.swipeMobileScreenSmall("DOWN");
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ApproveMoneyTransfer")).click();

    }

    public void captureImage() throws MalformedURLException, DocumentException, InterruptedException {
        try {
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImage")).click();
        }
        catch (Exception e){
            LOGGER.info("Capture image is not available");
        }
        wait.implicitlyWait(10,driver);
        findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "CaptureImageButton")).click();
        wait.hardWait(2000);
        wait.implicitlyWait(20,driver);
        try {
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "ConfirmButton")).click();
        }
        catch (Exception e){
            LOGGER.info("Confirm button is not available");
        }
        wait.hardWait(10000);
    }

    public void fillKYCWithExistingData(DataTable dataTable,String phone) throws MalformedURLException, DocumentException, InterruptedException {
        String agentId = CoreDB.getInstance().getUserIdByPhone(phone);
        String userId = CoreDB.getInstance().getUserIdFromLoanRequest(agentId);
        Document customerProfile =CoreDB.getInstance().getCustomerProfile(userId);
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String occupationDetails = map.get("OccupationDetails");
        String fatherName = map.get("FatherName");
        String motherName = map.get("MotherName");
        String mail = map.get("Email");
        Boolean addressVerified = customerProfile.getBoolean("localproofverified");

//        if(addressVerified.equals(false)){
//            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "AddressProof")).click();
//            wait.implicitlyWait(30, driver);
//            TouchAction option= new TouchAction(driver);
//            wait.hardWait(4000);
//            option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(236,912))).waitAction().perform();
//
//        }


        try {
            String occupation= customerProfile.get("occupation").toString();
            System.out.println("Occupation is there");
        }
        catch (Exception e){
            TouchAction option = new TouchAction(driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Occupation")).click();
            wait.hardWait(1300);
            option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(162,953))).perform();
            wait.hardWait(1000);
        }
        try {
            String occupationDetail= customerProfile.get("industry").toString();
            System.out.println("Occupation details is there");

        }
        catch (Exception e){
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "OccupationDetails")).sendKeys(occupationDetails);
        }
        try {
            String qualification= customerProfile.get("qualification").toString();
            System.out.println("qualification details is there");
            TouchAction option = new TouchAction(driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Qualification")).click();
            wait.hardWait(500);
            option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(195,1591))).perform();


        }
        catch (Exception e){
            TouchAction option = new TouchAction(driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Qualification")).click();
            option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(195,1591))).perform();


        }
        try {
            String maritalstatus= customerProfile.get("maritalstatus").toString();
            System.out.println("maritalstatus details is there");
            TouchAction option = new TouchAction(driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "MaritalStatus")).click();
            wait.hardWait(500);
            option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(162,1898))).perform();

        }
        catch (Exception e){
            TouchAction option = new TouchAction(driver);
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "MaritalStatus")).click();
            option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(162,1898))).perform();


        }
        try {
            String monthlyincome= customerProfile.get("monthlyincome").toString();
            System.out.println("Occupation details is there");

        }
        catch (Exception e){
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "MonthlyIncome")).sendKeys("55000");
        }
        swipe.swipeMobileScreenSmall("DOWN");
        swipe.swipeMobileScreenSmall("DOWN");

        try {
            String father= customerProfile.get("fathername").toString();
            System.out.println("Occupation details is there");

        }
        catch (Exception e){
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "FatherName")).sendKeys(fatherName);
        }
        try {
            String mother= customerProfile.get("mothername").toString();
            System.out.println("Occupation details is there");

        }
        catch (Exception e){
            findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "MotherName")).sendKeys(motherName);
        }

       findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "EmailId")).sendKeys(mail);
       findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.XPATH, "Domain")).click();
       wait.hardWait(500);
       TouchAction option = new TouchAction(driver);
       option.tap(TapOptions.tapOptions().withPosition(new PointOption().withCoordinates(763,953))).perform();


    }


    public void submitMoneyTransfer() throws Throwable {
        try {
                wait.implicitlyWait(180, driver);
                findElement(Locator.getLocatorFromXML("AppraiserHomePage", LocatorType.ID, "SubmitWeigh")).click();

        }
        catch (Exception e){
            LOGGER.info("This is not money transfer page");
        }

    }
    public void esign(String esign, String phone) throws MalformedURLException, DocumentException, InterruptedException {
        wait.hardWait(30000);
        String eSingPage =findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "ESign")).getText();
        Assert.assertEquals(eSingPage,"ESign Flow");
        String header =findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "ESignHeader")).getText();
        //Assert.assertEquals(header,"Please get the following documents eSigned by the customer");
        String ESignSteps =findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "ESignSteps")).getText();
//        Assert.assertEquals(ESignSteps,"Process :\n" +
//                "1.When you press 'Start eSign Process' button, customer will get an SMS with esign-in link.\n" +
//                "\n" +
//                " 2.Ask the customer to click on the link and follow the process to sign the document.");
//        List<WebElement> images =findElements(Locator.getLocatorFromXML("AppraiserTO", LocatorType.XPATH, "EsignImage"));
//        Assert.assertEquals(images.size(),2);
        String esignResponse=Andromeda.getInstance().eSignStatus(phone);
        String status = JsonPath.read(esignResponse,String.format("$.data.status"));

        if(status.equals("PENDING")){
            //findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "EsignStart")).click();
            Andromeda.getInstance().initiateESign(phone);
        }

    }

    public void completeEsign() throws Throwable {
        wait.implicitlyWait(240, driver);
        findElement(Locator.getLocatorFromXML("AppraiserTO", LocatorType.ID, "ESIGNContinue")).click();
        wait.hardWait(6000);

    }


}

