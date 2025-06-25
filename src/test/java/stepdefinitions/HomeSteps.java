package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.ContactUsPage;
import utils.TestContextSetup;

public class HomeSteps {

    TestContextSetup context;
    HomePage homePage;
    ContactUsPage contactUsPage;

    public HomeSteps(TestContextSetup context) {
        this.context = context;
        this.homePage = context.pageObjectManager.getHomePage();
        this.contactUsPage = context.pageObjectManager.getContactUsPage();
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        homePage.goTo();
    }

    @Then("the site logo should be visible")
    public void the_site_logo_should_be_visible() {
        Assert.assertTrue(homePage.isLogoVisible(), "Site logo should be visible");
    }

    @Then("the hero image should be visible")
    public void the_hero_image_should_be_visible() {
        Assert.assertTrue(homePage.isHeroImageVisible(), "Hero image should be visible");
    }

    @Then("the footer should be visible")
    public void the_footer_should_be_visible() {
        Assert.assertTrue(homePage.isFooterVisible(), "Footer should be visible");
    }

    @When("I click on the Contact menu")
    public void i_click_on_the_contact_menu() {
        homePage.clickContactMenu();
    }

    @Then("I should be on the Contact page")
    public void i_should_be_on_the_contact_page() {
        Assert.assertTrue(contactUsPage.isSubmissionSuccessful() ||
                contactUsPage.isNameFieldVisible(), "Contact page should be loaded");
    }
}
