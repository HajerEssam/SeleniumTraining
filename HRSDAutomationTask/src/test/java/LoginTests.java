import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.pom.AddOrganizationPage;
import org.pom.HomePage;
import org.pom.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {
    WebDriver driver;

    @Test
    public void SignUpWithValidOrganization() throws InterruptedException {
        new HomePage(driver)
                .navigate()
                .changelanguage()
                .clickOnLogin();
        new LoginPage(driver)
                .clickOnAddNewOrganization();
        new AddOrganizationPage(driver)
                .RegisterAsOraganization();
    }

    @BeforeMethod
    public void setup() {
        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecure-localhost");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        new HomePage(driver)
                .navigate();

    }

    @AfterMethod
    public void quitTest() {
        driver.quit();
    }
}
