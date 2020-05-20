package org.seleniumjava.testscenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.seleniumjava.base.TestBase;
import org.seleniumjava.pages.HomePage;
import org.seleniumjava.pages.LoginPage;
import org.seleniumjava.pages.ShoppingCartPage;
import org.seleniumjava.testdata.ShoppingCostTestData;
import org.seleniumjava.tests.LoginTest;
import org.seleniumjava.tests.ProductPageTest;
import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class TS_ShoppingCost extends TestBase {
	
	
	public TS_ShoppingCost(){
		
		super();
		
		
	}
	


	
@BeforeClass(description="Initialize and LoginPage")

public void testInitialize(){
	initialization();
	log.info("*************Starting the Login Test*****************");  
	homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	log.info("*************End the Login Test - Test Case loginTest*****************");
	
//  Added the below code if someone wants to run for a single row, it will pickup the data from the first row	
	//Loading the excel file 
	excelOperations.loadExcel("ShoppingCost.xlsx");
	if(excelRowNo==0){
		excelRowNo=1;
	System.out.println(excelRowNo);	
	}
}


@Test(priority=1,description="ProductPage")


  public void selectAndAddToCart() {
	
	
	String productName=excelOperations.getCellData("Sheet1", excelRowNo, "DT_ProductName");
	String subProductName=excelOperations.getCellData("Sheet1", excelRowNo, "DT_SubProductName");
	System.out.println("The product Name is " + productName);
	System.out.println("The product Name is " + subProductName);	
	homePage.navigateToProductPage(productName);
	productPage.navigateSubProductName(subProductName);
	productPage.addToCart("25");	  
  }

@Test(priority=2,description="ShoppingCartPage")

public void CheckOutCart() {
	
	//System.out.println("This is the 2nd test  "+ paramProductName);
		shoppingCartPage.verifyProductSubTotal();
		shoppingCartPage.productCheckout();		  	  
	}
	  
	
  
@AfterClass

public void tearDown() {
	
	driver.quit();
	
}


}
