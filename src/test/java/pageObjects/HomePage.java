package pageObjects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//WebElements
	@FindBy(css="a[href='/login']")
	WebElement lnkLoginSignup;
	
	@FindBy(css="a[href='/logout']")
	WebElement lnkLogout;
	
	//a[normalize-space()='Logout']
	
			
	@FindBy(linkText="Delete Account")
	WebElement lnkDeleteAcct;
	
	//@FindBy(xpath="//i[@class='fa fa-user']")
	@FindBy(xpath="//li[10]//a[1]")
	WebElement lnkLoginStatus;
	
	//Action Methods
	
	public String getLoginText() {
		String strLogintext = lnkLoginStatus.getText();
		return strLogintext;
	}
	public boolean isSgnupLnkPresence() {
		boolean bisDisplayed;
		try {
			bisDisplayed = lnkLoginSignup.isDisplayed();
	
		}catch(NoSuchElementException e) {
			bisDisplayed = false;	
		}
		return bisDisplayed;
	}
	public boolean isLoginNameExist() {
		boolean bisDisplayed;
		try {
			bisDisplayed = lnkLoginStatus.isDisplayed();
	
		}catch(NoSuchElementException e) {
			bisDisplayed = false;	
		}
		return bisDisplayed;
	}
	
	
	
	public boolean isLogoutPresent() {
		boolean bisDisplayed;
		try {
			bisDisplayed = lnkLogout.isDisplayed();
		
		}catch(NoSuchElementException e) {
			bisDisplayed =  false;
		}
		return bisDisplayed;
	}
	public boolean isLoginStatusPresent() {
		boolean bisDisplayed;
		try {
			bisDisplayed= lnkLoginStatus.isDisplayed();
		
		}catch(NoSuchElementException e) {
			bisDisplayed= false;	
		}
		return bisDisplayed;
		
	}
	public boolean isDeleteLnkPresence() {
		boolean bisDisplayed;
		try {
			bisDisplayed = lnkDeleteAcct.isDisplayed();
		
		}catch(NoSuchElementException e) {
			bisDisplayed= false;	
		}
		return bisDisplayed;
	}

	public void clickAcctSignup() throws Throwable {
		utilities.UtilityCustomFunctions.doClick(driver, lnkLoginSignup);
	}
	public void clickLogout() throws Throwable {
		utilities.UtilityCustomFunctions.doClick(driver, lnkLogout);
	}
	public void clickDeleteAcct() throws Throwable {
		utilities.UtilityCustomFunctions.doClick(driver, lnkDeleteAcct);
	}
	//gettext
	
}
