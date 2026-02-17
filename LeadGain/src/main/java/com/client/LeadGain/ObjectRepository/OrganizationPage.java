package com.client.LeadGain.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
public OrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//td[@class='moduleName']/a")
private WebElement organizationModuleName;
public WebElement getOrganizationModuleName() { return organizationModuleName;}

@FindBy(xpath = "//a[@title='Organizations']")
private List<WebElement> allOrgNames;
public List<WebElement> getAllOrgNames(){ return allOrgNames;}

}
