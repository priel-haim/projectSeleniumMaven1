package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AllureAttachment;

public class LoginPage extends MenuPage {

    // open my login
    @FindBy(css = ".other-link.login")
    private WebElement OpenLoginUpBtn;

    // Write down the correct username
    @FindBy(css = "[autocomplete='username']")
    private WebElement usernameField;

    // Write down the correct password
    @FindBy(css = "[name='password']")
    private WebElement passwordField;

    // push the button to open my user
    @FindBy(css = ".btn-primary")
    private WebElement loginBtn;

    // error message
    @FindBy(css = ".alert-danger")
    private WebElement errorMessage;
    @FindBy(css = "#nav-dropdown .flex")
    private WebElement MyLogin;
    @FindBy(css = ".auth-panel")
    private WebElement finalErrorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("open your user name")
    public void openLogin() {
        click(OpenLoginUpBtn);
        sleep(1000);
    }

    @Step("login to the site")
    public void loginToTheSite(String username, String Password) {
        sleep(200);
        fillText(usernameField, username);
        fillText(passwordField, Password);
        sleep(200);
        click(loginBtn);
        AllureAttachment.attachElementScreenshot(MyLogin);
    }

    @Step("show me error message")
    public void loginToErrorMessage(String username, String Password) {
        sleep(200);
        fillText(usernameField, username);
        fillText(passwordField, Password);
        sleep(200);
        AllureAttachment.attachElementScreenshot(finalErrorMessage);
        click(loginBtn);
    }

    @Step("Show me an error message")
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    @Step("Confirm my login")
    public String getMyLogin() {
        return getText(MyLogin);
    }
}
