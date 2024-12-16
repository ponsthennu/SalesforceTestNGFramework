package com.salesforce.utilitypages;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

	import java.util.HashMap;
	import java.util.Map;
	import org.testng.ITestContext;
	import org.testng.ITestResult;

	public class ExtentReportListener implements ITestListener {
		
		public ExtentSparkReporter sparkreporter;
		public ExtentReports extent;
		public ExtentTest test;
		public void onStart(ITestContext context) {
			 sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreports.html");
			 sparkreporter.config().setDocumentTitle("Automation Report");
			 sparkreporter.config().setReportName("Functional Testing");

			 sparkreporter.config().setTheme(Theme.STANDARD);

			 sparkreporter.config().setDocumentTitle("Automation Report");

			 extent=new ExtentReports();
			 extent.attachReporter(sparkreporter);
			 extent.setSystemInfo("computer name", "localhost");
			 extent.setSystemInfo("Environment", "QA");

			 extent.setSystemInfo("Tester name", "ponmani");

			 extent.setSystemInfo("os", "Windows 11");

			 extent.setSystemInfo("Browser name", "chrome");		  
			 
		}
	 public void onTestStart(ITestResult result) {
		 
		
		    test = extent.createTest(result.getName());	 
	  }

	  public void onTestSuccess(ITestResult result) {

	    if (result.getStatus() == ITestResult.SUCCESS) {
	      test.log(Status.PASS, "Pass Test case is: " + result.getName());
	    }
	  }

	  public void onTestFailure(ITestResult result) {

	    if (result.getStatus() == ITestResult.FAILURE) {
	      test.log(Status.FAIL,
	          MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	      test.log(Status.FAIL,
	          MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	    }
	  }

	  public void onTestSkipped(ITestResult result) {

	    if (result.getStatus() == ITestResult.SKIP) {
	      test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
	    }
	  }

	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	    test.log(Status.INFO, "Test case failed but within success percentage: " + result.getName());
	  }

	  

	  public void onFinish(ITestContext context) {
	    Map<String, Object> testResult = new HashMap<String, Object>();
	      testResult.put("TotalTestCaseCount", context.getAllTestMethods().length);
	      testResult.put("PassedTestCaseCount", context.getPassedTests().size());
	      testResult.put("FailedTestCaseCount", context.getFailedTests().size());
	      testResult.put("SkippedTestCaseCount", context.getSkippedTests().size());
	      //test.flushReport();
	      extent.flush();
	  }
	}


