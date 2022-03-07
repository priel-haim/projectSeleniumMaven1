package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageObject.MenuPage;

public class Templates extends MenuPage {
	@FindBy(css = ".dataTables_wrapper")
	private List<WebElement> PageTemplatesBtn;
	@FindBy(css = ".c-list-header>.e-title")
	private List<WebElement> TemplateBtn;
	@FindBy(css = "[alt='IQ Test']")
	private WebElement IQTestBtn;
	@FindBy(css = "[alt='Technology Quiz']")
	private WebElement TechnologyQuizBtn;
	@FindBy(css = "#template-gallery>tbody>tr>td:nth-child(1)>div")
	private List<WebElement> TempletesQuiz;
	@FindBy(css = ".e-button-container>.btn-preview")
	private WebElement ClickTemplateBtn;
	@FindBy(css = ".c-thumbnail.gallery-item")
	private List<WebElement> AllTemplatesQuizList;
	@FindBy(css = ".c-button-group-button.e-close")
	private WebElement CloseTemplateBtn;
	// Upgrade
	@FindBy(css = ".nav-link.upgrade")
	private WebElement UpgradeBtn;
	// for assert
	@FindBy(css = ".is-shrinkable>div>span")
	private WebElement CustomShirtConfigurator;
	@FindBy(css = "[title='Shopping Order Form']")
	private WebElement ShoppingOrderForm;
	@FindBy(css = "[title='Technology Quiz']")
	private WebElement TechnologyQuiz;
	@FindBy(css = "[title='Custom Shirt Configurator']")
	private WebElement CustomShirt;

	public Templates(WebDriver driver) {
		super(driver);
	}

	public void ChooseTemplate(String name) {
		List<WebElement> list = AllTemplatesQuizList;
		for (WebElement AllTemplatesQuizList : list) {
			if (getText(AllTemplatesQuizList).contains(name)) {
				click(AllTemplatesQuizList);
				sleep(2000);
				break;
			}
			sleep(1000);
		}
	}

	public void IQTestPage() {
		click(IQTestBtn);
	}

	public void TechnologyQuiz() {
		click(TechnologyQuizBtn);
	}

	public void CloseTemplate() {
		click(CloseTemplateBtn);
	}

	public void Upgrade() {
		click(UpgradeBtn);
	}

	public String GetTheTemplate() {
		return getText(CustomShirtConfigurator);
	}

	public String GetShoppingOrderForm() {
		return getText(ShoppingOrderForm);
	}

	public String GetTechnologyQuiz() {
		return getText(TechnologyQuiz);
	}

}
