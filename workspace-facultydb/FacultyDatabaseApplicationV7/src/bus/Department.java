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
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	public static int add(Department element) throws SQLException {
		return DepartmentDB.insert(element);
	}
	
	public static int update(Department element) throws SQLException {
		return DepartmentDB.update(element);
	}
	
	public static int remove(int id) throws SQLException {
		return DepartmentDB.delete(id);
	}
	
	public static Department search(int id) throws SQLException, SQLException {
		return DepartmentDB.search(id);
	}
	
	public static ArrayList<Department> getData() throws SQLException, SQLException {
		return DepartmentDB.select();
	}
	

}
