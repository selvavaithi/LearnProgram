package com.getdatafromexcel.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class GetDataFromExcel {

	private static HSSFWorkbook workbook;

	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir") + "\\needful\\Book1.xls";
		try {
			FileInputStream fileinput = new FileInputStream(filePath);

			POIFSFileSystem myFileSystem = new POIFSFileSystem(fileinput);
			workbook = new HSSFWorkbook(myFileSystem);
			HSSFSheet worksheet = workbook.getSheet("Sheet2");

			HSSFRow headerRow = worksheet.getRow(1);
			int lastrow = worksheet.getLastRowNum();
			int rowLoop = 2;
			int cellLoop = 1;

			System.out.println("Sheet Name: " + worksheet.getSheetName());

			for (rowLoop = 2; rowLoop <= lastrow; rowLoop++) {
				HSSFRow row = worksheet.getRow(rowLoop);
				for (cellLoop = 1; cellLoop <= row.getLastCellNum(); cellLoop++) {
					HSSFCell cell = row.getCell(rowLoop);
					System.out.println("rowLoop: " + rowLoop + " - cellLoop: " + cellLoop + " = " + cell.toString());

					System.out.println("Header: " + headerRow.getCell(cellLoop));
				}
			}
			fileinput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
