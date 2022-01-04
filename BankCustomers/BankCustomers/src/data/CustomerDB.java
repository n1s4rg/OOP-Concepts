package data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bus.Customer;

public class CustomerDB {
	
	public static boolean addCustomer(Connection connection, Customer c) {
		
		PreparedStatement preparedStatement = null;
		
		String sqlQuery = "insert into CUSTOMER(CUSTOMER_ID,FIRST_NAME,LAST_NAME,SIN) values(?,?,?,?)";

		try {
		
			preparedStatement = connection.prepareStatement(sqlQuery);
			
			preparedStatement.setLong(1, c.getIdentificationNum());
			preparedStatement.setString(2, c.getFirstName());
			preparedStatement.setString(3, c.getLastName());
			preparedStatement.setLong(4, c.getPinNum());
			
			preparedStatement.executeUpdate();
			
			connection.commit();
			
			System.out.println("Customer added!");
			
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
public static void delete(Connection connection, int custId) {
		
		PreparedStatement preparedStatement = null;
		
		String sqlQuery = "delete from CUSTOMER where CUSTOMER_ID=?";
		
		try {
		
			preparedStatement = connection.prepareStatement(sqlQuery);
			
			preparedStatement.setInt(1,custId);
			
			preparedStatement.executeUpdate();
			
			connection.commit();
			
			System.out.println("Customer deleted!");
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
	
	public static String searchCustById(Connection connection,int custId) {
		
		ResultSet resultSet = null;
		
		PreparedStatement preparedStatement = null;
		
		String query = "Select * from CUSTOMER where CUSTOMER_ID=?";
		
		String id,firstname,lastname, pin;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1,custId);
			
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("\nCustomer\n``````````````````````````````````");
			
			
			while(resultSet.next()) {
				Customer customer = new Customer();
				
				id = resultSet.getString(1);
				firstname= resultSet.getString(2);
				lastname= resultSet.getString(3);
				pin= resultSet.getString(4);
				
				customer.setIdentificationNum(Long.parseLong(id));
				customer.setFirstName(firstname);
				customer.setLastName(lastname);
				customer.setPinNum(Long.parseLong(pin));
				
				String reString ="Id: "+id+", Firstname: "+firstname+", LastName: "+lastname+", Pin: "+pin;
				
				System.out.println(reString);
				return reString;
			}
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return "No Customer Found";
	}
	
	public static List<Customer> getAllCustomer(Connection connection){
		List<Customer> listOfCustomers = new ArrayList<Customer>();
		
		Statement myStatement = null;
		
		ResultSet resultSet = null;
		
		String query = "Select * from CUSTOMER";
		

		String id,firstname,lastname, pin;
		
		try {
			
			myStatement = connection.createStatement();
			
			resultSet = myStatement.executeQuery(query);

			while(resultSet.next()) {
				Customer customer = new Customer();
				
				id = resultSet.getString(1);
				firstname= resultSet.getString(2);
				lastname= resultSet.getString(3);
				pin= resultSet.getString(4);
				
				customer.setIdentificationNum(Long.parseLong(id));
				customer.setFirstName(firstname);
				customer.setLastName(lastname);
				customer.setPinNum(Long.parseLong(pin));
				
			
				listOfCustomers.add(customer);
			}
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return listOfCustomers;
	}
	
	public static void printAllCustomers(Connection connection) {
		Statement myStatement = null;
		
		ResultSet resultSet = null;
		
		String query = "Select * from CUSTOMER";
		

		String id,firstname,lastname, pin;
		
		try {
			
			myStatement = connection.createStatement();
			
			resultSet = myStatement.executeQuery(query);
			
			System.out.println("\nCUSTOMER\n``````````````````````````````````");
			int i = 1;
			
			
			while(resultSet.next()) {
				Customer customer = new Customer();
				
				id = resultSet.getString(1);
				firstname= resultSet.getString(2);
				lastname= resultSet.getString(3);
				pin= resultSet.getString(4);
				
				customer.setIdentificationNum(Long.parseLong(id));
				customer.setFirstName(firstname);
				customer.setLastName(lastname);
				customer.setPinNum(Long.parseLong(pin));
				
				String reString = i+") "+"Id: "+id+", Firstname: "+firstname+", LastName: "+lastname+", Pin: "+pin;
				
				System.out.println(reString);
				
				i++;
			}
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
}
