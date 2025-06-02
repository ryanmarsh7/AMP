package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static final ExtentReports extent = new ExtentReports();

    public static ExtentReports getReporter() {
        if (extent.getStartedReporters().isEmpty()) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle("Automation Test Report");
            htmlReporter.config().setReportName("Selenium Test Results");

            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
