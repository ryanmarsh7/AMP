package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // ======== Locators with Justification ========

    // Logo at the top left – unique class and always visible on page load.
    private By siteLogo = By.cssSelector("a.custom-logo-link img");

    // Hero image or banner – visually identifies the page and is consistently present.
    private By heroImage = By.cssSelector("section.elementor-section img");

    // 'Contact' menu link – top navigation. LinkText is readable and resilient.
    private By contactMenuLink = By.linkText("Contact");

    // Footer – useful for checking if the page is fully loaded.
    private By footer = By.cssSelector("footer.site-footer");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goTo() {
        System.out.println("Opening Aga Marsh Home Page");
        driver.get("https://www.agamarsh.co.uk/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(siteLogo));
        System.out.println("Homepage loaded");
    }

    public boolean isLogoVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(siteLogo)).isDisplayed();
    }

    public boolean isHeroImageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(heroImage)).isDisplayed();
    }

    public boolean isFooterVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(footer)).isDisplayed();
    }

    public void clickContactMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(contactMenuLink)).click();
        System.out.println("Clicked on Contact menu item");
    }
}
