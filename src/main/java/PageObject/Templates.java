package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Templates extends MenuPage {

    @FindBy(css = ".lg\\:col-span-8>div:nth-child(2)>div>div")
    List<WebElement> AllTemplatesList;
    @FindBy(css = "div.hidden.sm\\:flex.sm\\:items-center.sm\\:justify-between.m-auto>nav>div")
    List<WebElement> ListBtn;
    //    @FindBy(css = " .m-auto nav  .rounded-r-md svg")
//    WebElement pagination;
    @FindBy(css = "div>div.relative>div>a:nth-child(1)")
    WebElement Preview;

    // Upgrade
    @FindBy(css = ".nav-link.upgrade")
    WebElement UpgradeBtn;

    // for assert
    @FindBy(css = ".standalone-project-main.vcentered.left-left .c-headline-container.content-item .e-headline.is-shrinkable > div > span")
    WebElement ShoppingOrderForm;
    @FindBy(css = ".content-item .e-headline.is-shrinkable span")
    WebElement TechnologyQuiz;
    @FindBy(css = ".e-headline.is-shrinkable span")
    WebElement CustomShirtConfigurator;

    public Templates(WebDriver driver) {
        super(driver);
    }

    @Step("choosing the template")
    public void ChooseTemplate(String name) {
        for (WebElement buttonIndex : ListBtn) {
            buttonIndex.click();
            for (WebElement item : AllTemplatesList) {
                if (getText(item).contains(name)) {
                    sleep(2000);
                    WebElement previewButton = item.findElement(By.cssSelector("div>div.relative>div>a:nth-child(1)"));
                    hover(previewButton);
                    click(previewButton);
                    sleep(2000);
                    return;
                }
            }
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

    @Step("Get Custom Shirt Configurator")
    public String GetCustomShirtConfigurator(){
        return getText(CustomShirtConfigurator);
    }

}
