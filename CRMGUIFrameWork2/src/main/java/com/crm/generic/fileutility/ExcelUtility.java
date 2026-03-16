package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheet , int row , int cell) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		
		return data;
	}
	
	public void getRowCount(String sheet , int row) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/testScriptData");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheet).getPhysicalNumberOfRows();
	}
	
	public void writeDataToExcel(String sheet , int row , int cell) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/testScriptData");
		Workbook wb = WorkbookFactory.create(fis);
		String value = null;
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
	}
}
