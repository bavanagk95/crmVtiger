package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.GenericUtilities.FileUtility;

public class Login 
{
	WebDriver driver;
	
  public Login(WebDriver driver) 
  {
	this.driver=driver;
	  PageFactory.initElements(driver,this);
  }
  @FindBy(name="user_name")
  private WebElement usernameedt;
  
  @FindBy(name="user_password")
  private WebElement passwordedt;
  
  @FindBy(id="submitButton")
  private WebElement loginbtn;
  
  
public WebDriver getDriver() {
	return driver;
}

public WebElement getUsernameedt() {
	return usernameedt;
}

public WebElement getPasswordedt() {
	return passwordedt;
}

public WebElement getLoginbtn() {
	return loginbtn;
}
  
public void LogintoApp() throws Throwable 
{
	FileUtility fu=new FileUtility();
	 String URL = fu.getPropertyKeyValue("url");
	String USERNAME = fu.getPropertyKeyValue("username");
	   String PASSWORD = fu.getPropertyKeyValue("password");
	   
driver.get(URL);
  	usernameedt.sendKeys(USERNAME);
  	passwordedt.sendKeys(PASSWORD);
    loginbtn.click();
}
  
  	
  
  
}
