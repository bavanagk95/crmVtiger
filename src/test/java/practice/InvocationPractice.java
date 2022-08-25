package practice;

import org.testng.annotations.Test;

public class InvocationPractice
{
	@Test(invocationCount =2,priority = 3)
	 public void createContact()
	 {
		 System.out.println("Contact is created");
	 }
	 @Test(invocationCount =  3,priority = 2)
	 public void editContact()
	 {
		 System.out.println("contact is edited");
	 }
	 @Test(invocationCount =  1 , priority = 1)
	 public void createSales()
	 {
		 System.out.println("salesorder is created");
	 }
}
