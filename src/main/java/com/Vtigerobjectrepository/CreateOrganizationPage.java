package com.Vtigerobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	WebDriver driver=null;
	public CreateOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		  PageFactory.initElements(driver,this);

	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameedt() {
		return orgNameedt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgNameedt;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement savebtn;
	
	
	public void createOrganization(String org)
	{
		Home h=new Home(driver);
		   
		   h.getOrganizationlink().click();
 OrganizationPage o=new OrganizationPage(driver);
		   
		   o.getCreateOrglink().click();
		orgNameedt.sendKeys(org);
		savebtn.click();
	}
}
