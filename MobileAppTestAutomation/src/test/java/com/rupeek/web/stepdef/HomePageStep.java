package com.rupeek.web.stepdef;

import com.aventstack.extentreports.GherkinKeyword;
import com.rupeek.web.pages.*;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;


public class HomePageStep extends BaseStep{
    private static final Logger LOGGER = LogManager.getLogger(CommonSteps.class);
    private static HomePage homePage;
    private static  Common common ;
    private static String originalHandle;


    static {
        try {
            driverIsConfigured();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        homePage = new HomePage(driver);
        common = new Common(driver);
    }

    @Given("Home Page is loaded")
    public void homePageIsLoaded() throws Throwable {
        driverIsConfigured();
        String url = getEnvironmentProperty("home.page");
        originalHandle = driver.getWindowHandle();
        driver.get(url);
        cucumberReporter.setTestStep(cucumberReporter.getScenario().createNode(new GherkinKeyword("Given"), "Home Page is loaded"));
    }




}
