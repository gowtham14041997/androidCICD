package com.rupeek.web.runner;

import base.CucumberReporter;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.rupeek.web.stepdef.BaseStep;
import enums.Environment;
import io.cucumber.testng.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import reporting.MailableReport;

@CucumberOptions(features = "src/test/resources/feature/App/customer/NewHomeScreen.feature",
        glue = {"com.rupeek.web.stepdef", "listener"},
        //plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"},
        tags = {"@test"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
    private static String name;
    private static final Logger LOGGER = LogManager.getLogger(TestRunner.class);
    private TestNGCucumberRunner testNGCucumberRunner;
    CucumberReporter cucumberReporter = CucumberReporter.getCucumberReporterInstance();

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        BaseStep.runCommandLine("killall node");
        String environment = System.getProperty("environment");
        if (environment == null) {
            System.out.println("Reading the environment value from configuration file");
            environment = BaseStep.commonProperties.getProperty("environment");
        } else {
            System.out.println("Reading the environment value from system property");
        }

        if (environment != null) {
            switch (environment.trim().toLowerCase()) {
                case "qa":
                    BaseStep.ENVIRONMENT = Environment.QA;
                    break;
                case "dev":
                    BaseStep.ENVIRONMENT = Environment.DEV;
                    break;
                case "stg":
                    BaseStep.ENVIRONMENT = Environment.STG;
                    break;
                case "prod":
                    BaseStep.ENVIRONMENT = Environment.PROD;
                    break;
                default:
                    System.out.println("Unknown Environment. Please add the configuration for '" + environment + "'.");
                    System.exit(0);
                    break;
            }
        } else {
            System.out.println("Environment is null! Please assign an appropriate value to the environment.");
            System.exit(0);
        }
        System.out.println("Using Environment: " + BaseStep.ENVIRONMENT.getEnvironment());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        // the 'featureWrapper' parameter solely exists to display the feature file in a test report
        String currentFeature = featureWrapper.toString().substring(1, featureWrapper.toString().length() - 1);
        name = currentFeature;
        if (!currentFeature.equals(cucumberReporter.getFeatureName()) || (cucumberReporter.getFeatureName() == null)) {
            cucumberReporter.setFeature(cucumberReporter.getExtent().createTest(Feature.class, currentFeature));
            cucumberReporter.setFeatureName(cucumberReporter.getFeature().getModel().getName().trim());
        }

        LOGGER.info("Feature Name : " + currentFeature);
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    /**
     * Returns two dimensional array of PickleEventWrapper scenarios with their
     * associated CucumberFeatureWrapper feature.
     *
     * @return a two dimensional array of scenarios features.
     */
    @DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
        BaseStep.closeDriverAndAppiumSession();
    }

    //@AfterSuite
    public void sendReport() throws Exception {
        boolean sendReport = Boolean.valueOf(BaseStep.commonProperties.getProperty("report.send"));

        if (sendReport) {
            String recipientList = BaseStep.commonProperties.getProperty("report.recipient.list");
//            MailWithAttachmentService mailWithAttachmentService = new MailWithAttachmentService();
//            mailWithAttachmentService.sendMail(recipientList);
            MailableReport mailableReport = new MailableReport();
            mailableReport.sendMail(recipientList);
        }
    }

}