package com.LeadGain.TY.Login;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.client.LeadGain.GenericUtility.ExcelUtility;
import com.client.LeadGain.GenericUtility.MasterBaseClass;
import com.client.LeadGain.GenericUtility.ThreadSafeUtility;
import com.client.LeadGain.ObjectRepository.HomePage;
import com.client.LeadGain.ObjectRepository.LoginPage;


public class LoginTest extends MasterBaseClass
{
@Test(priority = 0)
public void verifyLoginWithValidCredentials() throws InterruptedException
{
	
	LoginPage loginPageObject=new LoginPage(ThreadSafeUtility.getDriver());
	loginPageObject.getUsernameEdt().sendKeys(futils.getDataFromPropertiesFile("username"));
	loginPageObject.getPasswordEdt().sendKeys(futils.getDataFromPropertiesFile("password"));
	loginPageObject.getSubmitButton().click();
	Assert.assertTrue(ThreadSafeUtility.getDriver().getTitle().contains("Home"));
	HomePage hp=new HomePage(ThreadSafeUtility.getDriver());
	hp.signOutFromApp();
}

@Test(priority = 1,dataProvider = "getDataForLogin")
public void verifyLoginWithInvalidCredentials(String username, String password)
{
	String expectedErrorMessage="You must specify a valid username and password";
	LoginPage loginPageObject=new LoginPage(ThreadSafeUtility.getDriver());
	loginPageObject.getUsernameEdt().sendKeys(username);
	loginPageObject.getPasswordEdt().sendKeys(password);
	loginPageObject.getSubmitButton().click();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	String errorText= wait.until(ExpectedConditions.visibilityOf(loginPageObject.getErrorMessage())).getText();
	System.out.println("username : "+username+",, password: "+password+" => "+errorText);
	Assert.assertTrue(errorText.contains(expectedErrorMessage));
}
@DataProvider
public Object[][] getDataForLogin()
{
	ExcelUtility eUtils=new ExcelUtility();
	int rowIndex = eUtils.getRowIndex("./TestData/LeadGainData.xlsx");
	System.out.println(rowIndex);
	Object[][] obj=new Object[rowIndex][2];
	for(int i=0;i<rowIndex;i++)
	{
		obj[i][0]=eUtils.getDataFromEXcelFile("./TestData/LeadGainData.xlsx", i+1, 0);
		obj[i][1]=eUtils.getDataFromEXcelFile("./TestData/LeadGainData.xlsx", i+1, 1);
	}
	return obj;
}
}
