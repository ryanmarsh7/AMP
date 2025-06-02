package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ContactUsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.xpath("//input[@id='input_1_1']");;
    private By emailField = By.xpath("//input[@id='input_1_3']");;
    private By phoneField = By.xpath("//input[@id='input_1_4']");
    private By enquiryField = By.xpath("//input[@id='input_1_5']");
    private By messageField = By.xpath("//textarea[@id='input_1_6']");
    private By submitButton = By.xpath("//input[@id='gform_submit_button_1']");

    // Optional: Wait for a success confirmation after form submission
    private By successMessage = By.cssSelector(".gform_confirmation_message");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goTo() {
        driver.get("https://www.agamarsh.co.uk/contact/");
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(phone);
    }

    public void enterEnquiry(String enquiry) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enquiryField)).sendKeys(enquiry);
    }

    public void enterMessage(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageField)).sendKeys(message);
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isSubmissionSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}
