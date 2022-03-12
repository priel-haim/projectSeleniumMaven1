package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AllureAttachment;

public class LoginPage extends MenuPage {
    // open the size involve.me
    @FindBy(css = ".other-link.login")
    WebElement OpenLoginUpBtn;
    @FindBy(css = "[autocomplete='username']")
    WebElement usernameField;
    @FindBy(css = "[name='password']")
    WebElement passwordField;
    @FindBy(css = ".btn-primary")
    WebElement loginBtn;
    @FindBy(css = ".alert-danger")
    WebElement errorMessage;
    @FindBy(css = "#nav-dropdown>div .flex")
    WebElement MyLogin;
    @FindBy(css = ".auth-panel")
    WebElement finalErrorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("open your user name")
    public void OpenLogin() {
        click(OpenLoginUpBtn);
        sleep(1000);
    }

    @Step("login to the site")
    public void LoginToTheSite(String username, String Password) {
        sleep(200);
        fillText(usernameField, username);
        fillText(passwordField, Password);
        sleep(200);
        click(loginBtn);
        AllureAttachment.attachElementScreenshot(MyLogin);
    }

    @Step("show me error message")
    public void LoginToErrorMessage(String username, String Password) {
        sleep(200);
        fillText(usernameField, username);
        fillText(passwordField, Password);
        sleep(200);
        AllureAttachment.attachElementScreenshot(finalErrorMessage);
        click(loginBtn);
    }

    @Step("Show me an error message")
    public String GetErrorMessage() {
        return getText(errorMessage);
    }

    @Step("Confirm my login")
    public String GetMyLogin() {
        return getText(MyLogin);
    }
}
