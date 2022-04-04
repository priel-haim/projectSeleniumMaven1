package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomShirtConfiguratorPage extends MenuPage {

    // Create Your Shirt
    @FindBy(css = ".c-button.btn")
    WebElement StartBtn;

    // Step 1:Choose a Fabric
    @FindBy(css = "[style='font-size: 14px;']")
    List<WebElement> ChooseTheColorBtn;

    // Step 2:Choose The Sleeve
    @FindBy(css = "[style='font-size: 14px;']")
    List<WebElement> ClickOnRightSleeveBtn;

    // Step 3:Choose The Cuff
    @FindBy(css = "[style='font-size: 14px;']")
    List<WebElement> ClickYouCuffBtn;

    // Step 4:Choose the fitting
    @FindBy(css = "[style='font-size: 14px;']")
    List<WebElement> ChooseYourGeyserBtn;

    // Step 5:Choose the collar
    @FindBy(css = "[style='font-size: 14px;']")
    List<WebElement> ChooseYourChooseBtn;

    // Step 6:Choose a size
    @FindBy(css = "span span")
    WebElement SearchButtonBtn;
    @FindBy(css = ".el-select-dropdown__item>span")
    List<WebElement> mySizeBtn;

    // Close the Project
    @FindBy(css = ".c-button-group-button.e-close")
    WebElement closeProjectBtn;

    // for assert
    @FindBy(css = "div:nth-child(4)>span")
    WebElement ChooseTheColor;
    @FindBy(css = "div:nth-child(2)>span")
    WebElement ClickOnRightSleeve;
    @FindBy(css = "div:nth-child(2)>span")
    WebElement ClickYouCuff;
    @FindBy(css = "div:nth-child(2)>span")
    WebElement ChooseYourFitting;
    @FindBy(css = ".v-grid>div:nth-child(1)>span")
    WebElement ChooseYourCollar;
    @FindBy(css = "ul>li:nth-child(2)>span")
    WebElement ChooseSize;
    @FindBy(css = ".c-button.btn")
    WebElement CreateYourCustomShirt;
    @FindBy(css = ".e-headline.is-shrinkable span")
    WebElement yourShirt;

    public CustomShirtConfiguratorPage(WebDriver driver) {
        super(driver);
    }

    @Step("create your shirt")
    public void createYourShirt() {
        click(StartBtn);
    }

    @Step("You need to choose the right fabric")
    public void chooseFabric(String fabric) {
        sleep(200);
        List<WebElement> MyColor = ChooseTheColorBtn;
        for (WebElement ChooseTheColorBtn : MyColor) {
            if (getText(ChooseTheColorBtn).contains(fabric)) {
                click(ChooseTheColorBtn);
                break;
            }
            sleep(2000);
        }
        sleep(2000);
    }

    @Step("What sleeve do you want?")
    public void chooseTheSleeve(String name) {
        sleep(800);
        List<WebElement> sleeve = ClickOnRightSleeveBtn;
        for (WebElement ClickOnRightSleeveBtn : sleeve) {
            if (getText(ClickOnRightSleeveBtn).contains(name)) {
                click(ClickOnRightSleeveBtn);
                break;
            }
            sleep(2000);
        }
        sleep(2000);
    }

    @Step("choose the cuff you want")
    public void chooseTheCuff(String name) {
        sleep(2000);
        List<WebElement> cuff = ClickYouCuffBtn;
        for (WebElement ClickYouCuffBtn : cuff) {
            if (getText(ClickYouCuffBtn).contains(name)) {
                click(ClickYouCuffBtn);
                break;
            }
            sleep(2000);
        }
        sleep(2000);
    }

    @Step("Choose what suits you")
    public void chooseTheFitting(String type) {
        sleep(2000);
        List<WebElement> BackOfTheShirt = ChooseYourGeyserBtn;
        for (WebElement ChooseYourGeyserBtn : BackOfTheShirt) {
            if (getText(ChooseYourGeyserBtn).contains(type)) {
                click(ChooseYourGeyserBtn);
                break;
            }
            sleep(2000);
        }
        sleep(2000);
    }

    @Step("choose your collar")
    public void chooseTheCollar(String type) {
        sleep(2000);
        List<WebElement> Collar = ChooseYourChooseBtn;
        for (WebElement ChooseYourChooseBtn : Collar) {
            if (getText(ChooseYourChooseBtn).contains(type)) {
                click(ChooseYourChooseBtn);
                break;
            }
            sleep(1000);
        }
    }

    @Step("what the a size of your Shirt?")
    public void theSizeOfTheShirt(String size) {
        click(SearchButtonBtn);
        sleep(2000);
        List<WebElement> mySize = mySizeBtn;
        for (WebElement mySizeBtn : mySize) {
            if (getText(mySizeBtn).contains(size)) {
                click(mySizeBtn);
                break;
            }
            sleep(2000);
        }
        sleep(2000);
    }

    @Step("choose your italian shirt")
    public void italianShirt(String[] type) {
        createYourShirt();
        chooseFabric(type[0]);
        chooseTheSleeve(type[1]);
        chooseTheCuff(type[2]);
        chooseTheFitting(type[3]);
        chooseTheCollar(type[4]);
        theSizeOfTheShirt(type[5]);
    }

    @Step("your ShirtIs Ready")
    public String yourShirtIsReady() {
        return getText(yourShirt);

    }
}
