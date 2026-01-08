package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactListPage {
    WebDriver driver;

    private By addNewContactButton = By.id("add-contact");
//    private By nameHeader = By.xpath("//div//thead//th[1]");
//    private By birthDateHeader = By.xpath("//div//thead//th[2]");
//    private By emailHeader = By.xpath("//div//thead//th[3]");
//    private By phoneHeader = By.xpath("//div//thead//th[4]");
//    private By addressHeader = By.xpath("//div//thead//th[5]");
//    private By addressDetailsHeader = By.xpath("//div//thead//th[6]");
//    private By countryHeader = By.xpath("//div//thead//th[7]");

    private By logoutButton = By.id("logout");
    private By contactTable = By.id("myTable");
    private By nameValue = By.xpath("//div//tr[@class='contactTableBodyRow'][1]//td[2]");
    private By birthDateValue = By.xpath("//div//tr[@class='contactTableBodyRow'][1]//td[3]");
    private By emailValue = By.xpath("//div//tr[@class='contactTableBodyRow'][1]//td[4]");
    private By phonevalue = By.xpath("//div//tr[@class='contactTableBodyRow'][1]//td[5]");
    private By addressValue = By.xpath("//div//tr[@class='contactTableBodyRow'][1]//td[6]");
    private By addressDetailsValue = By.xpath("//div//tr[@class='contactTableBodyRow'][1]//td[7]");
    private By countryValue = By.xpath("//div//tr[@class='contactTableBodyRow'][1]//td[8]");

    public ContactListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void navigateToAddContactPage() {
        driver.findElement(addNewContactButton).click();
    }

    public void navigateToContactDetails() {
        driver.findElement(contactTable).click();
    }

    public ContactListPage assertOnContactData(String firstName, String lastName, String birthDate, String email, String phone, String street1, String street2, String city, String state, String postalCode, String country) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameValue));
        Assert.assertEquals(driver.findElement(nameValue).getText(), firstName + " " + lastName);
        Assert.assertEquals(driver.findElement(birthDateValue).getText(), birthDate);
        Assert.assertEquals(driver.findElement(emailValue).getText(), email);
        Assert.assertEquals(driver.findElement(phonevalue).getText(), phone);
        Assert.assertEquals(driver.findElement(addressValue).getText(), street1 + " " + street2);
        Assert.assertEquals(driver.findElement(addressDetailsValue).getText(), city + " " + state + " " + postalCode);
        Assert.assertEquals(driver.findElement(countryValue).getText(), country);
        return this;
    }

}
