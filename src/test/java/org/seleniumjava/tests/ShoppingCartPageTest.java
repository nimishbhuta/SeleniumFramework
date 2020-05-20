package org.seleniumjava.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.seleniumjava.base.TestBase;
import org.seleniumjava.pages.HomePage;
import org.seleniumjava.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartPageTest extends TestBase {
	
	
	public ShoppingCartPageTest(){
		
		super();
	}
	

@BeforeMethod 

public void setup(){

	initialization();
	LoginPage loginPage = new LoginPage();
	 log.info("*************Starting the Login Test*****************");  
	 //HomePage homePage = new HomePage();
	 //homePage.loginLink.click();
	 homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	 log.info("*************End the Login Test - Test Case loginTest*****************");
	
}


  @Test
  
  public void verifySubTotalCart(){
	  
	  shoppingCartPage.verifyProductSubTotal();
  }
  
 @AfterMethod 

  public void tearDown(){
  	
	 driver.quit();
	 
  }

}
