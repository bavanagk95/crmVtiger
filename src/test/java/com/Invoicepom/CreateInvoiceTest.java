package com.Invoicepom;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Vtigerobjectrepository.CreateInvoicePage;
import com.Vtigerobjectrepository.CreateOrganizationPage;
import com.Vtigerobjectrepository.CreateProductPage;
import com.Vtigerobjectrepository.Home;
import com.Vtigerobjectrepository.Invoice;
import com.Vtigerobjectrepository.Login;
import com.Vtigerobjectrepository.OrganizationPage;
import com.Vtigerobjectrepository.Productpage;
import com.vTiger.GenericUtilities.BaseClass;
import com.vTiger.GenericUtilities.ExcelUtility;
import com.vTiger.GenericUtilities.FileUtility;
import com.vTiger.GenericUtilities.JavaUtility;
import com.vTiger.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.vTiger.GenericUtilities.Listenzer.class)
public class CreateInvoiceTest extends BaseClass
{
	Home h;
	int random;
	
	String subject;
	String billing;
	String shipping;
	String exppage;
	String orgName;
	String prodName;
@Test(priority = 1,groups = "Smoke")

public void createOrg() throws Throwable{
	
	   
	   
	   
	  /* String BROWSER = fu.getPropertyKeyValue("browser");
	   String USERNAME = fu.getPropertyKeyValue("username");
	   String PASSWORD = fu.getPropertyKeyValue("password");
	   String URL = fu.getPropertyKeyValue("url");*/
	   
	   int random = ju.getRandomNumber();

		 subject=excel.getExcelData("Sheet1", 1, 3)+random;
		 billing = excel.getExcelData("Sheet1", 1, 4);
		 shipping = excel.getExcelData("Sheet1", 1, 5);
		 exppage = excel.getExcelData("Sheet1", 1, 6);
		 orgName=excel.getExcelData("Sheet1", 1, 7)+random;
		 prodName = excel.getExcelData("Sheet1", 1, 8)+random;
		 
		
		
		
		
		
		  
		   wb.waitForElementInDOM(driver);
		  
		   
		   h=new Home(driver);
		 
		   
		   CreateOrganizationPage org=new CreateOrganizationPage(driver);
		   org.createOrganization(orgName);
		   driver.navigate().refresh();
}

		   @Test(priority = 2)
		   public void createProd()
		   {
		   CreateProductPage cpp=new CreateProductPage(driver);
		   cpp.createProd(prodName);
		
		   
		  // driver.navigate().refresh();
		   }
		   @Test(priority = 3)
		   public void createInvoice()
		   {
		     h.getMorelink().click();
		     h.getInvoicelink().click();
		    
		     Invoice in=new Invoice(driver);
		     in.getCreateinvoicebtn().click();
		     
		     
		    CreateInvoicePage ci=new CreateInvoicePage(driver);
		    ci.createInvoiceWithOrg(subject, billing, shipping, orgName,prodName);
		    
		   driver.navigate().refresh();
		   
		    h.getMorelink().click();
		     h.getInvoicelink().click();			   
		    
			   in.searchdd();
			   in.getSearchfield().sendKeys(subject);
			   in.getSubmitbtn().click();
			   WebDriverWait wait=new WebDriverWait(driver, 20);
				WebElement result = driver.findElement(By.xpath("//table[@class='layerPopupTransport']/tbody/tr/td[contains(text(),'Showing Records 1 - 1 of 1')]"));
				String result_text = result.getText();
				wait.until(ExpectedConditions.textToBePresentInElement(result, "Showing Records 1 - 1 of 1"));
				WebElement ele = driver.findElement(By.xpath("//span[@vtfieldname='subject']/preceding-sibling::a"));
				String name = ele.getText();
				/*if(name.equalsIgnoreCase(subject))
				{
					System.out.println("invoice created");
				}
				else {
					System.out.println("invoice created");
				}*/
				SoftAssert sa=new SoftAssert();
				
				sa.assertEquals(name, subject);
		    
		    
		    
		   
		     
		    
		    
}
}
