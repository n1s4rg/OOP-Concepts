package client;
                                                                                                                                                                                                                                     
//////////////////////////////////////
//JAVA API : From java.sql package //
//////////////////////////////////////
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**************
TO DO:
  in order to have access to the java.sql package, you MUST add a Reference Library to the classpath: 
    choose the option an external jar file (which is the ojdbc.jar)
*****************************/

//////////////////////////////////
// PA3-EN & B35-EN_FR - Version 01  //
//////////////////////////////////
public class FacultyDbTester {

	public static void main(String[] args)  {
		
		System.out.println("\n \t --- Version 01 ---  Query database--- \n \t" );
		
			Connection myConnection = null;
		
			String userName, password, service, url;		
			
	
			userName = "facultydb" ;
			password = "123" ;
			service = "localhost" ;
			
			url = "jdbc:oracle:thin:";
	
			
	  // -1-  Connect to the database
		try {
			
			myConnection = DriverManager.getConnection(url + userName + "/" + password + "@" + service);
			
		    System.out.println(" \n\t \t  Successful Connection ........\n");
		
		} 
		catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace()  ;
			 System.out.println("  \n \t\t\t Connection failed .....\n ");
		}
		
	// - 2- Query the database
		
		Statement myStatement = null ;
		
		ResultSet myResultSet = null;
		
		String sqlQuery = "select * from Department";
		String id, name;
		
		try {
			
			myStatement = myConnection.createStatement();
			myResultSet = myStatement.executeQuery(sqlQuery);
			
			
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
		
		System.exit(0);		

	}

}
/*
 *  Connection successful
Id: 1     Name: Computer Science
Id: 2     Name: Network
Id: 3     Name: Music

******/
