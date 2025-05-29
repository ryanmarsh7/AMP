package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class MenuTest {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the homepage
            driver.get("https://www.agamarsh.co.uk");

            //Click home button and ensure 'Agnieszka' text is there
            WebElement menuHome = driver.findElement(By.cssSelector("#menu-item-57 > a"));
            menuHome.click();

            // Locate the navigation menu
            WebElement navMenu = driver.findElement(By.cssSelector("#menu-main-menu")); // Adjust selector as needed

            // Find all links within the navigation menu
            List<WebElement> menuLinks = navMenu.findElements(By.tagName(""));

            // Iterate through each link
            for (int i = 0; i < menuLinks.size(); i++) {
                // Re-locate the navigation menu and links to avoid stale element references
                navMenu = driver.findElement(By.cssSelector("#menu-main-menu"));
                menuLinks = navMenu.findElements(By.tagName("a"));

                WebElement link = menuLinks.get(i);
                String linkText = link.getText();
                String href = link.getAttribute("href");

                // Click the link
                link.click();

                // Wait for the page to load (simple wait; consider using WebDriverWait for better control)
                Thread.sleep(2000);

                // Verify that the current URL matches the expected href
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl.equals(href)) {
                    System.out.println("PASS: '" + linkText + "' navigated to " + currentUrl);
                } else {
                    System.out.println("FAIL: '" + linkText + "' navigated to " + currentUrl + " instead of " + href);
                }

                // Navigate back to the homepage
                driver.navigate().back();

                // Wait for the homepage to load
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
