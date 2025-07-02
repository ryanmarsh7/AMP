package utils;

import org.openqa.selenium.WebDriver;
import pages.ContactPage;
import pages.HomePage;

public class PageObjectManager {
    private final WebDriver driver;
    private HomePage homePage;
    private ContactPage contactPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public ContactPage getContactPage() {
        if (contactPage == null) {
            contactPage = new ContactPage(driver);
        }
        return contactPage;
    }
}
