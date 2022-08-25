package com.vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author bavana
 *
 */
public class ExcelUtility
{
/**
 *    its used to read the data from Excel-Workbook based on below 
 * @param sheetName
 * @param rowNum
 * @param celNum
 * @return
 * @throws Throwable
 */
	public String getExcelData(String sheetName , int rowNum , int celNum) throws Throwable  {
		FileInputStream fisexcel = new FileInputStream(".\\Data\\VTigerTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fisexcel);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		return data;
	}
	
	/**
	 * used to get the last row number on specified sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fisexcel  = new FileInputStream(".\\Data\\VTigerTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fisexcel);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	
		
		
	}
	/**
	 * used to write data back to Excel based on below parameter
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */

	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable
	{
		FileInputStream fis  = new FileInputStream(".\\Data\\VTigerTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(celNum);
		cell.setCellValue(data);
		FileOutputStream fout=new FileOutputStream(".\\\\Data\\\\VTigerTestData.xlsx");
		wb.write(fout);
		wb.close();
	}
}
