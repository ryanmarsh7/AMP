package tests;
import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.ContactPage;


public class HomePageLoadValidation extends BaseTest {


    @Test
    public void testHomeLaunch() {

        driver.get("https://www.agamarsh.co.uk/");
        Assert.assertEquals(driver.getTitle(), "Agnieszka Marsh Photography - Agnieszka Marsh");

        String Title = driver.getTitle();
        System.out.println(Title);

        if(Title.equals("Agnieszka Marsh Photography - Agnieszka Marsh"))

    {
        System.out.println("Test Passed: Title page displayed");
    }
        else

    {
        System.out.println("Test Failed: Home page not displayed");
    }

}

    @Test
    public void validateContactFormSubmission() {
        System.out.println("Executing Contact Form scenarios");
        ContactPage contactPage = new ContactPage(driver);
        contactPage.goTo();
        contactPage.enterName("Xander Marsh");
        contactPage.enterEmail("Xaxa@test.com");
        contactPage.enterPhone("07729455026");
        contactPage.enterEnquiry("Test of email");
        contactPage.enterMessage("This is a test message from our automation framework. This is to confirm that the website is up and running as expected");
        contactPage.submitForm();

        Assert.assertTrue(contactPage.isSubmissionSuccessful(), "Contact form submission failed.");

        System.out.println("contact form scenario executed as expected");
    }

}
