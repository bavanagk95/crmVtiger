package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.GenericUtilities.WebDriverUtility;

public class Invoice {
	WebDriver driver=null;
	  public Invoice(WebDriver driver) 
	  {
		this.driver=driver;
		  PageFactory.initElements(driver,this);
	  }
@FindBy(xpath = "//img[@title='Create Invoice...']")
private WebElement Createinvoicebtn;
 
@FindBy(xpath = "//div[@id='basicsearchcolumns_real']/select[@name='search_field']")
private WebElement searchdropdown;

@FindBy(name = "search_text")
private WebElement searchfield;

public WebDriver getDriver() {
	return driver;
}

public WebElement getCreateinvoicebtn() {
	return Createinvoicebtn;
}

public WebElement getSearchdropdown() {
	return searchdropdown;
}

public WebElement getSearchfield() {
	return searchfield;
}

public WebElement getSubmitbtn() {
	return submitbtn;
}
@FindBy(name = "submit")
private WebElement submitbtn;

public void searchdd() {
WebDriverUtility wb=new WebDriverUtility();
wb.select(searchdropdown, "Subject");

}}

