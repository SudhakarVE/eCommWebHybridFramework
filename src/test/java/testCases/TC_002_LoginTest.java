package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
public class TC_002_LoginTest extends BaseClass{
	@Test(groups= {"Sanity","Master"})
	void test_login() throws Throwable {
		
		logger.info("******starting TC_002_LoginTest ****");
		try {
			String sCurrentUrl;
			SoftAssert sa = new SoftAssert();
			HomePage hp = new HomePage(driver);
			LoginPage lp = new LoginPage(driver);
			
			//Verify Home Page url
			sCurrentUrl= driver.getCurrentUrl();
			sa.assertEquals("https://automationexercise.com/", sCurrentUrl);
			logger.info("Home Url Validation: "+ sCurrentUrl);
			
			//Check Signup Link
			sa.assertEquals(hp.isSgnupLnkPresence(), true);
			logger.info("Signup Link Check "+ hp.isSgnupLnkPresence());
			
			//Click Signup Link
			hp.clickAcctSignup();
			logger.info("Signup/Login Link clicked");
			
			//Login Label Validation
			String lblLogin;
			lblLogin = lp.getLoginTitle();
			
			
			sa.assertEquals(lblLogin, "Login to your account", "Login Title Header");
			logger.info("Validated Login Header: "+lblLogin);
			
			//Enter Login Details and Submit Page
			lp.setLoginEmail(rb.getString("email2"));
			lp.setLoginPwd(rb.getString("password"));
			logger.info("Login Details Entered");
			
			lp.clickLogin();
			logger.info("Login Button Clicked");
			//Validate Login Success
			if(hp.isLoginNameExist()) {
				logger.info("Login Success: My Account page exist");
				Assert.assertTrue(true, "Login Success: My Account page exist");
			}
			else {
				Assert.assertTrue(false,"Login Failed: My Account page not exist");
				
				logger.info("Login Failed: My Account page not exist");
			}
			
			//Verify that 'Logged in as username' is visible
			
			sa.assertEquals(hp.getLoginText().trim(),"Logged in as ValidTest","Login UserName not displayed");
			logger.info("Logged in user is: " + hp.getLoginText());
			
			//Verify that 'Delete Account Link is visible
			//Delete Link Present Validation
			sa.assertEquals(hp.isDeleteLnkPresence(), true,"Delete Account Link Check");
			logger.info("Delete Account Link Check "+ hp.isDeleteLnkPresence());
			
			//Verify that 'Logout' Link is visible
			sa.assertEquals(hp.isLogoutPresent(), true,"Logout Link Check");
			logger.info("Logout Link Check "+ hp.isLogoutPresent());
			
			//Click Logout
			hp.clickLogout();
			logger.info("Logout Clicked");
			
			//Verify that 'Logout' Link is not visible
			sa.assertEquals(hp.isLogoutPresent(), false,"Logout Link Check after Logout");
			logger.info("Logout Link Check after Logout"+ hp.isLogoutPresent());
			
			//Verify that 'Logged in as username' is not visible
			sa.assertEquals(hp.isLoginStatusPresent(), false,"Logged In UserName");
			logger.info("Logout Link Check "+ hp.isLoginStatusPresent());
			
			
			
			//Verify that 'Delete Account Link is not visible after Logout
			sa.assertEquals(hp.isDeleteLnkPresence(), false,"Delete Link after Logout");
			logger.info("Delete Link check after Logout  "+ hp.isDeleteLnkPresence());
			
			//Verify that 'SignupLogin is visible
			sa.assertEquals(hp.isSgnupLnkPresence(), true,"Signup Link Check after Logout");
			logger.info("Signup Link Check after Logout"+ hp.isSgnupLnkPresence());
			
			//Verify HomePage Url displayed.
			//Verify Home Page url
			sCurrentUrl= driver.getCurrentUrl();
			sa.assertEquals(sCurrentUrl,"https://automationexercise.com/login","Home Url Validation After Successful Logout: ");
			logger.info("Home Url Validation After Successful Logout: "+ sCurrentUrl);
			
			logger.info("******Ended TC_002_LoginTest ****");	
			sa.assertAll();
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}//test
	}//class
