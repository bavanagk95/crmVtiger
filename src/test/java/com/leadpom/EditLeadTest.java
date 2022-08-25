package com.leadpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtigerobjectrepository.CreateLead;
import com.Vtigerobjectrepository.Home;
import com.Vtigerobjectrepository.Lead;
import com.Vtigerobjectrepository.Login;
import com.Vtigerobjectrepository.MassEditLead;
import com.vTiger.GenericUtilities.BaseClass;
import com.vTiger.GenericUtilities.ExcelUtility;
import com.vTiger.GenericUtilities.FileUtility;
import com.vTiger.GenericUtilities.JavaUtility;
import com.vTiger.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.vTiger.GenericUtilities.Listenzer.class)
public class EditLeadTest extends BaseClass
{
	String BROWSER;
	String USERNAME;
	String PASSWORD;
	String URL;
	
	String Lname;
	String Company;
	String UpdateName;
	
	Home h;
	WebDriverUtility wb;
    Lead l;
    
    int random;
	
	@Test(groups = "Smoke")
  public void createLead() throws Throwable {
	  
	  	   JavaUtility ju=new JavaUtility();
	   FileUtility fu=new FileUtility();
	   ExcelUtility excel=new ExcelUtility();
	   
	   
	   
	    BROWSER = fu.getPropertyKeyValue("browser");
	    USERNAME = fu.getPropertyKeyValue("username");
	    PASSWORD = fu.getPropertyKeyValue("password");
	    URL = fu.getPropertyKeyValue("url");
	   
	    random=ju.getRandomNumber();
	    Lname = excel.getExcelData("Sheet3", 1, 3)+random;
	    Company = excel.getExcelData("Sheet3",1 ,2)+random;
	   UpdateName = excel.getExcelData("Sheet3", 1, 4)+random;
	  
	   
	 
   	    wb=new WebDriverUtility();

	   wb.waitForElementInDOM(driver);
	 
	   
	   h=new Home(driver);
	   h.getLeadlink().click();
	   
	    l=new Lead(driver);
	   l.getCreateleadbtn().click();
	    
	   CreateLead cl=new CreateLead(driver);
	   cl.getLastnameedt().sendKeys(Lname);
	   cl.getCompanyedt().sendKeys(Company);
	   cl.getSave().click();
	}
	   
	   @Test(dependsOnMethods = "createLead")
	   public void editLead() {
		  

	   h.getLeadlink().click();
	   l.searchdropdown();
	   l.getSearchfield().sendKeys(Lname);
	   l.getSubmitbtn().click();
	   
	  String name = l.searchLead(Lname);
	  System.out.println(name);
	//  Assert.assertEquals(name, UpdateName);
	  
	  if(name.equals(Lname))
	  {
		  System.out.println("name is added");
	  }
	  else
	  {
		  System.out.println("name is not added");
	  }
	  l.selectCheckbox(Lname);
	  l.getMasseditbtn().click();
	  
	  
	  MassEditLead ms=new MassEditLead(driver);
	  ms.getLnameedt().sendKeys(UpdateName);
	  ms.getSavebtn().click();
	  
	 
	  
	  
			Lead lead=new Lead(driver);
			lead.searchdropdown();
			lead.getSearchfield().sendKeys(UpdateName);
			lead.getSubmitbtn().click();
			
			
			WebElement result = driver.findElement(By.xpath("//table[@class='layerPopupTransport']/tbody/tr/td[contains(text(),'Showing Records 1 - 1 of 1')]"));
			String result_text = result.getText();
			wb.waitForElement(driver, result);
			//wait.until(ExpectedConditions.textToBePresentInElement(result, "Showing Records 1 - 1 of 1"));
			WebElement ele = driver.findElement(By.xpath("//span[@vtfieldname='lastname']/preceding-sibling::a"));
			String name1 = ele.getText();
			

			 
			/*  if(name1.equalsIgnoreCase(UpdateName))
			  {
				  System.out.println("name is updated");
			  }
			  else
			  {
				  System.out.println("name is not updated");
			  }*/
			Assert.assertEquals(name1, UpdateName);
	  
	   
	   
	   
	   }  
	  
	   
	   
}

