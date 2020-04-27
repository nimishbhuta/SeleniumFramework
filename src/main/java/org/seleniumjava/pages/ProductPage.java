package org.seleniumjava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.seleniumjava.base.TestBase;
import org.seleniumjava.utils.excelUtils;
import org.testng.annotations.DataProvider;


public class ProductPage extends TestBase {
	
	
	@FindBy(linkText="Apparel & Shoes")
	public WebElement apparelShoesLink;
	
	@FindBy(linkText="Electronics")
	public WebElement electronicsLink;

	@FindBy(linkText="Computers")
	public WebElement computersLink;

	@FindBy(id="products-orderby")
	public WebElement productSortSelect;

	@FindBy(className="qty-input")
	public WebElement quantityTBox;
	
	@FindBy(id="add-to-cart-button-36")
	public WebElement addToCartbtn;
	
	
	 public ProductPage(){
		PageFactory.initElements(driver, this);  
	  }
	


	
	public void sortByText(String text){
		webOperations.selectdropDownBox(productSortSelect,"ByVisible",text);
	}


	public void navigateSubProductName(String text){
		webOperations.clickWebElement(driver.findElement(By.linkText(text)));
	}
	
	
	public void addToCart(String qtyValue){

		  //priceValue=Double.valueOf(driver.findElement(By.xpath("//span[contains(@itemprop,'price')]")).getText());
		 webOperations.setText(quantityTBox, qtyValue);	
		 webOperations.clickWebElement(addToCartbtn);
	}
	
	
	

}
