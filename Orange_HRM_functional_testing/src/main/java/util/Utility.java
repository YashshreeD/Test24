package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;



public class Utility {
	
	public static String getExcelSheetData(String sheetName,int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		
		String path = "C:\\Users\\yashs\\Downloads\\Mathematical+&+Logical+Functions.xlsx";
		
		InputStream file = new FileInputStream(path); 
		
		Cell cell = WorkbookFactory.create(file).getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			
		String data;
		try {
			 data = cell.getStringCellValue();
		}
		catch(java.lang.IllegalStateException e)
		{
			double numericData = cell.getNumericCellValue();
			data = String.valueOf(numericData);
		}
		finally {
			if (file != null) {
				file.close();
			}
		}
		
		return data;
	}
	public static void captureScreenShot(String testID) {
		DateTimeFormatter DateTime = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		
		for(int i = 0; i <= 6; i++)
		{	
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 
			LocalDateTime now = LocalDateTime.now();
		    String NowDateTime = now.format(DateTime);
			
			File dest = new File("C:\\Users\\yashs\\Documents\\Testing\\Automition testing\\note\\selenium\\TestDAta\\Test_"+testID+NowDateTime+".jpg");
			
			FileHandler.copy(source, dest);
			Thread.sleep(1000);
		}
	}
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String result = getExcelSheetData("Mathematical & LogicalFunctions",0,2);
		System.out.println(result);
	}
}
