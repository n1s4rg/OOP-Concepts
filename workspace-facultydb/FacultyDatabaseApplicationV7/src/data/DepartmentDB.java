package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bus.Department;

public class DepartmentDB {	
	static private Connection myConnection;
	static private String mySQLStatement = null;	
	static private String mySQLQuery = null;
	static private Statement myStatemnt = null;
	static private ResultSet myResultSet = null;
	static private Department aDepartment = null;
	/*
	 * return 1 if added successfully otherwise 0
	 */
	public static int insert(Department aNewDepartment) throws SQLException {
		myConnection = DBConnection.getConnection();		
		mySQLStatement = "Insert into Department(deptNumber, DeptName)  values( " 
                                                    + aNewDepartment.getId() 
                                                    + ", \'" 
                                                    + aNewDepartment.getName()  
                                                    +  "\')" ;
		try {
			myStatemnt = myConnection.createStatement();
			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);
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
	
	public static int update(Department newDepartment) throws SQLException {
		
		myConnection = DBConnection.getConnection();
		
		mySQLStatement = "update department set DeptName =  \'"    
				
			                               +   newDepartment.getName()     +    "\' WHERE  DeptNumber = "
			                  
			                  +  newDepartment.getId() ;
		
		try {
			
			myStatemnt = myConnection.createStatement();
			
			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);
			
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
	
	/**
	 * 
	 * @param id primary key of vehicle
	 * @return	return 1 if removed successfully otherwise 0
	 * @throws SQLException
	 */
	public static int delete(int id ) throws SQLException {
		myConnection = DBConnection.getConnection();
		
		mySQLStatement = "Delete FROM Department WHERE DeptNumber = "  + id  ;
		
		try {
			myStatemnt = myConnection.createStatement();
			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);
			
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
	
	public static Department search(int id) throws SQLException, SQLException{
		
		myConnection = DBConnection.getConnection();
		
		mySQLQuery = "SELECT DeptNumber, DeptName FROM Department WHERE  DeptNumber = " + id ;
		
		myStatemnt = myConnection.createStatement();
		
		myResultSet = myStatemnt.executeQuery(mySQLQuery);
		
		if(myResultSet.next()) {
			aDepartment = new Department(Integer.parseInt(myResultSet.getString(1)), myResultSet.getString(2)   );
		}		
		return aDepartment;
	}
	
	public static ArrayList<Department> select() throws SQLException, NumberFormatException, SQLException{
		
		myConnection = DBConnection.getConnection();
		
		mySQLQuery = "SELECT * FROM Department";
		
		myStatemnt = myConnection.createStatement();
		myResultSet = myStatemnt.executeQuery(mySQLQuery);
		
		ArrayList<Department> myList = new ArrayList<Department>();
		while(myResultSet.next()) {
			
			aDepartment = new Department(Integer.parseInt(myResultSet.getString(1) ) ,  myResultSet.getString(2) );
			
			myList.add(aDepartment);
		}
		
		return myList;
	}

}
