package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.ChooseProjectType;
import PageObject.CustomShirtConfiguratorPage;
import PageObject.LoginPage;
import PageObject.MyWorkspace;
import PageObject.Templates;


public class CustomShirtConfigurator extends BaseTest {
	private String[] ItalianShirt = { "100% pure cotton Purreal", "short sleeve", "angled double button", "Slim",
			"pointy", "M" };
	private String yourShirt = "Your custom shirt is almost ready";

	@Test(description = "Sign in with my name details")
	public void tc01_OpenLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToTheSite("prili2@walla.com", "Haim-Haim");
		String actual = loginPage.GetMyLogin();
		String expected = "Haim-a";
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Click on START")
	public void tc02_StartToProject() {
		MyWorkspace workspace = new MyWorkspace(driver);
		workspace.StartProject();
		String condition1 = "Start";
		driver.get("https://app.involve.me/project/choose?workspace_uuid=65f139c8-d26d-4b99-84c9-c8064fd67fb6");
		Assert.assertTrue(condition1 != driver.getTitle());
	}

	@Test(description = "Choose my project type")
	public void tc03_OpeningPaymentFormPage() {
		ChooseProjectType choosePro = new ChooseProjectType(driver);
		choosePro.ChooseProject("Payment Form");
		String condition1 = "Payment Form";
		driver.get("https://app.involve.me/templates?type=payment");
		Assert.assertFalse(condition1 == driver.getCurrentUrl());
	}

	@Test(description = "Choose my projact")
	public void tc04_ChooseYourShirtPage() {
		Templates template = new Templates(driver);
		driver.get("https://app.involve.me/template/payment-form-custom-shirt-configurator");
		template.ChooseTemplate("Custom Shirt Configurator");
		Assert.assertTrue(driver.getTitle() != "Custom Shirt Configurator");
	}

	@Test(description = "Dimensions of the garment")
	public void tc05_ShirtDimensionsPage() {
		CustomShirtConfiguratorPage Shirt = new CustomShirtConfiguratorPage(driver);
		Shirt.italianShirt(ItalianShirt);
		Assert.assertTrue(Shirt.yourShirtIsReady().contains(yourShirt));
	}
}
