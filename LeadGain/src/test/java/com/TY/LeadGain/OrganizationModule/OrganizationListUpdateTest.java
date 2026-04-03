package com.TY.LeadGain.OrganizationModule;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.client.LeadGain.GenericUtility.BaseClass;
import com.client.LeadGain.ObjectRepository.OrganizationPage;

public class OrganizationListUpdateTest extends BaseClass
{
@Test
public void massUpdateOrganizationList() throws InterruptedException
{
	String websiteUpdateText="TPGlobal@123.com";
	OrganizationPage orgPage = homePageObject.clickOnOrgLink();
	orgPage.getOrgListCheckBoxes().get(0).click();
	orgPage.getOrgListCheckBoxes().get(1).click();
	orgPage.getMassEditButton().click();
	orgPage.getWebsiteTextEdt().sendKeys(websiteUpdateText);
	orgPage.getSaveButton().click();
	Assert.assertTrue(orgPage.getOrgWebsiteList().get(0).getText().equals(websiteUpdateText));
	Assert.assertTrue(orgPage.getOrgWebsiteList().get(1).getText().equals(websiteUpdateText));
}
}
