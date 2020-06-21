package org.facebook.products.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Entire code from AbstractTestNGCucumberTests has to be implemented in here
 * though we chose a nack approach of extending it
 * For better understanding go through AbstractTestNGCucumberTests.class, TestNGCucumberRunner.java & CucumberOptions.java
 * all are available in io.cucumber.testng
 */

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org/facebook/products/steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class TestRunner extends AbstractTestNGCucumberTests {
}