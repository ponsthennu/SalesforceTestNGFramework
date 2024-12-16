package com.salesforce.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.salesforce.basepages.BaseSalesforcePage;

public class SalesforceLoginPage extends BaseSalesforcePage{
	
	

	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="Login")
	WebElement login;
	@FindBy(id="error")
	WebElement err_message;
	@FindBy(id="rememberUn")
	WebElement remembercheckbox;
	@FindBy(xpath="//*[@id=\"userNavLabel\"]")
	WebElement salesforceusermenu;
	@FindBy(linkText="Logout")
	WebElement logout;
	@FindBy(id="idcard-identity")
	WebElement expectedusername;
	@FindBy(id="forgot_password_link")
	WebElement forgotpwd;
	@FindBy(id="header")
	WebElement forgetpwdmsg;
	@FindBy(id="un")
	WebElement forgotpwdpgeusername;
	@FindBy(id="continue")
	WebElement continuebtn;
	@FindBy(xpath="//div/p[1]")
	WebElement passwordsentmsg;
	


	//created this method to call the constructor parameterized base parent page using super class
	public SalesforceLoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterdataintoUserName(String strUsername) {
		waitforelement(username);
		username.sendKeys(strUsername);
		
	}


	public void enterdataintoPassword(String strPassword) throws InterruptedException {
		waitforelement(password);
        password.sendKeys(strPassword);
						
	  }
	
	
	public void clickonLoginButton() {
		waitforelement(login);
		login.click();
	}
	public void validatepassword()
	{
		String expectedmsg="Please enter your password." ;

		String actualmsg=err_message.getText();
		System.out.println("Password Error Message:"+ actualmsg);
        Assert.assertEquals(actualmsg, expectedmsg);

	}
	public void validateloginerrormsg()
	{
		String expectedloginmsg="Please check your username and password. If you still can't log in, contact your Salesforce administrator." ;
		String actualmsg=err_message.getText();
		System.out.println("Login Error Message:"+ actualmsg);
        Assert.assertEquals(actualmsg, expectedloginmsg);
		
	}
	public void clickonLogoutButton() {
		waitforelement(logout);
        logout.click();

	}
	public void validatecheckboxandusername() {
		String expectedmsg="ponmani027@gmail.com" ;
		waitforelement(expectedusername);

		String actualmsg=expectedusername.getText();
		System.out.println("Password Error Message:"+ actualmsg);
        Assert.assertEquals(actualmsg, expectedmsg);


	}
	
	public boolean ischeckboxIsChecked() {
		return remembercheckbox.isSelected();
		
		}
	public boolean isusernameIsDispalyed() {
		return username.isDisplayed();
		
		}

	public void usermenudropdown() {
		waitforelementclickable(salesforceusermenu);
		salesforceusermenu.click();
		
	}
	public void remembermecheckbox() {
		waitforelementclickable(remembercheckbox);
		remembercheckbox.click();
	}
	public void forgotpwdlink() {
		waitforelement(forgotpwd);
		forgotpwd.click();
	}

	public boolean isforgetpwdmsgIsDispalyed() {
	
	return forgetpwdmsg.isDisplayed();		
		 
	}

	public void forgotpwdpgeusername() {
		waitforelement(forgotpwdpgeusername);
		forgotpwdpgeusername.click();
	}

	public void continuebtn() {
		waitforelement(continuebtn);
		continuebtn.click();
	}

	public void enterdataintoforgetUserName(String strforgotpwd) {
		waitforelement(forgotpwdpgeusername);
		forgotpwdpgeusername.sendKeys(strforgotpwd);
		
	}
public boolean ispwdsentmsgIsDispalyed() {
	return passwordsentmsg.isDisplayed();
	
	}
	}
	
	


