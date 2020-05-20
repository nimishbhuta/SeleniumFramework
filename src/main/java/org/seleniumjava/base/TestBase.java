package org.seleniumjava.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.seleniumjava.pages.HomePage;
import org.seleniumjava.pages.LoginPage;
import org.seleniumjava.pages.ProductPage;
import org.seleniumjava.pages.ShoppingCartPage;
import org.seleniumjava.tests.LoginTest;
import org.seleniumjava.utils.WebEventListener;
import org.seleniumjava.utils.excelUtils;
import org.seleniumjava.utils.webUtils;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static webUtils webOperations;
	public static excelUtils excelOperations;
	String propertiesDirPath;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static ProductPage productPage;
	public static ShoppingCartPage shoppingCartPage;
	public static Logger log ;
	public static int excelRowNo=0;
	public TestBase(){
		try{
			
			propertiesDirPath=System.getProperty("user.dir") + "\\src\\main\\java\\org\\seleniumjava\\config\\config.properties";
			prop=new Properties();
			FileInputStream oFile=new FileInputStream(propertiesDirPath);
			prop.load(oFile);
			
			
		}
		catch(FileNotFoundException e) {
				e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
	}
		
		
		
	}
	
	
	
	public static void initialization(){
		
		String browserName=prop.getProperty("browser");
	    //System.out.println(Thread.currentThread().getId());
		
		if (browserName.equals("chrome")) {
				System.out.println("inside");
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\java\\org\\seleniumjava\\drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				driver=new ChromeDriver(options);
			}
		else if (browserName=="FireFox"){
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\main\\java\\org\\seleniumjava\\drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
			
		 	}	
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("urlName"));
		//Initiliazing the web operations util 
		 webOperations=new webUtils();
		//Initiliazing the web operations util 
		 excelOperations=new excelUtils();
		 e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		loginPage=new LoginPage();
		homePage=new HomePage();
		productPage=new ProductPage();
		shoppingCartPage=new ShoppingCartPage();
		
		log=LogManager.getLogger("SeleniumFramework");
		
	}

	public static void ObjectRequired(){
		
		 excelOperations=new excelUtils();
	}
	
	
}
