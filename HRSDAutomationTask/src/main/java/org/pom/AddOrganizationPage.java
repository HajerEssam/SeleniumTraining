package org.pom;

import org.openqa.selenium.*;
import org.testng.Assert;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class AddOrganizationPage extends BasePage{
    WebDriver driver;
    static String organizationDomain;

    String arabicOrganizationNameRoot = "input[placeholder='Organization Name in Arabic']";
    String arabicOrganizationNameHost = "dga-field[id='OrganizationArabicNameField']";
    ArrayList<String> arabicNameShadowRoots = new ArrayList<>();

    String englishOrganizationNameRoot = "input[placeholder='Organization Name in English']";
    String englishOrganizationNameHost = "dga-field[id='OrganizationEnglishNameField']";
    ArrayList<String> englishNameShadowRoots = new ArrayList<>();

    String nationalNumberRoot = "input[placeholder='The Unified National Number']";
    String nationalNumberHost = "dga-numeric-field[id='Number700Field']";
    ArrayList<String> nationalNumberShadowRoots = new ArrayList<>();

    String organizationSectorRoot = "input[placeholder='Organization Sector']";
    String organizationSectorHost = "dga-field[id='OrganizationOrientationField']";
    ArrayList<String> organizationSectorShadowRoots = new ArrayList<>();

    String organizationLogoInputRoot = "input[id='single-file-input']";
    String organizationLogoInputHost = "dga-upload[id='OrganizationSloganButton']";
    ArrayList<String> organizationLogoInputShadowRoots = new ArrayList<>();

    String organizationPhoneNumberRoot = "input[placeholder='111234567']";
    String organizationPhoneNumberHost = "dga-field[id='OrganizationPhoneField']";
    ArrayList<String> organizationPhoneNumberShadowRoots = new ArrayList<>();

    String applicantNameRoot = "input[placeholder='Applicant Name']";
    String applicantNameHost = "dga-field[id='OrganizationRepresentativeNameField']";
    ArrayList<String> applicantNameShadowRoots = new ArrayList<>();

    String applicantNationalIDRoot = "input[placeholder='Applicant National ID']";
    String applicantNationalIDHost = "dga-numeric-field[id='OrganizationRepresentativeIDField']";
    ArrayList<String> applicantIDShadowRoots = new ArrayList<>();

    String applicantPhoneNumberRoot = "input[placeholder='512345678']";
    String applicantPhoneNumberHost = "dga-field[id='OrganizationRepresentativePhoneField']";
    ArrayList<String> applicantPhoneNumberShadowRoots = new ArrayList<>();

    String applicantJobTitleRoot = "input[placeholder='Applicant Job Title']";
    String applicantJobTitleHost = "dga-field[formcontrolname='applicantPosition']";
    ArrayList<String> applicantJobTitleShadowRoots = new ArrayList<>();

    String organizationEstablishDateRoot = "input[placeholder='DD/MM/YYYY']";
    String organizationEstablishDateHost = "dga-date-field[id='FoundationDateField']";
    ArrayList<String> establishDateShadowRoots = new ArrayList<>();

    String emailDomainRoot = "input[placeholder='@example.com']";
    String emailDomainHost = "dga-field[id='DomainField']";
    ArrayList<String> emailDomainShadowRoots = new ArrayList<>();

    String applicantEmailRoot = "input[placeholder='someone@example.com']";
    String applicantEmailHost = "dga-field[id='EmailDomainField']";
    ArrayList<String> applicantEmailShadowRoots = new ArrayList<>();

    String signupButtonRoot = "RegisterButton";

    String SMSCode0LocatorHost = "dga-sms-code-field[id='VerificationCodeField']";
    String SMSCode0ShadowRoot = "input[id='-0']";
    ArrayList<String> SMSCode0ShadowRoots = new ArrayList<>();


    String SMSCode1LocatorHost = "dga-sms-code-field[id='VerificationCodeField']";
    String SMSCode1ShadowRoot = "input[id='-1']";
    ArrayList<String> SMSCode1ShadowRoots = new ArrayList<>();


    String SMSCode2LocatorHost = "dga-sms-code-field[id='VerificationCodeField']";
    String SMSCode2ShadowRoot = "input[id='-2']";
    ArrayList<String> SMSCode2ShadowRoots = new ArrayList<>();


    String SMSCode3LocatorHost = "dga-sms-code-field[id='VerificationCodeField']";
    String SMSCode3ShadowRoot = "input[id='-3']";
    ArrayList<String> SMSCode3ShadowRoots = new ArrayList<>();

    String successMessageRoot = "dga-text[class='content dga_body_l_regular success_strong hydrated']";
    String successMessageHost1 = "dga-alert[class='alert hydrated']";
    String successMessageHost2 = "dga-message[class='alert-content hydrated']";

    public AddOrganizationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void RegisterAsOraganization() throws InterruptedException {
        enterArabicName();
        enterEnglishName();
        enterUnifiedNationalNumber();
        enterOrganizationSector();
        selectOrganizationLogoFile();
        enterOrganizationPhoneNumber();
        enterApplicantName();
        enterApplicantNationalID();
        enterApplicantPhoneNumber();
        enterApplicantJobTitle();
        enterOrganizationEstablishedDate();
        enterEmailDomain();
        enterApplicantEmail();
        scrollIntoView(driver.findElement(By.id("RegisterButton")));
        click(driver.findElement(By.id("RegisterButton")));
        enterSMSCode("5555");
        assertOnSuccessMessage();

    }

    private void enterArabicName() throws InterruptedException {
        arabicNameShadowRoots.add(arabicOrganizationNameHost);
        arabicNameShadowRoots.add(arabicOrganizationNameRoot);
        try {
            getShadowRootElement(arabicNameShadowRoots).sendKeys("وزارة الاتصالات");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(arabicNameShadowRoots).sendKeys("وزارة الاتصالات");
        }
    }

    private void enterEnglishName() throws InterruptedException {
        englishNameShadowRoots.add(englishOrganizationNameHost);
        englishNameShadowRoots.add(englishOrganizationNameRoot);
        try {
            getShadowRootElement(englishNameShadowRoots).sendKeys("Ministry of Communication");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(englishNameShadowRoots).sendKeys("Ministry of Communication");
        }
    }

    private void enterUnifiedNationalNumber() throws InterruptedException {
        nationalNumberShadowRoots.add(nationalNumberHost);
        nationalNumberShadowRoots.add(nationalNumberRoot);
        String nationalId = generateOrganizationNationalID();
        try {
            getShadowRootElement(nationalNumberShadowRoots).sendKeys(nationalId);
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(nationalNumberShadowRoots).sendKeys(nationalId);
        }
    }

    private void enterOrganizationSector() throws InterruptedException {
        organizationSectorShadowRoots.add(organizationSectorHost);
        organizationSectorShadowRoots.add(organizationSectorRoot);
        try {
            getShadowRootElement(organizationSectorShadowRoots).sendKeys("حكومي");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(organizationSectorShadowRoots).sendKeys("حكومي");
        }
    }

    private void selectOrganizationLogoFile() throws InterruptedException {
        organizationLogoInputShadowRoots.add(organizationLogoInputHost);
        organizationLogoInputShadowRoots.add(organizationLogoInputRoot);
        try {
            getShadowRootElement(organizationLogoInputShadowRoots).sendKeys("C:\\Users\\hmahmoud\\Desktop\\Screenshot 2026-01-05 161839.png");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(organizationLogoInputShadowRoots).sendKeys("C:\\Users\\hmahmoud\\Desktop\\Screenshot 2026-01-05 161839.png");
        }
    }

    private void enterOrganizationPhoneNumber() throws InterruptedException {
        organizationPhoneNumberShadowRoots.add(organizationPhoneNumberHost);
        organizationPhoneNumberShadowRoots.add(organizationPhoneNumberRoot);
        try {
            getShadowRootElement(organizationPhoneNumberShadowRoots).sendKeys("111234567");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(organizationPhoneNumberShadowRoots).sendKeys("111234567");
        }
    }

    private void enterApplicantName() throws InterruptedException {
        applicantNameShadowRoots.add(applicantNameHost);
        applicantNameShadowRoots.add(applicantNameRoot);
        try {
            getShadowRootElement(applicantNameShadowRoots).sendKeys("هاجر");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(applicantNameShadowRoots).sendKeys("هاجر");
        }
    }

    private void enterApplicantNationalID() throws InterruptedException {
        applicantIDShadowRoots.add(applicantNationalIDHost);
        applicantIDShadowRoots.add(applicantNationalIDRoot);
        String ID = generateApplicantID();
        try {
            getShadowRootElement(applicantIDShadowRoots).sendKeys(ID);
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(applicantIDShadowRoots).sendKeys(ID);
        }
    }

    private void enterApplicantPhoneNumber() throws InterruptedException {
        applicantPhoneNumberShadowRoots.add(applicantPhoneNumberHost);
        applicantPhoneNumberShadowRoots.add(applicantPhoneNumberRoot);
        try {
            getShadowRootElement(applicantPhoneNumberShadowRoots).sendKeys("512345678");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(applicantPhoneNumberShadowRoots).sendKeys("512345678");
        }
    }

    private void enterApplicantJobTitle() throws InterruptedException {
        applicantJobTitleShadowRoots.add(applicantJobTitleHost);
        applicantJobTitleShadowRoots.add(applicantJobTitleRoot);
        try {
            getShadowRootElement(applicantJobTitleShadowRoots).sendKeys("محامي");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(applicantJobTitleShadowRoots).sendKeys("محامي");
        }
    }

    private void enterOrganizationEstablishedDate() throws InterruptedException {
        establishDateShadowRoots.add(organizationEstablishDateHost);
        establishDateShadowRoots.add(organizationEstablishDateRoot);
        try {
            getShadowRootElement(establishDateShadowRoots).sendKeys("01/09/2003");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(establishDateShadowRoots).sendKeys("01/09/2003");
        }
    }

    private void enterEmailDomain() throws InterruptedException {
        emailDomainShadowRoots.add(emailDomainHost);
        emailDomainShadowRoots.add(emailDomainRoot);
        organizationDomain = getRandomString(6);
        try {
            getShadowRootElement(emailDomainShadowRoots).sendKeys("@"+organizationDomain+".com");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(emailDomainShadowRoots).sendKeys("@"+organizationDomain+".com");
        }
    }

    private void enterApplicantEmail() throws InterruptedException {
        applicantEmailShadowRoots.add(applicantEmailHost);
        applicantEmailShadowRoots.add(applicantEmailRoot);
        try {
            getShadowRootElement(applicantEmailShadowRoots).sendKeys("Hajer@"+organizationDomain+".com");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            getShadowRootElement(applicantEmailShadowRoots).sendKeys("Hajer@"+organizationDomain+".com");
        }
    }

    private void enterSMSCode(String code) throws InterruptedException {
        SMSCode0ShadowRoots.add(SMSCode0LocatorHost);
        SMSCode0ShadowRoots.add(SMSCode0ShadowRoot);
        SMSCode1ShadowRoots.add(SMSCode1LocatorHost);
        SMSCode1ShadowRoots.add(SMSCode1ShadowRoot);
        SMSCode2ShadowRoots.add(SMSCode2LocatorHost);
        SMSCode2ShadowRoots.add(SMSCode2ShadowRoot);
        SMSCode3ShadowRoots.add(SMSCode3LocatorHost);
        SMSCode3ShadowRoots.add(SMSCode3ShadowRoot);

        getShadowRootElement(SMSCode0ShadowRoots).sendKeys(String.valueOf(code.charAt(0)));
        getShadowRootElement(SMSCode1ShadowRoots).sendKeys(String.valueOf(code.charAt(1)));
        getShadowRootElement(SMSCode2ShadowRoots).sendKeys(String.valueOf(code.charAt(2)));
        getShadowRootElement(SMSCode3ShadowRoots).sendKeys(String.valueOf(code.charAt(3)));
        click(driver.findElement(By.id("ConfirmButton")));
    }

    private void assertOnSuccessMessage() throws InterruptedException {
        try {
            WebElement successMessage = locateElementInNestedShadowRoots(successMessageHost1,successMessageHost2,successMessageRoot);
            Assert.assertEquals(successMessage.getText(),"An email has been sent containing the request number and a summary of the data entered in the registration form.");
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            WebElement successMessage = locateElementInNestedShadowRoots(successMessageHost1,successMessageHost2,successMessageRoot);
            Assert.assertEquals(successMessage.getText(),"An email has been sent containing the request number and a summary of the data entered in the registration form.");
        }
    }

    private String generateApplicantID() {

        String prefix = "1";

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MMddHHmmss"));

        String id = prefix + timestamp.substring(0, 9);

        return id;
    }

    private String generateOrganizationNationalID() {

        String prefix = "700";

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MMddHHmmss"));

        String id = prefix + timestamp.substring(0, 7);

        return id;
    }
}
