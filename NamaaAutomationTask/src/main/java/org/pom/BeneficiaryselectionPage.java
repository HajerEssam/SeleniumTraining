package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BeneficiaryselectionPage extends BasePage{
    private WebDriver driver;
    private String beneficiariesListRoot ="input[id='beneficiary']";
    private String beneficiariesListHost ="dga-select[id='beneficiary']";
    private By beneficiaryId = By.cssSelector("dga-select-item[id='1000000008']");
    private String beneficiaryIdRoot = "dga-select-item[id='1000000008']";
    private String beneficiaryIdHost = "dga-select-dropdown";
    private By checkButton = By.cssSelector("dga-button[id='check_btn']");
    private By goToRequests = By.cssSelector("dga-button[variant='dark']");

    public BeneficiaryselectionPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void selectBeneficiary() throws InterruptedException {
        click(locateElementsInShadowRoot(beneficiariesListHost,beneficiariesListRoot));
        //click(locateElementsInShadowRoot(beneficiaryIdHost,beneficiaryIdRoot));
        click(driver.findElement(beneficiaryId));
        click(driver.findElement(checkButton));
        click(driver.findElement(goToRequests));
    }

}
