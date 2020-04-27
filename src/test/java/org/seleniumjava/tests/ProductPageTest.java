package org.seleniumjava.tests;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.seleniumjava.base.TestBase;
import org.seleniumjava.pages.HomePage;
import org.seleniumjava.pages.LoginPage;
import org.seleniumjava.pages.ProductPage;
import org.seleniumjava.utils.excelUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ProductPageTest extends TestBase {
	
	ProductPage productPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public ProductPageTest(){
		super();
	}
	
	 @BeforeMethod 
	 
	 public void setUp() {
		 	
		 	initialization();
		 	loginPage=new LoginPage();
		 	homePage=new HomePage();
		 	homePage.loginLink.click();
		 	homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		 	
		 	
	 }
	 
	
	  @Test(priority=1)
	  public void verifyProducPageTitle() throws InterruptedException {
		productPage=homePage.navigateToProductPage("Apparel & Shoes");  
		Thread.sleep(2000);  
		String actualPageTitle=driver.getTitle();
		String expPageTitle="Demo Web Shop. Apparel & Shoes";
		
		Assert.assertEquals(actualPageTitle,expPageTitle, "The expected title <" + expPageTitle +"> does not match with the actual title <"+actualPageTitle+">");
	  }
	
	  private boolean IsNull(Object excelOperations) {
			// TODO Auto-generated method stub
		  if( excelOperations == null ){
				return true;
			}
			return false;
		}
	  
	  
	  @DataProvider
	  
	  public Object[][] getSortByData(){
		 System.out.println("The exceloperation object is " + this.IsNull(excelOperations));
		 Object[][] sortData =excelOperations.getExcelData("ProductPageTestData.xlsx","SortBy");
		 System.out.println("Print the values in the object array" + Arrays.deepToString(sortData));
		 return sortData;
		 
	  }
	  
	  
	  

	@Test(priority=2,dataProvider="getSortByData")
	  public void sortByFeature(String sorting) {
		productPage=homePage.navigateToProductPage("Apparel & Shoes");
		productPage.sortByText(sorting);
	  }
	  
	  @Test(priority=3)
	  public void selectSubProductAddToCart() {
		 productPage=homePage.navigateToProductPage("Apparel & Shoes");
		 productPage.navigateSubProductName("Blue Jeans");
		 productPage.addToCart("25");	  
	  }
	  
	  @AfterMethod
	  public void tearDown() throws InterruptedException{	  
		 driver.quit();
		 Thread.sleep(2000);
		  }
		  
  
}
