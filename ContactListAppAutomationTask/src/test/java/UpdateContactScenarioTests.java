import Pom.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UpdateContactScenarioTests {
    WebDriver driver;

    @Test
    public void addAndUpdateContactForNewUser() throws InterruptedException {
//        new AddUserPage(driver)
//                .signup("Hagar","Mahmoud","hagarmahmoud@gmail.com","1234567");
//        new ContactListPage(driver)
//                .clickOnLogoutButton();
        new LoginPage(driver)
                .navigate()
                .login("hagarmahmoud@gmail.com", "1234567");
        new ContactListPage(driver)
                .navigateToAddContactPage();
        new AddContactPage(driver)
                .addContact("Hagar", "Essam", "2003-09-01",
                        "hagarmahmoud@gmail.com", "123456789",
                        "street1", "street2", "city",
                        "cairo", "1234", "Egypt");
        new ContactListPage(driver)
                .assertOnContactData("Hagar", "Essam", "2003-09-01",
                        "hagarmahmoud@gmail.com", "123456789",
                        "street1", "street2", "city",
                        "cairo", "1234", "Egypt")
                .navigateToContactDetails();
        new Contactdetailspage(driver)
                .navigateToEditContactDetails();
        new EditcontactPage(driver)
                .EditDateOfBirth("2003-12-01")
                .clickSubmitButton();
        new Contactdetailspage(driver)
                .assertOnFirstName("Hagar")
                .assertOnDateOfBirth("2003-12-01");
    }

    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        new AddUserPage(driver)
                .navigate();

    }

    @AfterMethod
    public void quitTest() {
        driver.quit();
    }
}
