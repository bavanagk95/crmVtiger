package Lead;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;
import com.vTiger.GenericUtilities.ExcelUtility;
import com.vTiger.GenericUtilities.FileUtility;
import com.vTiger.GenericUtilities.JavaUtility;
import com.vTiger.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead 
{
	
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
//step 1 read data from property file	
		WebDriverUtility wb=new WebDriverUtility();
	JavaUtility ju=new JavaUtility();
   FileUtility fu=new FileUtility();
  
   String BROWSER = fu.getPropertyKeyValue("browser");
  String USERNAME = fu.getPropertyKeyValue("username");
  String PASSWORD = fu.getPropertyKeyValue("password");
  String URL = fu.getPropertyKeyValue("url");
  
  
  //step 2 read data from excel file
  
  ExcelUtility excel=new ExcelUtility();
  String Lname = excel.getExcelData("Sheet3", 1, 3);
  String Company = excel.getExcelData("Sheet3",1 ,2);
  String UpdateName = excel.getExcelData("Sheet3", 1, 4);
  
  //step3 launch browser
  
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
  
  //step 4 login to app
  WebDriverUtility wbu=new WebDriverUtility();
  
  //driver.manage().window().maximize();
  wbu.waitForElementInDOM(driver);
  driver.get(URL);
  
  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
  driver.findElement(By.id("submitButton")).click();
  
  // step 5 navigate to Lead
  
  driver.findElement(By.xpath("//a[.='Leads']")).click();
  driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
  int random = ju.getRandomNumber();
  driver.findElement(By.name("lastname")).sendKeys(Lname+random);
  driver.findElement(By.name("company")).sendKeys(Company);
  driver.findElement(By.xpath("//input[@type='radio']/following-sibling::input")).click();
  driver.findElement(By.xpath("//input[@type='submit']")).click();
  driver.findElement(By.xpath("//a[.='Leads']")).click();
  List<WebElement> nameList = driver.findElements(By.xpath("//div[@id='ListViewContents']/descendant::tr[*]/td[3]"));
  ArrayList<String> list=new ArrayList<String>();
  for( WebElement wb2:nameList)
  {
	  String name = wb2.getText();
	list.add(name);
  }
  if(list.contains(Lname+random))
  {
	 WebElement ele = driver.findElement(By.xpath("//a[contains(.,'"+Lname+"')]/../preceding-sibling::td/input")); 
	 ele.click();
	 driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
	 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(UpdateName);
	 driver.findElement(By.xpath("//input[@type='submit' and @name='button']")).click();
	 driver.findElement(By.xpath("//a[contains(.,'"+UpdateName+"')]/../preceding-sibling::td/input")).click();
	 driver.findElement(By.xpath("//input[@value='Delete']")).click();
	 wb.swithToAlertWindowAndAccpect(driver, UpdateName);
	 
	 List<WebElement> nameList1 = driver.findElements(By.xpath("//div[@id='ListViewContents']/descendant::tr[*]/td[3]"));
	  ArrayList<String> list1=new ArrayList<String>();
	  for( WebElement wb1:nameList1)
	  {
		  String name = wb1.getText();
		list1.add(name);
	  }
	 /* if(list.contains(UpdateName))
	  {
		  System.out.println(UpdateName+ " not deleted");
	  }
	  else
	  {
		  System.out.println(UpdateName+ " deleted");
	  }*/
	 
  }
  else {
	  System.out.println("name not present");
  }
driver.close();
	}
	
}
