package com.client.LeadGain.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	String path="./TestData/LeadGainBook.xlsx";

	public String getDataFromEXcelFile(int rowIndex, int cellIndex)
	{
		String data="";
		try {
			FileInputStream fis=new FileInputStream(path);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		data = cell.toString();
		workbook.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}
	
	public void setDataIntoExcelFile(int rowIndex, int cellIndex, String value)
	{
		try {
			FileInputStream fis=new FileInputStream(path);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.getRow(rowIndex);
			if(row==null) {
				row=sheet.createRow(rowIndex);
			}
			row.createCell(cellIndex, CellType.STRING).setCellValue(value);
			FileOutputStream fos=new FileOutputStream(path);
			workbook.write(fos);
			workbook.close();
		}
		catch (Exception e) {
		// TODO: handle exception
	}
	}
	
	public int getRowIndex()
	{
		int data=0;
		try {
			FileInputStream fis=new FileInputStream(path);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet("Sheet1");
		data = sheet.getLastRowNum();
		workbook.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}
	
	public int getCellCount(int rowIndex)
	{
		int cellCount=0;
		try {
			FileInputStream fis=new FileInputStream(path);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet("Sheet1");
		cellCount = sheet.getRow(rowIndex).getLastCellNum();
		workbook.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return cellCount;
	}
}
