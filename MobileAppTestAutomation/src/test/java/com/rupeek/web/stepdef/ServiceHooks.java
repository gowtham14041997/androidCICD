package com.rupeek.web.stepdef;

import com.aventstack.extentreports.GherkinKeyword;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import restapi.APIServices;
import restapi.Component;


public class ServiceHooks extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(ServiceHooks.class);
    public static Integer failedTest = 0;
    public static Integer totalTest = 0;
    private static String stepSeperator =   "\n" +
            "---------------------------------------------------------------------------------------------------------------------\n" +
                                            "---------------------------------------------------------------------------------------------------------------------";

    @Before
    public void initializeTest(Scenario scenarioDef) throws ClassNotFoundException {
        totalTest = totalTest + 1 ;
        apiComponent = new Component();
        apiServices = new APIServices();
        cucumberReporter.setScenario(cucumberReporter.getFeature().createNode(new GherkinKeyword("Scenario"), scenarioDef.getName()));
        cucumberReporter.setScenarioName(cucumberReporter.getScenario().getModel().getName().trim());
        LOGGER.info(cucumberReporter.getScenarioName());
        LOGGER.info(stepSeperator);


    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            failedTest = failedTest + 1;
            try {
                System.out.println("The current scenario '" + scenario.getName() + "' is failed.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info(cucumberReporter.getScenarioName());
        LOGGER.info(stepSeperator);
    }
}