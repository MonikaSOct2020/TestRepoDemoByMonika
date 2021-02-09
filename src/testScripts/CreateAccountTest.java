package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyProfilePage;

public class CreateAccountTest {

	@Test
	public void createAccountTest() {
		PredefinedActions.start();
		HomePage homePage = new HomePage();
		AuthenticationPage authenticationPage = homePage.clickOnSignIn();
		authenticationPage.enterEmailAdress("automation1@gmail.com");
		CreateAccountPage createAccountPage = authenticationPage.clickOnCreateAccount();
		System.out.println("Navigate to create account page");
		createAccountPage.enterCreateAccountDetails();
		MyProfilePage myProfilePage = createAccountPage.clickOnRegistration();
		String actual = myProfilePage.getHeaderText();
		String expected = "automation automation";
		Assert.assertEquals(actual, expected, "Verification of headertext failed");
	}
}