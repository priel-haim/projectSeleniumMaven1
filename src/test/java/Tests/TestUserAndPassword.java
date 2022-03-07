package Tests;

import PageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestUserAndPassword extends BaseTest{

	@Test(description = "Test the login failed scenario - check that login failed, and you get the right message")
	public void tc01_OpenLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToErrorMessage("phaim7485a@gmail.com", "Praim35");
		String login=loginPage.GetErrorMessage();
		Assert.assertEquals(login, "These credentials do not match our records.");
	}

	@Test(dataProvider ="getData", description="use incorect login information")
	public void tc02_OpenLogin2(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginToErrorMessage(username, password);
		String actual=loginPage.GetErrorMessage();
		String expected="These credentials do not match our records.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][]getData(){
		Object[][]myData= {
				{"pppp@gmail.com","111111"},
				{"papa@walla.co.il","123456"},
				{"prielha1234@gmail.com","1985"},
				{"prielhaim7485@gmail.com","PrielHam1985"},
		};
		return myData;
	}
}