package Tests;

import PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CustomShirtConfigurator extends BaseTest {
	private String[] ItalianShirt = { "100% pure cotton Purreal", "short sleeve", "angled double button", "Slim",
			"pointy", "M" };
	private String yourShirt = "Your custom shirt is almost ready";

	@Test(description = "Sign in with my name details")
	public void tc01_OpenLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToTheSite("prili2@walla.com", "Haim-Haim");
		String expected = "Haim-a";
        String actual = loginPage.GetMyLogin();
		Assert.assertEquals("Haim-a", expected);
	}

	@Test(description = "Click on START")
	public void tc02_StartToProject() {
		ChooseProjectType projectType = new ChooseProjectType(driver);
		projectType.ChooseFromListMain("Templates");
		MyMenu menu = new MyMenu(driver);
		String myMenu = menu.GetMyTemplate();
		Assert.assertEquals("Templates", myMenu);
	}

	@Test(description = "Choose my project type")
	public void tc03_OpeningPaymentFormPage() {
		ChooseProjectType choosePro = new ChooseProjectType(driver);
		choosePro.ChooseProject("Payment Form");
		Assert.assertEquals("Payment form", choosePro.PaymentFormTypeProject());
	}

	@Test(description = "Choose my projact")
	public void tc04_ChooseYourShirtPage() {
		Templates template = new Templates(driver);
		template.ChooseTemplate("Custom Shirt Configurator");
		String shirt = template.GetCustomShirtConfigurator();
		Assert.assertEquals(shirt, "The Italian shirt \nmade for you");
	}

	@Test(description = "Dimensions of the garment")
	public void tc05_ShirtDimensionsPage() {
		CustomShirtConfiguratorPage Shirt = new CustomShirtConfiguratorPage(driver);
		Shirt.italianShirt(ItalianShirt);
		Assert.assertTrue(Shirt.yourShirtIsReady().contains(yourShirt));
	}
}
