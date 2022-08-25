package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.GenericUtilities.WebDriverUtility;

public class SalesOrderPage {
	 WebDriver driver=null;
	 
	 public SalesOrderPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }


@FindBy(xpath = "//img[@title='Create Sales Order...']")
private WebElement createsalesbtn;

public WebDriver getDriver() {
	return driver;
}
@FindBy(xpath = "//div[@id='basicsearchcolumns_real']/select[@name='search_field']")
private WebElement searchdropdown;

@FindBy(xpath = "//input[@name='search_text']")
private WebElement searchedt;

@FindBy(xpath = "//input[@name='submit']")
private WebElement submitbtn;

public WebElement getSearchdropdown() {
	return searchdropdown;
}



public WebElement getSearchedt() {
	return searchedt;
}



public WebElement getSubmitbtn() {
	return submitbtn;
}

public WebElement getCreatesalesbtn() {
	return createsalesbtn;
}
public void searchdd() {
WebDriverUtility wb=new WebDriverUtility();
wb.select(searchdropdown, "Subject");

}
   
}
