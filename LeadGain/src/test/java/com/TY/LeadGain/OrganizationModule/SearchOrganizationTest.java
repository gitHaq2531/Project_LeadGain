package com.TY.LeadGain.OrganizationModule;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.client.LeadGain.GenericUtility.BaseClass;
import com.client.LeadGain.ObjectRepository.OrganizationPage;

public class SearchOrganizationTest extends BaseClass
{
@Test
public void searchOrgWithAlphabetOptionsTest() throws InterruptedException
{
	OrganizationPage orgPage = homePageObject.clickOnOrgLink();
	List<WebElement> searchAlphabetsList = orgPage.getSearchAlphabetsList();
	for(int i=0;i<searchAlphabetsList.size();i++)
	{
		searchAlphabetsList.get(i).click();
		char a=(char)(65+i);
		char b=(char)(65+i+32);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//a[@title='Organizations' and (starts-with(text(),'"+a+"') or  starts-with(text(),'"+b+"'))]"))));
		Assert.assertTrue(elements.size()>0);
	}
}
}
