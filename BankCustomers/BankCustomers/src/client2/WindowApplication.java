package client2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import bus.Customer;

import data.ConnectionDB;
import data.CustomerDB;
import javax.swing.SwingConstants;


public class WindowApplication {

	private JFrame frmFortisBank;
	
	Connection connection = ConnectionDB.getInstance();
	private JTextField textFieldFirstname;
	private JTextField textFieldLastname;
	private JTextField textFieldSIN;
	
	
	DefaultListModel<String> custStr = new DefaultListModel<>();
	private JTextField textFieldId;
	
	public void addDept(String custStrg) {
		custStr.addElement(custStrg);
	}
	
	public void refreshList() {
		custStr.clear();
		List<Customer> t = CustomerDB.getAllCustomer(connection);
		populateList(t);	
	}
	
	public void populateList(List<Customer> t) {
		for (Customer customer : t) {
			addDept("Id = "+customer.getIdentificationNum()+", Firstname: "+customer.getFirstName()+", LastName:  "+customer.getLastName()+", Pin =  "+customer.getPinNum());
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowApplication window = new WindowApplication();
					window.frmFortisBank.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFortisBank = new JFrame();
		frmFortisBank.setTitle("Fortis Bank");
		frmFortisBank.setBounds(100, 100, 953, 535);
		frmFortisBank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFortisBank.getContentPane().setLayout(null);
		
		Statement myStatement = null;
		
		ResultSet resultSet = null;
		
		String query = "Select * from CUSTOMER";
	
		try {

			myStatement = connection.createStatement();
			resultSet = myStatement.executeQuery(query);
			
			while(resultSet.next()) {

				custStr.addElement("Id = "+resultSet.getString(1)+", Firstname: "+resultSet.getString(2)+", LastName:  "+resultSet.getString(3)+", Pin =  "+resultSet.getString(4));
				
			}
			
		}catch(Exception exception) {
			JOptionPane.showMessageDialog(null, exception.getMessage()); 
		}
		
		JLabel lblNewLabel = new JLabel("Add Customer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(74, 11, 156, 17);
		frmFortisBank.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstname = new JLabel("Firstname");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstname.setBounds(10, 63, 83, 17);
		frmFortisBank.getContentPane().add(lblFirstname);
		
		textFieldFirstname = new JTextField();
		textFieldFirstname.setBounds(102, 62, 128, 20);
		frmFortisBank.getContentPane().add(textFieldFirstname);
		textFieldFirstname.setColumns(10);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastname.setBounds(10, 102, 83, 17);
		frmFortisBank.getContentPane().add(lblLastname);
		
		textFieldLastname = new JTextField();
		textFieldLastname.setColumns(10);
		textFieldLastname.setBounds(102, 101, 128, 20);
		frmFortisBank.getContentPane().add(textFieldLastname);
		
		JLabel lblFirstname_1_1 = new JLabel("SIN");
		lblFirstname_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstname_1_1.setBounds(10, 144, 83, 17);
		frmFortisBank.getContentPane().add(lblFirstname_1_1);
		
		textFieldSIN = new JTextField();
		textFieldSIN.setColumns(10);
		textFieldSIN.setBounds(102, 143, 128, 20);
		frmFortisBank.getContentPane().add(textFieldSIN);
		
		JButton btnCustomerAdd = new JButton("ADD");
		btnCustomerAdd.setBounds(102, 205, 89, 23);
		frmFortisBank.getContentPane().add(btnCustomerAdd);
		
		btnCustomerAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			  try { 
				  String firstName = textFieldFirstname.getText(); 
				  String lastName = textFieldLastname.getText();
				  long sin = Long.parseLong(textFieldSIN.getText());
				 
				  Customer customer = new Customer(firstName,lastName,sin);
				  
				  boolean didAdd = CustomerDB.addCustomer(connection, customer);
				  
				  if(didAdd) {
					  JOptionPane.showMessageDialog(null, "Customer added!");
					  addDept("Id = "+customer.getIdentificationNum()+", Firstname: "+customer.getFirstName()+", LastName:  "+customer.getLastName()+", Pin =  "+customer.getPinNum());
				  } else {
					  JOptionPane.showMessageDialog(null, "Sorry couldn't add customer, please enter all fields!");
				  }
				  
			  } catch(Exception exception) {
				  JOptionPane.showMessageDialog(null, exception.getMessage()); 
			  }
				 
			}
		});
		
		JList<String> list = new JList<>(custStr);
		 list.setBounds(387,43, 540,377);
		frmFortisBank.getContentPane().add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(149, 356, 89, 23);
		frmFortisBank.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					int deptId = Integer.parseInt(textFieldId.getText()); 
					
					
					int result = JOptionPane.showConfirmDialog(null, "Do you want to delete?");
					
					if(result == JOptionPane.YES_OPTION){
						CustomerDB.delete(connection, deptId);
						 
						refreshList();
						JOptionPane.showMessageDialog(null, "Customer Deleted!");
		            }
				} catch (Exception ex) {
					 JOptionPane.showMessageDialog(null, ex.getMessage()); 
				}
			}
		});
		
		JButton btnRefresh = new JButton("Refresh List");
		btnRefresh.setBounds(610, 451, 89, 23);
		frmFortisBank.getContentPane().add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				refreshList();
			}
		});
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(50, 356, 89, 23);
		frmFortisBank.getContentPane().add(btnSearch);
		
		JLabel lblCustId = new JLabel("Cust ID");
		lblCustId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCustId.setBounds(10, 308, 83, 17);
		frmFortisBank.getContentPane().add(lblCustId);
		
		
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(102, 307, 128, 20);
		frmFortisBank.getContentPane().add(textFieldId);
		
		JLabel lblCustomers = new JLabel("Customers");
		lblCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomers.setBounds(569, 11, 156, 17);
		frmFortisBank.getContentPane().add(lblCustomers);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					int custId = Integer.parseInt(textFieldId.getText()); 

					String result = CustomerDB.searchCustById(connection, custId);
					 
					JOptionPane.showMessageDialog(null, result);
		            
				} catch (Exception ex) {
					 JOptionPane.showMessageDialog(null, ex.getMessage()); 
				}
			}
		});
	}
}
