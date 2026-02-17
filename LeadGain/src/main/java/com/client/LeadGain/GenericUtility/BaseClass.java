package com.client.LeadGain.GenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import com.client.LeadGain.ObjectRepository.HomePage;
import com.client.LeadGain.ObjectRepository.LoginPage;

public class BaseClass 
{
	public WebDriver driver=null;
	DatabaseUtility dbutils=new DatabaseUtility();
	FileUtility futils = new FileUtility();
	public WebDriverWait wait;
	public HomePage homePageObject;
@BeforeSuite
public void beforeSuitConfig()
{
	System.out.println("before suite run");
	dbutils.getDatabaseConnection();
}

@BeforeClass
public void beforeClassConfig(XmlTest test)
{
	String browser = System.getProperty("browser");
	if(browser==null) {
		browser = test.getParameter("browser");
		if(browser==null) {
		browser = futils.getDataFromPropertiesFile("browser");
		}
	}
	ThreadSafeUtility.setBrowser(browser);
	
	if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}else if(browser.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}else if(browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	ThreadSafeUtility.setDriver(driver);
	driver=ThreadSafeUtility.getDriver();
	driver.get(futils.getDataFromPropertiesFile("url"));	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
}

@BeforeMethod
public void beforeMethodConfig()
{
	LoginPage loginPageObject=new LoginPage(ThreadSafeUtility.getDriver());
	loginPageObject.loginToApplication(futils.getDataFromPropertiesFile("username"), futils.getDataFromPropertiesFile("password"));
	homePageObject= new HomePage(ThreadSafeUtility.getDriver());
}

@AfterMethod
public void afterMethodConfig()
{
	homePageObject.signOutFromApp();
}

@AfterClass
public void afterClassConfig()
{
	try {
		if(driver!=null) {
		driver.quit();
		}
	}
	finally
	{
	ThreadSafeUtility.removeDriver();
	}
}

@AfterSuite
public void AfterSuiteConfig()
{
	System.out.println("after suite run");
	dbutils.closeConnection();
}
}
