package practice;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympics 
{
   public static void main(String[] args) 
   {
	   System.out.println("enter the name");
	   Scanner s=new Scanner(System.in);
	   String name = s.next();
	 
	   WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://olympics.com");
		WebElement gold = driver.findElement(By.xpath("//span[contains(.,'"+name+"')]/ancestor::li[@class='b2p-list__item position-relative']/descendant::span[@class='result-medal result-medal--gold']"));
		System.out.println(gold.getText());
   }
}
