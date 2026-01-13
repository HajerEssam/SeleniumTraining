package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    String loginNavigator = "loginBtn";
    String languageButton = "langBtn";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage navigate(){
        driver.navigate().to("https://stg-dev.hrsdportal.hrsd.gov.sa/");
        return this;
    }

    public void clickOnLogin(){
        driver.findElement(By.id(loginNavigator)).click();
    }

    public HomePage changelanguage(){
        driver.findElement(By.id(languageButton)).click();
        return this;
    }
}
