package utils;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.net.MalformedURLException;

public class BaseTest{

    @BeforeMethod
    public void beforeWithData(){
        //create driver
        BasePage.driver.set(Driver.getDriver(DriverType.CHROME));
    }

    @AfterMethod
    public void endTest(ITestResult testResult){

        //close driver
        BasePage.driver().quit();
        DriverProvider.closeDriver();

    }

    @AfterSuite(alwaysRun = true)
    public void flushReporter() {
        //reporter.closeReporter();
    }

}
