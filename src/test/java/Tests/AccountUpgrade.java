package Tests;

import PageObject.ChooseASubscriptionThatSuitsYou;
import PageObject.LoginPage;
import PageObject.MyWorkspace;
import PageObject.YouAreAlmostOnStarter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountUpgrade extends BaseTest {

    @Test(description = "Sign in with my name details")
    public void tc01_openLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.cookies();
        loginPage.openLogin();
        loginPage.loginToTheSite("prili2@walla.com", "Haim-Haim");
        String expected = "Haim-a";
        String actual = loginPage.getMyLogin();
        Assert.assertEquals("Haim-a", expected);
    }

    @Test(description = "click on the button to upgrade")
    public void tc02_chooseUpgrade() {
        MyWorkspace myWorkspace = new MyWorkspace(driver);
        String Upgrade = myWorkspace.getUpgrade();
        myWorkspace.clickUpgrade();
        Assert.assertEquals("Upgrade ⭐", Upgrade);
    }

    @Test(description = "choose in upgrade")
    public void tc03_chooseTypeUpgrade() {
        ChooseASubscriptionThatSuitsYou chooseSuitable = new ChooseASubscriptionThatSuitsYou(driver);
        chooseSuitable.chooseMonthlyOrYearly("monthly");
        String Type = chooseSuitable.getChooseTypeUpgrade();
        chooseSuitable.typeUpgrade("Get Business monthly");
        Assert.assertEquals(Type, "Get Business monthly");

    }

    @Test(description = "The details of the means of payment, and personal details should be stated")
    public void tc04_fillInDetails() {
        YouAreAlmostOnStarter starter = new YouAreAlmostOnStarter(driver);
        starter.yourPaymentDetails1("Haim Navon", "4580-0303-3333-8353", "1226", "333", "ert54v6");
        starter.yourBillingDetails1("Haim", "Navon", "PHA", "p-azoulay@gmail.com", "052-2345672", "Rakefet", "15",
                "99000", "bait shemesh", "IL");
        starter.yourOrderSummary();
        String payment = "Your order summary";
        Assert.assertTrue(starter.yourOrderSummaryy().contentEquals(payment));
    }
}
