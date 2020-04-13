package org.facebook.products.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Runs each cucumber scenario found in the features as separated test
 */


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"cucumber/stepdefs"},          //glue = {""}; -> too works fine unusually :-p
        tags = {"@ProfilesLogon"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun=true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass()); // Java “This” can be used to get the handle of the current class
    }

    @Test(groups="cucumber scenarios", description="Runs Cucumber scenarios", dataProvider="scenarios") // "scenarios" name of method in DataProvider annotation
    public void scenario(PickleWrapper pickleEvent) throws Throwable {
        // the 'featureWrapper' parameter solely exists to display the feature file in a test report
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    /**
     * Returns two dimensional array of CucumberFeatureWrapper feature
     *
     * @return a two dimensional array of scenarios features
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
    }
}