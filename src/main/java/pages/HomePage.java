package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = ".//span[contains(text(), 'Loans')]")
    public WebElement loansButton;

    @FindBy(how = How.LINK_TEXT, using = "Mortgages")
    public WebElement mortrageLink;

    public MortgagePage openMortgagePage(){
        loansButton.click();
        mortrageLink.click();
        return GetPage(MortgagePage.class);
    }
}
