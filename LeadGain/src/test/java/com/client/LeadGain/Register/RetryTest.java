package com.client.LeadGain.Register;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {
	int count=1;
@Test(retryAnalyzer = com.client.LeadGain.GenericUtility.RetryAnalyzerUtility.class)
public void retryTestMethod()
{
	System.out.println("started");
	System.out.println(count);
	if(count<4) {
		count++;
	Assert.assertEquals(false, true);
	}else {
		Assert.assertEquals(true, true);
	}
	System.out.println("done");
}
}
