package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class EntitiesLoginPage extends BasePage{
    private WebDriver driver;
    private String url = "http://portal.entities.namaa.sumerge.com/login";
    private String nationalIdRoot = "input[id='national_id_val']";
    private String nationalIdHost = "dga-numeric-field[id='national_id']";
    private By mockLoginButton = By.cssSelector("dga-button[variant='ghost']");
    By AssessmentRequestsSection = By.xpath("//dga-navigation-group-item[2]");

    public EntitiesLoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public EntitiesLoginPage navigate(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
        return this;
    }

    public void loginAsEntity(String id) throws InterruptedException {
        sendKeys(locateElementsInShadowRoot(nationalIdHost,nationalIdRoot),id);
        click(driver.findElement(mockLoginButton));
        waitForVisibility(driver.findElement(AssessmentRequestsSection));
    }
}
