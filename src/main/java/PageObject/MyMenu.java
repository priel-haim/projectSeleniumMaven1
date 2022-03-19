package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyMenu extends MenuPage {

    @FindBy(css = ".fas.fa-caret-down.ml-2")
    WebElement yourAccountField;
    @FindBy(css = "div>.darken")
    WebElement forgetBtn;
    @FindBy(css = "[autocomplete='username']")
    WebElement forgetPasswordField;
    @FindBy(css = ".btn.btn-primary")
    WebElement messageEmailBtn;
    @FindBy(css = ".nav-item.dropdown")
    WebElement OpenMenulist;
    @FindBy(css = ".dropdown-menu.w-auto.whitespace-no-wrap.absolute.bg-white.shadow-md>li>a")
    List<WebElement> Menulist;

    public MyMenu(WebDriver driver) {
        super(driver);
    }

    @Step("user menu")
    public void UserMenu(String name) {
        click(yourAccountField);
        sleep(2000);
        List<WebElement> list = Menulist;
        for (WebElement menuList : list) {
            if (getText(menuList).equalsIgnoreCase(name)) {
                click(menuList);
                break;
            }
        }
        sleep(1000);
    }

    @Step("you forget you password ")
    public void ForgetPassword(String Email) {
        click(forgetBtn);
        sleep(1000);
        fillText(forgetPasswordField, Email); // forget your password
        sleep(2000);
        click(messageEmailBtn); // message to Email
    }

}