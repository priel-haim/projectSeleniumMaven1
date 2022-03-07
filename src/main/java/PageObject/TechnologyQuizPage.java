package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechnologyQuizPage extends MenuPage {

	@FindBy(css = ".c-button.btn")
	private WebElement StartBtn;
	@FindBy(css = ".btn-secondary.shadow")
	private List<WebElement> Round1List;
	@FindBy(css = ".btn-secondary.shadow")
	private List<WebElement> Round2List;
	@FindBy(css = ".answer-behaviour.shadow")
	private List<WebElement> Round3List;
	@FindBy(css = ".btn-secondary.shadow")
	private List<WebElement> Round4List;
	@FindBy(css = ".answer-behaviour.shadow")
	private List<WebElement> Round5List;
	@FindBy(css = ".c-button.btn")
	private WebElement NextBtn;
	@FindBy(css = ".e-headline span")
	private WebElement YourFinalScore;

	// for assert
	@FindBy(css = "button:nth-child(5)")
	private WebElement AppleComputer;

	public TechnologyQuizPage(WebDriver driver) {
		super(driver);

	}

	public void OpenTechnologyQuiz() {
		click(StartBtn);
	}

	public void WhoFoundedAppleComputer(String name) {
		List<WebElement> computer = Round1List;
		for (WebElement Round1List : computer) {
			if (getText(Round1List).contains(name)) {
				actions.click(Round1List).click(NextBtn).build().perform();
				break;
			}
			sleep(2000);
		}
		click(NextBtn);
		sleep(2000);
	}

	public String GetWhoFoundedAppleComputer() {
		return getText(AppleComputer);
	}

	public void WhatShortcutsTheOperatingSystem(String name) {
		List<WebElement> OS = Round2List;
		for (WebElement Round2List : OS) {
			if (getText(Round2List).contains(name)) {
				actions.click(Round2List).click(NextBtn).build().perform();
				break;
			}
			sleep(2000);
		}
		click(NextBtn);
		sleep(2000);
	}

	public void HowManyComputersLanguagesUse(String number) {
		List<WebElement> LanguagesAreInUse = Round3List;
		for (WebElement Round3List : LanguagesAreInUse) {
			if (getText(Round3List).contains(number)) {
				actions.click(Round3List).click(NextBtn).build().perform();
				break;
			}
			sleep(2000);
		}
		click(NextBtn);
		sleep(2000);
	}

	public void WhatDoesWWWMean(String name) {
		List<WebElement> Acronyms = Round4List;
		for (WebElement Round4List : Acronyms) {
			if (getText(Round4List).contains(name)) {
				actions.click(Round4List).click(NextBtn).build().perform();
				break;
			}
			sleep(2000);
		}
		click(NextBtn);
		sleep(2000);
	}

	public void WhereToPutTheMOVExtension(String name) {
		List<WebElement> MOV = Round5List;
		for (WebElement Round5List : MOV) {
			if (getText(Round5List).contains(name)) {
				actions.click(Round5List).click(NextBtn).build().perform();
				break;
			}
			sleep(2000);
		}
		click(NextBtn);
		sleep(2000);
	}

	public void AnsweringTheQuestions(String inventor, String Shortcut, String number, String Meaning, String Name) {
		WhoFoundedAppleComputer(inventor);
		WhatShortcutsTheOperatingSystem(Shortcut);
		HowManyComputersLanguagesUse(number);
		WhatDoesWWWMean(Meaning);
		WhereToPutTheMOVExtension(Name);
		sleep(1000);
	}

	public String getTitle() {
		return getText(YourFinalScore);

	}
}
