package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_003_DDT_LoginTest extends BaseClass{
	
	@Test(dataProvider="LoginData" ,dataProviderClass=DataProviders.class,groups={"DataDriven"})
	public void test_DDT_Login(String email, String password,String Name,String res) throws Throwable {
	try {
	logger.info("******starting TC_003_DDT_LoginTest ****");
	String sCurrentUrl;
	SoftAssert sa = new SoftAssert();
	HomePage hp = new HomePage(driver);
	LoginPage lp = new LoginPage(driver);
	
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
	lp.setLoginEmail(email);
	lp.setLoginPwd(password);
	logger.info("Login Details Entered");
	
	lp.clickLogin();
	logger.info("Login Button Clicked");
	if(res.equalsIgnoreCase("valid")) {
		
		if(hp.isLoginStatusPresent()) {
		//Verify that 'Logged in as username' is visible
		sa.assertEquals(hp.getLoginText().trim(),"Logged in as "+Name,"Login UserName displayed");
		logger.info("Logged in user is: " + hp.getLoginText());
		
		//Verify that 'Logout' Link is visible
		sa.assertEquals(hp.isLogoutPresent(), true,"Logout Link Check");
		logger.info("Logout Link Check "+ hp.isLogoutPresent());
		hp.clickLogout();
		logger.info("Logout Clicked");
		}
		else {
			Assert.assertEquals(false, true,"Logged Name not exist : Failed");
			logger.info("Logged Name not exist : Failed " + Name);
		}
	}
	if(res.equalsIgnoreCase("Invalid")) {
		
		//
		if(lp.isLoginMsgExist()) {
			sa.assertEquals(true, true,"Login Error Message Exist");
		   String sValMsg = lp.getLoginErrMsg();
		   if(sValMsg.equalsIgnoreCase("Your email or password is incorrect!")) {
			   sa.assertEquals(true, true,"Expected Error Message" + sValMsg +" Exist");
			   logger.info("Expected Error Message" + sValMsg +" Exist" + res);
		   }
		   else {
			   sa.assertEquals(sValMsg, true,"Invalid Error Message" + sValMsg );
			   logger.info("Expected Error Message Not Exist" + res);
		   }
		}
		else {
			sa.assertEquals(false, true,"Login Error Message Not Exist");
			logger.info("Login Error Message Not Exist" + res);
		}
		if(hp.isLoginStatusPresent()) {
			sa.assertEquals(true, false,"Login should not exist");
			logger.info("Login should fail but passed");
			//Click Logout
			hp.clickLogout();
			logger.info("Logout Clicked");
		}
		else {
			sa.assertEquals(false, false,"Login failed as expected");
			logger.info("Login failed for " + res);
		}
		
		//Verify that 'Logout' Link is not visible
		if(hp.isLogoutPresent()==false) {
		sa.assertEquals(hp.isLogoutPresent(), false,"Logout Link not exist");
		logger.info("Logout Link not exist: Passed");
		}
		else {
			sa.assertEquals(true, false,"Logout Link should not exist");
			logger.info("Logout Link exist: failed");
			hp.clickLogout();
			logger.info("Logout Clicked");
			
		}
	}
	
	
	
	sa.assertAll();
	}catch(Exception e) {
		Assert.fail(e.getMessage());
	}//catch
	}
}//class
