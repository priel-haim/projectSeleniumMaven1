package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChooseProjectType extends MenuPage {

    //choose project
    @FindBy(css = "#app .flex>div:nth-child(3) div>a")
    List<WebElement> ListMain;
    @FindBy(css = "div:nth-child(1)>.divide-gray-100 .text-gray-700")
    List<WebElement> TemplateTitleType;

    //for assert
    @FindBy(css = "div:nth-child(1)>div>div:nth-child(1)>button>div.text-gray-700")
    WebElement Quiz;
    @FindBy(css = "div:nth-child(1)>div>div:nth-child(3)>button>div.text-gray-700")
    WebElement PaymentForm;

    public ChooseProjectType(WebDriver driver) {
        super(driver);
    }

    @Step("Make-up to choose from the menu list")
    public void ChooseFromListMain(String name){
        List<WebElement> list = ListMain;
        for (WebElement ListMain : list) {
            if(getText(ListMain).contains(name)){
                click(ListMain);
                break;
            }
        }
    }

    @Step("choosing template type")
    public void ChooseProject(String name) {
        List<WebElement> list = TemplateTitleType;
        for (WebElement TemplateTitleType : list) {
            if (getText(TemplateTitleType).equalsIgnoreCase(name)) {
                click(TemplateTitleType);
                break;
            }
            sleep(1000);
        }
        sleep(2000);
    }

    @Step("The type of project is a quiz")
    public String QuizTypeProject() {
        return getText(Quiz);
    }

    @Step("The type of project is a Payment Form")
    public String PaymentFormTypeProject() {
        return getText(PaymentForm);
    }
}
