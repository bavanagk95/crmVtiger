package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLead
{
	 WebDriver driver=null;
	   public CreateLead(WebDriver driver)
	   {
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }

	   @FindBy(name="lastname")
	   private WebElement lastnameedt;
	   
	   @FindBy(name = "company")
	   private WebElement companyedt;
	    
	   @FindBy(xpath = "//input[@type='radio']/following-sibling::input")
	   private WebElement assignedtogroup;
	   
	   public WebDriver getDriver() {
		return driver;
	}


	public WebElement getLastnameedt() {
		return lastnameedt;
	}


	public WebElement getCompanyedt() {
		return companyedt;
	}


	public WebElement getAssignedtogroup() {
		return assignedtogroup;
	}


	public WebElement getAssignedtouser() {
		return assignedtouser;
	}


	public WebElement getSave() {
		return save;
	}

	@FindBy(xpath = "//input[@type='radio']/preceding-sibling::input")
	   private WebElement assignedtouser;
	   
	   @FindBy(xpath = "//input[@type='submit']")
	   private WebElement save;
	   
	   
	   
	   
	   
	   

}
