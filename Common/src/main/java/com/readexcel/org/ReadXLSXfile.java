package com.readexcel.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSXfile {

	public static void readfile(String filepath, Object sheetobj) {

		String[][] excelValue;

		try {
			FileInputStream inputStream = new FileInputStream(new File(filepath));
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = null;

			if (sheetobj instanceof Integer) {
				sheet = wb.getSheetAt((int) sheetobj);
			}
			if (sheetobj instanceof String) {
				sheet = wb.getSheet((String) sheetobj);
			}

			Iterator<Row> rowIt = sheet.rowIterator();

			Row row = rowIt.next();

			int noOfrow = sheet.getLastRowNum();
			int noOfcolumn = row.getLastCellNum();

			excelValue = new String[noOfrow][noOfcolumn];

			System.out.println("No: of column " + noOfcolumn + " no: of row " + noOfrow);

			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
