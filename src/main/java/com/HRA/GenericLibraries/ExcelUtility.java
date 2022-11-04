 package com.HRA.GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility extends JavaUtility {

	/**
	 * This method is used to read data from Excel file
	 * 
	 * @author ROOMAN
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo) throws Throwable {
		/* create object for physical file */
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		/* create workbook */
		Workbook wb = WorkbookFactory.create(fi);
		/* get sheet */
		Sheet sh = wb.getSheet(SheetName);
		/* get row */
		Row ro = sh.getRow(RowNo);
		/* get cell */
		Cell cel = ro.getCell(ColumnNo);
		/* read the data */
		String value = cel.getStringCellValue();
		/* return the value */
		return value;
	}

	/**
	 * This method is used to Write data into Excel file
	 * 
	 * @author ROOMAN
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String SheetName, int RowNo, int ColumnNo, String data) throws Throwable

	{
		/* create object for physical file */
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		/* create workbook */
		Workbook wb = WorkbookFactory.create(fi);
		/* get sheet */
		Sheet sh = wb.getSheet(SheetName);
		/* get row */
		Row ro = sh.createRow(RowNo);
		/* create cell */
		Cell cel = ro.createCell(ColumnNo);
		/* To pass the data into the cell */
		cel.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);

		wb.write(fos);
	}

	/**
	 * This method is used to get last row number
	 * 
	 * @author ROOMAN
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String SheetName) throws Throwable {
		/* create object for physical file */
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		/* create workbook */
		Workbook wb = WorkbookFactory.create(fi);
		/* get sheet */
		Sheet sh = wb.getSheet(SheetName);
		/* To get last row number */
		int count = sh.getLastRowNum();
		/* return the count number */
		return count;
	}

	/**
	 * 
	 * @param driver @param sh @throws Throwable @throws
	 */
	public Map<String,String> getList(WebDriver driver, String sheetName, int row, int keycolumn, int valuecolumn) throws Throwable {
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		
		int count = sh.getLastRowNum();
		
		/*Empty map*/
		Map<String, String> map = new HashMap<String, String>();
		
		for (int i = 0; i <= count; i++) {
			String key = sh.getRow(i).getCell(keycolumn).getStringCellValue();
			String value = sh.getRow(i).getCell(valuecolumn).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
}
