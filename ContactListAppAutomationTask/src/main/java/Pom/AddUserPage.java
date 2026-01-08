package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserPage {
    WebDriver driver;
    private String url = "https://thinking-tester-contact-list.herokuapp.com/addUser";
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit");


    public AddUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddUserPage navigate() {
        driver.navigate().to(url);
        return this;
    }

    public AddUserPage signup(String firstName, String lastName, String email, String password) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return this;
    }
}
