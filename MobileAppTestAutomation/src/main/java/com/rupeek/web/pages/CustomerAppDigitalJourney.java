package com.rupeek.web.pages;

import com.rupeek.web.LocatorType;
import com.rupeek.web.locator.Locator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class CustomerAppDigitalJourney extends BasePage{

    private static final Logger logger = LogManager.getLogger(CustomerAppDigitalJourney.class);
    Waits wait ;
    Swipes swipe;

    public CustomerAppDigitalJourney(AppiumDriver driver) {
        super(driver);
        this.wait = new Waits(driver);
        this.swipe = new Swipes(driver);
    }
    Actions actions = new Actions(driver);
    public Boolean userSelectsTOLoan(String type, String homescreen) throws Throwable{

        if (homescreen.equalsIgnoreCase("old")) {
            if (type.equalsIgnoreCase("doorstep"))
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "atDoorStep")).click();
            else
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "atBankBranch")).click();
        }
        else if (homescreen.equalsIgnoreCase("new")) {
            new TouchAction(driver).press(PointOption.point(500, 1454)).waitAction().moveTo(PointOption.point(500,1080)).release().perform();
            if (type.equalsIgnoreCase("doorstep"))
                driver.findElementByAccessibilityId("At Doorstep\n" +
                        "Instant 30 Minutes").click();
            else
                driver.findElementByAccessibilityId("At Bank Branch\n" +
                        "Within 3 kms").click();
        }
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "shiftgoldLoanCVContainer")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "applyNowBtn")).click();
        return findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "currentLoanDetailHeading")).getText().contains("Current Loan Detail");
    }

    public Boolean userFillsLoanInformation(String amount, String lender) throws Throwable{
        WebElement currentLoanAmount =  findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "currentLoanAmount"));
        actions.moveToElement(currentLoanAmount).click().perform();
        currentLoanAmount.sendKeys(amount);

        WebElement currentMonthlyInterestRate = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "currentMonthlyInterestRate"));
        actions.moveToElement(currentMonthlyInterestRate).click().perform();

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "currentMonthlyInterestRateOptions")).click();

        if (lender.equalsIgnoreCase("muthoot")){
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "muthoot")).click();
        } else if (lender.equalsIgnoreCase("manappuram")) {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "manappuram")).click();
        }
        else if (lender.equalsIgnoreCase("banks")) {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "banks")).click();
        }
        else {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "others")).click();
        }
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
        return findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "uploadLoanReceiptBanner")).isDisplayed();
    }

    public boolean userSkipsReceiptUpload() throws Throwable{
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "skipUploadLoanReceipt")).click();
        return findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "requestSuccessfulMessage")).getText().contains("Request Successful!");
    }

    public boolean userSelectsFreshLoan(String type, String homescreen) throws Throwable {
        if (homescreen.equalsIgnoreCase("old")) {
            if (type.equalsIgnoreCase("doorstep")) {
                swipe.swipeTillGivenElementIsFound(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "atDoorStep"));
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "atDoorStep")).click();
            }
                else
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "atBankBranch")).click();
        }
        else if (homescreen.equalsIgnoreCase("new")) {
            new TouchAction(driver).press(PointOption.point(500, 1454)).waitAction().moveTo(PointOption.point(500,1080)).release().perform();
            if (type.equalsIgnoreCase("doorstep"))
                driver.findElementByAccessibilityId("At Doorstep\n" +
                        "Instant 30 Minutes").click();
            else
                driver.findElementByAccessibilityId("At Bank Branch\n" +
                        "Within 3 kms").click();
        }
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "applyNowBtn")).click();
        return true;
    }

    public boolean userFillsLoanAmount(String amount, String type) throws Throwable {
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "loanAmountInputNativeView")).sendKeys(amount);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "proceedNativeView")).click();

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "pinCodeNativeView")).sendKeys("560001");
        wait.explicitWaitUntilElementToBeClickable(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "continueButtonNativeView"));
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "continueButtonNativeView")).click();
        wait.hardWait(20000);
        try{
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "doorstepNativeView")).click();
        }
        catch (Exception e){
            logger.info("Doorstep didn't display");
        }
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "proceedNativeView")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "addAddress")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "searchNativeView")).sendKeys("560001");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "BengaluruAddress")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "confirmAddress")).click();
        wait.hardWait(4000);
        if (type.equalsIgnoreCase("doorstep"))
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "houseNumber")).sendKeys("123");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "proceedNativeView")).click();
        return true;
    }

    public boolean userCancelsAppointment() throws Throwable{
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(529,664)).perform();
        wait.hardWait(3000);
        swipe.swipeMobileScreenSmall("DOWN");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "changeAppointment")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "cancelAppointment")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "cancelYes")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "cancelReason")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "reason")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "cancelAppointment")).click();
        return findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "cancelConfirm")).getText().contains("Appointment Cancelled");

    }

    public boolean userReschedulesAppointment() throws Throwable{
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(529,664)).perform();
        wait.hardWait(3000);
        swipe.swipeMobileScreenSmall("DOWN");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "changeAppointment")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "rescheduleAppointment")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "reason")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "rescheduleAppointment")).click();
        userSelectsSlot();
        if(findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "confirmMessage")).getText().contains("Reschedule Successful")){
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "done")).click();
            return true;
        }
        else return false;
    }

    public void userSelectsSlot() throws Throwable {
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "loanDates")).click();
        try {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "selectTimeSlot")).click();
            if (driver.findElement(By.id("com.rupeek.customer.debug:id/no_available_slot_title")).isDisplayed()) {
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "emergencySlot")).click();
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "slotTime")).click();
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "confirmBookingButton")).click();
            }
        } catch (Exception e) {
            try {
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "proceedNativeView")).click();
            } catch (Exception exception) {
                logger.info("Element not found");
            }
        }

    }

    public void digitalJourneyWebFlow(String loanType) throws Throwable{
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "editText")).clear();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "editText")).sendKeys("60000");
        wait.hardWait(5000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "confirmProceed")).click();
        wait.hardWait(5000);
        try{
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "goldLoanOnly")).click();
        }catch (Exception e){
            logger.info("Gold card selection page isn't present");
        }
        wait.hardWait(10000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "editText")).sendKeys("560001");
        wait.hardWait(2000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "continueGoldLoan")).click();
        wait.hardWait(10000);
        if (loanType.equalsIgnoreCase("Doorstep")){
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "doorStepWebView")).click();
        } else if (loanType.equalsIgnoreCase("Bank Branch")) {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "bankBranchWebView")).click();
        }
        if (loanType.equalsIgnoreCase("Doorstep") || loanType.equalsIgnoreCase("Bank Branch")) {
            for (int i = 0; i <= 2; i++)
                swipe.swipeMobileScreenSmall("DOWN");
            try {
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "popUpBlackCross")).click();
            } catch (Exception e) {
                logger.info("Popup isn't present");
            }
            for (int i = 0; i <= 3; i++)
                swipe.swipeMobileScreenSmall("DOWN");
        }
        wait.hardWait(2000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "scheduleAppointment")).click();
        try{
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "scheduleAppointment")).click();
        }catch (Exception e){
            logger.info("Location page appeared successfully");
        }

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "searchLocationWeb")).click();
        /*try {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "popUpBlackCross")).click();

        }catch (Exception e){
            logger.info("Popup isn't present");
        }*/
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "editText")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "editText")).sendKeys("560001");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "Bengaluru")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "confirmProceed")).click();
        try{
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "confirmProceed")).click();
        }catch (Exception e){
            logger.info("Address page is opened");
        }
        wait.hardWait(2000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "addressWeb")).sendKeys("123, abcd");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "landmarkWeb")).sendKeys("Near Railway Station");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "mobile")).sendKeys("8109231512");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "confirmProceed")).click();
        wait.hardWait(7000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "tomorrow")).click();
        wait.hardWait(2000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "morningSlot")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "confirmProceed")).click();
        wait.hardWait(4000);
        List<WebElement> checkboxes = findElements(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "checkBox"));
        for (WebElement checkbox: checkboxes)
            checkbox.click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "confirmProceed")).click();
        try{
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "confirmProceed")).click();
        }catch (Exception e){
            logger.info("Request submitted successfully");
        }

    }

}