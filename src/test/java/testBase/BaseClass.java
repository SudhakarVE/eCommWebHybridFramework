package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public ResourceBundle rb;
	
	//@BeforeClass(groups= {"Sanity","Regression","Master"})
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setup(String br)
	{
		
		rb = ResourceBundle.getBundle("config");//Read config.properties.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch(br) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--start-maximized");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-infobars");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("autofill.profile_enabled", false);
			
			options.setExperimentalOption("prefs", prefs);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			
			driver=new ChromeDriver(options);
			break;
		case "edge":
			EdgeOptions eoptions = new EdgeOptions();
			
			eoptions.addArguments("--start-maximized");
			eoptions.addArguments("--remote-allow-origins=*");
			eoptions.addArguments("--disable-infobars");
			Map<String, Object> eprefs = new HashMap<String, Object>();
			eprefs.put("autofill.profile_enabled", false);
			
			eoptions.setExperimentalOption("prefs", eprefs);
			capabilities.setCapability(EdgeOptions.CAPABILITY, eoptions);
			eoptions.merge(capabilities);
			driver= new EdgeDriver(eoptions);
			break;
		default:
			//driver = new ChromeDriver();
			
		}
		
		logger = LogManager.getLogger(this.getClass());
		
		
		//WebDriverManager.chromedriver().setup();
		
		
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		/*
		options.addArguments("--disable-autofill");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("-–disable-notifications");
		
		*/
		//options.AddUserProfilePreference("autofill.profile_enabled", false);
		
		
		/*
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("disable-popup-blocking", true);
		prefs.put("disable-infobars", true);
		*/
		
		
		// To remove the message "Your browser is controlled by automated software."
		//prefs.put("excludeSwitches", new String[] {"enable-automation"});
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		// To disable the auto save page password popup.
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		//driver.get("https://automationexercise.com/");
		//driver.get("https://demo.opencart.com/index.php");
		
		//driver.manage().window().maximize();
	}
	//@AfterClass(groups= {"Sanity","Regression","Master","DataDriven"})
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	public String captureScreen(String tname) throws IOException, InterruptedException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		Thread.sleep(1000);		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
