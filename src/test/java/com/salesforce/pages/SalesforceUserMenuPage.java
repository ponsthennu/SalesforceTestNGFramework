package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesforce.basepages.BaseSalesforcePage;

public class SalesforceUserMenuPage extends BaseSalesforcePage{

	//created this method to call the constructor parameterized base parent page using super class


	public SalesforceUserMenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
			
			@FindBy(xpath="//div[@id='userNav-menuItems']")
			WebElement usermenuitems;
			
			public void validateusermenuoption() throws InterruptedException
			{
				
			List<String> expectedUserMenuList=new ArrayList<String>();
			expectedUserMenuList.add("My Profile");
			expectedUserMenuList.add("My Settings");
			expectedUserMenuList.add("Developer Console");
			expectedUserMenuList.add("Switch to Lightning Experience");
			expectedUserMenuList.add("Logout");
			//List<WebElement> userMenuList=driver.findElement(By.xpath("//div[@id='userNav-menuItems']"));
          // List<String> usermenuitemss=new ArrayList<String>();
		    //System.out.println(usermenuitemss.size());
		   // WebElement mm=usermenuitems;
			//for(WebElement options:mm){
			//	String menulist=options.getText();
			//	((List<String>) usermenuitems).add(menulist);
	         // System.out.println(options.length());
			
			//Iterator<String> usermenuitemss1 = usermenuitems;
		   // while (usermenuitemss1.hasNext()) {
		     // String element = usermenuitems.getText();
		     // System.out.println(element);
		   // }
	       // Collection<?> element = null;
			//Assert.assertEquals(element,expectedUserMenuList,"Menu list is not displayed correctly");

		    }
           }
			
			
		
			
		
	
			
			



	


