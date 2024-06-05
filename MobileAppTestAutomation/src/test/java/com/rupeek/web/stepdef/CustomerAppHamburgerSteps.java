package com.rupeek.web.stepdef;

import com.aventstack.extentreports.GherkinKeyword;
import com.rupeek.web.pages.Common;
import com.rupeek.web.pages.CustomerAppHamburgerItems;
import com.rupeek.web.pages.Waits;
import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;


public class CustomerAppHamburgerSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(CustomerAppCommonSteps.class);
    private static CustomerAppHamburgerItems hamburger;
    private static Common common;
    private static Waits wait;


    static {
        try {
            driverIsConfigured();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        hamburger = new CustomerAppHamburgerItems(driver);
        common = new Common(driver);
        wait = new Waits(driver);
    }

    @Then("User navigates to {string} section")
    public void UserNavigatesReferEarnSection(String page) throws Throwable {
        wait.implicitlyWait(10, driver);
        hamburger.clickOnHamburgerThenClickPage(page);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User navigates to refer and earn section"));
    }

    @Then("User is able to navigate to refer and earn page")
    public void userNavigatedToReferAndEarnPage() throws Throwable {
        wait.implicitlyWait(10, driver);
        Assert.assertTrue(hamburger.referAndEarnPageAppears());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User is able to navigate to refer and earn page"));
    }

    @Then("User is able to refer refer a friend")
    public void userRefersFriend() throws Throwable {
        wait.implicitlyWait(10, driver);
        Assert.assertTrue(hamburger.userRefersHisFriend());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User is able to refer refer a friend"));
    }

    @Then("User is able to navigate to Articles page")
    public void userNavigatedToArticlesPage() throws Throwable {
        wait.implicitlyWait(10, driver);
        Assert.assertTrue(hamburger.articlesPageAppears());
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User navigates to Articles page"));
    }

    @Then("User navigates to {string} section on new home screen")
    public void UserNavigatesSectionOnNewHomeScreen(String page) throws Throwable {
        wait.implicitlyWait(10, driver);
        hamburger.clickOnHamburgerThenClickSectionOnNewHomeScreen(page);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Then"), "User navigates to refer and earn section"));
    }
}