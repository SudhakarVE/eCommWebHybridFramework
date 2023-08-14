package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	//WebElements
	
	@FindBy(css="div[class='signup-form'] h2")
	WebElement lblSgnupUser;
	
	@FindBy(css="div[class='login-form'] h2")
	WebElement lblLogin;
	
	@FindBy(css="input[name='name']")
	WebElement txtSgnupName;
	
	@FindBy(css="input[data-qa='signup-email']")
	WebElement txtSgnupEmail;
	
	@FindBy(css="input[data-qa='login-email']")
	WebElement txtLoginEmail;
	
	@FindBy(css="input[data-qa='login-password']")
	WebElement txtLoginPwd;
	
	@FindBy(css="button[data-qa='login-button']")
	WebElement btnLogin;
	
	@FindBy(xpath="//form[@action='/login']//p")
	WebElement lblLoginErrMsg;
	
	
	@FindBy(css="button[data-qa='signup-button']")
	WebElement btnSgnupSubmit;
	
	
	//isExistMethods
	
	
	public boolean isLoginMsgExist() {
		boolean bisDisplayed;
		try {
			bisDisplayed = lblLoginErrMsg.isDisplayed();
	
		}catch(NoSuchElementException e) {
			bisDisplayed = false;	
		}
		return bisDisplayed;
	}
	
	//Action Methods - getMethods
	public String getSgnupUserTitle() {
		
		String SgnupUsr = lblSgnupUser.getText();
		return SgnupUsr; 
	}
	
	public String getLoginTitle() {
		String sLoginUser = lblLogin.getText();
		return sLoginUser;
	}
	public String getLoginErrMsg() {
		String sLoginErrMsg = lblLoginErrMsg.getText();
		return sLoginErrMsg;
	}
	
	
	
	//Set Methods
	public void setSignupName(String sgnName) {
		//txtSgnupName.sendKeys(sgnName);
		utilities.UtilityCustomFunctions.sendKeys(driver, txtSgnupName, sgnName);
	}
	
	public void setSignupEmail(String sgnEmail) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtSgnupEmail, sgnEmail);
	}
	
	public void setLoginEmail(String lgnEmail) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtLoginEmail, lgnEmail);
	}
	
	public void setLoginPwd(String lgnPwd) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtLoginPwd, lgnPwd);
	}
	
	
	//Click Events
	public void clickSignup() throws Exception {
		//btnSgnupSubmit.click();
		utilities.UtilityCustomFunctions.doClick(driver, btnSgnupSubmit);
	}
	public void clickLogin() throws Exception {
		//btnSgnupSubmit.click();
		utilities.UtilityCustomFunctions.doClick(driver, btnLogin);
		
	}
	
}
