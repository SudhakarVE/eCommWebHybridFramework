package testCases;
import pageObjects.AccountCreatedPage;
import pageObjects.AccountDeletedPage;
import pageObjects.EnterAcctInfoPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	void test_account_registration() throws Throwable  {
		logger.info("******starting TC_001_AccountRegistrationTest ****");
		try {
		String sCurrentUrl;
		SoftAssert sa = new SoftAssert();
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		EnterAcctInfoPage eap = new EnterAcctInfoPage(driver);
		AccountCreatedPage acp = new AccountCreatedPage(driver);
		AccountDeletedPage adp = new AccountDeletedPage(driver);
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("acceptInsecureCerts", "true");
		//Verify Home Page url
		sCurrentUrl= driver.getCurrentUrl();
		sa.assertEquals("https://automationexercise.com/", sCurrentUrl);
		logger.info("Home Url Validation: "+ sCurrentUrl);
		/*
		if(sCurrentUrl.equalsIgnoreCase("")) {
			sa.assertEquals(true, true, "Home Page Url Correct");
		}
		else {
			sa.assertEquals(false, true, "Home Page Url Not Correct");
			sa.fail("Home Page Url Not Correct: " + sCurrentUrl);
		}
		*/
		sa.assertEquals(hp.isSgnupLnkPresence(), true);
		logger.info("Signup Link Check "+ hp.isSgnupLnkPresence());
		/*
		try {
			//Verify login/signup link present
			if(hp.getSgnupLnkPresence()) {
				
				sa.assertEquals(true, true, "Home Page Present");
				
			}
			else {
				sa.assertEquals(false, true, "Home Page Missing");
				sa.fail("Home Page Missing");
			}
		}catch(Exception e) {
			e.getMessage();
		}
		*/
		
		hp.clickAcctSignup();
		logger.info("Signup Link clicked");
		//New User/Login Page Validation
			
			sCurrentUrl= driver.getCurrentUrl();
			logger.info("Login Page Url: "+sCurrentUrl);
			sa.assertEquals(sCurrentUrl, "https://automationexercise.com/login", "Url in Login Page");
			
			
			String lblSgnup;
			lblSgnup = lp.getSgnupUserTitle();
			
			
			sa.assertEquals(lblSgnup, "New User Signup!", "New User Page Title Header");
			logger.info("Validated Signup Page Title Header: "+lblSgnup);
			
			logger.info("Entered Name and Email");
			lp.setSignupName("ReUseName");
			lp.setSignupEmail("ReUseEmail@gmail.com");
			lp.clickSignup();
			logger.info("Signup Link Clicked in Login Page");
			
			
			if(eap.islblAcctInfoExist()) {
				logger.info("Valid Email and Name Entered ");
				Assert.assertTrue(true, "New Email Success: Enter Account Page exist");
			}
			else {
				Assert.assertTrue(false, "New Email Failed: Enter Account Page not exist");
				logger.info("New Email Failed: Enter Account Page not exist");
			}
			
			
			//Validate Enter Account Information Page
			
			//Url Validation
			sCurrentUrl= driver.getCurrentUrl();
			logger.info("Account Information Page Url is: " + sCurrentUrl);
			sa.assertEquals(sCurrentUrl, "https://automationexercise.com/signup", "Url of Account Info/Signup Page");
			
			
			//Title Validation
			
			String lblEnterAcctInfo;
			lblEnterAcctInfo = eap.getlblAcctInfo();
			
			sa.assertEquals(lblEnterAcctInfo, "ENTER ACCOUNT INFORMATION", "Account Info Section title");
			logger.info("Account Info Section title Validation: "+lblEnterAcctInfo );
			
			logger.info("Add Account Information");
			//Input Account Info Data
			eap.setTitle("Mr.");
			eap.setPassword("admin");
			eap.selDay("2");
			eap.selMonth("April");
			eap.selYear("1976");
			
			eap.setNewsltr();
			eap.setOffers();
			
			eap.setAcctFName("Sudhakar");
			eap.setAcctLName("VE");
			eap.setAcctCompany("Freelance Consultant");
			eap.setAddress1("Addr1");
			eap.setAddress2("addr2");
			eap.selCountry("India");
			System.out.println("Selected India");
			eap.setAcctState("Tamilnadu");
			System.out.println("Selected state");
			eap.setAcctCity("Chennai");
			eap.setAcctZipCode("631501");
			eap.setAcctMobileNo("7708674417");
			System.out.println("Phone No");
			
			eap.clickCreateAcct();
			logger.info("Clicked Signup Create Account");
			

			//Account Created Page. Verify Url
			sCurrentUrl= driver.getCurrentUrl();
						
			sa.assertEquals(sCurrentUrl, "https://automationexercise.com/account_created", "Account Created Page Url");
			logger.info("Account Created Page Url Validation: "+sCurrentUrl );
			
			//Verify Confirm Message
			String aclblActConfmMsg  = acp.getAcctConfirmMsg();
			sa.assertEquals(aclblActConfmMsg, "ACCOUNT CREATED!");
			
			logger.info("ACCOUNT CREATED! Label Displayed");
			
			acp.clickContinueCreated();
			logger.info("Clicked Continue on ACCOUNT CREATED!");
			
				//Url After Account Created Successfully
				sCurrentUrl= driver.getCurrentUrl();
				//sa.assertEquals(sCurrentUrl, "https://automationexercise.com/", "Home Page Url");
				Assert.assertEquals(sCurrentUrl, "https://automationexercise.com/", "Home Page Url");
				logger.info("Home Page After Acct Created: "+sCurrentUrl );
				
				//Delete Link Present Validation
				sa.assertEquals(hp.isDeleteLnkPresence(), true,"Delete Account Link Validation");
				logger.info("Delete Account Link Check "+ hp.isDeleteLnkPresence());
				//Click Delete Link
				
				hp.clickDeleteAcct();
			   logger.info("Delete Account Link Clicked");
			   //Acct Delete Url Check
			    sCurrentUrl= driver.getCurrentUrl();
				sa.assertEquals(sCurrentUrl, "https://automationexercise.com/delete_account", "Delete Account Url");
				logger.info("Delete Account Url Displayed: "+sCurrentUrl );
				
				//Account Deleted Confm Msg
				String adlblDelConfmMsg = adp.getAcctDeleteConfm();
				sa.assertEquals(adlblDelConfmMsg,"ACCOUNT DELETED!");
				
				
				//Continue from Delete Page	
				adp.clickDeleteContinue();
				logger.info("Clicked Continue on Account Delete Page");
				
				//Verify Url Back to Home Page
				sCurrentUrl= driver.getCurrentUrl();
				System.out.println("Url after Acct Deleted: " + sCurrentUrl);
				
				sCurrentUrl= driver.getCurrentUrl();
				sa.assertEquals(sCurrentUrl, "https://automationexercise.com/", "Home Page Url After Acct Deleted");
				logger.info("Home Page After Acct Deleted: "+sCurrentUrl );
				
							
				//Verify Signup/Login Exist
				sa.assertEquals(hp.isSgnupLnkPresence(), true,"Signup Link After Acct Delete Not present");
				logger.info("Signup Link After Acct Delete");
				
				logger.info("******Ended TC_001_AccountRegistrationTest ****");
				
				sa.assertAll();
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		}
	}
	

