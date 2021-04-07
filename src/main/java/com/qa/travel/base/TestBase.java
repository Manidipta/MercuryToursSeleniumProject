package com.qa.travel.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;

import com.qa.travel.utility.ConfigDataProvider;

public class TestBase {
	//Declare variables
		public static WebDriver driver = null;
		//public static ExcelDataProvider excelData;
		public static ConfigDataProvider configData;
		public static WebDriverWait explicitWait;

		//based on user input - url and browser, driver will initiate
		public WebDriver startApplication(String url, String browser) 
		{
			String path = System.getProperty("user.dir");

			if (driver == null) {
				if (browser.equalsIgnoreCase("chrome")) 
				{
				//	this.killProcess("chrome");
					System.setProperty("webdriver.chrome.driver", path+"//Drivers//chromedriver");
					//handle Save Password window
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");

					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					options.setExperimentalOption("prefs", prefs);

					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					
					options.merge(capabilities);
					
					driver = new ChromeDriver(options);
				}

				else if (browser.equalsIgnoreCase("firefox")) 
				{

				}

				else if (browser.equalsIgnoreCase("internet explorer") || browser.equalsIgnoreCase("IE")) 
				{

				}

				else 
				{

				}

			}

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);

			return driver;
		}

		//close browser
		public void quitBrowser(WebDriver driver) 
		{
			driver.quit();
			driver = null;
		}

		//Kill existing process
		public void killProcess(String process) 
		{	
			try {
				Runtime.getRuntime().exec("taskkill /F /IM "+process+"");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	//	@BeforeSuite
		public void setUpSuite() 
		{
			//	excelData = new ExcelDataProvider();
			configData = new ConfigDataProvider();

		}

	//	@AfterSuite
		public void tearDownSuite() 
		{
			this.quitBrowser(driver);
		}
		
//		public void setActions(String action) {
//			
//		//	switch (action){
//				
//				
//				
//			}

}
