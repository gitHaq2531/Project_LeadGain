package com.client.LeadGain.Register;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.client.LeadGain.GenericUtility.ExcelUtility;

public class ExcelTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	String path="C:\\Users\\User\\OneDrive\\Desktop\\Batch_Preparation\\TestCases.xlsx";

	FileInputStream fis=new FileInputStream(path);
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("Sheet1");
	Row row = sheet.getRow(95);
	if(row==null) {
		System.out.println("null got");
	}
	Cell cell = row.getCell(1);
	System.out.println(cell.toString());
	System.out.println("done");
}
}
