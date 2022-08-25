package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgSearchPage
{
	WebDriver driver=null;
	public  OrgSearchPage(WebDriver driver)
	{
		this.driver=driver;
		  PageFactory.initElements(driver,this);

	}
	     public WebDriver getDriver() {
		return driver;
	}
	     @FindBy(xpath = "//input[@id='search_txt']")
	     private WebElement searchfield;
	     
	     @FindBy(xpath = "//input[@name='search']")
	     private WebElement searchbtn;
	     
	     
		public WebElement getSearchfield() {
			return searchfield;
		}
		public WebElement getSearchbtn() {
			return searchbtn;
		}
}
