package com.TY.LeadGain.OrganizationModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.LeadGain.GenericUtility.BaseClass;
import com.client.LeadGain.ObjectRepository.OrganizationPage;

public class OrganizationPageIconTest extends BaseClass
{
		@Test
		public void verifySearchNowButtonVisibility()
		{
			OrganizationPage orgPageObj = homePageObject.clickOnOrgLink();
			WebElement searchNowButton = orgPageObj.getSearchNowButton();
			Assert.assertTrue(searchNowButton.isDisplayed());
			orgPageObj.getSearchIcon().click();
			Assert.assertFalse(searchNowButton.isDisplayed());
		}
		@Test
		public void verifyCalendarPopupVisibility() throws InterruptedException
		{
			OrganizationPage orgPage = homePageObject.clickOnOrgLink();
			orgPage.getCalendarIcon().click();
			Assert.assertTrue(orgPage.getCalendarPopup().isDisplayed());
			orgPage.getCloseCalendarIcon().click();
			Assert.assertFalse(orgPage.getCalendarPopup().isDisplayed());
		}
		@Test
		public void verifyClockPopupVisibility()
		{
			OrganizationPage orgPage = homePageObject.clickOnOrgLink();
			Assert.assertFalse(orgPage.getClockPopup().isDisplayed());
			orgPage.getClockIcon().click();
			Assert.assertTrue(orgPage.getClockPopup().isDisplayed());
		}
		
		@Test
		public void verifyClockCityDropDownListSelection() throws InterruptedException
		{
			OrganizationPage orgPage = homePageObject.clickOnOrgLink();
			orgPage.getClockIcon().click();
			Select clockCityDropDownSelect = new Select(orgPage.getClockCityDropDown());
			for(int i=0;i<clockCityDropDownSelect.getOptions().size();i++)
			{
				clockCityDropDownSelect.selectByIndex(i);
				Assert.assertEquals(clockCityDropDownSelect.getFirstSelectedOption().getText(), clockCityDropDownSelect.getOptions().get(i).getText());
			}
		}
}
