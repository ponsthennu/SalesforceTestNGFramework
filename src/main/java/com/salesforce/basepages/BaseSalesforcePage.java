package com.salesforce.basepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseSalesforcePage {
	
	WebDriver driver;
	//created constructor method in base page for initialize the page factory for all salesforce pages
	public BaseSalesforcePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void waitforelement(WebElement element)
	{
        WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitforelementclickable(WebElement element)
	{
        WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
