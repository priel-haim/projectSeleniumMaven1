package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyMenu extends MenuPage {

    @FindBy(css = "#nav-dropdown [focusable='false']") //.fas.fa-caret-down.ml-2
    private WebElement yourAccountField;
    @FindBy(css = "div>.darken")
    private WebElement forgetBtn;
    @FindBy(css = "[autocomplete='username']")
    private WebElement forgetPasswordField;
    @FindBy(css = ".btn.btn-primary")
    private WebElement messageEmailBtn;
    @FindBy(css = ".nav-item.dropdown")
    private WebElement OpenMenulist;
    @FindBy(css = ".md\\:items-center .items-center div ul li")
    private List<WebElement> MenuList;
    @FindBy(css = ".items-center.text-sm>a:nth-child(2)")
    private WebElement GetmyTemplate;


    public MyMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Button and selection in the My Username menu")
    public void userMenu(String name) {
        click(yourAccountField);
        sleep(2000);
        List<WebElement> list = MenuList;
        for (WebElement menuList : list) {
            if (getText(menuList).equalsIgnoreCase(name)) {
                click(menuList);
                break;
            }
        }
        sleep(1000);
    }

    @Step("you forget you password ")
    public void forgetPassword(String Email) {
        click(forgetBtn);
        sleep(1000);
        fillText(forgetPasswordField, Email); // forget your password
        sleep(2000);
        click(messageEmailBtn); // message to Email
    }

    @Step("my template")
    public String getMyTemplate(){
        return getText(GetmyTemplate);
    }
}