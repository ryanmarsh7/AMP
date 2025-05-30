package tests;
import base.BaseTest;
import org.testng.annotations.Test;


public class HomePageLoadValidation extends BaseTest {


    @Test
    public void testHomeLaunch() {

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

}
