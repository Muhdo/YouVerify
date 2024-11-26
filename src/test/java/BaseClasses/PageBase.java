package BaseClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageBase {

      public static WebDriver driver;
        WebDriverWait wait;

        public PageBase(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }

        public void waitForVisibilityOfElement(WebElement element) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
        }

        public void waitForClickAbilityOfElement(WebElement element) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

        public void click(WebElement element) {
            int attempt = 0;
            while(attempt < 3) {
                try {
                    waitForClickAbilityOfElement(element);
                    element.click();
                    break;
                } catch (StaleElementReferenceException e) {
                    //only re initializing elements here to handle stale element exception
                    //only re-initializing cos of stale elements, so can remove them, the one done in the constructor is enough
                    PageFactory.initElements(driver, this); //Re-initializes the elements on the page, used because I am using page factory annotations
                    attempt++;
                }

            }
            if(attempt == 3){
                throw new  RuntimeException ("Failed to click element after 3 attempts due to StaleElementReferenceException");
            }

        }

        public void clear(WebElement element) {
            waitForVisibilityOfElement(element);
            element.clear();
        }

        public void enterText(WebElement element, String text) {
            int attempt = 0;
            while(attempt < 3) {
                try {
                    waitForVisibilityOfElement(element);
                    element.sendKeys(text);
                    break;
                }catch (StaleElementReferenceException e){
                    PageFactory.initElements(driver, this);
                    attempt++;
                }

            }
            if(attempt == 3){
                throw new RuntimeException("Failed to enter text after 3 attempts due to StaleElementReferenceException");
            }
        }

        public void sleep(int sleep) {
            try {
                Thread.sleep(1000 * sleep);
            } catch (InterruptedException e) {

            }
        }

        public void scrollTo(WebElement element) {
            int attempt = 0;
            while(attempt < 3) {
                try {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].scrollIntoView(true)", element);
                    break;
                }catch (StaleElementReferenceException e){
                    PageFactory.initElements(driver, this);
                    attempt++;
                }
            }
            if(attempt == 3){
                throw new RuntimeException("Failed to scroll to element after 3 attempts due to StaleElementReferenceException");
            }
        }

        public void selectOptionsByIndex(WebElement element, int index) {
            Select select = new Select(element);
            select.selectByIndex(index);
        }

        public void verifyText(WebElement element, String text, String comment){
            int attempt = 0;
            while(attempt <3) {
                try {
                    waitForVisibilityOfElement(element);
                    Assert.assertEquals(element.getText(), text, comment);
                    break;
                }catch (StaleElementReferenceException e){
                    PageFactory.initElements(driver, this);
                    attempt++;
                }
            }
            if(attempt == 3){
                throw new RuntimeException("Failed to verify text after 3 attempts due to StaleElementReferenceException");
            }
        }
    }





