package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    String addOrganizationButton = "RegisterNewOrganizationButton";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnAddNewOrganization(){
        driver.findElement(By.id(addOrganizationButton)).click();
    }
}
