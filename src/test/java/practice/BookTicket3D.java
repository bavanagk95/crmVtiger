package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket3D 
{
	@Test(dataProvider = "dataProvider_BookTicketPract1")
	 public void book(String src, String dst, int ticket)
	 {
		 System.out.println("book ticket from "+src+"to"+dst  +ticket);
	 }
	 @DataProvider
	 public Object[][] dataProvider_BookTicketPract1(){
		Object[][] objarr=new Object[4][3];
		 objarr[0][0]="Bangalore";
		 objarr[0][1]="Hyderabad";
		 objarr[0][2]=5;
		 
		 objarr[1][0]="Bangalore";
		 objarr[1][1]="Cochin";
		 objarr[1][2]=10;
		 
		 objarr[2][0]="Bangalore";
		 objarr[2][1]="Mumbai";
		 objarr[2][2]=10;
		 
		 objarr[3][0]="Bangalore";
		 objarr[3][1]="Delhi";
		 objarr[3][2]=8;
		 
		 return objarr;
		 
	 }
	 
}
