package BaseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

        public static WebDriver driver;
        String browser;
        String file_path = "src/test/java/Utils/testData.properties";
        FileInputStream fis;
        public Properties testData;

        public TestBase(){
            props();
        }


        public void props(){
            testData = new Properties();
            try {
                fis  = new FileInputStream(file_path);
                testData.load(fis);
            }catch (IOException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }

        @BeforeClass
        public void mainSetup(){
            browser = testData.getProperty("browser");
            if(browser.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if(browser.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            else if(browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
            driver.get(testData.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        }

        public void sleep(int sleep){
            try{
                Thread.sleep(1000 * sleep);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        @AfterClass
        public void tearDown(){
            if(null != driver){
                driver.quit();
            }
        }
    }


