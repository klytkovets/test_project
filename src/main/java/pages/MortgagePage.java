package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MortgagePage extends BasePage{


    //* UI Mapping *//
    @FindBy(how = How.CSS, using = ".bloc-contenu.bloc-contenu-versements ")
    public WebElement mortrageCalc;

    @FindBy(how = How.XPATH, using = (".//div[@class='row']//div[@class='slider-handle min-slider-handle custom'][1]"))
    public WebElement priceSliderHandle;

    @FindBy(how = How.ID, using = "PrixPropriete")
    public WebElement priceField;

    @FindBy(how = How.ID, using = "PrixProprietePlus")
    public WebElement priceIncreaseButton;

    @FindBy(how = How.ID, using = "MiseDeFond")
    public WebElement downPaymentField;

    @FindBy(how = How.XPATH, using = ".//select[@id='Amortissement']")
    public WebElement ammortizationDropdown;

    @FindBy(how = How.XPATH, using = ".//b[@class='button'][1]")
    public WebElement amortButton;

    @FindBy(how = How.XPATH, using = ".//li[contains(text(), '15')]")
    public WebElement fifteenYears;

    @FindBy(how = How.XPATH, using = ".//label[@for='FrequenceVersement']/following-sibling::div//b")
    WebElement paymentFrequencyButton;

    @FindBy(how = How.XPATH, using = ".//li[normalize-space(text()) = 'weekly']")
    WebElement weeklyPaymentOption;

    @FindBy(how = How.ID, using = "TauxInteret")
    WebElement interestRateBox;

    @FindBy(how = How.ID, using = "btn_calculer")
    WebElement calculateButton;

    @FindBy(how = How.ID, using = "paiement-resultats")
    WebElement paymentResult;



    //* Page Methods *//

    @Step("Opening mortgage calculator")
    public void openMortgagePaymentCalc(){
        mortrageCalc.click();
    }

    @Step("Verifying price slider")
    public boolean verifyPriceSlider(){
        int price = Integer.valueOf(priceField.getAttribute("value"));
        Actions actions = new Actions(BasePage.driver.get());
        WebElement From = priceSliderHandle;
        actions.clickAndHold(From)
                .moveByOffset(100, 0)
                .release().build().perform();
        int changedPrice = Integer.valueOf(priceField.getAttribute("value"));
        return price != changedPrice;
    }

    @Step("Changing price to: {0}")
    public void increasePrice(int price){
        while (Integer.valueOf(priceField.getAttribute("value")) != price){
            priceIncreaseButton.click();
        }
    }

    @Step("Setting down payment to: {0}")
    public void setDownPayment(int downPayment){
        downPaymentField.sendKeys(String.valueOf(downPayment));
    }

    @Step("Changing ammortization to \"15 Years\"")
    public void setAmortizationFor15Years(){
        amortButton.click();
        fifteenYears.click();
    }

    @Step("Changing payment frequency to \"weekly\"")
    public void setPaymentFrequencyToWeekly(){
        paymentFrequencyButton.click();
        weeklyPaymentOption.click();
    }

    @Step("Setting interest rate to: {0}")
    public void setInterestRateTo(String rate){
        interestRateBox.clear();
        interestRateBox.sendKeys(rate);
    }

    @Step("Clicking on \"Calculate\" button")
    public void clickOnCalculateButton(){
        calculateButton.click();
    }

    @Step("Getting payment result")
    public float getPaymentResult(){
        waitForElement(paymentResult);
        return Float.valueOf(paymentResult.getText().replace("$", ""));
    }

}
