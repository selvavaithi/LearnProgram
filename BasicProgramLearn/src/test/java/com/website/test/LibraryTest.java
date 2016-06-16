package com.website.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.common.test.ThisIsCommonTest;
import com.readexcel.org.ReadXLSXfile;

public class LibraryTest {

	public static void main(String[] args) {

		ThisIsCommonTest cmm = new ThisIsCommonTest();
		
		String strlastruntime ="16/06/2016 9:17:00 AM",dateFormat ="MM/dd/yyyy hh:mm:ss a";
		
		try
        {
            strlastruntime = strlastruntime.trim();
            System.out.println("strlastruntime = "+strlastruntime+" dateFormat = "+dateFormat);
            java.util.Locale l = java.util.Locale.UK;
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(dateFormat,l);
            //System.out.println("formatter = "+formatter);
            java.util.Date date = formatter.parse( strlastruntime );
            System.out.println("date = "+date);
            long time = date.getTime();
            System.out.println("time = "+time);

        }
        catch(java.text.ParseException ee)
        {
            ee.printStackTrace();
            System.out.println(ee);
        }
		
		cmm.setStr("Testing");

		System.out.println(cmm.needfulfilepath);

		ReadXLSXfile.readfile(cmm.needfulfilepath, 0);
		int dataRow, dataColumn;
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new File("D:\\Mine\\GitHub\\Common\\Needfulfiles\\DataSet.xlsx"));
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> rowIt = sheet.rowIterator();

			dataRow = 0;
			while (rowIt.hasNext()) {
				Row row = rowIt.next();

				Iterator<Cell> cellIt = row.cellIterator();
				dataColumn = 0;
				while (cellIt.hasNext()) {
					Cell cell = cellIt.next();
					String strt = null;
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN: {
						strt = cell.getBooleanCellValue() + "";
						break;
					}
					case Cell.CELL_TYPE_NUMERIC: {
						strt = cell.getNumericCellValue() + "";
						break;
					}
					case Cell.CELL_TYPE_STRING: {
						strt = cell.getStringCellValue() + "";
						break;
					}
					}
					System.out.println(cell.getCellType() + " : " + strt + "[" + dataRow + "][" + dataColumn + "]");
					dataColumn++;
				}

				dataRow++;
			}
			wb.close();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
