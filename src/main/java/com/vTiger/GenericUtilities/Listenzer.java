package com.vTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenzer implements ITestListener
{
public void onTestFailure(ITestResult result)
{
	JavaUtility ju=new JavaUtility();
	String date = ju.getSystemDate();
	String testName=result.getMethod().getMethodName();
	
	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
	File src = edriver.getScreenshotAs(OutputType.FILE);
	File dest= new File("./pictures/"+testName+date+".png");
	try {
		FileUtils.copyFile(src, dest);
		
	}catch(IOException e){
		e.printStackTrace();
	}

}
}
