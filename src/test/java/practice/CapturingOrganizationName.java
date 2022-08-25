package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CapturingOrganizationName 
{
	public static void main(String[] args)
	{
		  WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://192.168.0.190:8888");
    driver.findElement(By.name("user_name")).sendKeys("admin");
    driver.findElement(By.name("user_password")).sendKeys("admin");
    driver.findElement(By.id("submitButton")).click();
    driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index' and .='Organizations']")).click();
    List<WebElement> orglist = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
    String expectedmsg="jspiders";
    Boolean flag=false;
    int rowcount=1;
    for(WebElement wb:orglist)
    {
    	rowcount++;
    	String org = wb.getText();
    	System.out.println(org);
    	if(org.equalsIgnoreCase(expectedmsg))
    	{
    		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+rowcount+"]/td[1]/input")).click();
    		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+rowcount+"]/td[8]/a[.='del']")).click();
    		flag=true;
    		break;
    	}
    	
    
    }
    if(!flag)
    {
    	System.out.println(expectedmsg + " is not there");
    }


    }
}
