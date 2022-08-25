package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage 
{
	WebDriver driver=null;
	public  SearchProductPage(WebDriver driver)
	{
		this.driver=driver;
		  PageFactory.initElements(driver,this);

	}
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchfield;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchbtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
}
