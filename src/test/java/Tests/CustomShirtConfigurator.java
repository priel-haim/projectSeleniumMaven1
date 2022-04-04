package Tests;

import PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CustomShirtConfigurator extends BaseTest {
	private String[] ItalianShirt = { "100% pure cotton Purreal", "short sleeve", "angled double button", "Slim",
			"pointy", "M" };
	private String yourShirt = "Your custom shirt is almost ready";

	@Test(description = "Sign in with my name details")
	public void tc01_openLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openLogin();
		loginPage.loginToTheSite("prili2@walla.com", "Haim-Haim");
		String expected = "Haim-a";
        String actual = loginPage.getMyLogin();
		Assert.assertEquals("Haim-a", expected);
	}

	@Test(description = "Click on START")
	public void tc02_startToProject() {
		ChooseProjectType projectType = new ChooseProjectType(driver);
		projectType.chooseFromListMain("Templates");
		MyMenu menu = new MyMenu(driver);
		String myMenu = menu.getMyTemplate();
		Assert.assertEquals("Templates", myMenu);
	}

	@Test(description = "Choose my project type")
	public void tc03_openingPaymentFormPage() {
		ChooseProjectType choosePro = new ChooseProjectType(driver);
		choosePro.chooseProject("Payment Form");
		Assert.assertEquals("Payment form", choosePro.paymentFormTypeProject());
	}

	@Test(description = "Choose my projact")
	public void tc04_chooseYourShirtPage() {
		Templates template = new Templates(driver);
		template.chooseTemplate("Custom Shirt Configurator");
		String shirt = template.getCustomShirtConfigurator();
		Assert.assertEquals(shirt, "The Italian shirt \nmade for you");
	}

	@Test(description = "Dimensions of the garment")
	public void tc05_shirtDimensionsPage() {
		CustomShirtConfiguratorPage Shirt = new CustomShirtConfiguratorPage(driver);
		Shirt.italianShirt(ItalianShirt);
		Assert.assertTrue(Shirt.yourShirtIsReady().contains(yourShirt));
	}
}
