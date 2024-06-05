package com.rupeek.web.stepdef;

import com.aventstack.extentreports.GherkinKeyword;
import com.rupeek.web.pages.CmbTemplateHomePage;
import com.rupeek.web.pages.Common;
import com.rupeek.web.pages.HomePage;
import com.rupeek.web.pages.Waits;
import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class cmbTemplateSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(cmbTemplateSteps.class);
    private static HomePage homePage;
    private static Common common ;
    private static String originalHandle;
    private static CmbTemplateHomePage cmbTemplateHomePage;
    private static Waits wait;


    static {
        try {
            driverIsConfigured();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        homePage = new HomePage(driver);
        common = new Common(driver);
        cmbTemplateHomePage = new CmbTemplateHomePage(driver);
        wait = new Waits(driver);
    }

    @Given("cmb homepage is loaded")
    public void homePageIsLoaded() throws Throwable {
        driverIsConfigured();
        String url = getEnvironmentProperty("cmb_41.page");
        originalHandle = driver.getWindowHandle();
        driver.get(url);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Given"), "cmb_41 Page is loaded"));
    }

    @And("Phone number {string} is entered")
    public void phoneNumberIsEntered(String mobileNumber) throws Throwable {
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("And"), String.format("Phone number %s is entered", mobileNumber)));
        cmbTemplateHomePage.enterMobNumber("9999999999");
        LOGGER.info("phone number entered - "+ mobileNumber);
    }
}
