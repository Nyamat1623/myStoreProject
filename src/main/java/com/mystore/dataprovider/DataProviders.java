package com.mystore.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DataProviders {

	String path=(System.getProperty("user.dir")+"\\src\\test\\resources\\Testdata\\Book1.xlsx");
	@DataProvider(name = "Sheet1")
	public Object[][] getData() throws IOException {
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        
        XSSFRow row;
        XSSFCell cell;
        
        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount - 1][2]; // Exclude header row

        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header
            row = (XSSFRow) sheet.getRow(i);
            // Ensure you are accessing individual cells in the row
            data[i - 1][0] = getCellValueAsString(row.getCell(0)); // Username
            data[i - 1][1] = getCellValueAsString(row.getCell(1)); // Password
        }
        
        workbook.close();
        return data;
    }

	private String getCellValueAsString(Cell cell) {
	    if (cell == null) {
	        return ""; // Handle null cells gracefully
	    }

	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue();
	        case NUMERIC:
	            // Convert numeric value to string without decimal point
	            return String.valueOf((int) cell.getNumericCellValue()); // Cast to int to remove decimal
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        default:
	            return "";
	    }
	}
}