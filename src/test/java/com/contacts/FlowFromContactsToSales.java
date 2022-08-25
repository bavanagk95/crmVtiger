package com.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.vTiger.GenericUtilities.ExcelUtility;
import com.vTiger.GenericUtilities.FileUtility;
import com.vTiger.GenericUtilities.JavaUtility;
import com.vTiger.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlowFromContactsToSales
{
    public static void main(String[] args) throws Throwable 
    {
    	 WebDriver driver=null;
   	  //Step 1  read data from property file
    	 WebDriverUtility wb=new WebDriverUtility();
 		JavaUtility ju=new JavaUtility();
 	   FileUtility fu=new FileUtility();
 	   ExcelUtility excel=new ExcelUtility();
   	
 	   
 	   
 	   String URL = fu.getPropertyKeyValue("url");
   	String USERNAME = fu.getPropertyKeyValue("username");
   	String PASSWORD = fu.getPropertyKeyValue("password");
   	String BROWSER = fu.getPropertyKeyValue("browser");
   	
   	
   	// step 2 read data from excel sheet
   	
   	
   	
   	String Lname = excel.getExcelData("Sheet1", 1, 2);
   	String Subject = excel.getExcelData("Sheet1", 1, 3);
   	String Billadd = excel.getExcelData("Sheet1", 1, 3);
  	String shipadd = excel.getExcelData("Sheet1", 1, 4);
   	String qty = excel.getExcelData("Sheet2", 3, 0);
   	// String Acttitle = excel.getExcelData("Sheet2", 3, 1);
   	
   	
   	 
   	 
   	
   	//step 3 launch the browser
   	
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
   	
      driver.manage().window().maximize();
	  wb.waitForElementInDOM(driver);
	  driver.get(URL);
	  
	  //step 4 login to app
	  
	  
	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	  driver.findElement(By.id("submitButton")).click();
	  
	  //step 5 navigate to contacts module
	  
	  driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	  
	  //step 6 adding details of contacts
	  
	  WebElement dropdown = driver.findElement(By.xpath("//Select[@name='salutationtype']"));
	  
	  wb.select(dropdown,"Mrs.");
	  
	  
	  driver.findElement(By.name("lastname")).sendKeys(Lname);
	  driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
	  
	  /* String parentid = driver.getWindowHandle();
	  Set<String> allid = driver.getWindowHandles();
	  for(String id:allid)
	  {
		  driver.switchTo().window(id);
	  }*/
	  
	  driver.findElement(By.xpath("//a[.='uber']")).click();
	 wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
	  //driver.switchTo().window(parentid);
	 
	  driver.findElement(By.xpath("//input[@type='submit' and @value='  Save  ']")).click();
	 // WebElement ele = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']"));
	 // String ContactName = ele.getText();
	  
	  
	  //  step 7 navigate to sales order
	  

	  driver.findElement(By.xpath("//a[.='More']")).click();
	  driver.findElement(By.name("Sales Order")).click();
	  driver.findElement(By.xpath("//img[@title='Create Sales Order...']")).click();
	  driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(Subject);
	  driver.findElement(By.xpath("//input[@name='contact_name']/following-sibling::img")).click();
	  String salesparentid = driver.getWindowHandle();
	  Set<String> org = driver.getWindowHandles();
	  for(String id:org)
	  {
		  
		  wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView");
		  //driver.switchTo().window(id);
		  
	  }
	  List<WebElement> allContact = driver.findElements(By.xpath("//a[.='Name ']/../../../tr[*]/td[1]"));
	  ArrayList<String> list=new ArrayList<String>();
	  for(WebElement wb1:allContact)
	  {
		 String contacts = wb1.getText();
		 list.add(contacts);
		 
	  }
	  System.out.println(list);
	  
	  
	  if(list.contains(Lname))
	  {
		  System.out.println("contact is verified" );
	  }
	  else
	  {
		  System.out.println("not added");
	  }
	  
		  

	  
	  
	  
	  
	  

   	 
	}
}
