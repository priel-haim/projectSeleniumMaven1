package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

	// Close the Project
	@FindBy(css = ".float-right>img")
	WebElement closeProjectBtn;
	// for assert
	// Button for closing the project
	@FindBy(css = ".e-close img")
	WebElement close;

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public String exitTheProject() {
		return getText(closeProjectBtn);

	}

}
