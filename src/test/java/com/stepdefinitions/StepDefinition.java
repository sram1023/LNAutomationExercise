package com.stepdefinitions;

import com.context.DriverManager;
import com.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class StepDefinition {

    private final HomePage homePage = new HomePage(DriverManager.getDriver());
    private static WebDriverWait wait = null;

    @Given("the user is landing on the site")
    public void applicationSite() {
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(homePage.acceptAllCookies()));
        ele.click();
    }

    @And("click the Choose your Industry link")
    public void clickIndustryLink() {
        homePage.clickChooseYourIndustry();
    }

    @Then("validate the following industry headings are present and clickable")
    public void validateIndustryHeadings(DataTable dataTable) {
        List<String> industryHeadings = dataTable.asList(String.class);
        for (String industryHeading : industryHeadings) {
            try {
                // Wait for the element to be present in the DOM
                wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
                wait.until(ExpectedConditions.presenceOfElementLocated(homePage.industries(industryHeading)));
                System.out.println("Element is present in the DOM.");

                // Wait for the element to be visible and clickable
                wait.until(ExpectedConditions.elementToBeClickable(homePage.industries(industryHeading)));
                System.out.println("Element is clickable.");

            } catch (Exception e) {
                System.out.println("Element is not present or not clickable: " + e.getMessage());
            }
        }
    }

    @And("click on the {string} link")
    public void clickOnTheFinancialServicesLink(String industryHeading) {
        DriverManager.getDriver().findElement(homePage.industries(industryHeading)).click();
    }

    @Then("validate the following financial services are present and clickable")
    public void validateFinancialServices(DataTable dataTable) {
        List<String> financialServices = dataTable.asList(String.class);
        for (String financialService : financialServices) {
            try {
                // Wait for the element to be present in the DOM
                wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
                wait.until(ExpectedConditions.presenceOfElementLocated(homePage.financialServices(financialService)));
                System.out.println("Element is present in the DOM.");

                // Wait for the element to be visible and clickable
                wait.until(ExpectedConditions.elementToBeClickable(homePage.financialServices(financialService)));
                System.out.println("Element is clickable.");

            } catch (Exception e) {
                System.out.println("Element is not present or not clickable: " + e.getMessage());
            }
        }
    }

}
