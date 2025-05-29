package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {
    public static void main(String[] args) {
        //set webdriver location
        System.setProperty("webdriver.chrome.driver", "/Users/agnieszkamarsh/Desktop/chromedriver-mac-x64/chromedriver");
        headerTest();
    }


    public static void headerTest(){

        //Create an instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        //launch AMP website
        driver.get("https://www.agamarsh.co.uk/");

        String Title = driver.getTitle();
        System.out.println(Title);

        if (Title.equals("Agnieszka Marsh Photography - Agnieszka Marsh")){
            System.out.println("Test Passed: Title page displayed");
        }
        else {
            System.out.println("Test Failed: Home page not displayed");
        }

        driver.close();
    }

    public static void menuTest(){

        //Create an instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        //launch AMP website
        driver.get("https://www.agamarsh.co.uk/");

        String Title = driver.getTitle();
        System.out.println(Title);

        if (Title.equals("Agnieszka Marsh Photography - Agnieszka Marsh")){
            System.out.println("Test Passed: Title page displayed");
        }
        else {
            System.out.println("Test Failed: Home page not displayed");
        }

        driver.close();
    }
}