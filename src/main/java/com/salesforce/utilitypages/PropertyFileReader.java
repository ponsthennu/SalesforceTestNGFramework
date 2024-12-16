package com.salesforce.utilitypages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class PropertyFileReader {


	FileInputStream fileinput;
	public String getProperties(String key)
	{
		
		String filepath="C:\\Eclipse\\SalesforceFramework\\PropertyFile\\Propertyfile.txt";
		try
		{
			fileinput=new FileInputStream(filepath);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop=new Properties();
		try{
			prop.load(fileinput);	
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("browser"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value=prop.getProperty(key);
		return value;
	}
	}
	
	