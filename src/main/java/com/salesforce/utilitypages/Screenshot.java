package com.salesforce.utilitypages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.salesforce.basepages.BaseSalesforceTest;

public class Screenshot extends BaseSalesforceTest {
	
	  public static String screenshotName;
	 
	  
	  public void takeScreenshot(WebDriver driver) throws IOException {
	  TakesScreenshot screenshot=((TakesScreenshot)driver); File
	  srcFile=screenshot.getScreenshotAs(OutputType.FILE);
	  
	 String fileDir=System.getProperty("user.dir"); 
	 System.out.println(fileDir);
	  Date currentdate=new Date();
	  String timestamp=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentdate); 
	  String filepath=fileDir+"\\ScreenshotFile\\Screenshot"+timestamp+".jpg";
	  System.out.println(filepath);
			 
			 //String filepath="C:\\Eclipse\\SalesforceFramework\\ScreenshotFile\\Screenshot.jpg";
			  File desFile=new File(filepath); try { FileUtils.copyFile(srcFile, desFile);
			  }catch(IOException e) { e.printStackTrace(); } }
			 
	 
		/*
		 * try { Date currentdate=new Date(); screenshotName =
		 * currentdate.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		 * FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir") +
		 * "\\reports\\" + screenshotName));
		 * System.out.println("Successfully captured a screenshot"); } catch
		 * (IOException e) { System.out.println("Exception while taking screenshot " +
		 * e.getMessage()); }
		 * 
		 */
	 
	  
	 
	 
	 

}
