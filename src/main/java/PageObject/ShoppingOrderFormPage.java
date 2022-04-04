package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingOrderFormPage extends MenuPage {

    // Open The Store
    @FindBy(css = ".c-button.btn")
    WebElement ShopNowBtn;

    // Pick your favorite look
    @FindBy(css = "[style='font-size: 14px;']")
    List<WebElement> StyleBtns;

    // What's your size?
    @FindBy(css = ".el-select__caret.el-input__icon")
    WebElement OpenYourSizeBtn;
    @FindBy(css = "div ul>.el-select-dropdown__item span")
    List<WebElement> YourSizeList;

    // What's your first name?
    @FindBy(css = "[placeholder='First Name*']")
    WebElement FnameField;

    // what's your last name & email?
    @FindBy(css = ".is-shrinkable>div>span")
    WebElement LastNameAndEmail;
    @FindBy(css = "[placeholder='Last Name']")
    WebElement LnameField;
    @FindBy(css = "[placeholder='Email*']")
    WebElement EmailField;
    @FindBy(css = ".c-button.btn")
    WebElement ContinueBtn;

    // which shipping method would you prefer?
    @FindBy(css = ".btn-secondary")
    List<WebElement> ShippingBtn;

    // where should we ship your attire?
    @FindBy(css = "[placeholder='Street address*']")
    WebElement StreetAddressField;
    @FindBy(css = ".zipCode-label>input")
    WebElement PostalCodeField;
    @FindBy(css = "[placeholder='City*']")
    WebElement CityField;
    @FindBy(css = "[placeholder='State*']")
    WebElement StateField;
    @FindBy(css = ".el-input__icon.el-icon-arrow-up")
    WebElement SelectCountryBtn;

    // Search My Country
    @FindBy(css = ".el-select-dropdown__wrap>ul>li span")
    List<WebElement> MyCountryList;
    @FindBy(css = ".e-headline span")
    WebElement finalTile;

    public ShoppingOrderFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("Style your way")
    public void styleYourWay() {
        sleep(1000);
        click(ShopNowBtn);
        sleep(2000);
    }

    @Step("what is Your Favorite Look?")
    public void pickYourFavoriteLook(String styleName) {
        for (WebElement StyleBtn : StyleBtns) {
            if (getText(StyleBtn).contains(styleName)) {
                click(StyleBtn);
                break;
            }
        }
        sleep(2000);
    }

    @Step("what is your size?")
    public void yourSize(String value) {
        click(OpenYourSizeBtn);
        List<WebElement> size = YourSizeList;
        for (WebElement YourSizeList : size) {
            sleep(1000);
            if (getText(YourSizeList).equalsIgnoreCase(value)) {
                click(YourSizeList);
                break;
            }
        }
        sleep(1000);
    }

    @Step("what is your first name?")
    public void firstName(String frame) {
        fillText(FnameField, frame);
        sleep(500);
        click(ContinueBtn);
    }

    @Step("what is your last name and your email?")
    public void lastNameAndEmail(String lname, String email) {
        fillText(LnameField, lname);
        sleep(2000);
        fillText(EmailField, email);
        sleep(1000);
        click(ContinueBtn);
    }

    @Step("prefer shipping")
    public void preferShipping(String text) {
        List<WebElement> shipping = ShippingBtn;
        for (WebElement ShippingBtn : shipping) {
            if (getText(ShippingBtn).contains(text)) {
                click(ShippingBtn);
                break;
            }
            sleep(2000);
        }
        sleep(2000);
    }

    @Step("Choose your exact address")
    public void shippingAddress(String[] address) {
        fillText(StreetAddressField, address[0]);
        sleep(2000);
        fillText(PostalCodeField, address[1]);
        sleep(1000);
        fillText(CityField, address[2]);
        sleep(1000);
        fillText(StateField, address[3]);
        sleep(1000);
        click(SelectCountryBtn);
        sleep(500);
        List<WebElement> country = MyCountryList;
        for (WebElement MyCountryList : country) {
            if (getText(MyCountryList).contains(address[4])) {
                click(MyCountryList);
                break;
            }
            sleep(80);
        }
        sleep(1000);
        click(ContinueBtn);
    }

    @Step("fill order form")
    public void fillOrderForm(String styleName, String size, String fName, String lName, String email, String[] address,
                              String shippingMethod) {
        styleYourWay();
        pickYourFavoriteLook(styleName);
        yourSize(size);
        firstName(fName);
        lastNameAndEmail(lName, email);
        preferShipping(shippingMethod);
        shippingAddress(address);
        sleep(1000);

    }

    @Step("get title")
    public String getTitle() {
        return getText(finalTile);
    }

}
