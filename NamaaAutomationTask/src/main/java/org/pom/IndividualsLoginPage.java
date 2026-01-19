package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndividualsLoginPage extends BasePage{
    private WebDriver driver;
    private String url = "http://portal.individual.namaa.sumerge.com/login";
    private String nationalIdRoot = "input[id='national_id_val']";
    private String nationalIdHost = "dga-numeric-field[id='national_id']";
    private By mockLoginButton = By.cssSelector("dga-button[variant='ghost']");
    private By HomepageTitle = By.xpath("//dga-text[@variant='dga_header_xl_bold']");

    public IndividualsLoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public IndividualsLoginPage navigate(){
        driver.navigate().to(url);
        return this;
    }

    public void loginAsIndividual(String id) throws InterruptedException {
        sendKeys(locateElementsInShadowRoot(nationalIdHost,nationalIdRoot),id);
        click(driver.findElement(mockLoginButton));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe(
                "https://portal.individual.namaa.sumerge.com/landing"
        ));
    }
}

