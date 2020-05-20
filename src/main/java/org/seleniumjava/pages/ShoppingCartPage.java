package org.seleniumjava.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumjava.base.TestBase;

public class ShoppingCartPage extends TestBase {
	
	public ShoppingCartPage(){
		
		PageFactory.initElements(driver,ShoppingCartPage.this);
		
	}
	
	//OR
	 
	 @FindBy(id="checkout")
	 WebElement checkOutBtn;
	 
	 @FindBy(name="updatecart")
	 WebElement updateCartBtn;
	 
	 @FindBy(name="continueshopping")
	 WebElement continueShoppingBtn;
	 
	 @FindBy(name="applydiscountcouponcode")
	 WebElement applydiscountBtn;
	 
	 
	 @FindBy(id="termsofservice")
	 WebElement termsServiceCbox;
	 

	 @FindBy(className="qty-input")
	 WebElement qtyInputTBox;
	
	 @FindBy(xpath="//span[contains(@class,'product-unit-price')]")
	 WebElement priceTableText;
	 
	 @FindBy(xpath="//*[@id='topcartlink']/a")
	 WebElement shoppingCartLink;
	 
	 @FindBy(xpath="//*[@class='product-subtotal']")
	 WebElement subTotalTableText;
	 
	 
	 public String getProductQty(){
		 String productQty = null;
		 
		try {
			productQty=webOperations.getTBoxValue(qtyInputTBox);
			System.out.println("The quantity is " + productQty);
			
		}
		catch(NoSuchElementException e){
			System.out.println("Element Not found trying again - " + qtyInputTBox.toString());
            e.printStackTrace();
		}
		return productQty;
	 }
	 
	 public String getProductPrice(){
		 String productPrice = null;
		 
		try {
			productPrice=webOperations.getTextValue(priceTableText);
			System.out.println("The Product Price :" + productPrice);
			
		}
		catch (NoSuchElementException e){
			
			System.out.println("Element Not found trying again - " + priceTableText.toString());
            e.printStackTrace();
		}
		return productPrice;
	 }
	 
	 public String getProductSubTotal() {
		 
		 String productTotal=null;
		 
		 try {
			 	productTotal=webOperations.getTextValue(subTotalTableText);
				System.out.println("The Product Price :" +  productTotal);
				
			}
			
		 catch (NoSuchElementException e){
				
				System.out.println("Element Not found trying again - " + productTotal.toString());
	            e.printStackTrace();
			}	
			return productTotal;
		 }
		 
       

       public void productCheckout() {
    	   	
    	   webOperations.clickWebElement(termsServiceCbox);
    	   webOperations.clickWebElement(checkOutBtn);
       }

	public void verifyProductSubTotal() {
		// TODO Auto-generated method stub
		 
 	   webOperations.clickWebElement(shoppingCartLink);
 	  
 	   int productQty=Integer.valueOf(getProductQty()) ;
 	  
 	   double productPrice=Double.valueOf(getProductPrice());
 	   double actualSubTotal=Double.valueOf(getProductSubTotal());
 	   double expSubTotal=productQty*productPrice;
 	   
	
	    	   if(String.valueOf(expSubTotal).equals(String.valueOf(actualSubTotal))){
	    	 	   System.out.println("The expected value " +String.valueOf(expSubTotal)+"matches with the actual value"+String.valueOf(actualSubTotal));
	    	   }
	    	   else{
	    	 	   System.out.println("The expected value " +String.valueOf(expSubTotal)+"does not match with the actual value"+String.valueOf(actualSubTotal));   
	    	   }
		
	}

	
       }
       
       
       
       


