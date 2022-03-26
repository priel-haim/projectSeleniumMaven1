package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Templates extends MenuPage {

    @FindBy(css = ".lg\\:col-span-8>div:nth-child(2) > div > div")
    List<WebElement> AllTemplatesQuizList;
    @FindBy(css = "div:nth-child(2) div:nth-child(8) a:nth-child(1)")
    WebElement Preview;

    // Upgrade
    @FindBy(css = ".nav-link.upgrade")
     WebElement UpgradeBtn;

    // for assert
    @FindBy(css = "[title='Shopping Order Form']")
    WebElement ShoppingOrderForm;
    @FindBy(css = "[title='Technology Quiz']")
    WebElement TechnologyQuiz;

    public Templates(WebDriver driver) {
        super(driver);
    }

    @Step("choosing the template")
    public void ChooseTemplate(String name) {
        List<WebElement> list = AllTemplatesQuizList;
        for (WebElement AllTemplatesQuizList : list) {
            if (getText(AllTemplatesQuizList).contains(name)) {
                click(Preview);
                sleep(2000);
                break;
            }
            sleep(1000);
        }
    }

    @Step("to upgrade")
    public void Upgrade() {
        click(UpgradeBtn);
    }

    @Step("Get shopping order form")
    public String GetShoppingOrderForm() {
        return getText(ShoppingOrderForm);
    }

    @Step("Get technology quiz")
    public String GetTechnologyQuiz() {
        return getText(TechnologyQuiz);
    }

}
