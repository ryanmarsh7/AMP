package stepdefinitions;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
    private final TestContextSetup testContext;

    public Hooks(TestContextSetup testContext) {
        this.testContext = testContext;
    }

    @After
    public void tearDown() {
        if (testContext.driver != null) {
            testContext.driver.quit();
        }
    }
}
