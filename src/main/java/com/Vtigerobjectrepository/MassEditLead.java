package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MassEditLead 
{
	WebDriver driver=null;
	   public MassEditLead(WebDriver driver)
	   {
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }
	   
	   public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLnameedt() {
		return lnameedt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	@FindBy(xpath = "//input[@name='lastname']")
	   private WebElement lnameedt;
	   
	   @FindBy(xpath = "//input[@type='submit' and @name='button']")
	   private WebElement savebtn;
	   
}
