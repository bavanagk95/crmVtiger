package practice;

import org.testng.annotations.Test;

public class Priority1
{
 @Test(priority=2)
 public void createContact()
 {
	 System.out.println("Contact is created");
 }
 @Test(priority = 1)
 public void editContact()
 {
	 System.out.println("contact is edited");
 }
 @Test(priority = 0)
 public void createSales()
 {
	 System.out.println("salesorder is created");
 }
}
