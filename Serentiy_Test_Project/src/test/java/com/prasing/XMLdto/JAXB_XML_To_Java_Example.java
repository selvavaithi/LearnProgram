package com.prasing.XMLdto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JAXB_XML_to_Java_Example {
	public static void main(String[] args) {
		try {
			File file = new File(System.getProperty("user.dir") + "\\JAXB_XMLtoJavaExample.xml");
			FileInputStream excelFile = new FileInputStream(
					new File(System.getProperty("user.dir") + "\\Needed\\Book1.xlsx"));
System.out.println(System.getProperty("user.dir") + "\\JAXB_XMLtoJavaExample.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(CreditToken.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			CreditToken credittoken = (CreditToken) jaxbUnmarshaller.unmarshal(file);

			List<Header> list = credittoken.getHeader();

			System.out.println(list.get(0).getUserAgent() + " : " + list.get(0).getUserAgentId() + " : "
					+ list.get(0).getVersion());

			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			XSSFSheet sheet = workbook.getSheet("header");

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				String str = null;
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						str = cell.getBooleanCellValue() + "";
						break;
					case Cell.CELL_TYPE_NUMERIC:
						str = cell.getNumericCellValue() + "";
						break;
					case Cell.CELL_TYPE_STRING:
						str = cell.getStringCellValue() + "";
						break;
					}
					System.out.print(str + "\t\t");
					if (str.contentEquals(list.get(0).getVersion() + "")) {
						System.out.println("Found: ");
					}
				}
				System.out.println("");
			}
			excelFile.close();
			workbook.close();

		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
