package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingOrderFormPage extends MenuPage {
	// Open The Store
	@FindBy(css = ".c-button.btn")
	private WebElement ShopNowBtn;

	// Pick your favorite look
	@FindBy(css = "[style='font-size: 14px;']")
	private List<WebElement> StyleBtns;

	// What's your size?
	@FindBy(css = ".el-select__caret.el-input__icon")
	private WebElement OpenYourSizeBtn;
	@FindBy(css = "div ul>.el-select-dropdown__item span")
	private List<WebElement> YourSizeList;

	// What's your first name?
	@FindBy(css = "[placeholder='First Name*']")
	private WebElement FnameField;

	// what's your last name & email?
	@FindBy(css = ".is-shrinkable>div>span")
	private WebElement LastNameAndEmail;
	@FindBy(css = "[placeholder='Last Name']")
	private WebElement LnameField;
	@FindBy(css = "[placeholder='Email*']")
	private WebElement EmailField;
	@FindBy(css = ".c-button.btn")
	private WebElement ContinueBtn;

	// which shipping method would you prefer?
	@FindBy(css = ".btn-secondary")
	private List<WebElement> ShippingBtn;

	// where should we ship your attire?
	@FindBy(css = "[placeholder='Street address*']")
	private WebElement StreetAddressField;
	@FindBy(css = ".zipCode-label>input")
	private WebElement PostalCodeField;
	@FindBy(css = "[placeholder='City*']")
	private WebElement CityField;
	@FindBy(css = "[placeholder='State*']")
	private WebElement StateField;
	@FindBy(css = ".el-input__icon.el-icon-arrow-up")
	private WebElement SelectCountryBtn;

	// Search My Country
	@FindBy(css = ".el-select-dropdown__wrap>ul>li span")
	private List<WebElement> MyCountryList;

	// for Assert
	// click to start
	@FindBy(css = ".c-button.btn")
	private WebElement ShopNow;
	// Choose Your Favorite Look
	@FindBy(css = "div:nth-child(4)>.c-image-answer-title")
	private WebElement YuorShort;
	// Choose your size
	@FindBy(css = "li:nth-child(3)>span")
	private WebElement YourSize;
	@FindBy(css = "label>span")
	private WebElement FirstName;
	// What your name and last name adn your email?
	@FindBy(css = ".input-label.lastName-label>input")
	private WebElement LastName;
	@FindBy(css = "/html/body/div[1]/div/div/div[3]/div/div/div[3]/div/div[3]/div/form/div/label/span")
	private WebElement Email;
	// which shipping method would you prefer?
	@FindBy(css = "button:nth-child(4)")
	private WebElement ShippingMethod;
	// Where to send the garment?
	@FindBy(css = ".e-headline span")
	private WebElement ShippingAddress;
	@FindBy(css = "div:nth-child(1)>label>span")
	private WebElement StreetAddress;
	@FindBy(css = "form>div:nth-child(2)>label>span")
	private WebElement PostalCode;
	@FindBy(css = "div:nth-child(3)>label>span")
	private WebElement City;
	@FindBy(css = "div:nth-child(4)>label>span")
	private WebElement State;
	@FindBy(css = "div:nth-child(5)>div>label")
	private WebElement Country;
	@FindBy(css = ".e-headline span")
	private WebElement finalTile;
	//
	@FindBy(css = ".e-headline span")
	private WebElement CheckingTheOrder;

	public ShoppingOrderFormPage(WebDriver driver) {
		super(driver);
	}

	public void StyleYourWay() {
		sleep(1000);
		click(ShopNowBtn);
		sleep(2000);
	}

	public void PickYourFavoriteLook(String styleName) {
		// List<WebElement> style = StyleBtn;
		for (WebElement StyleBtn : StyleBtns) {
			if (getText(StyleBtn).contains(styleName)) {
				click(StyleBtn);
				break;
			}
		}
		sleep(2000);
	}

	public void YourSize(String value) {
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

	public void FirstName(String fname) {
		fillText(FnameField, fname);
		sleep(500);
		click(ContinueBtn);
	}

	public void LastNameAndEmail(String lname, String email) {
		fillText(LnameField, lname);
		sleep(2000);
		fillText(EmailField, email);
		sleep(1000);
		click(ContinueBtn);
	}

	public void PreferShipping(String text) {
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

	public void ShippingAddress(String[] address) {
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

	public void fillOrderForm(String styleName, String size, String fName, String lName, String email, String[] address,
			String shippingMethod) {
		StyleYourWay();
		PickYourFavoriteLook(styleName);
		YourSize(size);
		FirstName(fName);
		LastNameAndEmail(lName, email);
		PreferShipping(shippingMethod);
		ShippingAddress(address);
		sleep(1000);

	}

	public String openTheShop() {
		return getText(ShopNow);
	}

	public String getTitle() {
		return getText(finalTile);
	}

}
