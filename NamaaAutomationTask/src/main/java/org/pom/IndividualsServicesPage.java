package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class IndividualsServicesPage extends BasePage{
    private WebDriver driver;
    private String url = "http://portal.individual.namaa.sumerge.com/social-record/beneficiary-services";
    private By medicalAssessmentRequest = By.xpath("//app-landing-page-card[@text='DISABILITY_ASSESSMENT_LANDING.SERVICE_CARD_TITLE']//dga-box[@backgroundcolor='bg_white']");

    public IndividualsServicesPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public IndividualsServicesPage navigate(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
        return this;
    }

    public void chooseMedicalAssessmentRequest(){
        click(driver.findElement(medicalAssessmentRequest));
    }
}
