package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage{

	public AccountCreatedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Elements
	
	@FindBy(css="h2[data-qa='account-created']")
	WebElement lblCofirmMsg;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement btnAcctCrtdContinue;
	
	
	
	//Action Methods
	public String getAcctConfirmMsg() {
	String strAcctConfmsg="";	
	try {
		strAcctConfmsg=utilities.UtilityCustomFunctions.getValue(driver, lblCofirmMsg);
		//return strAcctConfmsg;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return strAcctConfmsg;
	}
	public void clickContinueCreated() throws Exception {
		// TODO Auto-generated method stub
		utilities.UtilityCustomFunctions.doClick(driver, btnAcctCrtdContinue);
	}
	
}
