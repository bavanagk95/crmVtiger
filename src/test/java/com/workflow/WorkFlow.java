package com.workflow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vTiger.GenericUtilities.ExcelUtility;
import com.vTiger.GenericUtilities.FileUtility;
import com.vTiger.GenericUtilities.JavaUtility;
import com.vTiger.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkFlow 
{
  public static void main(String[] args) throws Throwable {
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
		
		//step 2 read data from excel sheet
		
		String Lname = excel.getExcelData("Sheet4", 1, 1);
		String Company = excel.getExcelData("Sheet4", 1, 2);
		String OrgName = excel.getExcelData("Sheet4", 3, 1);
		String BillAdd = excel.getExcelData("Sheet4", 3, 2);
		String ShipAdd = excel.getExcelData("Sheet4", 3, 3);
		String UpadateOrgName = excel.getExcelData("Sheet4", 3, 4);
		String OppurtunityName = excel.getExcelData("Sheet4", 5, 1);
		String PricebookName = excel.getExcelData("Sheet4", 7, 1);
		
		//Step3 launch the browser
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else {
			System.out.println("Browser not specified");
		}
		
		// Step 4 login to app
		wb.waitForElementInDOM(driver);
		  driver.manage().window().maximize();
		  driver.get(URL);
		  
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  
		  // Step 5 navigate to lead and create lead
		  driver.findElement(By.xpath("//a[.='Leads']")).click();
		  driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		  int random = ju.getRandomNumber();
		  String Lname1 = Lname+random;
		  driver.findElement(By.name("lastname")).sendKeys(Lname1);
		  driver.findElement(By.name("company")).sendKeys(Company);
		  driver.findElement(By.xpath("//input[@type='radio']/following-sibling::input")).click();
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  
		  // step 6 navigate to organization and create a organization
		  String OrgName1 = OrgName+random;
		  driver.findElement(By.xpath("//a[.='Organizations']")).click();
		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName1);
		 // driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(BillAdd);
		 // driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(ShipAdd);
		  driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		  wb.waitForPage(driver, "http://192.168.0.190:8888/index.php?action=DetailView&module=Accounts&parenttab=Marketing&record=530&viewname=0&start=");
		  //step 7 edit organization
		 driver.navigate().refresh();
		  String UpadateOrgName1 = UpadateOrgName+random;
		  driver.findElement(By.xpath("//a[.='Organizations']")).click();
		 WebElement ele = driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@name='search_field']"));
		 wb.select(ele, "Organization Name");
		 driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrgName1);
		 driver.findElement(By.xpath("//input[@name='submit']")).click();
		// driver.switchTo().alert().accept();
		  driver.findElement(By.xpath("//a[.='"+OrgName1+"']/../../td[8]/a[.='edit']")).click();
		  driver.findElement(By.xpath("//input[@name='accountname']")).clear();
		  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(UpadateOrgName1);
		  
		  driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		  driver.navigate().refresh();
		  
		  
		  // Step 8 create oppurtunity
		  String OppurtunityName1 = OppurtunityName+random;
		  driver.findElement(By.xpath("//a[.='Opportunities']")).click();
		  driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		  driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(OppurtunityName1);
		  driver.findElement(By.xpath("//input[@name='related_to']/following-sibling::img[@title='Select']")).click();
		  wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Accounts&action=Popup&html=Popup_picker&form=vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord=");
		  driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(UpadateOrgName1);
		  driver.findElement(By.xpath("//input[@name='search']")).click();
		  driver.findElement(By.xpath("//a[.='"+UpadateOrgName1+"']")).click();
		  wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Potentials&action=EditView&return_action=DetailView&parenttab=Sales");
		  driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		  
		//step 9 Navigate to pricebook
		  String PricebookName1 = PricebookName+random;
		  driver.findElement(By.xpath("//a[.='More']")).click();
		  driver.findElement(By.name("Price Books")).click();
		  driver.findElement(By.xpath("//img[@title='Create Price Book...']")).click();
		  driver.findElement(By.xpath("//input[@name='bookname']")).sendKeys(PricebookName1);
		  driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		  
		  
		  //step 10 navigate to more info in pricebook and add product
		  
		  driver.findElement(By.xpath("//a[.='More Information']")).click();
		  driver.findElement(By.xpath("//img[@id='show_PriceBooks_Products']")).click();
		  driver.findElement(By.xpath("//input[@title='Select Products']")).click();
		  driver.findElement(By.xpath("//td[.='cars']/preceding-sibling::td/input"));
		  driver.findElement(By.xpath("//input[@value='Add To Price Books']")).click();
		  List<WebElement> books = driver.findElements(By.xpath("//div[@id='ListViewContents']/descendant::div[1]/table/tbody/tr[*]/td[3]"));
		  System.out.println(books);
		  
		  
		  
		  
		  
		  
}
}
