package Utils.ExtentReporter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;


import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static BaseClasses.TestBase.driver;

public class ExtentReport implements ITestListener {
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest test;

    public static String localDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        LocalDateTime currentTime = LocalDateTime.now();
        return (dtf.format(currentTime));
    }

    public void onStart(ITestContext context) {
        String currentDate = localDate();
        String reportPath = "./Reports/TestReport-" + currentDate + ".html";
        extentSparkReporter = new ExtentSparkReporter(reportPath);
        extentSparkReporter.config().setReportName("Test Automation Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("Automation Report");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Tester", "Muhammed Oyewumi");
        extentReports.setSystemInfo("Browser name", "chrome");
        extentReports.setSystemInfo("OS", "Windows 11");

    }

    public void onTestSuccess(ITestResult result) {
        test = extentReports.createTest(result.getName());
        test.log(Status.PASS, "Test case passed is: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test = extentReports.createTest(result.getName());
        test.log(Status.FAIL, "Test case failed is: " + result.getName());

        try {
            String currentDate = localDate();
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "./Screenshots/" + result.getName() + "_" + currentDate + ".png";
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));

            test.addScreenCaptureFromPath(screenshotPath, "Screenshot of the failure");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extentReports.createTest(result.getName());
        test.log(Status.SKIP, "Test case skipped is: " + result.getName());
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
