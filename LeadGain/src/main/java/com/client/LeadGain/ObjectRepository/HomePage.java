package com.client.LeadGain.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//td/img[@src='themes/softed/images/user.PNG']")
private WebElement adminIcon;
public WebElement getAdminIcon() { return adminIcon;}

@FindBy(linkText = "Sign Out")
private WebElement signOutLink;
public WebElement getSignOutLink() { return signOutLink;}

@FindBy(xpath = "//td[@class]/a[text()='Organizations']")
private WebElement organizationLink;
public WebElement getorganizationLink() { return organizationLink;}

public OrganizationPage clickOnOrgLink()
{
	organizationLink.click();
	return new OrganizationPage(driver);
}

@FindBy(xpath = "//td[@class!='moduleName']/a[text()='Contacts']")
private WebElement contactsLink;
public WebElement getContactsLink() { return contactsLink;}

public void signOutFromApp()
{
	Actions act=new Actions(driver);
	act.moveToElement(adminIcon).perform();
	act.click(adminIcon).moveToElement(signOutLink).click().perform();
}
}
