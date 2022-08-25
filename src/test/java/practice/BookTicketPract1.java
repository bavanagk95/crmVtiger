package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicketPract1 
{
 @Test(dataProvider = "dataProvider_BookTicketPract1")
 public void book(String src, String dst)
 {
	 System.out.println("book ticket from "+src+"to"+dst);
 }
 @DataProvider
 public Object[][] dataProvider_BookTicketPract1(){
	Object[][] objarr=new Object[4][2];
	 objarr[0][0]="Bangalore";
	 objarr[0][1]="Hyderabad";
	 
	 objarr[1][0]="Bangalore";
	 objarr[1][1]="Cochin";
	  
	 objarr[2][0]="Bangalore";
	 objarr[2][1]="Mumbai";
	 
	 objarr[3][0]="Bangalore";
	 objarr[3][1]="Delhi";
	 
	 return objarr;
	 
 }
 
}
