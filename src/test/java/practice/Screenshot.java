package practice;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;


import com.vTiger.GenericUtilities.BaseClass;

public class Screenshot extends BaseClass
{
	@Test
	public void verifyLead(Method metd) throws IOException {
		System.out.println(metd.getName());
		String currentTestName=metd.getName();
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./pictures/"+currentTestName+".png");
		FileUtils.copyFile(src, dst);
		

	}

}
