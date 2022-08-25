package com.Vtigerobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vTiger.GenericUtilities.WebDriverUtility;

public class CreateInvoicePage 
{
	WebDriver driver=null;
	WebDriverUtility wb=new WebDriverUtility();
	  public CreateInvoicePage(WebDriver driver) 
	  {
		this.driver=driver;
		  PageFactory.initElements(driver,this);
	  }
	  
	  public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSubjectedt() {
		return subjectedt;
	}

	public WebElement getOrgnameimg() {
		return Orgnameimg;
	}

	public WebElement getBillAdd() {
		return billAdd;
	}

	public WebElement getShipAdd() {
		return shipAdd;
	}

	public WebElement getSearchItem() {
		return searchItem;
	}

	public WebElement getquantity() {
		return quantity;
	}

	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(name="subject")
	  private WebElement subjectedt;
	  
	  @FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	  private WebElement Orgnameimg;
	  
	  @FindBy(name = "bill_street")
	  private WebElement billAdd;
	  
	  @FindBy(name = "ship_street")
	  private WebElement shipAdd;
	  
	  @FindBy(xpath = "//img[@id='searchIcon1']")
	  private WebElement searchItem;
	  
	  @FindBy(xpath = "//input[@name='qty1']")
	  private WebElement quantity;
	  
	  @FindBy(xpath = "//input[@type='submit']")
	  private WebElement saveBtn;

public void createInvoiceWithOrg(String subject,String bill,String ship,String orgname,String prod )
{
	subjectedt.sendKeys(subject);
	Orgnameimg.click();
	wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=");
	OrgSearchPage orgsch=new OrgSearchPage(driver);
	orgsch.getSearchfield().sendKeys(orgname);
	orgsch.getSearchbtn().click();
	/*driver.findElement(By.xpath(""))
	
	WebDriverUtility wb=new WebDriverUtility();
	wb.waitForElement(driver, Orgnameimg)*/
	
	driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
	driver.switchTo().alert().accept();
	driver.navigate().refresh();
	wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Sales");
	billAdd.sendKeys(bill);
	shipAdd.sendKeys(ship);
	searchItem.click();
	wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Products&action=Popup&html=Popup_picker&select=enable&form=HelpDeskEditView&popuptype=inventory_prod&curr_row=1&return_module=Invoice&currencyid=1");
	
	SearchProductPage prodsch=new SearchProductPage(driver);
	prodsch.getSearchfield().sendKeys(prod);
	prodsch.getSearchbtn().click();
	driver.findElement(By.xpath("//a[.='"+prod+"']")).click();
	//driver.navigate().refresh();
	wb.switchToWindow(driver, "http://192.168.0.190:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Sales");
	quantity.sendKeys("1");
	
	
	
	
	saveBtn.click();
}





}
