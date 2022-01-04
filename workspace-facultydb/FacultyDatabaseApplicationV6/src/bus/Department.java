package bus;

import java.sql.SQLException;
import java.util.ArrayList;

import data.DepartmentDB;

public class Department {
	
	private int id;
	private String name;
	
	public Department() {
		super();
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		             //return "Department [id=" + id + ", name=" + name + "]";		
		return "Department [ " + id + " - " + name  + "]";
	}
	
	///////////////////
	//public static services
	///////////////////////////
	public static int add(Department newDepartment) throws SQLException {
		
		return DepartmentDB.insert(newDepartment);
	}
	
	public static ArrayList<Department> getData() throws SQLException, SQLException {
		
		return DepartmentDB.select();
	}	

}
