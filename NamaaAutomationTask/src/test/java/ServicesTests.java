import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.pom.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ServicesTests {
    WebDriver driver;

    @Test
    public void validateAssessmentRequestExistance() throws InterruptedException {
        new IndividualsLoginPage(driver)
                .navigate()
                .loginAsIndividual("1000000008");
        new IndividualsServicesPage(driver)
                .navigate()
                .chooseMedicalAssessmentRequest();

        new IndividualDisabilityAssessmentServicePage(driver)
                .startService();

        new BeneficiaryselectionPage(driver)
                .selectBeneficiary();

        String firstrequestNumber = new IndivdualRequestsPage(driver).getFirstRequestNumber();

        new EntitiesLoginPage(driver)
                .navigate()
                .loginAsEntity("1999988879");

        new EntityHomePage(driver)
                .goToAssessmentRequests()
                .searchById(firstrequestNumber)
                .assertOnRequestId(firstrequestNumber);
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
    }

    @AfterMethod
    public void quitTest() {
        driver.quit();
    }
}

