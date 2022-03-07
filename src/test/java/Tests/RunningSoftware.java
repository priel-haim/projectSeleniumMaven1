package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ChooseProjectType;
import PageObject.LoginPage;
import PageObject.MenuPage;
import PageObject.MyWorkspace;
import PageObject.TechnologyQuizPage;
import PageObject.Templates;

public class RunningSoftware extends BaseTest {

	private String YourFinalScore = "Your final score:";

	@Test(description = "Open Login")
	public void tc01_OpenLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToTheSite("prili2@walla.com", "Haim-Haim");
		// compares between the account name and what is expected
		Assert.assertEquals(loginPage.GetMyLogin(), "Haim-a");
	}

	@Test(description = "Click On The Start")
	public void tc02_TestingCalculationSoftware() {
		MyWorkspace workspace = new MyWorkspace(driver);
		String expected = workspace.GetStart();
		workspace.StartProject();
		Assert.assertEquals("Start", expected);
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
		String typeTemplate = templates.GetTechnologyQuiz();
		templates.ChooseTemplate("Technology Quiz");
		Assert.assertEquals(typeTemplate, "Technology Quiz");
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