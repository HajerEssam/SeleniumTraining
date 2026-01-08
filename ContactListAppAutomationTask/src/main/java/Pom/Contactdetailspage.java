package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Contactdetailspage {
    WebDriver driver;

    private By detailsForm = By.id("contactDetails");
    private By editContactButton = By.id("edit-contact");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By dateOfBirthField = By.id("birthdate"); // By.xpath("//span[@id=\"birthdate\"]");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By streetAddress1Field = By.id("street1");
    private By streetAddress2Field = By.id("street2");
    private By cityField = By.id("city");
    private By stateOfProvinceField = By.id("stateProvince");
    private By postalCodeField = By.id("postalCode");
    private By countryField = By.id("country");

    public Contactdetailspage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToEditContactDetails() {
        driver.findElement(editContactButton).click();
    }

    public Contactdetailspage assertOnDateOfBirth(String birthDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(dateOfBirthField, birthDate));
        Assert.assertEquals(driver.findElement(dateOfBirthField).getAttribute("textContent"), birthDate);
        return this;
    }

    public Contactdetailspage assertOnFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(firstNameField, firstName));
        Assert.assertEquals(driver.findElement(firstNameField).getAttribute("textContent"), firstName);
        return this;
    }
}
