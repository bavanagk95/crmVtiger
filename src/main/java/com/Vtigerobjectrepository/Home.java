package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.GenericUtilities.WebDriverUtility;

public class Home 
{
	WebDriver driver=null;
	  public Home(WebDriver driver) 
	  {
		this.driver=driver;
		  PageFactory.initElements(driver,this);
	  }
	  WebDriverUtility weblib=new WebDriverUtility();
	  @FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index' and .='Organizations']")
	   private WebElement Organizationlink;
	  
	  @FindBy(xpath = "//a[text()='Leads' and @href='index.php?module=Leads&action=index']")
	   private WebElement leadlink;
	  
	  @FindBy(xpath = "//a[.='Contacts' and @href='index.php?module=Contacts&action=index']")
	   private WebElement Contactlink;
	  
	  @FindBy(xpath = "//a[@href='index.php?module=Products&action=index' and .='Products']")
	   private WebElement Productlink;

	  @FindBy(xpath = "//a[.='More']")
	   private WebElement Morelink;
	  
	  @FindBy(name = "Invoice")
	  private WebElement Invoicelink;
	  
	  @FindBy(xpath = "//a[.='Sales Order']")
	   private WebElement Salesorderlink;

	  @FindBy(xpath = "//a[.='Price Books']")
	   private WebElement Pricebooklink;

	  @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	  private WebElement adminbtn;
	  
	  @FindBy(xpath = "//a[.='Sign Out']")
	 
	  private WebElement signoutbtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganizationlink() {
		return Organizationlink;
	}

	public WebElement getLeadlink() {
		return leadlink;
	}

	public WebElement getContactlink() {
		return Contactlink;
	}

	public WebElement getProductlink() {
		return Productlink;
	}

	public WebElement getMorelink() {
		return Morelink;
	}

	public WebElement getInvoicelink() {
		return Invoicelink;
	}

	public WebElement getSalesorderlink() {
		return Salesorderlink;
	}

	public WebElement getPricebooklink() {
		return Pricebooklink;
	}

	public WebElement getAdminbtn() {
		return adminbtn;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	  
	  public void logout()
	  {
		  weblib.mouseOverOnElement(driver, adminbtn);
		  signoutbtn.click();
	  }
	  
	  
	  
	  
	  

	  
	  

}
