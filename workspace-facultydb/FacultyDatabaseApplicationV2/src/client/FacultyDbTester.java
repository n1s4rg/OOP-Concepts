package client;

//////////////////////////////////////
// JAVA API : From java.sql package //
//////////////////////////////////////
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**************
TO DO:
  in order to have access to the java.sql package, you MUST add a Reference Library to the classpath: 
    choose the option an external jar file (which is the ojdbc.jar)
*****************************/

////////////////////////
//  B35-FR- Version 02  //
///////////////////////
public class FacultyDbTester {
	
	
	public static void main(String[] args)  {
		
		System.out.println("\n \t --- Version 02  ----  With dynamic data input --- \n \t" );
		
		Scanner scan = new Scanner(System.in);
	
		Connection myConnection = null;
		
		String userName, password, service, url;
		
		userName = "facultydb" ;
		password = "123" ;
		service = "localhost" ;
		
		url = "jdbc:oracle:thin:";
		
	// -1-  Connect to the database		
		try {
			
	    myConnection = DriverManager.getConnection(url + userName + "/" + password + "@" + service);
		    System.out.println(" Connection successful");
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			 System.out.println("  failure  ");
		}
		
		
    // -2- Query the database		
		Statement myStatement = null ;		
		ResultSet myResultSet = null;
		String id =null , name = null;
		
		String query = "select * from Department";		
		
		try {			
			  myStatement = myConnection.createStatement();			
			  myResultSet = myStatement.executeQuery(query);				
					while(myResultSet.next())
					{		
					  id = myResultSet.getString(1);
					  name = myResultSet.getString(2);				
				 	    System.out.println("Id: " + id + "     Name: " + name);			
					}
			} 
	   catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				System.out.println(ex.toString());
			}
		
   // -3- insert data into the Department table		
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
