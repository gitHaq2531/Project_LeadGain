package com.client.LeadGain.GenericUtility;

import java.util.Set;
import org.openqa.selenium.WebDriver;

public class WebDriverUtility 
{
	WebDriver driver;
	public WebDriverUtility(WebDriver driver)
	{
		this.driver=driver;
	}
public boolean switchToWindow(String partialTitle)
{
	Set<String> allWidIds = driver.getWindowHandles();
	for (String id : allWidIds) {
		driver.switchTo().window(id);
		String title = driver.getTitle();
		if(title.contains(partialTitle)) {
			return true;
		}
	}
	return false;
}

public boolean switchToWindowByPartialTitleOrUrl(String partialTitle, String partialUrl)
{
	String parentWindow = driver.getWindowHandle();
	
	Set<String> allWIds = driver.getWindowHandles();
	for (String id : allWIds) 
	{
		driver.switchTo().window(id);
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		
		boolean titleMatch=title.contains(partialTitle);
		boolean urlMatch = url.contains(partialUrl);
		
		if(titleMatch || urlMatch)
		{
			return true;
		}
	}
	driver.switchTo().window(parentWindow);
	return false;
}
}
