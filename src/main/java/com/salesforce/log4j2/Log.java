package com.salesforce.log4j2;

import org.apache.logging.log4j.LogManager;
import org.testng.log4testng.Logger;

public class Log {
	    //Initialize Log4j instance
	    private static final org.apache.logging.log4j.Logger Log =  LogManager.getLogger(Log.class);
	//private static final Logger Log=Logger.getLogger(Log.class);
	    //Info Level Logs
	    public static void info (String message) {
	        Log.info(message);
	    }
	    //Warn Level Logs
	    public static void warn (String message) {
	        Log.warn(message);
	    }
	    
	    //Error Level Logs
	    public static void error (String message) {
	        Log.error(message);
	    }
	    //Fatal Level Logs
	    public static void fatal (String message) {
	        Log.fatal(message);
	    }
	    //Debug Level Logs
	    public static void debug (String message) {
	        Log.debug(message);
	    }
	    public static void startTestCase(String testCaseName)
	    {
	    	Log.info("----------------------------------------------------------------");
	    	Log.info("Starting Test Case: "+testCaseName);

	    	Log.info("----------------------------------------------------------------");

	    }
	    public static void endTestCase(String testCaseName)
	    {
	    	Log.info("----------------------------------------------------------------");
	    	Log.info("Ending Test Case: "+testCaseName);

	    	Log.info("----------------------------------------------------------------");

	    }

}
