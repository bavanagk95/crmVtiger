package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	WebDriver driver=null;
	  public OrganizationPage(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
	  }
	 public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCreateOrglink() {
		return createOrglink;
	}
	@FindBy(xpath = "//img[@title='Create Organization...']")
	 private WebElement createOrglink;

}
