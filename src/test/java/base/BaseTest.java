package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import tests.DriverFactory;
import tests.ConfigReader;

public class BaseTest {
    public WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver();
        System.out.println("Browser: " + ConfigReader.getBrowser());
        System.out.println("Headless: " + ConfigReader.isHeadless());
      //  System.out.println("Environment: " + ConfigReader.getEnvironment());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}