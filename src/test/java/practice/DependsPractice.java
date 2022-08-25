package practice;

import org.testng.annotations.Test;

public class DependsPractice
{
	 @Test(dependsOnMethods = "createSales")
	 public void createContact()
	 {
		 System.out.println("Contact is created");
	 }
	 @Test(dependsOnMethods = "createSales")
	 public void editContact()
	 {
		 System.out.println("contact is edited");
	 }
	 @Test()
	 public void createSales()
	 {
		 System.out.println("salesorder is created");
	 }
}
