package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
WebDriver driver=null;
public  Productpage(WebDriver driver)
{
	this.driver=driver;
	  PageFactory.initElements(driver,this);

}
     public WebDriver getDriver() {
	return driver;
}

	@FindBy(xpath = "//img[@title='Create Product...']")
     private WebElement product;
	
	public WebElement getProduct() {
		return product;
	}
	
	public void createProduct(String prod)
	{
		product.sendKeys(prod);
	}
}
