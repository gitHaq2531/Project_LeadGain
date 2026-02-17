package com.client.LeadGain.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(name = "user_name")
private WebElement usernameEdt;
public WebElement getUsernameEdt() { return usernameEdt;}

@FindBy(name = "user_password")
private WebElement passwordEdt;
public WebElement getPasswordEdt() { return passwordEdt;}

@FindBy(id ="submitButton")
private WebElement submitButton;
public WebElement getSubmitButton() { return submitButton;}

public void loginToApplication(String username, String password)
{
	getUsernameEdt().sendKeys(username);
	getPasswordEdt().sendKeys(password);
	getSubmitButton().click();
}
}
