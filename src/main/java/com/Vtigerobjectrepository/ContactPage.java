package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
  WebDriver driver=null;
  
  public ContactPage(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  
  public WebDriver getDriver() {
	return driver;
}

public WebElement getCreateconimg() {
	return createconimg;
}

@FindBy(xpath = "//img[@title='Create Contact...']")
  private WebElement createconimg;
  
  
}
