package com.Vtigerobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vTiger.GenericUtilities.WebDriverUtility;

public class Lead 
{
   

WebDriver driver=null;
   public Lead(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
  
   
   @FindBy(xpath = "//img[@title='Create Lead...']")
   private WebElement createleadbtn;
   
   @FindBy(xpath = "//div[@id='basicsearchcolumns_real']/select[@name='search_field']")
   private WebElement searchdropdown;

   @FindBy(name = "search_text")
   private WebElement searchfield;

   @FindBy(name = "submit")
   private WebElement submitbtn;
   
   public WebElement getSearchdropdown() {
	return searchdropdown;
}


public WebElement getSearchfield() {
	return searchfield;
}



public WebElement getSubmitbtn() {
	return submitbtn;
}





@FindBy(xpath = "//div[@id='ListViewContents']/descendant::tr[*]/td[3]")
   private WebElement lastnamelist;
   
   //(xpath = "//a[text()='""']/../preceding-sibling::td/input")
  // private WebElement checkbox;
   
   @FindBy(xpath = "//input[@value='Mass Edit']")
   private WebElement masseditbtn;
   
   @FindBy(xpath = "//input[@value='Delete']")
   private WebElement deletebtn;
public WebDriver getDriver() {
	return driver;
}

public WebElement getCreateleadbtn() {
	return createleadbtn;
}

public WebElement getLastnamelist() {
	return lastnamelist;
}

//public WebElement getCheckbox() {
//	return checkbox;


public WebElement getMasseditbtn() {
	return masseditbtn;
}

public WebElement getDeletebtn() {
	return deletebtn;
}

public void searchdropdown() {
   
  WebDriverUtility wb=new WebDriverUtility();
  wb.select(searchdropdown, "Last Name");
  
}

public  String searchLead(String Lname) {
	//WebElement ele = driver.findElement(By.xpath("//a[.='"+Lname+"']"));
	WebDriverWait wait=new WebDriverWait(driver, 20);
	WebElement result = driver.findElement(By.xpath("//table[@class='layerPopupTransport']/tbody/tr/td[contains(text(),'Showing Records 1 - 1 of 1')]"));
	String result_text = result.getText();
	wait.until(ExpectedConditions.textToBePresentInElement(result, "Showing Records 1 - 1 of 1"));
	WebElement ele = driver.findElement(By.xpath("//span[@vtfieldname='lastname']/preceding-sibling::a"));
	String name = ele.getText();
	return name;
}
   
   public void selectCheckbox(String Lname)
   {
	   driver.findElement(By.xpath("//a[text()='"+Lname+"']/../preceding-sibling::td/input")).click();
   }
   
   
}
