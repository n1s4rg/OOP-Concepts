package client;
// From java.sql package
////
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import bus.Department;
import data.DBConnection;

/**************
TO DO:
  in order to have access to the java.sql package, you MUST add a Reference Library to the classpath: 
    choose the option an external jar file (which is the ojdbc.jar)
*****************************/

//////////////////////////////////////////////////////
//    Version 05  --with Department class   //
//////////////////////////////////////////////////////

public class FacultyDbTester {
	
	public static void main(String[] args)  {
		
		System.out.println("\n \t --- Version 05  ---  USING  DBConnection class & Department class --- \n \t" );
		
		Scanner scan = new Scanner(System.in);
		Connection myConnection = null;
		
		ArrayList<Department> departmentList = new ArrayList<> ();
	
		
    //Query the database: facultydb5
		
		Statement myStatement = null ;
		
		ResultSet myResultSet = null;
		
		String query = "select * from Department";
		
		String id = null, name =null;
		
		Department aNewDepartment = null ;
		
		try {
			
			myConnection = DBConnection.getConnection();
			
			myStatement = myConnection.createStatement();
			
			myResultSet = myStatement.executeQuery(query);			
			
			while(myResultSet.next())
			{	
				aNewDepartment = new Department() ;
				
			     id = myResultSet.getString(1);
			     
			     name = myResultSet.getString(2);	
			     
			    aNewDepartment.setId(  Integer.parseInt(id)    );
			    
			    aNewDepartment.setName(name);
			
		     	//			    
			    departmentList.add(aNewDepartment) ;
			
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println(ex.toString());
		}
		
		System.out.println("\n \t List of departments from facultydb database");	
		for(Department currentDepartment : departmentList)
		{
			System.out.println(currentDepartment);
		}
		
 //inserting data into the Department table		
	PreparedStatement 	myPreparedStatement = null ;
	int dept_id; String dept_name;
	
	String sqlStatement;
	
	System.out.println("Dept id : ");
	dept_id = scan.nextInt();
	
	        scan.nextLine();  //cin.ignore()
	
	System.out.println("Dept name : ");
	dept_name = scan.nextLine();
	
	sqlStatement = "insert into Department values( ?  , ? )  ";
	
	try
	{
		myPreparedStatement = myConnection.prepareStatement(sqlStatement);
		
		
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
/****
 * 
 	 --- Version 05  ---  USING  DBConnection class & Department class --- 
 	
 Connection successful

 	 List of departments from facultydb database
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
Department [id=16, name=Ethic]
Department [id=17, name=Game Development]
Dept id : 

****/
