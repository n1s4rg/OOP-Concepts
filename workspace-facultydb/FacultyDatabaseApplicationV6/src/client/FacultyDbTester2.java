package client;
// From java.sql package
////
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
       import java.sql.SQLException;
//import java.sql.Statement;

import java.util.ArrayList;
import java.util.Scanner;

import bus.Department;
import data.DBConnection;

/**************
TO DO:
  in order to have access to the java.sql package, you MUST add a Reference Library to the classpath: 
    choose the option an external jar file (which is the ojdbc.jar)
*****************************/

			////////////////////////////////////////////////////////////////////////// 
			//                                                                      //
			//  - VERSION 06  -- using only the business classes                    //
			//                                                                       //
			//////////////////////////////////////////////////////////////////////////

//3_tiers Application

/*****************************
 * 
  Client Application  <=======> Business Application  <========>  Database Application
     Front-end                        Back-End                            Back-end
    Client Layer                  Business Layer                     Data Layer 
 * 
 **************************/

public class FacultyDbTester2 {	

	public static void main(String[] args) throws SQLException  {
		
		System.out.println("\n \t --- Version 06  ---   using only  business classes --- \n \t" );
		Scanner scan = new Scanner(System.in); 		

      // ArrayList<Department> departmentList = new ArrayList<>();		
        // -1- Querying the database: faculty database       
	      	//departmentList  = Department.getData();	  
		
		for (Department current : Department.getData())	{
			System.out.println(current);			
		}
		
		///insert
		int dept_id; String dept_name;
		System.out.println("Dept id : ");
		dept_id = scan.nextInt();		
		        scan.nextLine();  // C++ : cin.ignore()		
		System.out.println("Dept name : ");
		dept_name = scan.nextLine();
		
		Department aNewDept = new Department();
		aNewDept.setId(dept_id);
		aNewDept.setName(dept_name);
		
		     int row_number = Department.add(aNewDept);
		     if (row_number<=0 )
		          System.out.println("not added");                       
	                         //display again
	                             // departmentList = new ArrayList<>();
	                 		
	                         // -1- Querying the database: faculty database	                        
	                 	      	//departmentList  = Department.getData();	 
		                 		
		                 		for (Department current : Department.getData())
		                 		{
		                 			System.out.println(current.toString());		                 			
		                 		}                		
		
	scan.close();
		System.exit(0);		

	}

}

/**********************************************************
 	
 	 --- Version 06  ---   using only  business classes --- 
 	
 Connection successful
Department [ 1 - Management]
Department [ 2 - Fashion]
Department [ 3 - Math]
Department [ 4 - Biology]
Department [ 5 - HighTech]
Department [ 6 - Software development]
Department [ 7 - Computer]
Department [ 8 - Network]
Department [ 9 - Hardware]
Department [ 10 - Design]
Department [ 11 - Language Workshops]
Department [ 12 - Music]
Department [ 13 - Ethic]
Department [ 14 - Computer Science]
Department [ 15 - Network]
Department [ 16 - Ethic]
Department [ 17 - Game Development]
Department [ 18 - History]
Dept id : 
19
Dept name : 
Biology
 Connection successful
 Connection successful
Department [ 1 - Management]
Department [ 2 - Fashion]
Department [ 3 - Math]
Department [ 4 - Biology]
Department [ 5 - HighTech]
Department [ 6 - Software development]
Department [ 7 - Computer]
Department [ 8 - Network]
Department [ 9 - Hardware]
Department [ 10 - Design]
Department [ 11 - Language Workshops]
Department [ 12 - Music]
Department [ 13 - Ethic]
Department [ 14 - Computer Science]
Department [ 15 - Network]
Department [ 16 - Ethic]
Department [ 17 - Game Development]
Department [ 18 - History]
Department [ 19 - Biology]
************************************************************/

 


	
	
	
	


