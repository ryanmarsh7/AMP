package utils;

import org.openqa.selenium.WebDriver;
import tests.DriverFactory;

public class TestContextSetup {
    public WebDriver driver;
    public PageObjectManager pageObjectManager;

    public TestContextSetup() {
        driver = DriverFactory.createDriver();
        pageObjectManager = new PageObjectManager(driver);
    }
}
