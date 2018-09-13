package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverProvider implements Driver{

    static String OS_EXTENTION = (System.getProperty("os.name").toLowerCase().contains("win")) ? ".exe" :
            (System.getProperty("os.name").toLowerCase().contains("mac")) ? "_mac" :
                    "_linux";

    static String CHROME_PATH = "drivers/chromedriver" + OS_EXTENTION;

    public static ChromeDriver getChrome(){

        System.setProperty("webdriver.chrome.driver", CHROME_PATH);

        DesiredCapabilities caps = DesiredCapabilities.chrome();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--headless");

        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return new ChromeDriver();

    }


    public static void closeDriver(){
        instance.get().quit();
        instance.set(null);
    }

}
