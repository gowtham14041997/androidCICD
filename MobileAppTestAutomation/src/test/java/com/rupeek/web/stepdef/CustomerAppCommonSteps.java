package com.rupeek.web.stepdef;



import base.BaseTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.rupeek.web.db.CoreDB;
import com.rupeek.web.pages.*;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static com.rupeek.web.db.CoreDB.*;


public class CustomerAppCommonSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(CustomerAppCommonSteps.class);
    private static CustomerApp customerApp;
    private static Common common;
    private static Waits wait;

    private static CoreDB coreDB;


    static {
        try {
            driverIsConfigured();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    @Given("RupeekApp is opened")
    public void homePageIsLoaded() throws Throwable {
        driverIsConfigured();
        String appID = null;
        if (driver != null) {
            try {
                if (driver instanceof AndroidDriver) {
                    appID = (String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE);
                } else if (driver instanceof IOSDriver) {
                    appID = String.valueOf(driver.getCapabilities().getCapability(IOSMobileCapabilityType.BUNDLE_ID));
                } else {
                    LOGGER.info("unknown driver type");
                    Assert.fail();

                }
                if (appID != null){
                    driver.terminateApp(appID);
                    driver.activateApp(appID);
                }
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
            }
        }
        customerApp = new CustomerApp(driver);
        common = new Common(driver);
        wait = new Waits(driver);
        customerApp.selectDesiredEnv("PRODUCTION");
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Given"), "RupeekApp is opened"));
    }

    @When("User enters {string} phone number")
    public void userEnterNumber(String number) throws Throwable {
        wait.implicitlyWait(10, driver);
        customerApp.userEnterPhoneNumber(number);

        //String referral = driver.findElementById("com.rupeek.customer.debug:id/referralCodeCBContainer").getText();

        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("When"), "User enters " + number + " phone number"));
    }

    @Then("User enters {string} name")
    public void userEnterName(String name) throws Throwable {
        wait.implicitlyWait(10, driver);
        customerApp.userEnterName(name);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User enters " + name + " name"));
    }


    @Then("User enters otp for sign up for {string}")
    public void userEntersOtpForSignUp(String phoneNumber) throws Throwable {
        wait.implicitlyWait(10, driver);
        String otp = common.getOtpFromAAARedis(phoneNumber, BaseTest.getEnvironmentProperty("redis.AAA.host"), BaseTest.getEnvironmentProperty("redis.AAA.port"), "customerApp");
        customerApp.userEntersOtpForSignUp(otp);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User successfully enters otp"));
    }

    @Then("User enters city {string} and reaches to homePage")
    public void userEntersBangaloreAndReachesHomePage(String city) throws Throwable {
        wait.implicitlyWait(10, driver);
        customerApp.userEntersDesiredCity(city);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User enters city " + city + " and reaches to homePage"));
    }

    @Then("user enters otp at login for {string}")
    public void iscorrectOtpgivenForLogin(String phone) throws Throwable {
        wait.implicitlyWait(10, driver);
        Assert.assertTrue(customerApp.iscorrectOtpPassedforLogin(phone));
        customerApp.enterPinPass();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "user enters otp at login for  " + phone));

    }

    @Then("App homepage is loaded")
    public void appHomepageIsLoaded() throws Throwable {
        wait.implicitlyWait(10, driver);
        Assert.assertTrue(customerApp.appHomepageIsLoaded());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "App homepage is loaded"));
    }

    @Then("validate all components of homePage")
    public void validateHomepageComponents() throws Throwable {
        wait.implicitlyWait(10, driver);
        Assert.assertTrue(customerApp.validateHomepageComponents());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "validate all components of homePage"));
    }

    @Then("user for {string} is deleted from core DB")
    public void deleteUserFromCoreDB(String number) throws Throwable {
        Assert.assertEquals(CoreDB.getInstance().deleteDocumentByPhone(number), 1);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "user for " + number + " is deleted from core DB"));
    }

    @Then("User enters city {string} and reaches to new homePage")
    public void userEntersCityAndReachesToNewHomePage(String city) throws Throwable {
        wait.implicitlyWait(10, driver);
        customerApp.userEntersDesiredCityforNewHomePage(city);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User enters city " + city + " and reaches to new homePage"));

    }

    @Then("validate all components of new home screen")
    public void validateNewHomeScreenComponents() throws Throwable {
        wait.implicitlyWait(10, driver);
        Assert.assertTrue(customerApp.validateNewHomeScreenComponents());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "validate all components of new homePage"));
    }

    @Then("App New homepage is loaded")
    public void appNewHomepageIsLoaded() throws Throwable {
        wait.implicitlyWait(5, driver);
        Assert.assertTrue(customerApp.appNewHomepageIsLoaded());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "App New homepage is loaded"));
    }

    @Then("reset the App")
    public void resetApp() {
        //driver.resetApp();
    }

    @And("User requests Rupeek Gold Card on new HomeScreen")
    public void userSelectsRupeekGoldCardOnNewHomeScreen() throws Throwable {
        wait.implicitlyWait(10, driver);
        customerApp.selectRupeekGoldCard();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User selects Rupeek Gold Card on new HomeScreen"));
    }

    @Then("Rupeek Gold Card request is submitted successfully")
    public void rupeekGoldCardRequestIsSubmittedSuccessfully() throws Throwable {
        wait.implicitlyWait(10, driver);
        Assert.assertTrue(customerApp.validateRupeekGoldCardRequest());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "Rupeek Gold Card request is submitted successfully"));

    }

    @And("Transaction is deleted for {string}")
    public void userAndTransactionAreDeleted(String phone) throws Throwable{
        wait.implicitlyWait(10, driver);
        coreDB = CoreDB.getInstance();
        String userId = coreDB.getUserIdByPhone(phone);
        String transactionId = coreDB.getTransactionId(userId);
        coreDB.archiveLoanRequest(transactionId);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "Transaction is deleted for" +phone));
    }
}
