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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import  org.apache.log4j.Logger;


public class LoginTest extends TestBase {



			 

	public LoginTest(){
	
		super();
	}
	
	
	
	
	 
 @BeforeMethod(alwaysRun=true)
 
 public void setUp() {
	 	
	 	initialization();
	 	BasicConfigurator.configure();
	 	log.info("*************Initialization*****************");  
 }
 
 
  @Test(priority=1)
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
  
  @Test(priority=2)
  @Severity(SeverityLevel.BLOCKER)
  @Description("Verify the login test")
  @Story("Story Name:- To check whether the user is able to login")
  public void loginTest() {
	 //loginPage=new LoginPage();
	 log.info("*************Starting the Login Test*****************");  
	 homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	 log.info("*************End the Login Test - Test Case loginTest*****************");
	 
  }
  
  @AfterMethod(alwaysRun=true)
  
  public void tearDown(){
	  
	  driver.quit();
	  
  }
  
} 
