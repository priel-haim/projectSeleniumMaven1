package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Templates extends MenuPage {

    @FindBy(css = ".lg\\:col-span-8>div:nth-child(2)>div>div")
    private List<WebElement> AllTemplatesList;
    @FindBy(css = "div.hidden.sm\\:flex.sm\\:items-center.sm\\:justify-between.m-auto>nav>div")
    private List<WebElement> ListBtn;
    @FindBy(css = "div>div.relative>div>a:nth-child(1)")
    private WebElement Preview;

    // Upgrade
    @FindBy(css = ".nav-link.upgrade")
    private WebElement UpgradeBtn;

    // for assert
    @FindBy(css = ".standalone-project-main.vcentered.left-left .c-headline-container.content-item .e-headline.is-shrinkable > div > span")
    private WebElement ShoppingOrderForm;
    @FindBy(css = "[title='Technology Quiz']")
    private WebElement OpenTechnologyQuiz;
    @FindBy(css = ".content-item .e-headline.is-shrinkable span")
    private WebElement InTechnologyQuiz;
    @FindBy(css = ".e-headline.is-shrinkable span") // [title='Custom Shirt Configurator']
    private WebElement CustomShirtConfigurator;

    public Templates(WebDriver driver) {
        super(driver);
    }

    @Step("choosing the template")
    public void chooseTemplate(String name) {
        for (WebElement buttonIndex : ListBtn) {
            sleep(2000);
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
    public void upgrade() {
        click(UpgradeBtn);
    }

    @Step("Get shopping order form")
    public String getShoppingOrderForm() {
        return getText(ShoppingOrderForm);
    }

    @Step("")
    public String getTechnologyQuiz(){
        return getText(OpenTechnologyQuiz);
    }

    @Step("Get technology quiz")
    public String getTechnologyQuiz1() {
        return getText(InTechnologyQuiz);
    }

    @Step("Get Custom Shirt Configurator")
    public String getCustomShirtConfigurator(){
        return getText(CustomShirtConfigurator);
    }

}
