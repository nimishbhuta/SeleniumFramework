package org.seleniumjava.applicationFeatures;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.seleniumjava.base.TestBase;
import org.seleniumjava.pages.HomePage;
import org.seleniumjava.pages.LoginPage;
import org.seleniumjava.tests.LoginTest;
import org.testng.annotations.BeforeClass;

public class loginFeature extends TestBase {
	
	
	
	
	Logger log = LogManager.getLogger(LoginTest.class);
	
	public loginFeature(){
		
		super();
		
	}

  @BeforeClass
  
  public void loadPageObjects(){
	  
	  LoginPage loginPage = new LoginPage();
  }
  
  
  
  
	
	public void loginToApplication(WebDriver argdriver,String emailId,String password) {
		 
		 log.info("*************Starting the Login Test*****************");  
		 //HomePage homePage = new HomePage();
		 //homePage.loginLink.click();
		 homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		 log.info("*************End the Login Test - Test Case loginTest*****************");
		 
	  }
	
}
