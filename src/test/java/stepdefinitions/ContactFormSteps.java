package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import pages.ContactPage;
import tests.DriverFactory;

public class ContactFormSteps {

    WebDriver driver = DriverFactory.createDriver();
    ContactPage contactPage = new ContactPage(driver);

    @Given("I am on the Contact Us page")
    public void i_am_on_the_contact_us_page() {
        contactPage.goTo();
    }

    @When("I enter {string} into the name field")
    public void i_enter_name(String name) {
        contactPage.enterName(name);
    }

    @When("I enter {string} into the email field")
    public void i_enter_email(String email) {
        contactPage.enterEmail(email);
    }

    @When("I enter {string} into the phone field")
    public void i_enter_phone(String phone) {
        contactPage.enterPhone(phone);
    }

    @When("I enter {string} into the enquiry field")
    public void I_enter_enquiry(String message) {
        contactPage.enterEnquiry(message);
    }

    @When("I enter {string} into the message field")
    public void i_enter_message(String message) {
        contactPage.enterMessage(message);
    }

    @When("I submit the contact form")
    public void i_submit_the_form() {
        contactPage.submitForm();
    }

    @Then("I should see a confirmation message")
    public void i_should_see_confirmation() {
        Assert.assertTrue(contactPage.isSubmissionSuccessful());
    }
}
