package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageObject.MenuPage;

public class ChooseProjectType extends MenuPage{

	//choose project
	@FindBy(css="#app-layout>.container>div:nth-child(3)>div>a>div>.title")
	private List<WebElement> TemplateTitleType;
	
	//for assert
	@FindBy(css="div>div:nth-child(3) a:nth-child(1) div.title")
	private WebElement Quiz;
	@FindBy(css=".container>div:nth-child(3) a:nth-child(5) .title")
	private WebElement PaymentForm;
	
	public ChooseProjectType(WebDriver driver) {
		super(driver);
	}
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
	public String QuizTypeProject() {
		return getText(Quiz);
	}
	public String PaymentFormTypeProject() {
		return getText(PaymentForm);
	}

}
