package com.rupeek.web.stepdef;

import com.aventstack.extentreports.GherkinKeyword;
import com.rupeek.web.db.CoreDB;
import com.rupeek.web.db.CustomerIdentityServiceDB;
import com.rupeek.web.pages.Common;
import com.rupeek.web.pages.CustomerAppDigitalJourney;
import com.rupeek.web.pages.CustomerAppHamburgerItems;
import com.rupeek.web.pages.Waits;
import com.rupeek.web.service.Core;
import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class CustomerAppDJSteps extends BaseStep{

    private static final Logger LOGGER = LogManager.getLogger(CustomerAppDJSteps.class);
    private static CustomerAppHamburgerItems hamburger;
    private static Common common;
    private static Waits wait;
    private static CustomerAppDigitalJourney digitalJourney;
    private static CustomerIdentityServiceDB cisDB;
    private static CoreDB coreDB;



    static {
        try {
            driverIsConfigured();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        hamburger = new CustomerAppHamburgerItems(driver);
        common = new Common(driver);
        wait = new Waits(driver);
        digitalJourney = new CustomerAppDigitalJourney(driver);
    }

    @Then("User clicks on At {string} for {string} homescreen")
    public void userSelectsTOLoan(String type, String homescreen) throws Throwable{
        wait.implicitlyWait(5, driver);
        Assert.assertTrue(digitalJourney.userSelectsTOLoan(type, homescreen));
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User clicks on At "+type+" and select TO loan"));
    }

    @And("User fills {string} and {string} in loan information")
    public void userFillsLoanInformation(String amount, String lender) throws Throwable {
        wait.implicitlyWait(5, driver);
        Assert.assertTrue(digitalJourney.userFillsLoanInformation(amount, lender));
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "User fills "+amount+", 0.7% interest rate and "+lender+" in loan information"));
    }

    @And("User skips upload loan receipt and submits the request")
    public void userSkipsUploadLoanReceipt() throws Throwable {
        wait.implicitlyWait(5, driver);
        Assert.assertTrue(digitalJourney.userSkipsReceiptUpload());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "User skips upload loan receipt and submits the request"));
    }


    @Then("User clicks on At {string} and selects fresh loan for {string} homescreen")
    public void userClicksOnAtAndSelectsFreshLoanForHomescreen(String type, String homescreen) throws Throwable {
        wait.implicitlyWait(5, driver);
        Assert.assertTrue(digitalJourney.userSelectsFreshLoan(type, homescreen));
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User clicks on At "+type+" and selects fresh loan"));

    }

    @And("User fills loan amount {string} for {string} in native page")
    public void userFillsLoanAmountAndClicksViewSchemesButton(String amount, String type) throws Throwable{
        wait.implicitlyWait(5, driver);
        Assert.assertTrue(digitalJourney.userFillsLoanAmount(amount, type));
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "User fills loan amount "+amount+" and clicks View Schemes button"));

    }

    @And("User clicks on appointment card and cancels the appointment")
    public void userClicksOnAppointmentCardAndCancelsTheAppointment() throws Throwable{
        wait.implicitlyWait(5, driver);
        Assert.assertTrue(digitalJourney.userCancelsAppointment());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "User clicks on appointment card and cancels the appointment"));

    }

    @And("{string} transaction is created for customer {string}")
    public void transactionIsCreatedForCustomer(String loanType, String phone) throws IOException, SQLException {
        cisDB = CustomerIdentityServiceDB.getInstance();
        coreDB = CoreDB.getInstance();
        boolean existingUser = cisDB.IsExistingUser(phone);
        List<String> transactions= new ArrayList<>();
        if (!coreDB.hasActiveTransaction(phone)) {
            System.out.println("There is no active transaction");
        } else {
            transactions=coreDB.getActiveTransactions(phone);
            for(int j=0;j<transactions.size();j++){
                coreDB.archiveLoanRequest(transactions.get(j));
            }

        }

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        Instant tomorrowStart = tomorrow.atStartOfDay().toInstant(ZoneOffset.UTC);
        long epochTimeTomorrow = tomorrowStart.getEpochSecond();
        long startTime = epochTimeTomorrow+50400;
        boolean type=true;
        if(loanType.equals("Fresh")){
            type=false;
        }
        String url = getEnvironmentProperty("core_baseurl");
        Core.getInstance().createLoan(startTime,url,phone,type);
    }

    @And("User clicks on appointment card and reschedules the appointment")
    public void userClicksOnAppointmentCardAndReschedulesTheAppointment() throws Throwable{
        wait.implicitlyWait(5, driver);
        Assert.assertTrue(digitalJourney.userReschedulesAppointment());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "User clicks on appointment card and reschedules the appointment"));

    }

    @And("User selects available slot for booking loan")
    public void userSelectsAvailableSlotForBookingLoan() throws Throwable{
        wait.implicitlyWait(5, driver);
        digitalJourney.userSelectsSlot();
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "User selects available slot for booking loan"));

    }


    @And("User completes digital journey for {string}")
    public void userCompletesDigitalJourney(String loanType) throws Throwable {
        wait.implicitlyWait(5, driver);
        digitalJourney.digitalJourneyWebFlow(loanType);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), "User completes digital journey"));
    }
}