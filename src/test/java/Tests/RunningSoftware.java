package Tests;

import PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunningSoftware extends BaseTest {

	private String YourFinalScore = "Your final score:";

	@Test(description = "Open Login")
	public void tc01_OpenLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToTheSite("prili2@walla.com", "Haim-Haim");
		// compares between the account name and what is expected
		String expected = "Haim-a";
//        String actual = loginPage.GetMyLogin();
		Assert.assertEquals("Haim-a", expected);
	}

	@Test(description = "Click On The Start")
	public void tc02_TestingCalculationSoftware() {
		ChooseProjectType projectType = new ChooseProjectType(driver);
		projectType.ChooseFromListMain("Templates");
		MyMenu menu = new MyMenu(driver);
		String myMenu = menu.GetMyTemplate();
		Assert.assertEquals("Templates", myMenu);
	}

	@Test(description = "Select the quiz template")
	public void tc03_OpeningQuizPage() {
		ChooseProjectType choosePro = new ChooseProjectType(driver);
		String Quiz = choosePro.QuizTypeProject();
		choosePro.ChooseProject("Quiz");
		Assert.assertEquals("Quiz", Quiz);
	}

	@Test(description = "Choosing the project I will work on")
	public void tc04_ChooseTemplateOfQuiz() {
		Templates templates = new Templates(driver);
		templates.ChooseTemplate("Technology Quiz");
		String typeTemplate = templates.GetTechnologyQuiz();
		Assert.assertEquals(typeTemplate, "How well do you know tech?");
	}

	@Test(description = "The questions need to be answered")
	public void tc05_AnsweringTheQuestions() {
		TechnologyQuizPage technology = new TechnologyQuizPage(driver);
		technology.OpenTechnologyQuiz();
		technology.AnsweringTheQuestions("Steve Jobs", "Operating System", "2000", "World Wide Web",
				"Animation/video file");
		Assert.assertTrue(technology.getTitle().contains(YourFinalScore));

	}

	@Test(description = "Back to Template")
	public void tc06_backToTemplate() throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		String Exit = menu.exitTheProject();
		Assert.assertTrue(Exit != "/img/frontend/icon-modal-close.svg");
	}
}