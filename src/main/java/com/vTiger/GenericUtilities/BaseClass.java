package com.vTiger.GenericUtilities;

import java.sql.SQLException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Vtigerobjectrepository.Home;
import com.Vtigerobjectrepository.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	    public WebDriver driver;
	    static WebDriver sdriver;
	
	public    DataBaseUtility db=new DataBaseUtility();
	public   WebDriverUtility wb=new WebDriverUtility();
	public   JavaUtility ju=new JavaUtility();
	public   FileUtility fu=new FileUtility();
	public   ExcelUtility excel=new ExcelUtility();
	  
	   @BeforeSuite(groups = "Smoke")
       public void dbConnect() throws SQLException {
		// db.connectDB();
		 System.out.println("database connected");
	   }
	  // @Parameters("BROWSER")
	   @BeforeClass(groups = "Smoke")
	   public void browserLaunch() throws Throwable
	   {
		   String BROWSER = fu.getPropertyKeyValue("browser");
		   if(BROWSER.equalsIgnoreCase("chrome"))
		   {
		 	  WebDriverManager.chromedriver().setup();
		 	  driver=new ChromeDriver();
		   }
		 else
		 {

		 	  WebDriverManager.firefoxdriver().setup();
		 	  driver=new FirefoxDriver();
		 }
		   sdriver=driver;
	   }
	   
	   @BeforeMethod(groups = "Smoke")
	   public void loginToApp() throws Throwable
	   {
		  
		   Login l=new Login(driver); 
		  
		   l.LogintoApp();
	   }
	   
	   @AfterMethod(groups = "Smoke")
	   
		   public void logoutToApp()
	   {
		   Home h=new Home(driver);
			h.logout();   
		   }
	   @AfterClass(groups = "Smoke")
	   public void closeBrowser()
	   {
		   driver.close();
	   }
	   @AfterSuite(groups = "Smoke")
	   public void dbDisconnect() throws SQLException
	   {
		  // db.closeDB();
		   System.out.println("database connection closed");
	   }
	   }

