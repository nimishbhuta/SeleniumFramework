package org.seleniumjava.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtils  {
	
	public String excelFilePath=System.getProperty("user.dir") + "\\src\\main\\java\\org\\seleniumjava\\testdata\\";
	
	public static Workbook wbk;
	public static Sheet wsheet;
	
	
	public  Object[][] getExcelData(String fileName,String sheetName) {
		
		FileInputStream fileInput=null;
		
		
		try {
			fileInput=new FileInputStream(excelFilePath + fileName) ;
			System.out.println(excelFilePath + fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wbk=WorkbookFactory.create(fileInput);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wsheet=wbk.getSheet(sheetName);
		Object[][] testData=new Object[wsheet.getLastRowNum()][wsheet.getRow(0).getLastCellNum()]; 
		
		for (int i=0;i < wsheet.getLastRowNum();i++){
			
			for (int j=0;j < wsheet.getRow(0).getLastCellNum();j++){
				
				testData[i][j]=wsheet.getRow(i+1).getCell(j).toString();
				
			}
			
			
		}
		return testData;
		
	}




}
