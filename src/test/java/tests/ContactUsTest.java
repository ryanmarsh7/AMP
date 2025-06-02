package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import base.BaseTest;

public class ContactUsTest extends BaseTest {

    @Test
    public void validateContactFormSubmission() {
        ContactUsPage contactPage = new ContactUsPage(driver);
        contactPage.goTo();
        contactPage.enterName("Xander Marsh");
        contactPage.enterEmail("Xaxa@test.com");
        contactPage.enterPhone("07729455026");
        contactPage.enterEnquiry("Test of email");
        contactPage.enterMessage("This is a test message from our automation framework. This is to confirm that the website is up and running as expected");
        contactPage.submitForm();

        Assert.assertTrue(contactPage.isSubmissionSuccessful(), "Contact form submission failed.");
    }
}
