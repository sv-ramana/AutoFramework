package base;

import base.PageObjects.IntialPage;
import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.net.URL;
import java.util.HashMap;

public class base {
    public WebDriver driver;

    IntialPage firstpage = new IntialPage();
    @BeforeSuite
    public void BeforePreReqsuite() {
        System.out.println("Before Suite Started");
    }

    @BeforeTest
    public void BeforeprereqTest() {
        System.out.println("Test going to be started");
    }

    @BeforeClass
    public void BeforepreReqclass(){
        System.out.println("Before class started");
    }

    @BeforeMethod
    @Parameters({"Browser", "URL"})
    public void BeforepreReqMethod(String Browser, String URL) {
        System.out.println("Before Method started");
        ChromeOptions Options = new ChromeOptions();
        HashMap<String,Object> chromePrefs= new HashMap<String,Object>();
        chromePrefs.put("profile.default_content_settings.popups",0);
       // chromePrefs.put("download.default_directory",DesiredOutputPath);
        Options.setExperimentalOption("prefs",chromePrefs);
        Options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        Options.addArguments("--remote-allow-origins=*");
        Options.addArguments("--start-maximized");
        Options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (Browser.equals("Chrome")) {
            driver = WebDriverManager.chromedriver().capabilities(Options).create();
        } else if(Browser.equals("IE")) {
            driver = WebDriverManager.edgedriver().create();
        } else {
            driver = WebDriverManager.firefoxdriver().capabilities(Options).create();
        }
        driver.get(URL);
    }
    //(dataProvider = "Data-Providername")
    @Test
    public void testfirst() {
        System.out.println("main test started now");
        utilities.Sendvalues(driver, firstpage.search_bar, "QA Automation");
    }


    @AfterMethod
    public void AfterpreReqMethod() {
        System.out.println("After Method started");
    }

    @AfterClass
    public void AfterprereqClass() {
        System.out.println("After class started");
    }

    @AfterTest
    public void AfterprereqTest() {
        System.out.println("Test going to be End");
    }
    @AfterSuite
    public void AfterprereqSuite() {
        System.out.println("After Suite Started");
        driver.close();
        driver.quit();
    }

//    @DataProvider(name = "Data-Providername")
//    public Object[][] dataproviders(){
//        return new Object[][] {{"QA automation"},{"QA"}};
//    }
}
