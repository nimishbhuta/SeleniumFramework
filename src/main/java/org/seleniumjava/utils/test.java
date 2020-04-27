package org.seleniumjava.utils;

import java.util.Arrays;

public class test {

	 static excelUtils excelOperations=new excelUtils();
	 int num1;
	
	public static void main(String[] args) {
		
		
		

		getSortByData();
		
		 

	}
	
	public static Object[][] getSortByData(){
		
			
		Object[][] sortData =excelOperations.getExcelData("ProductPageTestData.xlsx","SortBy");
		System.out.println("Print the values in the object array" + Arrays.deepToString(sortData));
		return sortData;
		 
	  }
	
}
