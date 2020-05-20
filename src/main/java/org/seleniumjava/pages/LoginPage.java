package org.seleniumjava.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumjava.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase {

	//Page Factory- Object Repository
	@FindBy(id="Email")
	public WebElement emailTBox;
	@FindBy(id="Password")
	public WebElement passwordTBox;
	@FindBy(xpath="//input[contains(@class,'login-button')]")
	public WebElement  loginBtn;
	
	@FindBy(className="ico-login")
    public WebElement loginLink;
	
	public LoginPage(){
		
		PageFactory.initElements(driver,this);
	}
	
   //Methods - Action 
	@Step("Verify the page title step.....")
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	@Step("login with username : {0} and password: {1}...."  )
	
	public HomePage login(String emailID,String password){
		loginLink.click();
		emailTBox.sendKeys(emailID);
		passwordTBox.sendKeys(password);
		loginBtn.click();
		return new HomePage();
		
	}
}
