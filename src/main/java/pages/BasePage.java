package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    static String baseURL = "http://www.ia.ca";

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver driver(){
        return driver.get();
    }

    @Step("Opening home page")
    public static HomePage openHome(){
        driver.get().get(baseURL);
        driver.get().manage().window().maximize();
        return GetPage(HomePage.class);
    }

    public void selectFromDropdown(WebElement element, String text){
        //waitForElement(element);
        Select dropdown = new Select(element);
        dropdown.selectByValue(text);
    }

    static void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver.get(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    static <Page> Page GetPage(Class<Page> pageClass) {
        try {
            return PageFactory.initElements(driver.get(), pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
