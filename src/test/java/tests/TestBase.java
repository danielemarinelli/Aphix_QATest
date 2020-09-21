package tests;


import core.DriverFactory;
import core.TestConfig;
import org.junit.jupiter.api.TestReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestBase {

    private WebDriver driver;


    @BeforeSuite
    public void initSuite() throws Exception {
        TestConfig.load(System.getenv("env"));
        TestConfig.addProperty("browser",System.getenv("browser"));
        TestConfig.addProperty("env",System.getenv("env"));

    }

    @BeforeClass
    public void initDriver() {
        driver =  new DriverFactory().getDriver(TestConfig.getProperty("browser"));
    }


    public WebDriver driver() {
        return driver;
    }

    @BeforeMethod
    public void launchApp() {
        driver.get(TestConfig.getProperty("appHomeURL"));
    }



    @AfterMethod
    public void takeScreenShotIfFailure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera =((TakesScreenshot)driver);
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot taken: " + screenShot.getAbsolutePath());
            File DestFile = new File("./ScreenShots/"+result.getName()+"_Fail.png");
            FileHandler.copy(screenShot,DestFile);
        }

    }

    @AfterClass
    public void closeBrowser() {
        if(driver!=null) {
            driver.quit();
        }
    }
}