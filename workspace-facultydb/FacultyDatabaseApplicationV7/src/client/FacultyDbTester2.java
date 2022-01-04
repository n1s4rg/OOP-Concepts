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


/**************
TO DO:
  in order to have access to the java.sql package, you MUST add a Reference Library to the classpath: 
    choose the option an external jar file (which is the ojdbc.jar)
*****************************/

			////////////////////////////////////////////////////////////////////////// 
			//                                                                      //
			//  - VERSION 07  -- using only the business classes                    //
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
		
		System.out.println("\n \t --- Version V6M1  ---   using only  business classes --- \n \t" );
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Department> departmentList = new ArrayList<>();	
		Department     searchedDepartment =  new Department();		
		Department     aDept =  null;
		int dept_id; String dept_name;	
		
	// -1- Query the database: faculty database    
		System.out.println("... Querying the database: faculty database.... ");
	      	departmentList  = Department.getData();	 		
		for (Department current : departmentList)
		{
			System.out.println(current);			
		}	
		
	//-2- search for data into a database		
		System.out.println("... Searching for a department by department number .... ");
		 dept_id =0 ; dept_name = null;
		    searchedDepartment = null ;			 
		System.out.print("Enter department number to search for: ");
		dept_id = scan.nextInt();		
		    searchedDepartment = new Department();
		    
		    searchedDepartment = Department.search(dept_id);	
		    
		        System.out.println( "Department"  +  searchedDepartment) ;	
		        
    //  - 3- update	data into a database	
		 dept_id =0 ; dept_name = null;
		System.out.println("Enter department number to update: ");
		 dept_id = scan.nextInt();
		 
		        scan.nextLine();  // C++ : cin.ignore() 
		        
		System.out.println("Enter the new department name : ");
		dept_name = scan.nextLine();
		
				aDept = new Department();
				aDept.setId(dept_id);
				aDept.setName(dept_name);	
				
		   Department.update(aDept);              
			 		
	             // -1- Query again the database: faculty database
		          departmentList = new ArrayList<>();	            
	     	      	departmentList  = Department.getData();		         		
	         		for (Department current : departmentList)
	         		{
	         			System.out.println(current);	         			
	         		}  			                	
		        
    //-4- insert data into a database
		dept_id = 0 ;  dept_name  = null;
		System.out.println("Dept id : ");
		dept_id = scan.nextInt();		
		        scan.nextLine();  // C++ : cin.ignore()		
		System.out.println("Dept name : ");
		dept_name = scan.nextLine();		
		aDept = new Department();
		aDept.setId(dept_id);
		aDept.setName(dept_name);		
		      Department.add(aDept);
		      
                  // -1- Query again the database: faculty database
                       departmentList = new ArrayList<>();	                        
             	      	departmentList  = Department.getData();	 		                 		
                 		for (Department current : departmentList)
                 		{
                 			System.out.println(current);		                 			
                 		}    	
		 	                                 	
	scan.close();	System.exit(0);	
	}
}

/**********************************************************
 
 	 --- Version V7  ---   using only  business classes --- 
 	
... Querying the database: faculty database.... 
 Connection successful
Department [id=1, name=Management]
Department [id=2, name=Fashion]
Department [id=3, name=Math]
Department [id=4, name=Biology]
Department [id=5, name=HighTech]
Department [id=6, name=Software development]
Department [id=7, name=Computer]
Department [id=8, name=Network]
Department [id=9, name=Hardware]
Department [id=10, name=Design]
Department [id=11, name=Language Workshops]
Department [id=12, name=Music]
Department [id=13, name=Ethic]
Department [id=14, name=Computer Science]
Department [id=15, name=Network]
Department [id=16, name=Dance]
Department [id=17, name=Game Development]
Department [id=18, name=History]
Department [id=19, name=Biology]
Department [id=20, name=Mechanic]
Department [id=21, name=aaaaaa]
Department [id=22, name=bbb]
... Searching for a department by department number .... 
Enter department number to search for: 14
 Connection successful
DepartmentDepartment [id=14, name=Computer Science]
Enter department number to update: 
21
Enter the new department name : 
Dance

 Connection successful
Department [id=1, name=Management]
Department [id=2, name=Fashion]
Department [id=3, name=Math]
Department [id=4, name=Biology]
Department [id=5, name=HighTech]
Department [id=6, name=Software development]
Department [id=7, name=Computer]
Department [id=8, name=Network]
Department [id=9, name=Hardware]
Department [id=10, name=Design]
Department [id=11, name=Language Workshops]
Department [id=12, name=Music]
Department [id=13, name=Ethic]
Department [id=14, name=Computer Science]
Department [id=15, name=Network]
Department [id=16, name=Dance]
Department [id=17, name=Game Development]
Department [id=18, name=History]
Department [id=19, name=Biology]
Department [id=20, name=Mechanic]
Department [id=21, name=Dance]
Department [id=22, name=bbb]

************************************************************/

 


	
	
	
	


