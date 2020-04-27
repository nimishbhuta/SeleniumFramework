package org.seleniumjava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumjava.base.TestBase;
import org.seleniumjava.utils.webUtils;

public class HomePage extends TestBase {
	
	
	
	@FindBy(className="ico-login")
    public WebElement loginLink;
	

public HomePage(){
		
		PageFactory.initElements(driver,this);
	}



public ProductPage navigateToProductPage(String mainProductName){
	 webOperations.clickWebElement(driver.findElement(By.linkText(mainProductName)));
	 return new ProductPage();
	 
}
	
}
