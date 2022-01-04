package client1;

import java.util.Scanner;
import java.sql.Connection;

import bus.Customer;
import data.*;

public class ConsoleTesterApplication {

	public static void main(String[] args) {
		
		Connection connection = ConnectionDB.getInstance();

		int choice = 0;
		Scanner input = new Scanner(System.in);
		 
		do {
			System.out.println("\n\tMenu\n=======================");
			System.out.println("1 - Add");
			System.out.println("2 - Print all Customers");
			System.out.println("3 - Search");
			System.out.println("4 - Remove");
			System.out.println("5 - Exit");
			
			try {
				
				System.out.print("\nEnter your option: ");
				
				choice = input.nextInt();
				
				if (choice < 1 || choice > 6) {
					System.out.println("\n>>> Invalid Choice <<<");
				} else {
					
					switch (choice) {
					case 1:
						System.out.print("\nNew Customer Details\n```````````````````````````: ");
						System.out.print("\nFirst Name: ");
						String firstName = input.next();
						
						System.out.print("\nLast Name: ");
						String lastName = input.next();
						
						System.out.print("\nEnter your pin: ");
						long pin = input.nextLong();
						
						Customer cust = new Customer(firstName,lastName,pin);
						
						CustomerDB.addCustomer(connection,cust);	
						
						break;
						
					case 2:
						
						CustomerDB.printAllCustomers(connection);
						break;
					case 3:
						System.out.print("\nEnter Customer Id: ");
						int dtId = input.nextInt();
						CustomerDB.searchCustById(connection, dtId);
						
						break;
					case 4:
						System.out.print("\nEnter Customer Id to delete: ");
						int ddtId = input.nextInt();
						CustomerDB.delete(connection, ddtId);
						break;
			
					case 5:
						System.out.print("\nThank You...");
						input.close();
						break;
						
					}
				}
			} catch(Exception e) {
				input.next();
				System.out.println("Arggh! Invalid input");
			}
			
		} while (choice != 5);
		
	}
		
}

/*
 DB connected successfully!

	Menu
=======================
1 - Add
2 - Print all Customers
3 - Search
4 - Remove
5 - Exit

Enter your option: 1

New Customer Details
```````````````````````````: 
First Name: Alex

Last Name: Kevan

Enter your pin: 111
Customer added!

	Menu
=======================
1 - Add
2 - Print all Customers
3 - Search
4 - Remove
5 - Exit

Enter your option: 1

New Customer Details
```````````````````````````: 
First Name: Henna

Last Name: Wattson

Enter your pin: 333
Customer added!

	Menu
=======================
1 - Add
2 - Print all Customers
3 - Search
4 - Remove
5 - Exit

Enter your option: 2

CUSTOMER
``````````````````````````````````
1) Id: 40032, Firstname: Alex, LastName: Kevan, Pin: 111
2) Id: 28084, Firstname: Henna, LastName: Wattson, Pin: 333

	Menu
=======================
1 - Add
2 - Print all Customers
3 - Search
4 - Remove
5 - Exit

Enter your option: 3

Enter Customer Id: 28084

Customer
``````````````````````````````````
Id: 28084, Firstname: Henna, LastName: Wattson, Pin: 333

	Menu
=======================
1 - Add
2 - Print all Customers
3 - Search
4 - Remove
5 - Exit

Enter your option: 4

Enter Customer Id to delete: 28084
Customer deleted!

	Menu
=======================
1 - Add
2 - Print all Customers
3 - Search
4 - Remove
5 - Exit

Enter your option: 2

CUSTOMER
``````````````````````````````````
1) Id: 40032, Firstname: Alex, LastName: Kevan, Pin: 111

	Menu
=======================
1 - Add
2 - Print all Customers
3 - Search
4 - Remove
5 - Exit

Enter your option: 5

Thank You...
 
 */


