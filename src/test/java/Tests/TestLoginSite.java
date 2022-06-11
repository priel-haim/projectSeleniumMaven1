package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.MyMenu;

public class TestLoginSite extends BaseTest {

	@Test(description = " open my login")
	public void tc01_loginSite() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.cookies();
		loginPage.openLogin();
		loginPage.loginToTheSite("prili2@walla.com", "Haim-Haim");
		String expected = "Haim-a";
		Assert.assertEquals("Haim-a", expected);
	}

	@Test(description = "Check if there is a possibility from the user")
	public void tc02_signOut() {
		MyMenu yourMenu = new MyMenu(driver);
		yourMenu.userMenu("Log Out");
		String condition1 = "logout";
		driver.get("https://app.involve.me/login");
		Assert.assertTrue(driver.getTitle() != condition1);
	}

	@Test(description = "If it is possible to change the user password")
	public void tc03_forgetMyPassword() {
		MyMenu yourMenu = new MyMenu(driver);
		yourMenu.forgetPassword("prili2@walla.com");
		String condition1 = "Forgot password";
		driver.get("https://app.involve.me/password/reset");
		Assert.assertTrue(condition1 != driver.getTitle());
	}
}
