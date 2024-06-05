package com.rupeek.web.stepdef;

import com.aventstack.extentreports.GherkinKeyword;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.jayway.jsonpath.JsonPath;
import com.rupeek.web.APIService.ApiVerify;
import com.rupeek.web.db.AndromedaDB;
import com.rupeek.web.db.CoreDB;
import com.rupeek.web.pages.*;
import com.rupeek.web.service.Andromeda;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_lol.AN;
import io.cucumber.java.eo.Do;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class HomePageSteps_AppraiserApp extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(HomePageSteps_AppraiserApp.class);
    private static Waits wait;
    private static HomePage_AppraiserApp HomePage_AppraiserApp;
    private static AppraiserApp_TO appraiserAppTo;
    private static LoanAdminDashboard loanAdminDashboard;
    public static String agentPhone;
    private static AppraiserApp_Card appraiserApp_card;



    /* static {
        try {
            driverIsConfigured();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        wait = new Waits(driver);
    }*/
    @Given("Appraiser App homepage is loaded")
    public void AppraiserAppHomePageIsLoaded() throws Throwable {
        driverIsConfigured();
        driver.resetApp();
        HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
        appraiserApp_card= new AppraiserApp_Card(driver);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Given"), "Appraiser App homepage is loaded"));
        LOGGER.info("Appraiser App homepage is loaded");
    }


    @And("Continue Button is clicked")
    public void continueButtonIsClicked() throws Throwable {
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), String.format("Continue Button is clicked")));
        HomePage_AppraiserApp.continueButtonIsClicked();
        LOGGER.info("Continue Button is clicked");
    }

    @And("Ok Button is clicked")
    public void okButtonIsClicked() throws Throwable {
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), String.format("Ok Button is clicked")));
        //HomePage_AppraiserApp.selectEnv();
        HomePage_AppraiserApp.OkButtonIsClicked();
        LOGGER.info("Ok Button is clicked");

    }

    @And("Change Button is clicked")
    public void changeButtonIsClicked() throws Throwable {
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), String.format("Ok Button is clicked")));
        HomePage_AppraiserApp.ChangeButtonIsClicked();
        LOGGER.info("Ok Button is clicked");
    }

    @And("login button is clicked")
    public void loginButtonIsClicked() throws Throwable {
        HomePage_AppraiserApp.loginButtonIsClicked();
        LOGGER.info("Login Button is clicked");
    }

    @And("Agent enter phone number {string}")
    public void agentEnterPhoneNumber(String phone) throws Throwable {
        HomePage_AppraiserApp.phoneNumberIsEntered(phone);
        agentPhone = phone;
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent enter phone"+phone));

    }

    @And("Agent click on login")
    public void agentClickOnLogin() throws Throwable {
        HomePage_AppraiserApp.clickOnLogin();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent click on login"));
    }

    @Then("Agent {string} enter valid otp")
    public void agentEnterValidOtp(String phone) throws Throwable {
        String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
        HomePage_AppraiserApp.enterOTP(otp);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent enter valid otp"));

    }

    @Then("Agent cancel the warning popup")
    public void agentCancelTheWarningPopup() throws Throwable {
        HomePage_AppraiserApp.cancelWarning();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent click on login"));

    }

    @Then("Agent click on fresh loan")
    public void agentClickOnFreshLoan() throws Throwable {
        HomePage_AppraiserApp.clickOnFreshLoan();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent click on fresh loan"));

    }

    @Then("Agent swipe to start and end the journey")
    public void agentSwipeToStartAndEndTheJourney() throws Throwable {
        HomePage_AppraiserApp.swipeToStart();
        HomePage_AppraiserApp.swipeToStart();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent swipe to start and end the journey"));


    }

    @And("Agent add the gross weight")
    public void agentAddTheGrossWeight() throws Throwable {
        HomePage_AppraiserApp.addGrossWeight();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent add the gross weight"));

    }

    @Then("Agent {string} verify otp given by customer")
    public void agentVerifyOtpGivenByCustomer(String agentPhone) throws Throwable {
        HomePage_AppraiserApp.verifyCustomerOtp(agentPhone);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent swipe to start and end the journey"));

    }

    @And("Agent validate the gross weight and click on submit")
    public void agentValidateTheGrossWeightAndClickOnSubmit() throws Throwable {
        HomePage_AppraiserApp.validateTotalWeight();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent validate the gross weight and click on submit"));

    }

    @And("Agent clear the notification")
    public void agentClearTheNotification() throws Throwable {
        HomePage_AppraiserApp.clearNotification();


    }

    @And("Agent click touchstone")
    public void agentClickTouchstone() throws Throwable {
        HomePage_AppraiserApp.cleanTouchStone();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent click touchstone"));


    }

    @And("Agent add {int} jewel")
    public void agentAddJewel(int jewelNumber) throws Throwable {
        HomePage_AppraiserApp.addJewel(jewelNumber);

        HomePage_AppraiserApp.appriseTheJewel(1,"Fresh");

        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent add jewel"));

    }

    @And("Agent enters bank details by {string}")
    public void agentEntersBankDetailsBy(String pictureType, DataTable dataTable) throws Throwable {
        HomePage_AppraiserApp.bankDetails(pictureType, dataTable);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent enter bank details"));

    }

    @And("Agent fill KYC document details")
    public void agentFillKYCDocumentDetails(DataTable dataTable) throws Throwable {
       // HomePage_AppraiserApp.fillKyc(dataTable);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent fills kyc details"));

    }

    @And("Agent Adds Nominee details")
    public void agentAddsNomineeDetails(DataTable dataTable) throws MalformedURLException, DocumentException, InterruptedException, ClassNotFoundException {
        HomePage_AppraiserApp.addNominee(dataTable);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent add nominee details"));

    }

    @And("finger print is verified")
    public void fingerPrintIsVerified() throws MalformedURLException, DocumentException, ClassNotFoundException {
        HomePage_AppraiserApp.verifyFingerPrint();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Finger print is verified"));

    }

    @And("Agent select the scheme")
    public void agentSelectTheScheme() throws MalformedURLException, DocumentException, ClassNotFoundException, InterruptedException {

        //HomePage_AppraiserApp.selectScheme();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent add the scheme"));


    }


    @And("Agent {string} verify otp")
    public void agentVerifyOtp(String phone) throws MalformedURLException, DocumentException, InterruptedException, ClassNotFoundException {
        HomePage_AppraiserApp.verifyCashBack(phone);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent verify otp"));

    }

    @And("Agent is on admin approval page")
    public void agentIsOnAdminApprovalPage() throws MalformedURLException, DocumentException, ClassNotFoundException, InterruptedException {
        HomePage_AppraiserApp.adminApproval();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent is on admin approval page"));

    }

    @And("Kyc is approved on loan admin dashboard by {string}")
    public void kycIsApprovedOnLoanAdminDashboardBy(String phone,DataTable dataTable) throws IOException, DocumentException, InterruptedException, ClassNotFoundException {

        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String salutation = map.get("Salutation");
        String gender = map.get("Gender");
        String marriageStatus = map.get("MarriageStatus");
        String pan = map.get("Pan");
        Document agent = CoreDB.getInstance().getUserFromPhone(phone);
        String firstName = agent.get("firstname").toString();
        String lastName = agent.get("lastname").toString();
        String agentName = firstName + " " + lastName;

//        webDriverConfigured();
//        loanAdminDashboard= new LoanAdminDashboard(webDriver);
       // loanAdminDashboard.kycApproved(agentName,salutation,gender,marriageStatus,pan);
        Thread.sleep(3000);
        String laAdminUrl = getEnvironmentProperty("LA_Workflow");
        ApiVerify.approveEsign(phone,laAdminUrl,"Takeover");

        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Kyc is approved on loan admin dashboard"));

    }


    @And("{string} loan flow is apprised by LM {string} pictureType {string} with addressType {string}")
    public void loanFlowIsApprisedByLMPictureTypeWithAddressType(String loanType, String phone, String pictureType,String addressType, DataTable dataTable) throws Throwable {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String accountNumber = map.get("accountnumber");
        Document loanRequest = CoreDB.getInstance().getLoanRequest(phone);
        JsonObject loanInJson= new Gson().fromJson(loanRequest.toJson(), JsonObject.class);
        Boolean apprisalBeforeKyc = loanInJson.get("flags").getAsJsonObject().get("appraisalbeforekyc").getAsBoolean();
        String requestId = loanRequest.get("_id").toString();
        Double statusCode = Double.valueOf(CoreDB.getInstance().getLoanRequest(phone).get("statuscode").toString());
        agentPhone=phone;
        Document agent = CoreDB.getInstance().getUserFromPhone(agentPhone);
        String user= loanRequest.get("requester").toString();;
        String firstName = agent.get("firstname").toString();
        String lastName = agent.get("lastname").toString();
        String agentName = firstName + " " + lastName;
        String otpServiceUrl = getEnvironmentProperty("OTP_Service_baseUrl");
        String env = getEnvironmentProperty("RupeekWeb_Env");
        Boolean eSignEnable = loanInJson.get("flags").getAsJsonObject().get("isDocumentEsignEnabled").getAsBoolean();
        if(apprisalBeforeKyc.equals(false)) {
            if (statusCode == 1.41) {

                try{
                    CoreDB.getInstance().deleteCustomerProfile(accountNumber);

                }
                catch (Exception e){
                    System.out.println("Bank details not present");
                }

                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.swipeToStart();
                HomePage_AppraiserApp.swipeToStart();
                HomePage_AppraiserApp.verifyCustomerOtp(agentPhone);
                HomePage_AppraiserApp.bankDetails(pictureType,dataTable);

                //Document agent = CoreDB.getInstance().;

                HomePage_AppraiserApp.fillKyc(dataTable, addressType);
                HomePage_AppraiserApp.addNominee(dataTable);
                HomePage_AppraiserApp.addPhotos(statusCode,dataTable,phone);
                //HomePage_AppraiserApp.verifyFingerPrint();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);

                HomePage_AppraiserApp.appriseTheJewel(1,loanType);

                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    if(loanType.equals("Card"))
                    {
                        HomePage_AppraiserApp.selectScheme(loanType);
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    }
                    else{
                        HomePage_AppraiserApp.selectScheme(loanType);
                        HomePage_AppraiserApp.verifyCashBack(phone);
                    }
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);

                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,loanType);
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                   // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();




            } else if (statusCode == 1.6) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.swipeToStart();
                HomePage_AppraiserApp.verifyCustomerOtp(agentPhone);

                HomePage_AppraiserApp.bankDetails(pictureType,dataTable);
                HomePage_AppraiserApp.fillKyc(dataTable,addressType);
                HomePage_AppraiserApp.addNominee(dataTable);
                HomePage_AppraiserApp.addPhotos(statusCode,dataTable,phone);

                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);

                HomePage_AppraiserApp.appriseTheJewel(1,loanType);

                HomePage_AppraiserApp.verifyFingerPrint();
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    if(loanType.equals("Card"))
                    {
                        HomePage_AppraiserApp.selectScheme(loanType);
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    }
                    else{
                        HomePage_AppraiserApp.selectScheme(loanType);
                        HomePage_AppraiserApp.verifyCashBack(phone);
                    }
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);

                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,"Takeover");
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                   // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();


            } else if (statusCode == 1.9) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.verifyCustomerOtp(agentPhone);

                HomePage_AppraiserApp.bankDetails(pictureType,dataTable);
                HomePage_AppraiserApp.fillKyc(dataTable,addressType);
                HomePage_AppraiserApp.addNominee(dataTable);
                HomePage_AppraiserApp.addPhotos(statusCode,dataTable,phone);

                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,loanType);

                HomePage_AppraiserApp.verifyFingerPrint();
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    if(loanType.equals("Card"))
                    {
                        HomePage_AppraiserApp.selectScheme(loanType);
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    }
                    else{
                        HomePage_AppraiserApp.selectScheme(loanType);
                        HomePage_AppraiserApp.verifyCashBack(phone);
                    }
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);

                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,"Takeover");
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                   // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();

            }
            else if (statusCode == 2.1) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.bankDetails(pictureType,dataTable);
                HomePage_AppraiserApp.fillKyc(dataTable,addressType);
                HomePage_AppraiserApp.addNominee(dataTable);

                HomePage_AppraiserApp.addPhotos(statusCode,dataTable,phone);

                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,loanType);
                HomePage_AppraiserApp.verifyFingerPrint();
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    if(loanType.equals("Card"))
                    {
                        HomePage_AppraiserApp.selectScheme(loanType);
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    }
                    else{
                        HomePage_AppraiserApp.selectScheme(loanType);
                        HomePage_AppraiserApp.verifyCashBack(phone);
                    }
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);

                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,"Takeover");
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                    // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();


            }

            else if (statusCode == 2.2) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);

                String agentId = CoreDB.getInstance().getUserIdByPhone(phone);
                String userId = CoreDB.getInstance().getUserIdFromLoanRequest(agentId);
                Document customerProfile  = CoreDB.getInstance().getCustomerProfile(userId);
                Boolean ekycCollected = customerProfile.getBoolean("ekyccollected");
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
//                if (ekycCollected){
//                    HomePage_AppraiserApp.confirmCurrentAddress();
//                    HomePage_AppraiserApp.fillKYCWithExistingData(dataTable,phone);
//
//                }
//                else {
//                    HomePage_AppraiserApp.confirmCurrentAddress();
//                    HomePage_AppraiserApp.fillKyc(dataTable,addressType);
//                }
//                HomePage_AppraiserApp.confirmCurrentAddress();
                HomePage_AppraiserApp.fillKyc(dataTable,addressType);
//                HomePage_AppraiserApp.fillKYCWithExistingData(dataTable,phone);
                HomePage_AppraiserApp.addNominee(dataTable);
                HomePage_AppraiserApp.addPhotos(statusCode,dataTable,phone);
               // HomePage_AppraiserApp.verifyFingerPrint();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);

                HomePage_AppraiserApp.appriseTheJewel(1,loanType);

                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    if(loanType.equals("Card"))
                    {
                        HomePage_AppraiserApp.selectScheme(loanType);
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    }
                    else{
                        HomePage_AppraiserApp.selectScheme(loanType);
                        HomePage_AppraiserApp.verifyCashBack(phone);
                    }
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);

                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,"Takeover");
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                    // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();


            }
            else if (statusCode == 2.25) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();

               // HomePage_AppraiserApp.verifyFingerPrint();

                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,loanType);

                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    if(loanType.equals("Card"))
                    {
                        HomePage_AppraiserApp.selectScheme(loanType);
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    }
                    else{
                        HomePage_AppraiserApp.selectScheme(loanType);
                        HomePage_AppraiserApp.verifyCashBack(phone);
                    }
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);

                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,"Takeover");
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                    // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();


            }
            else if (statusCode == 2.3) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,loanType);
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    if(loanType.equals("Card"))
                    {
                        HomePage_AppraiserApp.selectScheme(loanType);
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    }
                    else{
                        HomePage_AppraiserApp.selectScheme(loanType);
                        HomePage_AppraiserApp.verifyCashBack(phone);
                    }
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);

                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,"Takeover");
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                    // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }

                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();

            }
            else if (statusCode == 2.35) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,loanType);
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    if(loanType.equals("Card"))
                    {
                        HomePage_AppraiserApp.selectScheme(loanType);
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    }
                    else{
                        HomePage_AppraiserApp.selectScheme(loanType);
                        HomePage_AppraiserApp.verifyCashBack(phone);
                    }
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);

                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,"Takeover");
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                    // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();
  

            }
            else if (statusCode == 2.36) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();

                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,loanType);

                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    if(loanType.equals("Card"))
                    {
                        HomePage_AppraiserApp.selectScheme(loanType);
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    }
                    else{
                        HomePage_AppraiserApp.selectScheme(loanType);
                        HomePage_AppraiserApp.verifyCashBack(phone);
                    }
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);

                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,"Takeover");
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                    // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();


            }
            else if (statusCode == 2.4) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    if(loanType.equals("Card"))
                    {
                        HomePage_AppraiserApp.selectScheme(loanType);
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    }
                    else{
                        HomePage_AppraiserApp.selectScheme(loanType);
                        HomePage_AppraiserApp.verifyCashBack(phone);
                    }
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);

                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,loanType);
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                    // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();


            }
            else if (statusCode == 2.42) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(!apprisalFormCompleted) {
                    if (loanType.equals("Card")) {
                        appraiserApp_card.CreditCardForm();
                        appraiserApp_card.creditCardDetails(user);

                    } else {
                        try {
                            HomePage_AppraiserApp.verifyCashBack(phone);
                        }
                        catch (Exception e){
                            System.out.println("Select scheme page is not available");
                            HomePage_AppraiserApp.verifyCashBack(phone);
                        }
                    }
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
                HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone,laAdminUrl,"Takeover");
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                    // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();

            }
            else if (statusCode == 2.5) {
                boolean kycApproved=false;
                try {
                     kycApproved =loanInJson.get("iskycapproved").getAsBoolean();

                }
                catch (Exception e){
                    System.out.println("KYC ot approved");
                }
                if(kycApproved){
                    webDriverConfigured();
                    Thread.sleep(3000);
                    loanAdminDashboard= new LoanAdminDashboard(webDriver);
                    loanAdminDashboard.JewelleryAppraisal(agentName);
                }
                else {
                    HomePage_AppraiserApp.ChangeButtonIsClicked();
                    HomePage_AppraiserApp.selectEnv(env);
                    HomePage_AppraiserApp.OkButtonIsClicked();
                    HomePage_AppraiserApp.loginButtonIsClicked();
                    HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                    HomePage_AppraiserApp.clickOnLogin();
                    agentPhone = phone;
                    String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                    HomePage_AppraiserApp.enterOTP(otp);
                    HomePage_AppraiserApp.clickOnFreshLoan();
                    HomePage_AppraiserApp.adminApproval();
                    resetApp();
                    Thread.sleep(3000);
                    String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                    ApiVerify.approveEsign(phone,laAdminUrl,loanType);
                    webDriverConfigured();
                    Thread.sleep(3000);
                    loanAdminDashboard= new LoanAdminDashboard(webDriver);
                    loanAdminDashboard.JewelleryAppraisal(agentName);
                }
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
                    // String status = esignJson.get("")

                    HomePage_AppraiserApp.esign(esignResponse,phone);
                }
                AndromedaDB.getInstance().updateStatus(requestId);
                resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp3);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    HomePage_AppraiserApp.completeEsign();
                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();
            }
            else if (statusCode == 2.7) {
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                if(eSignEnable){
                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
                    String status = JsonPath.read(esignResponse,String.format("$.data.status"));
//                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
//                    // String status = esignJson.get("")
                    if(status.equals("PENDING")){
                        HomePage_AppraiserApp.esign(esignResponse,phone);
                        AndromedaDB.getInstance().updateStatus(requestId);
                        resetApp();
                        HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                        HomePage_AppraiserApp.ChangeButtonIsClicked();
                        HomePage_AppraiserApp.selectEnv(env);
                        HomePage_AppraiserApp.OkButtonIsClicked();
                        HomePage_AppraiserApp.loginButtonIsClicked();
                        HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                        HomePage_AppraiserApp.clickOnLogin();
                        agentPhone = phone;
                        String otp3 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                        HomePage_AppraiserApp.enterOTP(otp3);
                        HomePage_AppraiserApp.clickOnFreshLoan();
                        HomePage_AppraiserApp.completeEsign();

                    }
                    else if(status.equals("SUCCESS")) {
                        HomePage_AppraiserApp.completeEsign();

                    }
                }

                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                resetApp();
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);

                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();
            }

            else if (statusCode == 2.8) {
                webDriverConfigured();
                loanAdminDashboard= new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName,phone);
                driverIsConfigured();
                //driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.submitMoneyTransfer();
                resetApp();

            }
        }
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Fresh loan flow is apprised by LM"));
    }


    @And("Jewellery apprisal is approved on loan admin dashboard by {string}")
    public void jewelleryApprisalIsApprovedOnLoanAdminDashboardBy(String phone) throws MalformedURLException, DocumentException, InterruptedException, ClassNotFoundException {
        webDriverConfigured();
        wait.hardWait(3000);
        loanAdminDashboard= new LoanAdminDashboard(webDriver);
        Document agent = CoreDB.getInstance().getUserFromPhone(phone);
        String firstName = agent.get("firstname").toString();
        String lastName = agent.get("lastname").toString();
        String agentName = firstName + " " + lastName;
        loanAdminDashboard.JewelleryAppraisal(agentName);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Jewellery appraisal is approved on loan admin dashboard"));

    }

    @And("Agent complete the appraisal process")
    public void agentCompleteTheAppraisalProcess() throws MalformedURLException, DocumentException, ClassNotFoundException, InterruptedException {

       // HomePage_AppraiserApp.completeAppraisal(eSignEnable);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent complete the appraisal process"));

    }

    @And("Money transfer is approved on loan admin dashboard by {string}")
    public void moneyTransferIsApprovedOnLoanAdminDashboardBy(String phone) throws MalformedURLException, DocumentException, InterruptedException, ClassNotFoundException {
        webDriverConfigured();
        loanAdminDashboard= new LoanAdminDashboard(webDriver);
        Document agent = CoreDB.getInstance().getUserFromPhone(phone);
        String firstName = agent.get("firstname").toString();
        String lastName = agent.get("lastname").toString();
        String agentName = firstName + " " + lastName;
        loanAdminDashboard.moneyTransferApprove(agentName,phone);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Money transfer is approved on loan admin dashboard"));

    }

    @And("Agent {string} Capture pledge card on LM app")
    public void agentCapturePledgeCardOnLMApp(String phone) throws Throwable {

        HomePage_AppraiserApp.ChangeButtonIsClicked();
        //HomePage_AppraiserApp.selectEnv(env);
        HomePage_AppraiserApp.OkButtonIsClicked();
        HomePage_AppraiserApp.loginButtonIsClicked();
        HomePage_AppraiserApp.phoneNumberIsEntered(phone);
        HomePage_AppraiserApp.clickOnLogin();
        agentPhone = phone;
        String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
        HomePage_AppraiserApp.enterOTP(otp);
        HomePage_AppraiserApp.clickOnFreshLoan();
       // HomePage_AppraiserApp.capturePledgeCard(phone,"Fresh",eSignEnable);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent capture the pledge card"));
    }

    @And("{string} loan flow is apprised by LM {string} pictureType {string} and {int} jewel")
    public void loanFlowIsApprisedByLMPictureTypeAndJewel(String loanType, String phone, String pictureType, int jewel,DataTable dataTable) throws Throwable {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String accountNumber = map.get("accountnumber");
        Document loanRequest = CoreDB.getInstance().getLoanRequest(phone);
        JsonObject loanInJson = new Gson().fromJson(loanRequest.toJson(), JsonObject.class);
        String requestId = loanInJson.get("_id").toString();
        Boolean apprisalBeforeKyc = loanInJson.get("flags").getAsJsonObject().get("appraisalbeforekyc").getAsBoolean();
        Double statusCode = Double.valueOf(CoreDB.getInstance().getLoanRequest(phone).get("statuscode").toString());
        agentPhone = phone;
        Document agent = CoreDB.getInstance().getUserFromPhone(agentPhone);
        String firstName = agent.get("firstname").toString();
        String lastName = agent.get("lastname").toString();
        String agentName = firstName + " " + lastName;
        String otpServiceUrl = getEnvironmentProperty("OTP_Service_baseUrl");
        String env = getEnvironmentProperty("RupeekWeb_Env");
        appraiserAppTo = new AppraiserApp_TO(driver);
        String addressType= "AAdhaar";
        Boolean eSignEnable = loanInJson.get("flags").getAsJsonObject().get("isDocumentEsignEnabled").getAsBoolean();
        if (apprisalBeforeKyc.equals(false)) {
            if (statusCode == 1.41) {
                try {
                    CoreDB.getInstance().deleteCustomerProfile(accountNumber);

                } catch (Exception e) {
                    LOGGER.info("Customer profile is not there");
                }
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.swipeToStart();
                HomePage_AppraiserApp.swipeToStart();
                HomePage_AppraiserApp.verifyCustomerOtp(agentPhone);
                HomePage_AppraiserApp.bankDetails(pictureType, dataTable);
                HomePage_AppraiserApp.fillKyc(dataTable, addressType);
                HomePage_AppraiserApp.addNominee(dataTable);
                HomePage_AppraiserApp.addPhotos(statusCode, dataTable, phone);
                appraiserAppTo.takeOverDocuments();
                //HomePage_AppraiserApp.adminApproval();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone, laAdminUrl, loanType);
                webDriverConfigured();
                Thread.sleep(3000);
                webDriverConfigured();
                Thread.sleep(5000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.takeOverPayment(agentName);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.startTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType,eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);


            } else if (statusCode == 1.6) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.swipeToStart();
                HomePage_AppraiserApp.verifyCustomerOtp(agentPhone);
                HomePage_AppraiserApp.bankDetails(pictureType, dataTable);
                HomePage_AppraiserApp.fillKyc(dataTable,addressType);
                HomePage_AppraiserApp.addNominee(dataTable);
                HomePage_AppraiserApp.addPhotos(statusCode, dataTable, phone);
                appraiserAppTo.takeOverDocuments();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone, laAdminUrl, loanType);
                webDriverConfigured();
                Thread.sleep(3000);
                webDriverConfigured();
                Thread.sleep(5000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.takeOverPayment(agentName);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.startTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 1.9) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.verifyCustomerOtp(agentPhone);
                HomePage_AppraiserApp.bankDetails(pictureType, dataTable);
                HomePage_AppraiserApp.fillKyc(dataTable,addressType);
                HomePage_AppraiserApp.addNominee(dataTable);
                HomePage_AppraiserApp.addPhotos(statusCode, dataTable, phone);
                appraiserAppTo.takeOverDocuments();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone, laAdminUrl, loanType);
                webDriverConfigured();
                Thread.sleep(3000);
                webDriverConfigured();
                Thread.sleep(5000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.takeOverPayment(agentName);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.startTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);
            } else if (statusCode == 2.1) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.bankDetails(pictureType, dataTable);
                HomePage_AppraiserApp.fillKyc(dataTable,addressType);
                HomePage_AppraiserApp.addNominee(dataTable);
                HomePage_AppraiserApp.addPhotos(statusCode, dataTable, phone);
                appraiserAppTo.takeOverDocuments();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone, laAdminUrl, loanType);
                webDriverConfigured();
                Thread.sleep(3000);
                webDriverConfigured();
                Thread.sleep(5000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.takeOverPayment(agentName);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.startTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);
            } else if (statusCode == 2.2) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                // HomePage_AppraiserApp.confirmCurrentAddress();
                HomePage_AppraiserApp.fillKyc(dataTable,addressType);
                String agentId = CoreDB.getInstance().getUserIdByPhone(phone);
                String userId = CoreDB.getInstance().getUserIdFromLoanRequest(agentId);
                Document customerProfile = CoreDB.getInstance().getCustomerProfile(userId);
                Boolean ekycCollected = customerProfile.getBoolean("ekyccollected");
//                if (ekycCollected) {
//                    HomePage_AppraiserApp.confirmCurrentAddress();
//                    HomePage_AppraiserApp.fillKYCWithExistingData(dataTable, phone);
//
//                } else {
//                    HomePage_AppraiserApp.confirmCurrentAddress();
//                    HomePage_AppraiserApp.fillKYCWithExistingData(dataTable, phone);
//                }
                //HomePage_AppraiserApp.fillKYCWithExistingData(dataTable,phone);
                HomePage_AppraiserApp.addNominee(dataTable);
                HomePage_AppraiserApp.addPhotos(statusCode, dataTable, phone);
                appraiserAppTo.takeOverDocuments();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone, laAdminUrl, loanType);
                webDriverConfigured();
                Thread.sleep(3000);
                webDriverConfigured();
                Thread.sleep(5000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.takeOverPayment(agentName);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.startTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.25) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.takeOverDocuments();
                resetApp();
                Thread.sleep(3000);
                String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                ApiVerify.approveEsign(phone, laAdminUrl, loanType);
                webDriverConfigured();
                Thread.sleep(3000);
                webDriverConfigured();
                Thread.sleep(5000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.takeOverPayment(agentName);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.startTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.3) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.takeOverDocuments();
                resetApp();
                Thread.sleep(3000);
                boolean kycApproved = false;
                try {
                    kycApproved = loanInJson.get("iskycapproved").getAsBoolean();

                } catch (Exception e) {
                    LOGGER.info("KYC is not approved");
                }
                if (kycApproved) {
                    webDriverConfigured();
                    Thread.sleep(3000);
                    loanAdminDashboard = new LoanAdminDashboard(webDriver);
                    loanAdminDashboard.takeOverPayment(agentName);
                } else {
                    String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                    ApiVerify.approveEsign(phone, laAdminUrl, loanType);
                    webDriverConfigured();
                    Thread.sleep(5000);
                    loanAdminDashboard = new LoanAdminDashboard(webDriver);
                    loanAdminDashboard.takeOverPayment(agentName);
                }

                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.startTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.301) {
                driver.resetApp();
                Thread.sleep(3000);
                boolean kycApproved = false;
                try {
                    kycApproved = loanInJson.get("iskycapproved").getAsBoolean();

                } catch (Exception e) {
                    LOGGER.info("KYC is not approved");
                }
                if (kycApproved) {
                    webDriverConfigured();
                    Thread.sleep(3000);
                    loanAdminDashboard = new LoanAdminDashboard(webDriver);
                    loanAdminDashboard.takeOverPayment(agentName);
                } else {
                    String laAdminUrl = getEnvironmentProperty("LA_Workflow");
                    ApiVerify.approveEsign(phone, laAdminUrl, loanType);
                    webDriverConfigured();
                    Thread.sleep(5000);
                    loanAdminDashboard = new LoanAdminDashboard(webDriver);
                    loanAdminDashboard.takeOverPayment(agentName);
                }
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp1 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp1);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.startTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.302) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.startTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                // HomePage_AppraiserApp.adminApproval();
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.304) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                // HomePage_AppraiserApp.adminApproval();
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.306) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                // HomePage_AppraiserApp.adminApproval();
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.307) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                //appraiserAppTo.submitPacket();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                //  HomePage_AppraiserApp.adminApproval();
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.33) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                // HomePage_AppraiserApp.adminApproval();
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.35) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                //  HomePage_AppraiserApp.adminApproval();
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.36) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1, loanType);
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                //  HomePage_AppraiserApp.adminApproval();
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.4) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                boolean apprisalFormCompleted = HomePage_AppraiserApp.apprisalFormCompleted();
                if (apprisalFormCompleted) {
                    HomePage_AppraiserApp.selectScheme(loanType);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                //  HomePage_AppraiserApp.adminApproval();
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
//                if(eSignEnable){
//                    String esignResponse=Andromeda.getInstance().eSignStatus(requestId);
//                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
//                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
//                    // String status = esignJson.get("")
//
//                    HomePage_AppraiserApp.esign(esignResponse,phone);
//                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.42) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.verifyCashBack(phone);
                HomePage_AppraiserApp.verifySchemeOtp(phone, otpServiceUrl);
                //  HomePage_AppraiserApp.adminApproval();
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
//                if(eSignEnable){
//                    String esignResponse=Andromeda.getInstance().eSignStatus(requestId);
//                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
//                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
//                    // String status = esignJson.get("")
//
//                    HomePage_AppraiserApp.esign(esignResponse,phone);
//                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);

            } else if (statusCode == 2.5) {
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.JewelleryAppraisal(agentName);
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
//                if(eSignEnable){
//                    String esignResponse=Andromeda.getInstance().eSignStatus(requestId);
//                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
//                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
//                    // String status = esignJson.get("")
//
//                    HomePage_AppraiserApp.esign(esignResponse,phone);
//                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);
            } else if (statusCode == 2.55) {
                driver.closeApp();
                CoreDB.getInstance().updateStatus(phone);
                driverIsConfigured();
                driver.resetApp();
                HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
                appraiserAppTo = new AppraiserApp_TO(driver);
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp2 = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp2);
                HomePage_AppraiserApp.clickOnFreshLoan();
//                if(eSignEnable){
//                    String esignResponse=Andromeda.getInstance().eSignStatus(requestId);
//                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
//                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
//                    // String status = esignJson.get("")
//
//                    HomePage_AppraiserApp.esign(esignResponse,phone);
//                }
                HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                driver.resetApp();
                webDriverConfigured();
                Thread.sleep(3000);
                loanAdminDashboard = new LoanAdminDashboard(webDriver);
                loanAdminDashboard.moneyTransferApprove(agentName, phone);
            } else if (statusCode == 2.7) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
//                if(eSignEnable){
//                    String esignResponse=Andromeda.getInstance().eSignStatus(phone);
//                    //JsonObject esignObject = new Gson().fromJson(esignResponse,JsonObject.class);
//                    JsonObject esignJson = new Gson().fromJson(esignResponse,JsonObject.class);
//                    // String status = esignJson.get("")
//
//                    HomePage_AppraiserApp.esign(esignResponse,phone);
//                }
                   HomePage_AppraiserApp.completeAppraisal(eSignEnable);
                    HomePage_AppraiserApp.capturePledgeCard(phone, loanType, eSignEnable);
                    driver.resetApp();
                    webDriverConfigured();
                    Thread.sleep(3000);
                    loanAdminDashboard = new LoanAdminDashboard(webDriver);
                    loanAdminDashboard.moneyTransferApprove(agentName, phone);
                } else if (statusCode == 2.8) {
                    webDriverConfigured();
                    Thread.sleep(3000);
                    loanAdminDashboard = new LoanAdminDashboard(webDriver);
                    loanAdminDashboard.moneyTransferApprove(agentName, phone);
                }

            }

        }


    @And("TO document is approved on loan admin dashboard by {string}")
    public void toDocumentIsApprovedOnLoanAdminDashboardBy(String phone, DataTable dataTable) throws MalformedURLException, DocumentException, InterruptedException {
        webDriverConfigured();
        Thread.sleep(5000);
        loanAdminDashboard= new LoanAdminDashboard(webDriver);
        Document agent = CoreDB.getInstance().getUserFromPhone(phone);
        String firstName = agent.get("firstname").toString();
        String lastName = agent.get("lastname").toString();
        String agentName = firstName + " " + lastName;
        loanAdminDashboard.takeOverPayment(agentName);
    }

    @And("Agent {string} start TO journey on")
    public void agentStartTOJourneyOn(String phone) throws Throwable {
        String otpServiceUrl = getEnvironmentProperty("OTP_Service_baseUrl");
        String env = getEnvironmentProperty("RupeekWeb_Env");
        Document loanRequest = CoreDB.getInstance().getLoanRequest(phone);
        JsonObject loanInJson= new Gson().fromJson(loanRequest.toJson(), JsonObject.class);
        Double statusCode = Double.valueOf(CoreDB.getInstance().getLoanRequest(phone).get("statuscode").toString());
        Boolean apprisalBeforeKyc = loanInJson.get("flags").getAsJsonObject().get("appraisalbeforekyc").getAsBoolean();
        HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
        appraiserAppTo = new AppraiserApp_TO(driver);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Given"), "Appraiser App homepage is loaded"));
        LOGGER.info("Appraiser App homepage is loaded");
        if(apprisalBeforeKyc.equals(false)) {
            if (statusCode == 2.302) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.startTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,"Takeover");
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                   // HomePage_AppraiserApp.selectScheme(loan);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
               // HomePage_AppraiserApp.adminApproval();

            }
           else if (statusCode == 2.304) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.endTheJourney();
                HomePage_AppraiserApp.swipeToStart();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,"Takeover");
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    //HomePage_AppraiserApp.selectScheme(loa);
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
               // HomePage_AppraiserApp.adminApproval();

            }
            else if (statusCode == 2.306) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.takeOverCollection();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,"Takeover");
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    //HomePage_AppraiserApp.selectScheme();
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
               // HomePage_AppraiserApp.adminApproval();

            }
            else if (statusCode == 2.307) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                appraiserAppTo.registerPacket();
                appraiserAppTo.TOReceipt();
                //appraiserAppTo.submitPacket();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,"Takeover");
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                    //HomePage_AppraiserApp.selectScheme();
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
              //  HomePage_AppraiserApp.adminApproval();



            }
            else if (statusCode == 2.33) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.addGrossWeight();
                HomePage_AppraiserApp.validateTotalWeight();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,"Takeover");
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                   // HomePage_AppraiserApp.selectScheme();
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
               // HomePage_AppraiserApp.adminApproval();

            }
            else if (statusCode == 2.35) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.cleanTouchStone();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,"Takeover");
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
                if(apprisalFormCompleted){
                   // HomePage_AppraiserApp.selectScheme();
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                else {
                    HomePage_AppraiserApp.verifyCashBack(phone);
                }
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
              //  HomePage_AppraiserApp.adminApproval();

            }
            else if (statusCode == 2.36) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                HomePage_AppraiserApp.addJewel(1);
                HomePage_AppraiserApp.appriseTheJewel(1,"Takeover");
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
//                if(apprisalFormCompleted){
//                    HomePage_AppraiserApp.selectScheme();
//                    HomePage_AppraiserApp.verifyCashBack(phone);
//                }
//                else {
//                    HomePage_AppraiserApp.verifyCashBack(phone);
//                }
               // HomePage_AppraiserApp.selectScheme();
                HomePage_AppraiserApp.verifyCashBack(phone);
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
               // HomePage_AppraiserApp.adminApproval();

            }
            else if (statusCode == 2.4) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
                boolean apprisalFormCompleted=HomePage_AppraiserApp.apprisalFormCompleted();
//                if(apprisalFormCompleted){
//                    HomePage_AppraiserApp.selectScheme();
//                    HomePage_AppraiserApp.verifyCashBack(phone);
//                }
//                else {
//                    HomePage_AppraiserApp.verifyCashBack(phone);
//                }
                //HomePage_AppraiserApp.selectScheme(loanType);
                HomePage_AppraiserApp.verifyCashBack(phone);
                HomePage_AppraiserApp.verifySchemeOtp(phone,otpServiceUrl);
               // HomePage_AppraiserApp.adminApproval();

            }
        }
    }

    @And("Agent {string} complete the appraisal process for {string}")
    public void agentCompleteTheAppraisalProcessFor(String phone, String loanType) throws Throwable {
        String otpServiceUrl = getEnvironmentProperty("OTP_Service_baseUrl");
        String env = getEnvironmentProperty("RupeekWeb_Env");
        Document loanRequest = CoreDB.getInstance().getLoanRequest(phone);
        JsonObject loanInJson = new Gson().fromJson(loanRequest.toJson(), JsonObject.class);
        Double statusCode = Double.valueOf(CoreDB.getInstance().getLoanRequest(phone).get("statuscode").toString());
        Boolean apprisalBeforeKyc = loanInJson.get("flags").getAsJsonObject().get("appraisalbeforekyc").getAsBoolean();
        HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
        appraiserAppTo = new AppraiserApp_TO(driver);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Given"), "Appraiser App homepage is loaded"));
        LOGGER.info("Appraiser App homepage is loaded");
        if (apprisalBeforeKyc.equals(false)) {
            if (statusCode == 2.7) {
                HomePage_AppraiserApp.ChangeButtonIsClicked();
                HomePage_AppraiserApp.selectEnv(env);
                HomePage_AppraiserApp.OkButtonIsClicked();
                HomePage_AppraiserApp.loginButtonIsClicked();
                HomePage_AppraiserApp.phoneNumberIsEntered(phone);
                HomePage_AppraiserApp.clickOnLogin();
                agentPhone = phone;
                String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
                HomePage_AppraiserApp.enterOTP(otp);
                HomePage_AppraiserApp.clickOnFreshLoan();
               // HomePage_AppraiserApp.(eSignEnable)
               //
               // (eSignEnable);
                //HomePage_AppraiserApp.capturePledgeCard(phone,loanType,eSignEnable);
                cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "Agent complete the appraisal process"));
            }
        }
    }

    @And("the status code is updated to {string} for agent {string}")
    public void theStatusCodeIsUpdatedToForAgent(String status, String phone) {
        CoreDB.getInstance().updateStatus(phone);

    }



    @And("Driver is configured for LM App")
    public void driverIsConfiguredForLMApp() throws Throwable {
        driverIsConfigured();
        //driver.resetApp();
        HomePage_AppraiserApp = new HomePage_AppraiserApp(driver);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Given"), "Appraiser App homepage is loaded"));
        LOGGER.info("Appraiser App homepage is loaded");
    }

    @And("Agent {string} submit fund transfer for Fresh loan")
    public void agentSubmitFundTransferForFreshLoan(String phone) throws Throwable {
        HomePage_AppraiserApp.ChangeButtonIsClicked();
        //HomePage_AppraiserApp.selectEnv(env);
        HomePage_AppraiserApp.OkButtonIsClicked();
        HomePage_AppraiserApp.loginButtonIsClicked();
        HomePage_AppraiserApp.phoneNumberIsEntered(phone);
        HomePage_AppraiserApp.clickOnLogin();
        agentPhone = phone;
        String otp = CoreDB.getInstance().getCoreUserByPhoneNumber(phone);
        HomePage_AppraiserApp.enterOTP(otp);
        HomePage_AppraiserApp.clickOnFreshLoan();
        HomePage_AppraiserApp.submitMoneyTransfer();
    }


    @And("driver is configured without reset")
    public void driverIsConfiguredWithoutReset() throws Throwable {
        driverIsConfigured();
    }



}


