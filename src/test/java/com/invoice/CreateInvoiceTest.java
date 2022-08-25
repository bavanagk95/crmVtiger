package com.invoice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vTiger.GenericUtilities.ExcelUtility;
import com.vTiger.GenericUtilities.FileUtility;
import com.vTiger.GenericUtilities.JavaUtility;
import com.vTiger.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateInvoiceTest
{
  public static void main(String[] args) throws Throwable
  
  {
	  WebDriver driver=null;
	  WebDriverUtility wb=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
	   FileUtility fu=new FileUtility();
	   ExcelUtility excel=new ExcelUtility();
	  //Step 1  read data from property file
	  
	
	String URL = fu.getPropertyKeyValue("url");
	String USERNAME = fu.getPropertyKeyValue("username");
	String PASSWORD = fu.getPropertyKeyValue("password");
	String BROWSER = fu.getPropertyKeyValue("browser");
	
	//step 2  read data from excel sheet
	
	
	String subject=excel.getExcelData("Sheet1", 1, 2);
	String billing = excel.getExcelData("Sheet1", 1, 3);
	String shipping = excel.getExcelData("Sheet1", 1, 4);
	String exppage = excel.getExcelData("Sheet1", 1, 5);
	
	//step3 launch the browser
	
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
	wb.waitForElementInDOM(driver);
	  driver.manage().window().maximize();
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(URL);
	  
	  //step 4  login to app
	  
	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	  driver.findElement(By.id("submitButton")).click();
	  
	  
	  
	  
	  
	  //step 4 Navigate to Invoice
	  
	  driver.findElement(By.xpath("//a[.='More']")).click();
	  driver.findElement(By.name("Invoice")).click();
	  driver.findElement(By.xpath("//img[@title='Create Invoice...']")).click();
	  WebElement CreatePage = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	  String create = CreatePage.getText();
	  String actcreate = "Creating New Invoice";
	  if(create.equals(actcreate))
	  {
		  System.out.println("create page is displayed");
	  }
	  else
	  {
		  System.out.println("page is not displayed");
	  }
	  driver.findElement(By.name("subject")).sendKeys(subject);
	  driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	  /*String parentid = driver.getWindowHandle();
	  Set<String> org = driver.getWindowHandles();
	  for(String id:org)
	  {
		  driver.switchTo().window(id);
		  
	  }*/
	  wb.switchToWindow(driver,"http://192.168.0.190:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=" );
	  driver.findElement(By.xpath("//a[.='uber']")).click();
	  wb.swithToAlertAndAccpect(driver);
	// Alert a = driver.switchTo().alert();
	 //a.accept();
	 wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Sales");
	  
	  driver.findElement(By.name("bill_street")).sendKeys(billing);
	  driver.findElement(By.name("ship_street")).sendKeys(shipping);
	  driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
	 
	  Set<String> product = driver.getWindowHandles();
	  for(String id:product)
	  {
		  wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Products&action=Popup&html=Popup_picker&select=enable&form=HelpDeskEditView&popuptype=inventory_prod&curr_row=1&return_module=Invoice&currencyid=1");
	  }
	driver.findElement(By.xpath("//a[.='Kids wear']/../preceding-sibling::td/input")).click();
	driver.findElement(By.xpath("//input[@value='Select Products']")).click();
	wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Sales");
	driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys("1");
	driver.findElement(By.name("button")).click();
	
	// step 5 verification of final page 
	
	WebElement title = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	String acttitle = title.getText();
	System.out.println(acttitle);
	if(acttitle.contains(exppage))
	{
		System.out.println("invoice is created");
		
	}
	else
	{
		System.out.println("its not created");
	}
	
	//step 5 close the browser
	
	driver.close();
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
 
  }
}
