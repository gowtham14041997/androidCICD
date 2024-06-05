package com.rupeek.web.stepdef;

import com.aventstack.extentreports.GherkinKeyword;
import com.rupeek.web.pages.Common;
import com.rupeek.web.pages.CustomerApp;
import com.rupeek.web.pages.Swipes;
import com.rupeek.web.pages.Waits;
import com.rupeek.web.service.AccountService;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import javax.validation.constraints.AssertTrue;

public class PaymentStep extends BaseStep{
    private static final Logger LOGGER = LogManager.getLogger(CustomerAppCommonSteps.class);
    private static CustomerApp customerApp;
    private static Common common;
    private static Waits wait;
    private static Swipes swipe;

    static {
        try {
            driverIsConfigured();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        wait = new Waits(driver);
        swipe = new Swipes(driver);
        customerApp = new CustomerApp(driver);
        common = new Common(driver);

    }

    @And("{string} page is opened")
    public void givenPageIsOpened(String page) throws Throwable{
        wait.implicitlyWait(20,driver);
        Assert.assertTrue(customerApp.givenPageIsOpened(page));
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), page+" page is opened"));

    }


    @Then("User clicks on active loans and {string} with insurance {string}")
    public void userClicksOnActiveLoansAndTransact(String action, String selectInsurance) throws Throwable{
        wait.implicitlyWait(10,driver);
        customerApp.performsTransaction(action, selectInsurance);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "user clicks on Active Loans and In Progress Loans"));

    }

    @Then("validate all the active loans")
    public void validateAllTheActiveLoans() throws Throwable{
        wait.implicitlyWait(10,driver);
        customerApp.myLoansIsOpened();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "validate all the active loans"));

    }

    @Then("validate all the payments")
    public void validateAllThePayments() throws Throwable{
        wait.implicitlyWait(10,driver);
        customerApp.validatePayments();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "validate all the payments"));

    }

    @Given("loan is created in account service")
    public void loanIsCreatedInAccountService() throws Throwable {
        AccountService.getInstance().createLoan(90);
    }

    @And("loan is deleted for the user")
    public void loanIsDeletedInAccountService() throws Throwable {
        AccountService.getInstance().deleteLoan();
    }

    @And("book delivery slot through {string}")
    public void bookDeliverySlot(String type) throws Throwable{
        wait.implicitlyWait(10,driver);
        customerApp.bookDeliverySlot(type);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "validate all the payments"));

    }

    @And("user pays the pending amount")
    public void userPaysThePendingAmount() throws Throwable{
        wait.implicitlyWait(10,driver);
        customerApp.makePayment();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "user pays the pending amount"));

    }

    @And("{string} widget is opened")
    public void widgetIsOpened(String quickLink) throws Throwable{
        wait.implicitlyWait(10,driver);
        customerApp.clickQuickLink(quickLink);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), ""+quickLink+" widget is opened"));
    }

    @And("user releases a jewel")
    public void userReleaseAJewel() throws Throwable{
        wait.implicitlyWait(10,driver);
        customerApp.releaseJewel();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "user releases a jewel"));

    }

    @Then("user e-signs the pledge")
    public void userESignsThePledge() throws Throwable{
        wait.implicitlyWait(10,driver);
        customerApp.eSignPledge();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "user e-signs the pledge"));

    }

    @Then("User clicks on renew loan with {string} and insurance {string}")
    public void userClicksOnActiveLoansAndRenewsLoan(String bestValue, String selectInsurance) throws Throwable{
        wait.implicitlyWait(10,driver);
        customerApp.renewLoan(bestValue, selectInsurance);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "user clicks on Active Loans and In Progress Loans"));

    }
}