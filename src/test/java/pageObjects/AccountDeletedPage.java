package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage extends BasePage{

	public AccountDeletedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//div/h2/b")
	WebElement lblAcctDeletedConfm;
	
	@FindBy(css=".btn.btn-primary")
	WebElement btnDeletedContinue;
	
	//Action Methods
	public String getAcctDeleteConfm() {
		String strDeletedConfm = null;
		try {
			strDeletedConfm = utilities.UtilityCustomFunctions.getValue(driver, lblAcctDeletedConfm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strDeletedConfm;
	}
	
	public void clickDeleteContinue() {
		try {
			utilities.UtilityCustomFunctions.doClick(driver, btnDeletedContinue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
