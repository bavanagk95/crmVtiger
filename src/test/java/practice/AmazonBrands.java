package practice;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBrands 
{
 public static void main(String[] args) 
 {
	 Scanner s=new Scanner(System.in);
	 String brand = s.next();

	  WebDriverManager.chromedriver().setup();

ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
        driver.findElement(By.xpath("//a[@href='/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles']")).click();
        driver.findElement(By.xpath(" //span[@class='a-size-base a-color-base' and .='"+brand+"']/ancestor::li[@class='a-spacing-micro']/descendant::i[@class='a-icon a-icon-checkbox']")).click();        
 }
}
