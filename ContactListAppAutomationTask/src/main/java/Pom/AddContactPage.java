package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContactPage {
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

    public AddContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addContact(String firstName, String lastName, String birthDate, String email, String phone, String street1, String street2, String city, String state, String postalCode, String country) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(dateOfBirthField).sendKeys(birthDate);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(streetAddress1Field).sendKeys(street1);
        driver.findElement(streetAddress2Field).sendKeys(street2);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateOfProvinceField).sendKeys(state);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(submitButton).click();
    }
}
