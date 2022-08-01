package testclasses;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.letskodeit.utilities.Constants;

import base.CheckPoint;
import base.BaseTest;
import junit.framework.Assert;

public class LoginTests extends BaseTest {


	//@BeforeClass
	public void setUp() {
		//super.commonSetUp();

	}

	@AfterMethod
	public void afterMethod() {
		if (nav.isUserLoggedIn()) {
			nav.logout();
			nav.login();
		}
	}

	@Test(enabled=false)
	public void testLogin() {
		nav = login.signInWith(Constants.DEFAULT_LOGIN, Constants.DEFAULT_PASSWORD);
		boolean result=nav.verifyHeader();
		CheckPoint.mark("test-01", result, "header verification");
		
		//Assert.assertTrue(headerResult);
		boolean result2 = nav.isUserLoggedIn();
		CheckPoint.markFinal("test-01", result2, "login verification");
		//Assert.assertTrue(result);
	}

	@Test
	public void testInvalidLogin() {
		nav = login.signInWith(Constants.DEFAULT_LOGIN, Constants.DEFAULT_PASSWORD);
		boolean result = nav.isUserLoggedIn();
		Assert.assertFalse(result);
	}
}
