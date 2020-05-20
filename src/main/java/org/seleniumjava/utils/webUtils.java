package org.seleniumjava.utils;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.seleniumjava.base.TestBase;
import org.testng.ITestContext;
import org.apache.commons.io.FileUtils;

public class webUtils extends TestBase {
	
	public void clickWebElement(WebElement webElement){
		webElement.click();
	}

	public void setText(WebElement webElement,String textValue){
		
		webElement.clear();
		webElement.sendKeys(textValue);
		
	}

	public String getTBoxValue(WebElement webElement){
		
		return webElement.getAttribute("value");
		
	}

	public String getTextValue(WebElement webElement){
		
		return webElement.getText();
		
	}

	
	public void selectdropDownBox(WebElement webElement,String methodName,String textValue){
		Select oSelect=new Select(webElement);
		
		if(methodName=="ByVisible"){
				oSelect.selectByVisibleText(textValue);
		}
		else if (methodName=="ByValue"){
			oSelect.selectByValue(textValue);
		}
		else if (methodName=="ByIndex"){
			Integer i=Integer.valueOf(textValue);
			oSelect.selectByIndex(i);
		}
	}
	
	public String getPageTitle(){
		
		String title=driver.getTitle();
		return title;	
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
	
	
	
	public int getCurrentIteration(ITestContext testContext) {
		int currentCount = testContext.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println("Executing count: " + currentCount);
		return  currentCount;
		
	}
	
}
