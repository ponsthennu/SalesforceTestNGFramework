package com.salesforce.tests;



import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.salesforce.basepages.BaseSalesforceTest;
import com.salesforce.pages.SalesforceLoginPage;
import com.salesforce.pages.SalesforceUserMenuPage;
import com.salesforce.utilitypages.PropertyFileReader;


public class SalesforceUserMenuTest extends BaseSalesforceTest{
	


	//@Listeners(com.salesforce.utilitypages.MyListener.class)

	    SalesforceUserMenuPage usermenu;
	   // SalesforceLoginTest test;
		SalesforceLoginPage login;
		PropertyFileReader properties;
	    String browserName;
	    String un;
	    String pw;
	    
		@BeforeMethod
		public void beforeMethod() throws InterruptedException, IOException

		{
			properties=new PropertyFileReader();
			browserName=properties.getProperties("browser");
		    driver=getBrowser();
			login=new SalesforceLoginPage(driver);
			usermenu = new SalesforceUserMenuPage(driver);
			//test = new SalesforceLoginTest();

		}
		
		//@Test(dependsOnMethods = "test.Testcase02_LoginToSalesforce()")
		
		@Test
		public void TestCase05() throws InterruptedException, IOException
		{
	
			login.enterdataintoUserName("ponmani027@gmail.com");
			login.enterdataintoPassword("Welcome@2025");
			login.clickonLoginButton();
            login.usermenudropdown();
			usermenu.validateusermenuoption();
  

		}
		
	}


	


