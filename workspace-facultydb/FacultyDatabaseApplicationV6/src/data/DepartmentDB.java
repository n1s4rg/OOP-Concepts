package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bus.Department;

public class DepartmentDB {
	
	////TWO METHOD
	
	static private Connection myConnection = null;
	static private String mySQLCommand = null;
	static private String mySQLQuery = null;
	static private Statement myStatement = null;
	static private ResultSet myResultSet = null;
	
	static private Department aDepartment = null;
	
	static private int rowAffected;
		
	/*
	 * return 1 if added successfully otherwise 0
	 */
	public static int insert(Department aNewDept) throws SQLException {
		
		myConnection = DBConnection.getConnection();
		rowAffected = 0;
		
 
       mySQLCommand = "insert into Department(deptNumber, DeptName)  values( " 
                                       + aNewDept.getId() 
                                       + "  ,  \'" 
                                       + aNewDept.getName()  +  "\' )"  ;
		
		
		//in the command Line (SQL *PLUS):
	                 // insert into department(dept_Number, Dept_Name) 
		             //             values  (        1      , 'Computer Science' )  ;
		
		try {
			
			myStatement = myConnection.createStatement();
			
			int rowAffected = myStatement.executeUpdate(mySQLCommand);
			
			                 myConnection.commit();
			
			if(rowAffected > 0) {
				return 1;
			}else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public static ArrayList<Department> select() throws SQLException, NumberFormatException{
		
		myConnection = DBConnection.getConnection();
		
		mySQLQuery= "SELECT * FROM Department";
		
		myStatement = myConnection.createStatement();
		
		myResultSet = myStatement.executeQuery(mySQLQuery);
		
		
		ArrayList<Department> myList = new ArrayList<Department>();
		
				while(myResultSet.next()) {
					
					aDepartment = new Department(Integer.parseInt(myResultSet.getString(1) ) ,
							                     myResultSet.getString(2)
							                    );
					
					myList.add(aDepartment);
				}
		
		return myList;
	}
}


























