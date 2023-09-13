package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

/*
Runs cucumber every detected feature as seperated test
 */
public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        System.out.println(browserName);
        if (browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--headless");
            driver=new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        }
        // Headless browser testing
        else if (browserName.equalsIgnoreCase("headless"))
         {

//             DesiredCapabilities caps = new DesiredCapabilities();
//                     caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
//                     System.getProperty("user.dir")+"/drivers/phantomjs.exe");
//             String[] phantomJsArgs = {"--web-security=no", "--ignore-ssl-errors=yes"};
//             caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
             System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
             ChromeOptions options=new ChromeOptions();
             options.addArguments("--headless");
             driver=new ChromeDriver(options);
//            driver = new PhantomJSDriver(caps);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.navigate().to("http://kazoositedev.softlinktest.com/home");
    }

    @AfterSuite
    public void stopDriver() {
        driver.quit();
    }

    //Take screenshot when test case fail & add it in the screenshots folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking screenshot.......");
            Helper.captureScreenShot(driver, result.getName());
        }
    }

}
