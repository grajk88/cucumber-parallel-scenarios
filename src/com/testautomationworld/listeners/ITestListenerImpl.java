package com.testautomationworld.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ITestListenerImpl extends ExtentReportListener implements ITestListener
{
	private static ExtentReports extent;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("PASS");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution started on UAT env...");
		extent= setUp();
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution completed on UAT env...");
		extent.flush();		
		System.out.println("Generated Report. . .");	
		
	}
	

}
