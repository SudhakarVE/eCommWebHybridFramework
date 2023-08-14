package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;
import testBase.BaseClass.*;
public class UtilityCustomFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void sendKeys(WebDriver webDriver, WebElement element, String keyValue) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			//js.executeScript("arguments[0].scrollIntoView();", element);
			WebDriverWait webWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
			webWait.until(ExpectedConditions.elementToBeClickable(element));
			webWait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			Actions action = new Actions(webDriver);
			action.moveToElement(element).doubleClick().build().perform();
			element.sendKeys(keyValue);
		}
		catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	
	}//function end
	public static boolean selectFromComboBox(WebDriver webDriver, WebElement element, String textValue) {
		//waitForJQueryToLoad(webDriver);
		boolean flag = false;
		try {
			((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			if (element.isDisplayed() || element.isEnabled()) {
				List<WebElement> options = element.findElements(By.tagName("option"));
				for (WebElement option : options) {
					if (textValue.equalsIgnoreCase(option.getText().trim())) {
						option.click();
						System.out.println("[" + textValue + "] is selected");
						BaseClass.logger.info("[" + textValue + "] is selected in Dropdown");
						flag = true; break;
					}
				}
			}
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return flag;
	}//function end
	
	/**
	 * This method is will performs click action on the element
	 * @param element Holds the Web element
	 * @return return the boolean value
	 * @throws Exception 
	 */
	public static boolean doClick(WebDriver webDriver, WebElement element) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		boolean isClicked = false;
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			//js.executeScript("window.scrollBy(0,3000)");
			WebDriverWait webWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
			webWait.until(ExpectedConditions.elementToBeClickable(element));
			webWait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].click();", element);
			//BaseClass.logger.info("Clicked...." + element.getAttribute("value"));
			//System.out.println("click element name : " + element.getAttribute("innerText"));
			/*
			Actions action = new Actions(webDriver);
			action.moveToElement(element).click().build().perform();
			*/
			isClicked = true;
		}  catch (Exception ex) {
			//Reporter.log("Exception occured while doClick event " + ex.getMessage());
			System.out.println("Exception occured while doClick event " + ex.getMessage());
			throw ex;
		}
		return isClicked;
	}

	/**
	 * This method helps to get text from web element
	 * @param driver The WebDriver
	 * @param element  Holds the web element
	 * 
	 * @return Returns the String
	 * @throws Exception 
	 */
	public static String getValue(WebDriver webDriver, WebElement element) throws Exception{
		String actualValue = null;
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		try {
			WebDriverWait webWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
			webWait.until(ExpectedConditions.elementToBeClickable(element));
			webWait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			actualValue = element.getText();
		}  catch (Exception ex) {
			//Reporter.log("Exception occured while getValue event " + ex.getMessage());
			System.out.println("Exception occured while getValue event " + ex.getMessage());
			//throw ex;
		}
		return actualValue;
	}
}