package org.seleniumjava.testScenarioRunner;

import org.seleniumjava.base.TestBase;
import org.seleniumjava.testscenarios.TS_ShoppingCost;
import org.seleniumjava.utils.excelUtils;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TS_ShoppingCostRunner extends TestBase {

@Test
	
	public static void testRun() throws ClassNotFoundException {
		// TODO Auto-generated method stubS
		
        //This is the runner which will execute all the rows in the excel sheet 
	
		//Loading the excel file and getting the rowCount of it
		
		TestBase.ObjectRequired();
		excelOperations.loadExcel("ShoppingCost.xlsx");
		int rowCount=excelOperations.getRowCount("Sheet1");
		for (int i=1;i < rowCount;i++) {
			
			//testNG.setTestClasses(new Class[]  {TS_ShippingCost.class});
			TestNG testNG= new TestNG();
			testNG.setTestClasses(new Class[] { TS_ShoppingCost.class });
			excelRowNo=i;
			testNG.run();
		
	
		}
		
	}


  
 
	
}