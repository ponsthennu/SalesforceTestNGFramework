package com.salesforce.basepages;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.salesforce.log4j2.Log;
import com.salesforce.utilitypages.PropertyFileReader;
import com.salesforce.utilitypages.Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSalesforceTest {
	
	public static WebDriver driver;
	
	PropertyFileReader properties;
	String browserName;
	
	
	//created method to get the browser
	public WebDriver getBrowser()
	{
		if(driver==null)
		
		properties=new PropertyFileReader();
		browserName=properties.getProperties("browser");

	
	if(browserName.equalsIgnoreCase("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
    Log.info("Tests is starting!");

	driver = new ChromeDriver(option);
	driver.manage().window().maximize();

}

else if(browserName.equalsIgnoreCase("firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	FirefoxOptions option=new FirefoxOptions();
	option.addArguments("--disable-notifications");
	driver = new FirefoxDriver(option);
	driver.manage().window().maximize();
}
	String url = properties.getProperties("url");
	//driver.get("https://login.salesforce.com/");
	driver.get(url);
	return driver;

}
  @AfterMethod
  //created method to close the browser 
  public void closeBrowser()throws InterruptedException, IOException 
  { 
	  Screenshot screenshot=new Screenshot();
	 screenshot.takeScreenshot(driver);
	 
	 
	  if (driver != null) {
	        Log.info("Tests are ending!");


          driver.quit();
	 // driver.close(); 
	  //driver=null;
	  }
 
  }
	/*
	 * @AfterSuite public void afterSuite() { //service.shutdown();
	 * ExtentManager.endReport(); }
	 */

}