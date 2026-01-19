package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EntityHomePage extends BasePage{
    WebDriver driver;
    By AssessmentRequestsSection = By.xpath("//dga-navigation-group-item[2]");
    By firstRequestNumber = By.xpath("//dga-table-row[1]//dga-table-data[@id='value_RequestsPage_RequestNumber']");
    String requestNumberFieldRoot = "input[id='input_Uuid']";
    String requestNumberFieldHost = "dga-field[id='input_Uuid']";
    By searchButton = By.cssSelector("dga-button[id='button_RequestsPage_Search']");

    public EntityHomePage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public EntityHomePage goToAssessmentRequests(){
        click(driver.findElement(AssessmentRequestsSection));
        driver.navigate().refresh();
        return this;
    }

    public EntityHomePage searchById(String id) throws InterruptedException {
        sendKeys(locateElementsInShadowRoot(requestNumberFieldHost,requestNumberFieldRoot),id);
        click(driver.findElement(searchButton));
        return this;
    }

    public void assertOnRequestId(String id){
        Assert.assertEquals(getText(driver.findElement(firstRequestNumber)),id);
    }
}

