package Utils.TestListener;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestNGListener;
import org.testng.ITestResult;


public class Retry implements IRetryAnalyzer, ITestNGListener {
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // Number of retries

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // Retry the test
        }
        return false; // Stop retrying
    }
}
