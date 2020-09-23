package com.actitime.genirics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	/**
	 * read the property file
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyValue(String key) throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/data/commondata.property");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;

	}

	/**
	 * common data for read the excel file
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public String getExcelValue(String sheetName, int row, int cell)
			throws EncryptedDocumentException, IOException, InvalidFormatException {
		FileInputStream fis = new FileInputStream("./src/test/resources/data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
		return value;

	}

	/**
	 * common data for write the excel file
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public void setExcelValue(String sheetName, int row, int cell, String value)
			throws EncryptedDocumentException, IOException, InvalidFormatException {
		FileInputStream fis = new FileInputStream("./src/test/resources/data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);

		FileOutputStream fos = new FileOutputStream("./data/testscript.xlsx");
		wb.write(fos);
		wb.close();
	}
}
