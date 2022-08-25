package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage 
{
 WebDriver driver=null;
 
 public CreateContactPage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
 }
 
 @FindBy(xpath = "//input[@name='lastname']")
 private WebElement lnameedt;
 
 @FindBy(xpath = "//input[@type='submit']")
 private WebElement savebtn;
 
 public void createContact(String lNname)
 {
	 lnameedt.sendKeys(lNname);
	 savebtn.click();
 }
 
 }
