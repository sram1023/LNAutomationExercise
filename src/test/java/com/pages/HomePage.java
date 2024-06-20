package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Choose Your Industry')]")
    private WebElement chooseYourIndustry;

    public void clickChooseYourIndustry() {
        chooseYourIndustry.click();
    }
    public By acceptAllCookies() {
        return By.xpath("//*[@id='onetrust-accept-btn-handler']");
    }

    public By financialServices(String financialService) {
        return By.xpath("(//ul[@class='level-1 score-section-menu'])[1]/li/a/div[contains(text(),'" + financialService + "')]");
    }

    public By industries(String industries) {
        return By.xpath("//div[normalize-space()='" + industries + "']");
    }
}
