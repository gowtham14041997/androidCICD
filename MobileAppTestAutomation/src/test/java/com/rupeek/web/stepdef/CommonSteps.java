package com.rupeek.web.stepdef;

import com.aventstack.extentreports.GherkinKeyword;
import com.rupeek.web.pages.*;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CommonSteps extends BaseStep {
    private static final Logger logger = LogManager.getLogger(CommonSteps.class);
    private static HomePage homePage;
    private static  Common common ;


    static {
        try {
            driverIsConfigured();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        homePage = new HomePage(driver);
        common = new Common(driver);
    }


}
