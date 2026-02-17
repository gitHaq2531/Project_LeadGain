package com.client.LeadGain.Register;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.client.LeadGain.GenericUtility.BaseClass;
import com.client.LeadGain.GenericUtility.ExcelUtility;
import com.client.LeadGain.ObjectRepository.OrganizationPage;

@Listeners(com.client.LeadGain.GenericUtility.ListenerImpClassUtility.class)
public class LoginTest extends BaseClass {
@Test
public void loginTest() {
//	ExcelUtility eu=new ExcelUtility();
//	System.out.println(eu.getDataFromEXcelFile(0, 1));
//	homePageObject.getorganizationLink().click();
//	OrganizationPage orgPageObj = new OrganizationPage(driver);
//	List<WebElement> allOrgNames = orgPageObj.getAllOrgNames();
//	for(int i=0;i<allOrgNames.size();i++)
//	{
//		String name = orgPageObj.getAllOrgNames().get(i).getText();
//		System.out.println(name);
//		eu.setDataIntoExcelFile(i+1, 0, name);
//	}
//	System.out.println(eu.getRowIndex());
	System.out.println("hyy");
	Assert.assertEquals(false, true);
	System.out.println("bye");
}

@Test
public void excelTest()
{
	ExcelUtility eu=new ExcelUtility();
	System.out.println(eu.getRowIndex());
	System.out.println(eu.getDataFromEXcelFile(0, 0));
}

}
