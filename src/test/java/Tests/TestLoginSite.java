package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.MyMenu;

public class TestLoginSite extends BaseTest {
	@Test
	public void tc01_LoginSite() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToTheSite("prili2@walla.com", "Haim-Haim");
		String expected = "Haim-a";
		String actual = loginPage.GetMyLogin();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void tc02_SignOut() {
		MyMenu yourMenu = new MyMenu(driver);
		yourMenu.UserMenu("Log Out");
		String condition1 = "logout";
		driver.get("https://app.involve.me/login");
		Assert.assertTrue(driver.getTitle() != condition1);
	}

	@Test
	public void tc03_ForgetMyPassworf() {
		MyMenu yourMenu = new MyMenu(driver);
		yourMenu.ForgetPassword("prili2@walla.com");
		String condition1 = "Forgot password";
		driver.get("https://app.involve.me/password/reset");
		Assert.assertTrue(condition1 != driver.getTitle());
	}
}
