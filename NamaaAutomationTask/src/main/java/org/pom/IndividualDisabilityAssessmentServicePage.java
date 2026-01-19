package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndividualDisabilityAssessmentServicePage extends BasePage{
    private WebDriver driver;
    private By startingSurviceButton = By.cssSelector("dga-button[size='medium']");

    public IndividualDisabilityAssessmentServicePage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void startService(){
        click(driver.findElement(startingSurviceButton));
    }
}
