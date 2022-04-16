package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AllureAttachment;

import java.util.List;

public class MyWorkspace extends MenuPage {

    @FindBy(css = ".list-none a")
    WebElement GetUpgrade;
    @FindBy(css = ".text-sm.flex.items-start>a")
    List<WebElement> MenuList;

    // for Assert
    @FindBy(css = ".upgrade")
    WebElement Upgrade;
//    @FindBy(css = ".rounded.bg-teal-500")
//    WebElement start;


    public MyWorkspace(WebDriver driver) {
        super(driver);
    }

    @Step("click to upgrade")
    public void clickUpgrade() {
        AllureAttachment.attachElementScreenshot(Upgrade);
        click(Upgrade);
    }

    @Step("get upgrade")
    public String getUpgrade() {
        return getText(GetUpgrade);
    }
}