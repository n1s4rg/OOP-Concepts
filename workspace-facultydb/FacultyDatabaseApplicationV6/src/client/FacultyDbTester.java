package client;
// From java.sql package
////
import java.sql.Connection;
//////import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
////////import java.util.ArrayList;
import java.util.Scanner;

import bus.Department;
import data.DBConnection;

/**************
TO DO:
  in order to have access to the java.sql package, you MUST add a Reference Library to the classpath: 
    choose the option an external jar file (which is the ojdbc.jar)
*****************************/

			/////////////////////////////////////////////////////////////////////// 
			//                                                                   //
			//  - VERSION 06  -- using the business classes & database classes
			//                                                                   //
			//////////////////////////////////////////////////////////////////////

public class FacultyDbTester {
	

	public static void main(String[] args)  {
		
		System.out.println("\n \t --- Version 06  ---   USING DBConnection class & Department class --- \n \t" );
		
		Scanner scan = new Scanner(System.in);
		Connection myConnection = null;	
		
		
		
    // -1- Querying the database: facultydb
		
		Statement myStatement = null ;		
		ResultSet myResultSet = null;	
		
		Department aDepartment = null ;
		
		String sqlQuery = null; String id = null, name = null;
		
		
		sqlQuery = "select * from Department";
		
	  try {			
			myConnection = DBConnection.getConnection();
			myStatement  = myConnection.createStatement();
			
			myResultSet  = myStatement.executeQuery(sqlQuery);			
			
			while(myResultSet.next())
			{	
				aDepartment = new Department() ;
				
			   id = myResultSet.getString(1);
			   name = myResultSet.getString(2);	
			  
			  aDepartment.setId(Integer.parseInt(id));
			  aDepartment.setName(name);
			  
			  System.out.println(aDepartment); 
			  
			     
			
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();			
			System.out.println(ex.toString());
		}
	  
	 
		
 //inserting data into the Department table	
	  
	PreparedStatement 	myPreparedStatement = null ;
	int dept_id; String dept_name;
	
	String sqlCommand;
	
	System.out.println("Dept id : ");
	dept_id = scan.nextInt();
	
	        scan.nextLine();  // C++ : cin.ignore()
	
	System.out.println("Dept name : ");
	dept_name = scan.nextLine();
	
	sqlCommand = "insert into Department values( ?  , ? )  ";
	
	try
	{
		myPreparedStatement = myConnection.prepareStatement(sqlCommand);
		
		
		myPreparedStatement.setInt(1, dept_id);
		
		myPreparedStatement.setString(2, dept_name);
		
		
		myPreparedStatement.executeUpdate();
		
		          myConnection.commit();		
		
	}
	catch(SQLException ex)
	{		
		System.out.println("Exception ... " + ex.getMessage());
		
	}	
	
	scan.close();
		System.exit(0);		

	}

}






/**********************************
			 
 	 --- Version 06  ---   USING DBConnection class & Department class --- 
 	
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
Dept id : 

***********************************/
	