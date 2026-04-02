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

@FindBy(css = "img[title='Search in Organizations...']")
private WebElement searchIcon;
public WebElement getSearchIcon() { return searchIcon;}

@FindBy(xpath = "//input[@name='submit' and @value=' Search Now ']")
private WebElement searchNowButton;
public WebElement getSearchNowButton() { return searchNowButton;}

@FindBy(xpath = "//td[@class='calHdr']/ancestor::table")
private WebElement CalendarPopup;
public WebElement getCalendarPopup() { return CalendarPopup;}

@FindBy(css = "img[title='Open Calendar...']")
private WebElement CalendarIcon;
public WebElement getCalendarIcon() { return CalendarIcon;}

@FindBy(xpath = "//td[@class='calHdr']//img[@src='themes/images/close.gif']")
private WebElement closeCalendarIcon;
public WebElement getCloseCalendarIcon() { return closeCalendarIcon;}

@FindBy(css = "img[title='Show World Clock...']")
private WebElement ClockIcon;
public WebElement getClockIcon() { return ClockIcon;}

@FindBy(id = "wclock")
private WebElement clockPopup;
public WebElement getClockPopup() { return clockPopup;}

@FindBy(name = "clockcity")
private WebElement clockCityDropDown;
public WebElement getClockCityDropDown() { return clockCityDropDown;}
}
