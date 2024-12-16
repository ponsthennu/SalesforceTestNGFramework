package com.salesforce.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesforce.basepages.BaseSalesforceTest;
import com.salesforce.pages.SalesforceLoginPage;
import com.salesforce.utilitypages.PropertyFileReader;
import com.salesforce.utilitypages.Screenshot;

//@Listeners(com.salesforce.utilitypages.MyListener.class)

public class SalesforceLoginTest extends BaseSalesforceTest {

	SalesforceLoginPage login;
	PropertyFileReader properties;
    String browserName;
    
    
	@BeforeMethod
	public void beforeMethod()

	{
		properties=new PropertyFileReader();
		browserName=properties.getProperties("browser");
	    driver=getBrowser();
		login=new SalesforceLoginPage(driver);
	}
	@Test(priority =2)
	public void Testcase01_LoginErrorMessage() throws InterruptedException
	  {

		  login.enterdataintoUserName("ponmani027@gmail.com");
		  login.enterdataintoPassword("");
		  login.clickonLoginButton();
		  login.validatepassword();

	  }
	@Test(priority =1,description = "Login Scenario with correct username and password.")
	public void Testcase02_LoginToSalesforce() throws InterruptedException, IOException
	  {
		  login.enterdataintoUserName("ponmani027@gmail.com");
		  login.enterdataintoPassword("Welcome@2025");
			Screenshot screenshot=new Screenshot();

		 screenshot.takeScreenshot(driver);

		  login.clickonLoginButton();
	  }
	@Test(priority =3)
	public void Testcase03_CheckRememberMe() throws InterruptedException
	  {
		  login.enterdataintoUserName("ponmani027@gmail.com");
		  login.enterdataintoPassword("Welcome@2025");
		  login.remembermecheckbox();
		  login.clickonLoginButton();
		  login.usermenudropdown();
		  login.clickonLogoutButton();
		  login.validatecheckboxandusername();
		  login.ischeckboxIsChecked();
		  login.isusernameIsDispalyed();


	  }
	@Test(priority =4)
	public void Testcase04_ForgotPassword() throws InterruptedException
	  {
		  login.enterdataintoUserName("ponmani027@gmail.com");
		  login.enterdataintoPassword("");
		  login.forgotpwdlink();
		  login.isforgetpwdmsgIsDispalyed();
		  login.enterdataintoforgetUserName("ponmani027@gmail.com");
		  login.continuebtn();
		  login.ispwdsentmsgIsDispalyed();

	  }
	@Test(priority =5)
	public void Testcase05_ValidateLoginErrorMessage() throws InterruptedException
	  {
		  login.enterdataintoUserName("123");
		  login.enterdataintoPassword("22131");
		  login.clickonLoginButton();
		  login.validateloginerrormsg();
	  }
}
