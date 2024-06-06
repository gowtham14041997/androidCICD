package com.rupeek.web.pages;

import com.rupeek.web.LocatorType;
import com.rupeek.web.db.CoreDB;
import com.rupeek.web.locator.Locator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class CustomerApp extends BasePage{


    private static final Logger logger = LogManager.getLogger(CustomerApp.class);
    Waits wait ;
    Swipes swipe;

    public CustomerApp(AppiumDriver driver) {
        super(driver);
        this.wait = new Waits(driver);
        this.swipe = new Swipes(driver);

    }

    public void selectDesiredEnv(String env) throws Throwable{
        wait.implicitlyWait(10,driver);
        try{
            driver.findElement(By.id("android:id/button1")).click();
        }catch (Exception e){
            logger.info("Popup box not displayed");
        }
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "envSelectDropDown")).click();
        for (int i=1; i<10; i++){
            MobileElement x = (MobileElement) driver.findElementByXPath(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "envDropDownList").getLocatorValue()+"["+i+"]");
            if (x.getText().equals(env)){
                x.click();
                break;
            }
        }
    }

    public void userEnterPhoneNumber(String phone) throws Throwable{
        wait.implicitlyWait(10,driver);

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
        logger.info("get started buton clicked");

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "acceptTnCButton")).click();
        logger.info("terms and condition accepted");

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "entryTextBox")).sendKeys(phone);
        logger.info(phone + " number entered");

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
        logger.info("submit phone number button clicked");

    }

    public void userEnterName(String name) throws Throwable{
        wait.implicitlyWait(10,driver);

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "entryTextBox")).sendKeys(name);
        logger.info(name + " name entered");

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
        logger.info("submit name button clicked");
        //wait 31 seconds till auto fetching popup exists
        Thread.sleep(31000);
    }

    public void userEntersOtpForSignUp(String otp) throws  Throwable{
        wait.implicitlyWait(5,driver);

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "enterOtpManually")).click();
        logger.info("entering otp manually");

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "entryTextBox")).sendKeys(otp);
        logger.info(otp + " otp entered");

        Thread.sleep(5000);

    }

    public void userEntersDesiredCity(String city) throws Throwable{
        wait.implicitlyWait(5,driver);

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "selectCityWhileSignUp")).click();
        logger.info ("User selects city");

        //findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "enterCityWhileSignUp")).sendKeys(city);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "bangaloreCitySelectorxpath")).click();
        logger.info (" Bangalore is slsected as a city");

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "applyLater")).click();
        logger.info("CLick on apply later and will redirect to homescreen");
    }

    public void userEntersDesiredCityforNewHomePage(String city) throws Throwable{
        wait.implicitlyWait(5,driver);

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "selectCityWhileSignUp")).click();
        logger.info ("User selects city");

        //findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "enterCityWhileSignUp")).sendKeys(city);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "delhiCitySelectorXpath")).click();
        logger.info ("Delhi is selected as city");

        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "applyLater")).click();
        logger.info("CLick on apply later and will redirect to new home screen");
    }

    public boolean iscorrectOtpPassedforLogin(String phone) throws  Throwable{
        wait.hardWait(3000);
        String otp = "";
        logger.info(otp.toLowerCase());
        otp= CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
        WebElement textBox = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "entryTextBox"));
        textBox.clear();
        textBox.sendKeys(otp);
        try {
            wait.hardWait(5000);
            if (findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "entryTextBox")).isDisplayed());
            {
                wait.hardWait(26000);
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "resendOTP")).click();
                iscorrectOtpPassedforLogin(phone);
            }}catch (Exception e){
                logger.info(otp + " otp entered");
        }
        logger.info(otp + " otp entered");
        return true;

    }

    public void enterPinPass(){
        wait.implicitlyWait(10,driver);

        try {
            if (driver.findElement(By.id("com.rupeek.customer.debug:id/titleTv")).isDisplayed()) {
                driver.getKeyboard().pressKey(Keys.NUMPAD1);
                driver.getKeyboard().pressKey(Keys.NUMPAD2);
                driver.getKeyboard().pressKey(Keys.NUMPAD3);
                driver.getKeyboard().pressKey(Keys.NUMPAD4);
                logger.info("pin entered");
            } else {
                logger.info("pin not entered");
            }
        }
        catch (Exception e){
            logger.info("pin page did not appear");
        }

    }

    public boolean appHomepageIsLoaded() throws Throwable{
        wait.hardWait(5000);
        WebElement hamburger = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ACCESSIBILITY_ID, "hamburger"));
        //reaching fresh/TO loan options
        List<WebElement> loanOptions = findElements(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "atDoorStep"));

        for (int i=0; i<5; i++){
            if(loanOptions.size()>0){
                break;
            }
            swipe.swipeMobileScreenSmall("DOWN");
            swipe.swipeMobileScreenSmall("DOWN");
            Thread.sleep(1000);
        }
        //WebElement freshLoan = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "atDoorStep"));
        //WebElement takeOverloan = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "atBankBranch"));
        if (!hamburger.isDisplayed()){
            return false;
        }
        //return (freshLoan.isDisplayed() && takeOverloan.isDisplayed());
        return true;
    }

    public boolean validateHomepageComponents() throws Throwable{

        driver.findElement(By.id("com.rupeek.customer.debug:id/homeBannerMainView"));

        String goldGramText = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "goldGramText")).getText();

        String todaysGoldValue = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "todaysGoldValue")).getText();


        String bankBranch3KmText = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "bankBranch3KmText")).getText();


        swipe.swipeMobileScreenSmall("DOWN");
        swipe.swipeMobileScreenSmall("DOWN");

        WebElement csreview =  driver.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='com.rupeek.customer.debug:id/customerImageRl']/../../android.widget.TextView"));

        WebElement bringingTrustText = driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.rupeek.customer.debug:id/homeScreenll']/android.widget.TextView"));


        swipe.swipeMobileScreenSmall("DOWN");
        swipe.swipeMobileScreenSmall("DOWN");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);

        return bankBranch3KmText.contains("BANK BRANCH EVERY 3 KMS") && goldGramText.contains("Today's gold rate")
                && csreview.getText().contains("Customer Review") && bringingTrustText.getText().contains("Bringing the Trust of Banks\n" +
                " at your Doorstep")
                && todaysGoldValue.contains(strDate);
    }

    public boolean appNewHomepageIsLoaded() throws Throwable{
        wait.hardWait(5000);
        WebElement newHomeScreen = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "newHomeScreen"));
        return newHomeScreen.isDisplayed();
    }

    public boolean validateNewHomeScreenComponents() {
        WebElement help = driver.findElementByAccessibilityId("Help");

        //swipe.swipeMobileScreenSmall("DOWN");
        //swipe.swipeMobileScreenSmall("DOWN");

        WebElement atDoorstep =  driver.findElementByAccessibilityId("At Doorstep\n" +
                "Instant 30 Minutes");

        WebElement atBankBranch = driver.findElementByAccessibilityId("At Bank Branch\n" +
                "Within 3 kms");

        /*swipe.swipeMobileScreenSmall("DOWN");
        swipe.swipeMobileScreenSmall("DOWN");

        WebElement rupeeksEasy4StepProcess = findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "rupeeksEasy4StepProcess"));

        swipe.swipeMobileScreenSmall("DOWN");
        swipe.swipeMobileScreenSmall("DOWN");

        WebElement customerTestimonials = driver.findElementByAccessibilityId("Customer Testimonials");

        WebElement knowMoreAboutRupeekGoldLoans = driver.findElementByAccessibilityId("Know more about Rupeek Gold Loans");
*/
        return help.isDisplayed() && atDoorstep.isDisplayed() && atBankBranch.isDisplayed();

    }

    public boolean givenPageIsOpened(String page) throws Throwable{
        wait.implicitlyWait(30, driver);
        try{
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "popup")).click();

        }catch (Exception e){
            logger.info("Pop up not present");
        }
        switch (page){
            case "replay_loan":
                return (findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ACCESSIBILITY_ID, "releasePage")).isDisplayed());
            case "my_loan":
                return (findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "myLoans")).isDisplayed());
            case "payment_history":
                return (findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ACCESSIBILITY_ID, "paymentsHistory")).isDisplayed());
            case "partial release":
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "popUpPartRelease")).click();
                return (findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ACCESSIBILITY_ID, "partRelease")).isDisplayed());
            case "part payment":
                return (findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ACCESSIBILITY_ID, "partPaymentPage")).isDisplayed());
            case "pay interest":
                return (findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ACCESSIBILITY_ID, "payInterestPage")).isDisplayed());
            case "Renewal or Top Up":
                return (findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ACCESSIBILITY_ID, "renewLoanPage")).isDisplayed());
            case "Close Loan":
                return (findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ACCESSIBILITY_ID, "closeLoanPage")).isDisplayed());
                default:
                return false;
        }
    }

    public void performsTransaction(String action, String selectInsurance) throws Throwable {
        List<WebElement> loans = findElements(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "currentLoanCb"));
        loans.get(0).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "proceedButton")).click();
        if (action.equalsIgnoreCase("pays interest")) {
            try {
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "payInterest")).click();
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "continuePayButton")).click();
            }catch (Exception e){
                logger.info("Pay interest not present");
            }
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "payInterestBtn")).click();
            }
        if (action.equalsIgnoreCase("closes loan")) {
            try {
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "closeLoan")).click();
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "continuePayButton")).click();
            }catch (Exception e){
                logger.info("Close loan not present");
            }
            wait.hardWait(5000);
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "viewGold")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "closeGoldButton")).click();
            wait.hardWait(2000);
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "selectedCb")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "payAmountButton")).click();

        }

        if (action.equalsIgnoreCase("part payment")){
            try {
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "partPayment")).click();
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "continuePayButton")).click();
            }catch (Exception e ){
                logger.info("Part payment not present");
            }
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "paymentAmount")).sendKeys("100");
            wait.hardWait(2000);
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "continueToPay")).click();

        }


    }

    public void myLoansIsOpened() throws Throwable{
        List<WebElement> loanDetails = findElements(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "loans"));
        logger.info("Total loans present" +loanDetails.size());
        loanDetails.get(0).click();
        wait.hardWait(2000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "pledge")).click();
        wait.hardWait(2000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "back")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "back")).click();
    }

    public void validatePayments() throws Throwable{
        try{
                wait.implicitlyWait(5,driver);
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "paymentArrow")).click();
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "back")).click();


        }catch (Exception e){
            logger.info("Element not found");
        }
    }

    public void makePayment() throws Throwable{
        wait.implicitlyWait(30,driver);
        try {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "paymentMethod")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "proceedButton")).click();
        }catch (Exception e){
            logger.info("Above page is not present");
        }
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "netBanking")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "bank")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "payNow")).click();
        wait.hardWait(5000);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(254,2138)).perform();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "success")).click();
        //findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "failure")).click();
        wait.hardWait(5000);
        try {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
            wait.hardWait(5000);
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "proceedESign")).click();

        }catch (Exception e){
            logger.info("Back button not present in close loan success page");
        }

    }

    public void bookDeliverySlot(String type) throws Throwable{
        /*for (int i=0;i<5;i++)
            swipe.swipeMobileScreenSmall("UP");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "pendingActions")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
        */
        if (type.equalsIgnoreCase("Bank Branch")){
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "bankBranch")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();

        }
        else if (type.equalsIgnoreCase("Doorstep")) {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "doorStep")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "addNewAddress")).click();
            wait.hardWait(1000);
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "searchLocation")).sendKeys("560001");
            wait.hardWait(5000);
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "prediction")).click();
            wait.hardWait(5000);
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "houseNo")).sendKeys("64");
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "landMark")).sendKeys("Near Sheraton Grande");
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
            wait.hardWait(5000);
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "doorStep")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "address")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "payAmountButton")).click();

        }
        wait.hardWait(5000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "date")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "time")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();


    }

    public void clickQuickLink(String quickLink) throws Throwable{
        driver.findElement(By.xpath("//android.widget.TextView[@text=\""+quickLink+"\"]")).click();
    }

    public void releaseJewel() throws Throwable{
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "checkBox")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "continueButton")).click();
        wait.hardWait(5000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "goldForNewLoan")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "closeGoldButton")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "termsConditions")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "payForRelease")).click();
    }

    public void selectRupeekGoldCard() throws Throwable{
        try {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "closePIP")).click();
        }catch (Exception e)
        {
            logger.info("pip not present");
        }
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "rupeekGoldCard")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "applyGoldCard")).click();
        try {
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "continueGoldLoan")).click();
        }catch (Exception e){
            logger.info("Popup isn't present");
        }

    }

    public boolean validateRupeekGoldCardRequest() throws Throwable{
        return findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "goldCardConfirm")).isDisplayed();

    }

    public void eSignPledge() throws Throwable{
        wait.hardWait(3000);
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "proceed")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "aadhar")).sendKeys("2323322134532");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "getOTP")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "enterOTP")).sendKeys("1234");
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "verifyOTP")).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "continue")).click();
    }

    public void renewLoan(String bestValue, String selectInsurance) throws Throwable{
        List<WebElement> loans = findElements(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "currentLoanCb"));
        loans.get(0).click();
        findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "proceedButton")).click();

        try {
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.XPATH, "renewLoan")).click();
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "continuePayButton")).click();
            }catch (Exception e){
                logger.info("Renew loan not present");
            }
            wait.hardWait(20000);
            if (bestValue.equalsIgnoreCase("NoBestValue"))
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "selectRenewalScheme")).click();
            if (selectInsurance.equalsIgnoreCase("disabled"))
                findElement(Locator.getLocatorFromXML("customerApp", LocatorType.CLASS_NAME, "checkBox")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "knowMore")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "payAmountButton")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "termsConditions")).click();
            findElement(Locator.getLocatorFromXML("customerApp", LocatorType.ID, "defaultButton")).click();

    }
}
