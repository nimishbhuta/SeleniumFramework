package org.seleniumjava.tests;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;

import org.seleniumjava.base.TestBase;
import org.seleniumjava.pages.HomePage;
import org.seleniumjava.pages.LoginPage;
import org.seleniumjava.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import  org.apache.log4j.Logger;


public class LoginTest extends TestBase {

	LoginPage loginPage;
	//ProductPage productPage;
	HomePage homePage;
	Logger log = LogManager.getLogger(LoginTest.class);
			 

	public LoginTest(){
	
		super();
	}
	
	
	 
 @BeforeMethod 
 
 public void setUp() {
	 	
	 	initialization();
	 	loginPage=new LoginPage();
	 	BasicConfigurator.configure();
	 	  
 }
 
	
  @Test(priority=1,description="Verify the login page title")
  @Severity(SeverityLevel.NORMAL)
  @Description("Verify the login page title test")
  @Story("Story Name:- To check the page title of login page")
  //Check the login page title
  public void verifyLoginPageTitleTest() throws InterruptedException {
	  
	  
	  log.info("*************Starting the Login Test- Test Case verifyLoginPageTitle*****************");
	  Thread.sleep(2000); 
	  String loginTitle=loginPage.validateLoginPageTitle();
	  //Assert.assertEquals(loginTitle, "Demo Web Shop");
	  System.out.println(loginTitle);
     Assert.assertEquals(loginTitle, "Demo Web Shop");
     log.info("*************Ending the Login Test - Test Case verifyLoginPageTitl*****************");
  }
  
  @Test(priority=2,description="Verify the login test")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Verify the login test")
  @Story("Story Name:- To check whether the user is able to login")
  public void loginTest() {
	  
	 log.info("*************Starting the Login Test*****************");  
	 homePage =new HomePage();
	 homePage.loginLink.click();
	 homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	 log.info("*************End the Login Test - Test Case loginTest*****************");
	 
  }
  
  @AfterMethod
  
  public void tearDown(){
	  
	  driver.quit();
	  
  }
  
} 
