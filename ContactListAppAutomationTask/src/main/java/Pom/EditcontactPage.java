package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditcontactPage {
    WebDriver driver;

    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By dateOfBirthField = By.id("birthdate");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By streetAddress1Field = By.id("street1");
    private By streetAddress2Field = By.id("street2");
    private By cityField = By.id("city");
    private By stateOfProvinceField = By.id("stateProvince");
    private By postalCodeField = By.id("postalCode");
    private By countryField = By.id("country");
    private By submitButton = By.id("submit");

    public EditcontactPage(WebDriver driver) {
        this.driver = driver;
    }

    public EditcontactPage EditDateOfBirth(String birthDate) {
        driver.findElement(dateOfBirthField).click();
        driver.findElement(dateOfBirthField).clear();
        driver.findElement(dateOfBirthField).sendKeys(birthDate);
        return this;
    }

    public void clickSubmitButton() throws InterruptedException {
        driver.findElement(submitButton).click();
    }
}
