package com.client.LeadGain.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtility 
{
	Connection con;
public void getDatabaseConnection()
{
	try {
	con = DriverManager.getConnection("url", "username", "password");
	}
	catch (Exception e) {
		// TODO: handle exception
	}
}

public ResultSet getResultSet(String query)
{
	ResultSet result=null;
	try {
	Statement stat = con.createStatement();
	result = stat.executeQuery(query);
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return result;
}

public int getUpdateOnQuery(String query)
{
	int result=0;
	try {
		Statement stat = con.createStatement();
		result = stat.executeUpdate(query);
	}catch (Exception e) {
		// TODO: handle exception
	}
	return result;
}

public void closeConnection()
{
	try
	{
		con.close();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
}
}
