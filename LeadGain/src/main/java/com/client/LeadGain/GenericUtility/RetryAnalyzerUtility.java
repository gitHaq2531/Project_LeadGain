package com.client.LeadGain.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerUtility implements IRetryAnalyzer
{
static int limit=5;
int count=1;
@Override
public boolean retry(ITestResult result) {
	if(count<=limit) {
		count++;
		return true;
	}
	return false;	
}
}
