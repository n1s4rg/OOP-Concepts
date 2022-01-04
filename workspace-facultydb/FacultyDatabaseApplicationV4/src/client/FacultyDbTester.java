package client;
// From java.sql package
////
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

                                       import data.DBConnection;

/**************
TO DO:
  in order to have access to the java.sql package, you MUST add a Reference Library to the classpath: 
    choose the option an external jar file (which is the ojdbc.jar)
*****************************/

///////////////////////////////////////////////////
//  - Version 04 - USING DBConnection class  //
///////////////////////////////////////////////////

public class FacultyDbTester {

	public static void main(String[] args)  {
		
		System.out.println("\n \t ---  Version 04  ----  USING DBConnection class  --- \n \t" );
		
		Scanner scan = new Scanner(System.in);
		Connection myConnection = null;
			
//Query the database: facultydb5
		
		Statement myStatement = null ;
		
		ResultSet myResultSet = null;
		
		String query = "select * from Department";
		String id, name;
		
		try {
			  myConnection = DBConnection.getConnection();
			
			myStatement = myConnection.createStatement();
			
			myResultSet = myStatement.executeQuery(query);			
			
			while(myResultSet.next())
			{		
			  id = myResultSet.getString(1);
			  name = myResultSet.getString(2);			
			
			System.out.println("Id: " + id + "     Name: " + name);
			
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println(ex.toString());
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
/***
 * 
 	 ---  Version 04  ----  USING DBConnection class  --- 
 	
 Connection successful
Id: 1     Name: Management
Id: 2     Name: Fashion
Id: 3     Name: Math
Id: 4     Name: Biology
Id: 5     Name: HighTech
Id: 6     Name: Software development
Id: 7     Name: Computer
Id: 8     Name: Network
Id: 9     Name: Hardware
Id: 10     Name: Design
Id: 11     Name: Language Workshops
Id: 12     Name: Music
Id: 13     Name: Ethic
Id: 14     Name: Computer Science
Id: 15     Name: Network
Id: 16     Name: Ethic
Id: 17     Name: Game Development
Dept id : 

*******************************/
