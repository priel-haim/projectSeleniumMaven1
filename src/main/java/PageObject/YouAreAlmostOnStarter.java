package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AllureAttachment;

public class YouAreAlmostOnStarter extends MenuPage {

    // Your Payment Details
    @FindBy(css = "#card-holder-name")
    WebElement NameField;
    // Frame
    @FindBy(css = "div iframe")
    WebElement Frame;
    @FindBy(css = "[name='cardnumber']")
    WebElement NumCardField;
    @FindBy(css = "[name='exp-date']")
    WebElement DateCardField;
    @FindBy(css = "[name='cvc']")
    WebElement SecurityNumbersField;
    @FindBy(css = "label>#coupon")
    WebElement CouponField;
    // for allure
    @FindBy(css = ".form-row.mb-3")
    WebElement allPaymentDetails;

    // Your Billing Details
    @FindBy(css = "#first_name")
    WebElement firstNameField;
    @FindBy(css = "#last_name")
    WebElement lastNameField;
    @FindBy(css = "#company")
    WebElement companyField;
    @FindBy(css = "#email")
    WebElement emailField;
    @FindBy(css = "#phone")
    WebElement phoneField;
    @FindBy(css = "#street")
    WebElement streetField;
    @FindBy(css = "#street_no")
    WebElement streetNoField;
    @FindBy(css = "#zip")
    WebElement ZIPCodeField;
    @FindBy(css = "#city")
    WebElement cityField;
    @FindBy(css = "label #country")
    WebElement countryList;
    // for allure
    @FindBy(css = ".col-sm-12>div>div:nth-child(1)")
    WebElement allBillingDetails;

    // I agree to the involve.me
    @FindBy(css = "span>label")
    WebElement IagreeBtn;
    @FindBy(css = "div #payment-submit")
    WebElement PaymentBtn;
    @FindBy(css = ".order-summary h5")
    WebElement orderSummary;

    public YouAreAlmostOnStarter(WebDriver driver) {
        super(driver);
    }

    @Step("your payment details")
    public void yourPaymentDetails1(String Name, String NumCard, String DateCard, String SecurityNumbers, String Coupon) {
        fillText(NameField, Name);
        // move to frame
        driver.switchTo().frame(Frame);
        fillText(NumCardField, NumCard);
        fillText(DateCardField, DateCard);
        fillText(SecurityNumbersField, SecurityNumbers);
        //  move back from frame
        driver.switchTo().defaultContent();
        fillText(CouponField, Coupon);
        sleep(1000);
        AllureAttachment.attachElementScreenshot(allPaymentDetails);
    }

    @Step("your billing details")
    public void yourBillingDetails1(String firstName, String lastName, String company, String email, String phone, String street, String streetNo, String ZIPCode, String city, String country) {
        fillText(firstNameField, firstName);
        fillText(lastNameField, lastName);
        fillText(companyField, company);
        fillText(emailField, email);
        fillText(phoneField, phone);
        fillText(streetField, street);
        fillText(streetNoField, streetNo);
        fillText(ZIPCodeField, ZIPCode);
        fillText(cityField, city);
        selectByValue(countryList, country);
        sleep(1000);
        AllureAttachment.attachElementScreenshot(allBillingDetails);
    }

    @Step("your order summary")
    public void yourOrderSummary() {
        click(IagreeBtn);
        click(PaymentBtn);
    }

    @Step("your order summaryy")
    public String yourOrderSummaryy() {
        return getText(orderSummary);
    }
}
