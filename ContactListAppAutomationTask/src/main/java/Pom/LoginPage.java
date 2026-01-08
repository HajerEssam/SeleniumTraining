package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    private String url = "http://thinking-tester-contact-list.herokuapp.com/";

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit");
    private By signupButton = By.id("signup");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage navigate() {
        driver.navigate().to(url);
        return this;
    }

    public LoginPage login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return this;
    }

    public void navigateToAddUserPage() {
        driver.findElement(signupButton).click();
    }
}
