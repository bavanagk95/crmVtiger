package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage
{
	WebDriver driver=null;
	public  CreateProductPage(WebDriver driver)
	{
		this.driver=driver;
		  PageFactory.initElements(driver,this);

	}
	@FindBy(name = "productname")
	private WebElement productedt;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement savebtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductedt() {
		return productedt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createProd(String prodName) {
Home h=new Home(driver);
	 h.getProductlink().click();
	   
	   Productpage p=new Productpage(driver);
	   p.getProduct().click();
	   
	  
	 productedt.sendKeys(prodName);
	   savebtn.click();
	}
}
