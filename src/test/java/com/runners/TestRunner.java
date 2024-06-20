package com.runners;

import com.context.DriverManager;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.stepdefinitions"},
        tags = "@FinancialServices",
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html", "json:target/cucumber-report/cucumber.json"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    private WebDriver driver;

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod
    public void setUpMethod() {
        // Initialize WebDriver using Singleton pattern
        driver = DriverManager.getDriver();

        // Open the application URL
        driver.get("https://risk.lexisnexis.co.uk/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod() {
        // Close the browser
        DriverManager.quitDriver();
    }
}