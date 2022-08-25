package com.Vtigerobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.GenericUtilities.WebDriverUtility;

public class CreateSalesOrderPage 
{
	
		 WebDriver driver=null;
		public WebDriverUtility wb=new WebDriverUtility();
		
		
		 
		 
		 public CreateSalesOrderPage(WebDriver driver)
		 {
			 this.driver=driver;
			 PageFactory.initElements(driver,this);
		 }
		 
		 @FindBy(name = "subject")
		 private WebElement subjectedt;
		 
		 @FindBy(xpath = "//input[@name='contact_name']/following-sibling::img[@title='Select']")
		 private WebElement contactbtn;
		 
		 @FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
		 private WebElement orgnameimg;
		 
		 @FindBy(xpath = "//textarea[@name='bill_street']")
		 private WebElement billAddedt;
		 
		 @FindBy(xpath = "//textarea[@name='ship_street']")
		 private WebElement shipAddedt;
		 
		 @FindBy(xpath = "//img[@id='searchIcon1']")
		 private WebElement searchProdimg;
		 
		 @FindBy(xpath = "//input[@name='qty1']")
		 private WebElement qtyedt;
		 
		 @FindBy(xpath = "//input[@type='submit']")
		 private WebElement savebtn;

		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getSubjectedt() {
			return subjectedt;
		}

		public WebElement getContactbtn() {
			return contactbtn;
		}

		public WebElement getOrgnameimg() {
			return orgnameimg;
		}

		
		public WebElement getBillAddedt() {
			return billAddedt;
		}

		

		public WebElement getShipAddedt() {
			return shipAddedt;
		}

		

		public WebElement getSearchProdimg() {
			return searchProdimg;
		}
		

		public WebElement getQtyedt() {
			return qtyedt;
		}

		

		public WebElement getSavebtn() {
			return savebtn;
		}
		
		public void createSalesOrder(String subject,String billadd,String shipadd,String lname,String org,String prod,String qty)
		{
			wb.waitForElementInDOM(driver);
			subjectedt.sendKeys(subject);
			contactbtn.click();
			
			wb.switchToWindow(driver, "Contacts");
			SearchContactPage sc=new SearchContactPage(driver);
			sc.getSearchlnameedt().sendKeys(lname);
			sc.getSearchbtn().click();
			driver.findElement(By.xpath("//a[text()=' "+lname+"']")).click();
			wb.swithToAlertAndAccpect(driver);
			driver.navigate().refresh();
			wb.switchToWindow(driver, "SalesOrder");
			orgnameimg.click();
			wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=");
			SearchOrgNamePage sorg=new SearchOrgNamePage(driver);
			sorg.getSearchlnameedt().sendKeys(org);
			sorg.getSearchbtn().click();
			driver.findElement(By.xpath("//a[.='"+org+"']")).click();
			wb.swithToAlertAndAccpect(driver);
			driver.navigate().refresh();
			wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=SalesOrder&action=EditView&return_action=DetailView&parenttab=Sales");
			
			
			billAddedt.sendKeys(billadd);
			shipAddedt.sendKeys(shipadd);
			searchProdimg.click();
			wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Products&action=Popup&html=Popup_picker&select=enable&form=HelpDeskEditView&popuptype=inventory_prod&curr_row=1&&&return_module=SalesOrder&currencyid=1");
			
			SearchProductPage sp=new SearchProductPage(driver);
			sp.getSearchfield().sendKeys(prod);
			sp.getSearchbtn().click();
			driver.findElement(By.xpath("//a[.='"+prod+"']")).click();
			//driver.navigate().refresh();
			wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=SalesOrder&action=EditView&return_action=DetailView&parenttab=Sales");
			qtyedt.sendKeys(qty);
			savebtn.click();
		}
}
