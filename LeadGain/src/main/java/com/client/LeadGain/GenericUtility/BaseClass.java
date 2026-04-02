package com.client.LeadGain.GenericUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.client.LeadGain.ObjectRepository.HomePage;
import com.client.LeadGain.ObjectRepository.LoginPage;

public class BaseClass extends MasterBaseClass
{
	@BeforeMethod
	public void beforeMethodConfig()
	{
		LoginPage loginPageObject=new LoginPage(ThreadSafeUtility.getDriver());
		loginPageObject.loginToApplication(futils.getDataFromPropertiesFile("username"), futils.getDataFromPropertiesFile("password"));
		homePageObject= new HomePage(ThreadSafeUtility.getDriver());
	}

	@AfterMethod
	public void afterMethodConfig()
	{
		homePageObject.signOutFromApp();
	}
}
