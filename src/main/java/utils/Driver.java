package utils;

import org.openqa.selenium.WebDriver;

import static utils.DriverProvider.getChrome;

public interface Driver {

    ThreadLocal<WebDriver> instance = new ThreadLocal<WebDriver>();

    static WebDriver getDriver(DriverType type){
        if (instance.get() == null) {
            switch (type) {
                case CHROME:
                    instance.set(getChrome());
                    break;
                case FIREFOX:
                    //instance.set(getFirefox());
                    break;
            }
        }
        return instance.get();
    }

}
