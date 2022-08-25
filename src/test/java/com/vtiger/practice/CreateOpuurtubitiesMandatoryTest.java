package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpuurtubitiesMandatoryTest
{
  public static void main(String[] args) throws IOException, InterruptedException
  {
	  WebDriver driver=null;
	//step1 read all common data
	  FileInputStream fis=new FileInputStream(".\\Data\\Commondata.properties");
	  Properties prop=new Properties();
	  prop.load(fis);
	  String URL = prop.getProperty("url");
	 String BROWSER = prop.getProperty("browser");
	  String USERNAME = prop.getProperty("username");
	  String PASSWORD = prop.getProperty("password");
	  
	  //step2 read data from excel
	  FileInputStream fisxel=new FileInputStream(".\\Data\\Testdata.xlsx");
	 
	  Workbook wb = WorkbookFactory.create(fisxel);
	  String oppname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	  
	  
	  //step3 launch the browser
	  
	  if(BROWSER.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	  }
	  
		  
	  else if(BROWSER.equalsIgnoreCase("firefox"))
	  {
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	  }
	  
	  else
	  {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	  }
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(URL);
	  
	  // step 4 login to app
	  
	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	  driver.findElement(By.id("submitButton")).click();
	  
	  
	  //step 5 navigate to opputunities link
	  
	  driver.findElement(By.xpath("//a[.='Opportunities']")).click();
	  driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
	  
	  //step 6 create oppurtunity with mandatory fields
	  
	  driver.findElement(By.name("potentialname")).sendKeys(oppname);
	  
	  //step 7
	   
	  driver.findElement(By.xpath("//input[@name='related_to']/following-sibling::img[@title='Select']")).click();
	  
	  String parentid = driver.getWindowHandle();
	  Set<String> allid = driver.getWindowHandles();
	  Iterator<String> i=allid.iterator();
	  String child = "null";
	  while(i.hasNext())
	  {
		  child=i.next();
	  }
	  driver.switchTo().window(child);
	  Thread.sleep(5000);
	  driver.findElement(By.id("1")).click();
	  Thread.sleep(5000);
	  driver.switchTo().window(parentid);
	 // Thread.sleep(4000);
	  driver.findElement(By.name("button")).click();
	  
	  
	   
	  }
	  
	  
  }

