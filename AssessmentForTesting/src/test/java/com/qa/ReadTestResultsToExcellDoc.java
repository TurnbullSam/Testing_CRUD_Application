package com.qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadTestResultsToExcellDoc 
{
	 public XSSFCell Cell;

	    public XSSFSheet ExcelWSheet = null;
	    
	    public XSSFWorkbook ExcelWBook = null;
	    
		public  XSSFRow Row = null;
		
		public FileInputStream file = null;
	
	   
	public void setCellData(String Result, int RowNum, int ColNum) 
	{ 
		Constants Constants = new Constants();
		
		
		try
	    {
			file = new FileInputStream (Constants.PathTestData + Constants.FileTestData);
			System.out.println(file + "file");
		}
		catch (FileNotFoundException e)
		{
			
		}
		try 
		{
			System.out.println(file + "1");
			ExcelWBook = new XSSFWorkbook(file);
			System.out.println(ExcelWBook + "3");
		}
		catch(IOException a)
		{
		
		}
	    

		try {
			System.out.println(ExcelWSheet + "2");
			ExcelWSheet = ExcelWBook.getSheetAt(0);
			Row = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constants.PathTestData + Constants.FileTestData);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
}
