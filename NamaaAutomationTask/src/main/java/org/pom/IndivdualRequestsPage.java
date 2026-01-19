package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IndivdualRequestsPage extends BasePage{
    WebDriver driver;
    By firstRequestNumber = By.xpath("//dga-table-row[1]//dga-table-data[@id='value_RequestsPage_RequestNumber']");
    String requestNumberFieldRoot = "input[id='input_Uuid']";
    String requestNumberFieldHost = "dga-field[id='input_Uuid']";
    By searchButton = By.cssSelector("dga-button[id='button_RequestsPage_Search']");

    public IndivdualRequestsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public String getFirstRequestNumber(){
        return getText(driver.findElement(firstRequestNumber));
    }
}
