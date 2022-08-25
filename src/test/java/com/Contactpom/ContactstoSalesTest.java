package com.Contactpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtigerobjectrepository.ContactPage;
import com.Vtigerobjectrepository.CreateContactPage;
import com.Vtigerobjectrepository.CreateOrganizationPage;
import com.Vtigerobjectrepository.CreateProductPage;
import com.Vtigerobjectrepository.CreateSalesOrderPage;
import com.Vtigerobjectrepository.Home;
import com.Vtigerobjectrepository.Login;
import com.Vtigerobjectrepository.SalesOrderPage;
import com.vTiger.GenericUtilities.BaseClass;
import com.vTiger.GenericUtilities.ExcelUtility;
import com.vTiger.GenericUtilities.FileUtility;
import com.vTiger.GenericUtilities.JavaUtility;
import com.vTiger.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.vTiger.GenericUtilities.Listenzer.class)

public class ContactstoSalesTest extends BaseClass
{
	String Lname;
	String Subject;
	String billing;
	String shipping;
	String qty;
	String org;
	String prod;
	int random;
	
	
	WebDriverUtility wb;
	JavaUtility ju;
	ExcelUtility excel;
	
	Home h;
	@Test(priority = 1,groups = "Smoke")
	
		public void createContact() throws Throwable {  
		  
	   	    
		   ju=new JavaUtility();
		 
		   excel=new ExcelUtility();
		   
		   
		   
		 /*  String BROWSER = fu.getPropertyKeyValue("browser");
		   String USERNAME = fu.getPropertyKeyValue("username");
		   String PASSWORD = fu.getPropertyKeyValue("password");
		   String URL = fu.getPropertyKeyValue("url");*/
		   
		   random = ju.getRandomNumber();
		   
		   Lname = excel.getExcelData("Sheet6", 1, 1)+random;
		  
		   
		   
		  
		   
		 
		   
		   
		   
		   
				   
		   wb=new WebDriverUtility();
		   
		   wb.waitForElementInDOM(driver);
		 
		   
		    h=new Home(driver);
		   h.getContactlink().click();
		   
		   ContactPage cp=new ContactPage(driver);
		   cp.getCreateconimg().click();
		   
		   CreateContactPage ccp=new CreateContactPage(driver);
		   ccp.createContact(Lname);
	}
		   
		   @Test(priority = 2, groups = "Smoke")
		   public void createOrg1() throws Throwable
		   {
			   org=excel.getExcelData("Sheet6", 1, 6)+random;
		   CreateOrganizationPage co=new CreateOrganizationPage(driver);
		   co.createOrganization(org);
		   driver.navigate().refresh();
		   }
		   
		   @Test(priority = 3,groups = "Smoke")
		   public void createProd1() throws Throwable
		   {

			    prod=excel.getExcelData("Sheet6", 1, 7)+random;
		   CreateProductPage cpp=new CreateProductPage(driver);
		   cpp.createProd(prod);
		   }
		   
		   @Test(priority = 4)
		   public void createSalesOrder() throws Throwable
		   {
			   Subject = excel.getExcelData("Sheet6", 1, 2)+random;
			    billing=excel.getExcelData("Sheet6", 1, 3);
			    shipping=excel.getExcelData("Sheet6", 1, 4);
			    qty=excel.getExcelData("Sheet6", 1, 5);
			    
		   h.getMorelink().click();
		   
		   h.getSalesorderlink().click();
		   
		   SalesOrderPage sp=new SalesOrderPage(driver);
		   sp.getCreatesalesbtn().click();
		   
		   CreateSalesOrderPage csp=new CreateSalesOrderPage(driver);
		   csp.createSalesOrder(Subject,billing ,shipping, Lname, org, prod, qty);
		  // driver.navigate().refresh();
		   h.getSalesorderlink().click();
		   
		   sp.searchdd();
		   sp.getSearchedt().sendKeys(Subject);
		   sp.getSubmitbtn().click();
		   WebDriverWait wait=new WebDriverWait(driver, 20);
			WebElement result = driver.findElement(By.xpath("//table[@class='layerPopupTransport']/tbody/tr/td[contains(text(),'Showing Records 1 - 1 of 1')]"));
			String result_text = result.getText();
			wait.until(ExpectedConditions.textToBePresentInElement(result, "Showing Records 1 - 1 of 1"));
			WebElement ele = driver.findElement(By.xpath("//span[@vtfieldname='subject']/preceding-sibling::a"));
			String name = ele.getText();
			/*if(name.equalsIgnoreCase(Subject))
			{
				System.out.println("sales order created");
			}
			else {
				System.out.println("sales not created");
			}*/
		
		   Assert.assertEquals(name, Subject);
		   
		   
		   
		   }
		   
		   
	}
	  

