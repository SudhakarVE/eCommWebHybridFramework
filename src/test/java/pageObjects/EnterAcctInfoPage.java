package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterAcctInfoPage extends BasePage{

	public EnterAcctInfoPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Elements
	
	@FindBy(xpath="//div/h2/b")
	WebElement lblAcctInfo;
	
	@FindBy(css="input[id='id_gender1']")
	WebElement rdbtnMr;
	
	@FindBy(css="input[id='id_gender2']")
	WebElement rdbtnMrs;
	
	@FindBy(css="input[id='name']")
	WebElement txtAcctName;
	
	@FindBy(css="input[data-qa='password']")
	WebElement txtAcctPassword;
	
	@FindBy(id="days")
	WebElement lstSelDay;
			
	@FindBy(id="months")
	WebElement lstSelMonth;
	
	@FindBy(id="years")
	WebElement lstSelYear;
	
	@FindBy(name="newsletter")
	WebElement chkbtnnewsltr;
	
	@FindBy(name="optin")
	WebElement chkbtnOffers;
	
	@FindBy(css="input[data-qa='first_name']")
	WebElement txtAcctFName;
	
	@FindBy(css="input[data-qa='last_name']")
	WebElement txtAcctLName;
	
	@FindBy(css="input[data-qa='company']")
	WebElement txtAcctCompany;
	
	@FindBy(name="address1")
	WebElement txtAddress1;
	
	@FindBy(name="address2")
	WebElement txtAddress2;
	
	@FindBy(id="country")
	WebElement lstSelcountry;
	
	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="zipcode")
	WebElement txtzipcode;
	
	@FindBy(name="mobile_number")
	WebElement txtMobileNo;
	
	@FindBy(css="button[data-qa='create-account']")
	WebElement btnCreateAcct;
	
	//Action Methods
	public void setTitle(String TitleName) {
		if(TitleName.equalsIgnoreCase("Mr.")) {
			//rdbtnMr.click();
			try {
				utilities.UtilityCustomFunctions.doClick(driver, rdbtnMr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			//rdbtnMrs.click();
			try {
				utilities.UtilityCustomFunctions.doClick(driver, rdbtnMrs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void setAcctName(String strAcctName) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtAcctName, strAcctName);
	}
	
	public void setPassword(String strAcctPwd) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtAcctPassword, strAcctPwd);
	}
	
	//DOB Selection
	public void selDay(String strDay) {
		utilities.UtilityCustomFunctions.selectFromComboBox(driver, lstSelDay, strDay);
	}
	public void selMonth(String strMonth) {
		utilities.UtilityCustomFunctions.selectFromComboBox(driver, lstSelMonth, strMonth);
	}
	public void selYear(String strYear) {
		utilities.UtilityCustomFunctions.selectFromComboBox(driver, lstSelYear, strYear);
	}
	
	//Select subscribe
	public void setNewsltr() throws Exception
	{
		utilities.UtilityCustomFunctions.doClick(driver, chkbtnnewsltr);
	}
	public void setOffers() throws Exception
	{
		{
			utilities.UtilityCustomFunctions.doClick(driver, chkbtnOffers);
		}
	}
	
	//Address Information element actions
	public void setAcctFName(String strAcctFName) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtAcctFName, strAcctFName);
	}
	public void setAcctLName(String strAcctLName) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtAcctLName, strAcctLName);
	}
	public void setAcctCompany(String strAcctCompany) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtAcctCompany, strAcctCompany);
	}
	public void setAddress1(String strAcctAdd1) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtAddress1, strAcctAdd1);
	}
	public void setAddress2(String strAcctAdd2) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtAddress2, strAcctAdd2);
	}

	public void selCountry(String strCountry) {
		utilities.UtilityCustomFunctions.selectFromComboBox(driver, lstSelcountry, strCountry);
	}
	
	public void setAcctState(String strAcctState) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtstate, strAcctState);
	}
	public void setAcctCity(String strAcctCity) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtcity, strAcctCity);
	}
	public void setAcctZipCode(String strAcctZipCode) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtzipcode, strAcctZipCode);
	}
	public void setAcctMobileNo(String strAcctMobileNo) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtMobileNo, strAcctMobileNo);
	}

	//Click create account
	public void clickCreateAcct()  {
		try {
			utilities.UtilityCustomFunctions.doClick(driver, btnCreateAcct);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public String getlblAcctInfo() {
		String lblAccountInfo;
		lblAccountInfo=lblAcctInfo.getText();
		return lblAccountInfo;
	}
	//isExistMethods
	public boolean islblAcctInfoExist() {
		boolean b; 
		try {
		b = lblAcctInfo.isDisplayed();
		}catch(Exception e) {
		b=false;	
		}
		return b;
	}
	
}	



