import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.MortgagePage;
import utils.BaseTest;

public class NewTest extends BaseTest {

    @Test(description = "Mortgage calculator test")

    public void test_name(){

        MortgagePage page = BasePage.openHome().openMortgagePage();

        page.openMortgagePaymentCalc();
        Assert.assertTrue(page.verifyPriceSlider(), "Failed to change price slider position");

        page.increasePrice(500_000);
        page.setDownPayment(50_000);
        page.setAmortizationFor15Years();
        page.setPaymentFrequencyToWeekly();
        page.setInterestRateTo("5");
        page.clickOnCalculateButton();

        //by provided instruction expected result should be 836.75, actual result is 842.47
        Assert.assertEquals(page.getPaymentResult(), 836.75, "Payment result does not equals to expected");
    }
}
