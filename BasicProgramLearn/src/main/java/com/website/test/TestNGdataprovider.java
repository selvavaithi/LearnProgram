package com.website.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGdataprovider {

	static Object[][] myObject = null;

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() { // The number of times data is
												// repeated, test will be
												// executed the same no. of
												// times
												// Here it will execute two
												// times

		// ..

		FileInputStream file;

		String filePath = System.getProperty("user.dir") + "\\needful\\Book1.xlsx";
		System.out.println(filePath);
		try {
			file = new FileInputStream(new File(filePath));

			// Get the workbook instance for XLS file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = sheet.iterator();

			Row row = rowIterator.next();
			int noOfrepeat = sheet.getLastRowNum();
			System.out.println("Test Repeat time " + noOfrepeat);

			short noOfData = row.getLastCellNum();
			System.out.println("No of Test Data " + noOfData);

			myObject = new Object[noOfrepeat][noOfData];

			int repeat_int = 0;
			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();

				String str = null;
				int data_int = 0;
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						str = "" + cell.getBooleanCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						str = "" + cell.getNumericCellValue();
						break;
					case Cell.CELL_TYPE_STRING:
						str = "" + cell.getStringCellValue();
						break;
					}

					myObject[repeat_int][data_int] = str;

					System.out.println("repeat_int:" + repeat_int + " data_int:" + data_int + " - "
							+ myObject[repeat_int][data_int]);

					data_int++;

				}
				System.out.println("");

				repeat_int++;

			}

			file.close();
			FileOutputStream out = new FileOutputStream(
					new File(System.getProperty("user.dir") + "\\needful\\output.xlsx"));
			workbook.write(out);
			workbook.close();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1",
		// "Test@123" } };
		return myObject;
	}

	// Here we are calling the Data Provider object with its Name
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword, String str) {

		System.out.println(sUsername + " , " + sPassword + " , " + str);

	}
}

//