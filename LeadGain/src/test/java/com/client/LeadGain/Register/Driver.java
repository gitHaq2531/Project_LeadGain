package com.client.LeadGain.Register;

import org.testng.annotations.Test;

import com.client.LeadGain.GenericUtility.ExcelUtility;

public class Driver {
	@Test
public void main() 
{	
	CalcInterface cObj = CalcInterface.getCalculator();
	cObj.add(3, 8);
}
@Test
public void readTest()
{
	ExcelUtility e=new ExcelUtility();
	System.out.println(e.getRowIndex());
	e.setDataIntoExcelFile(4, 0, "hyy");
	e.setDataIntoExcelFile(5, 0, "hyy123");
	e.setDataIntoExcelFile(6, 0, "hyy321");
	System.out.println(e.getRowIndex());

}

@Test
public void excelTest()
{
	ExcelUtility eu=new ExcelUtility();
	System.out.println(eu.getRowIndex());
	System.out.println(eu.getDataFromEXcelFile(0, 0));
	
}

}
