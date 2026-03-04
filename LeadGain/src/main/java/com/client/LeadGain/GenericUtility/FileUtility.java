package com.client.LeadGain.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	 * @author Afzaul Haque
	 * @param key
	 * @return it returns data from properties file based on given key
	 */
public String getDataFromPropertiesFile(String key)
{
	String data="";
	try {
	FileInputStream fis=new FileInputStream("./TestData/commonData.properties");
	Properties pObj=new Properties();
	pObj.load(fis);
	data = pObj.getProperty(key);
	}catch (Exception e) {
		// TODO: handle exception
	}
	return data;
}
}
