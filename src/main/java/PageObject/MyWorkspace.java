package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyWorkspace extends MenuPage {

    @FindBy(css = ".upgrade")
    WebElement UpgradeBtn;
    @FindBy(css = ".text-lg.text-white")
    WebElement StartBtn;
    @FindBy(css = ".text-sm.flex.items-start>a")
    List<WebElement> MenuList;
    // for Assert
    @FindBy(css = ".upgrade")
    WebElement Upgrade;
    @FindBy(css = ".rounded.bg-teal-500")
    WebElement start;


    public MyWorkspace(WebDriver driver) {
        super(driver);
    }

    @Step("start your project")
    public void StartProject() {
        click(StartBtn);
    }

    @Step("click to upgrade")
    public void ClickUpgrade() {
        click(UpgradeBtn);
    }

    @Step("get upgrade")
    public String GetUpgrade() {
        return getText(Upgrade);
    }

    @Step("get to start")
    public String GetStart() {
        return getText(start);
    }
}